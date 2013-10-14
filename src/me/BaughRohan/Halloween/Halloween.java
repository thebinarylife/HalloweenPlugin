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
	ItemStack cake = new ItemStack(Material.CAKE_BLOCK, 15);
	
	public void onEnable(){
		 logger.info("Enabling Halloween by Baugh70 and Rohan576!");
	}
	public void onDisable() {
		logger.info("Halloween is now disabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		
		
		if (commandLabel.equalsIgnoreCase("halloween") || commandLabel.equalsIgnoreCase("h")) {
			String halCmd = args[0];
			if (halCmd.equalsIgnoreCase("challenges") || halCmd.equalsIgnoreCase("help") || args.length == 0) {
				player.sendMessage(ChatColor.DARK_AQUA + "Halloween Challenges:");
				player.sendMessage(ChatColor.DARK_GREEN + "Pumpkin Picker: Get 10 pumpkins");
			} else if(args.length > 1){
				player.sendMessage(ChatColor.DARK_RED + "Do /halloween for help!");
			}
			if (halCmd.equalsIgnoreCase("pumpkinpicker")) {
					player.getInventory().contains(Material.PUMPKIN);
					player.getInventory().addItem(cake);
					
			}
		
		}
		return false;
		
	}
	
}
