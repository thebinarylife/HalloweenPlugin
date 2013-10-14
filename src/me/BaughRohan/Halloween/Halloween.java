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

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;

		if (commandLabel.equalsIgnoreCase("halloween") || commandLabel.equalsIgnoreCase("hw")) {
			if (args.length > 0) {
				String halCmd = args[0];

			
				if (halCmd.equalsIgnoreCase("challenges") || halCmd.equalsIgnoreCase("c")) {
					if (player.hasPermission("halloween.challenges")) {
						if (args.length < 2) {
							player.sendMessage(ChatColor.GRAY + "Halloween Challenges:");
							player.sendMessage(ChatColor.GOLD + "Pumpkin Picker: " + ChatColor.GRAY + "Get 10 pumpkins.");
							player.sendMessage(ChatColor.GOLD + "Pumpkin Carver: " + ChatColor.GRAY + "Get 20  Jack-o-Lanterns.");
						}
						else {
							if (halCmd.equalsIgnoreCase("pumpkinpicker")) {
								if (player.getInventory().containsAtLeast(new ItemStack(Material.PUMPKIN), 10)) {
									player.getInventory().addItem(new ItemStack(Material.CAKE_BLOCK, 15));
									player.getInventory().remove(new ItemStack(Material.PUMPKIN, 10));
									player.sendMessage(ChatColor.GRAY + "Congratulations on completing the " + ChatColor.GOLD + "Pumpkin Picker" + ChatColor.GRAY + " challenge!");
									Bukkit.broadcastMessage(ChatColor.GRAY + "" + player + ChatColor.YELLOW + " completed the " + ChatColor.GOLD + "Punpkin Picker" + ChatColor.YELLOW + " challenge!");
								}
								else {
									player.sendMessage(ChatColor.GOLD + "Pumpkin Picker: " + ChatColor.GRAY + "Gather 10 Pumpkins. Reward: 15 Cakes.");
								}
							}

							if (halCmd.equalsIgnoreCase("pumpkincarver")) {
								if (player.getInventory().containsAtLeast(new ItemStack(Material.JACK_O_LANTERN), 15)) {
									player.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));
									player.getInventory().remove(new ItemStack(Material.PUMPKIN, 10));
									player.sendMessage(ChatColor.GRAY + "Congratulations on completing the " + ChatColor.GOLD + "Pumpkin Carver" + ChatColor.GRAY + " challenge!");
									Bukkit.broadcastMessage(ChatColor.GRAY + "" + player + ChatColor.YELLOW + " completed the " + ChatColor.GOLD + "Punpkin Carver" + ChatColor.YELLOW + " challenge!");
								}
								else {
									player.sendMessage(ChatColor.GOLD + "Pumpkin Carver: " + ChatColor.GRAY + "Craft 15 Jack-O-Lanterns. Reward: 1 Diamond.");
								}
							}
						}
					}
					else {
						player.sendMessage(ChatColor.GOLD + "Sorry, but you don't have permission for " + ChatColor.GRAY + "halloween challenges" + ChatColor.GOLD + ".");
					}
				}
			}
			else {
				player.sendMessage(ChatColor.GRAY + "Halloween Commands:");
				player.sendMessage(ChatColor.GOLD + "/halloween challenges " + ChatColor.BLACK + ChatColor.BLACK + "-" + ChatColor.GRAY + " list challenges.");
				// More things to come.
			}
		}
		return true;
	}
}

