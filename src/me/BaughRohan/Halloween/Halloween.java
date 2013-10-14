package me.BaughRohan.Halloween;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.*;

public class Halloween extends JavaPlugin {
	Logger logger = getLogger();
	private Permissions perms = new Permissions();

	public void onEnable() {
		logger.info("Enabling Halloween by Baugh70 and Rohan576!");
	}

	public void onDisable() {
		logger.info("Halloween is now disabled.");
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player player = (Player) sender;

		if (commandLabel.equalsIgnoreCase("halloween")
				|| commandLabel.equalsIgnoreCase("hw")) {
			String halCmd = args[0];
			
			if (halCmd.equalsIgnoreCase("challenges") || halCmd.equalsIgnoreCase("help") || args.length == 0) {
				player.sendMessage(ChatColor.BLACK + "Halloween Challenges:");
				player.sendMessage(ChatColor.GOLD + "Pumpkin Picker: Get 10 pumpkins");
				player.sendMessage(ChatColor.GOLD + "Pumpkin Carver: Get 20  Jack-o-Lanterns");
				} else if (args.length > 1) {
				player.sendMessage(ChatColor.DARK_RED + "Do /halloween for help!");
			}
			if (halCmd.equalsIgnoreCase("pumpkinpicker")) {
				if (player.getInventory().containsAtLeast(new ItemStack(Material.PUMPKIN), 10)) {
					player.getInventory().addItem(new ItemStack(Material.CAKE_BLOCK, 15));
					player.getInventory().remove(new ItemStack(Material.PUMPKIN, 10));
					Bukkit.broadcastMessage(ChatColor.GRAY + "" + player + ChatColor.YELLOW + " completed the Pumpkin Picker challenge!");
				} else {
					player.sendMessage(ChatColor.GOLD + "Pumpkin Picker: Gather 10 Pumpkins. Reward: 15 Cake");
				}
			} else if (args.length == 0) {
				player.sendMessage(ChatColor.GRAY + "Halloween Challenges:");
				player.sendMessage(ChatColor.GOLD + "Pumpkin Picker: Get 10 pumpkins");
				player.sendMessage(ChatColor.GOLD + "Pumpkin Carver: Get 20  Jack-o-Lanterns");
			} else {
			}

			if (halCmd.equalsIgnoreCase("pumpkincarver")) {
				if (player.getInventory().containsAtLeast(new ItemStack(Material.JACK_O_LANTERN), 15)) {
					player.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));
					player.getInventory().remove(new ItemStack(Material.PUMPKIN, 10));
					Bukkit.broadcastMessage(ChatColor.BLACK + "" + player + ChatColor.GOLD + " completed the Punpkin Picker challenge!");
				} else {
					player.sendMessage(ChatColor.GOLD + "Pumpkin Carver: Craft 15 Jack-O-Lanterns. Reward: 1 Diamond.");
				}
			}
		}
		
		return false;

	}

}
