package me.BaughRohanPkerb0y.Halloween;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

public class Halloween extends JavaPlugin {
	Logger logger = getLogger();

	public void onEnable() {
		logger.info("Enabling Halloween by Baugh70, Rohan576, and Pkerb0y!");
		this.getCommand("halloween").setExecutor(this);
		this.getCommand("hw").setExecutor(this);
	}

	public void onDisable() {
		logger.info("Halloween is now disabled.");
	}
	
	public void challenge(ItemStack add, ItemStack remove, Player player) {
		player.getInventory().addItem(remove);
		player.getInventory().remove(add);
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
							player.sendMessage(ChatColor.GOLD + "Pumpkin Picker: " + ChatColor.GRAY + "Get 10 pumpkins. Reward: 15 Cakes.");
							player.sendMessage(ChatColor.GOLD + "Pumpkin Carver: " + ChatColor.GRAY + "Get 15 Jack-o-Lanterns. Reward: 1 Diamond.");
							player.sendMessage(ChatColor.GOLD + "Sticky Situation: " + ChatColor.GRAY + "Get 12 Cobwebs. Reward: 1 Spawn Witch Egg.");
							player.sendMessage(ChatColor.GOLD + "Haunted Slayer: " + ChatColor.GRAY + "See the challenge for required items. Reward: 2 Beacons");
							player.sendMessage(ChatColor.GOLD + "Ghostly Ghasts: " + ChatColor.GRAY + "Get 8 Ghast Tears. Reward: 64 Spawn Bat Eggs. (Troll time >:D)");
						}
						else {
							if (halCmd.equalsIgnoreCase("pumpkinpicker")) {
								if (player.getInventory().containsAtLeast(new ItemStack(Material.PUMPKIN), 10)) {
									challenge(new ItemStack(Material.CAKE_BLOCK, 15), new ItemStack(Material.PUMPKIN, 10), player);
									player.sendMessage(ChatColor.GRAY + "Congratulations on completing the " + ChatColor.GOLD + "Pumpkin Picker" + ChatColor.GRAY + " challenge!");
									Bukkit.broadcastMessage(ChatColor.GRAY + "" + player + ChatColor.YELLOW + " completed the " + ChatColor.GOLD + "Punpkin Picker" + ChatColor.YELLOW + " challenge!");
								}
								else {
									player.sendMessage(ChatColor.GOLD + "Pumpkin Picker: " + ChatColor.GRAY + "Gather 10 Pumpkins. Reward: 15 Cakes.");
								}
							}

							if (halCmd.equalsIgnoreCase("pumpkincarver")) {
								if (player.getInventory().containsAtLeast(new ItemStack(Material.JACK_O_LANTERN), 15)) {
									challenge(new ItemStack(Material.DIAMOND, 1), new ItemStack(Material.JACK_O_LANTERN, 15), player);
									player.sendMessage(ChatColor.GRAY + "Congratulations on completing the " + ChatColor.GOLD + "Pumpkin Carver" + ChatColor.GRAY + " challenge!");
									Bukkit.broadcastMessage(ChatColor.GRAY + "" + player + ChatColor.YELLOW + " completed the " + ChatColor.GOLD + "Punpkin Carver" + ChatColor.YELLOW + " challenge!");
								}
								else {
									player.sendMessage(ChatColor.GOLD + "Pumpkin Carver: " + ChatColor.GRAY + "Craft 15 Jack-O-Lanterns. Reward: 1 Diamond.");
								}
							}
							if (halCmd.equalsIgnoreCase("stickysituation")) {
								if (player.getInventory().containsAtLeast(new ItemStack(Material.WEB), 12)) {
									challenge(new ItemStack(Material.MONSTER_EGG, 1, (short) 66), new ItemStack(Material.WEB, 12), player);
									player.getInventory().addItem(new ItemStack(Material.MONSTER_EGG, 1, (short) 66));
									player.getInventory().remove(new ItemStack(Material.WEB, 12));
									player.sendMessage(ChatColor.GRAY + "Congratulations on completing the " + ChatColor.GOLD + "Sticky Situation" + ChatColor.GRAY + " challenge!");
									Bukkit.broadcastMessage(ChatColor.GRAY + "" + player + ChatColor.YELLOW + " completed the " + ChatColor.GOLD + "Sticky Situation" + ChatColor.YELLOW + " challenge!");
								}
								else {
									player.sendMessage(ChatColor.GOLD + "Sticky Situation: " + ChatColor.GRAY + "Gather 12 Cobwebs. Reward: 1 Spawn Witch Egg.");
								}
							}
							if (halCmd.equalsIgnoreCase("hauntedslayer")) {
								if (player.getInventory().containsAtLeast(new ItemStack(Material.ROTTEN_FLESH), 64) &&
									player.getInventory().containsAtLeast(new ItemStack(Material.BONE), 64) &&
									player.getInventory().containsAtLeast(new ItemStack(Material.STRING), 64) &&
									player.getInventory().containsAtLeast(new ItemStack(Material.ENDER_PEARL), 64) &&
									player.getInventory().containsAtLeast(new ItemStack(Material.SULPHUR), 64) &&
									player.getInventory().containsAtLeast(new ItemStack(Material.GOLD_NUGGET), 64))
								{
									player.getInventory().addItem(new ItemStack(Material.BEACON, 2));
									player.getInventory().remove(new ItemStack(Material.ROTTEN_FLESH, 64));
									player.getInventory().remove(new ItemStack(Material.BONE, 64));
									player.getInventory().remove(new ItemStack(Material.STRING, 64));
									player.getInventory().remove(new ItemStack(Material.ENDER_PEARL, 64));
									player.getInventory().remove(new ItemStack(Material.SULPHUR, 64));
									player.getInventory().remove(new ItemStack(Material.GOLD_NUGGET, 64));
									player.sendMessage(ChatColor.GRAY + "Congratulations on completing the " + ChatColor.GOLD + "Haunted Slayer" + ChatColor.GRAY + " challenge!");
									Bukkit.broadcastMessage(ChatColor.GRAY + "" + player + ChatColor.YELLOW + " completed the " + ChatColor.GOLD + "Haunted Slayer" + ChatColor.YELLOW + " challenge!");
								}
								else {
									player.sendMessage(ChatColor.GOLD + "Haunted Slayer: " + ChatColor.GRAY + "Gather 64 Rotten Flesh, Gunpowder, Bones, String, Ender Pearls, Golden Nuggets. Reward: 2 Beacons.");
								}
							}
							if (halCmd.equalsIgnoreCase("ghostlyghasts")) {
								if (player.getInventory().containsAtLeast(new ItemStack(Material.GHAST_TEAR), 8)) {
									challenge(new ItemStack(Material.MONSTER_EGG, 64, (short) 65), new ItemStack(Material.GHAST_TEAR, 8), player);
									player.sendMessage(ChatColor.GRAY + "Congratulations on completing the " + ChatColor.GOLD + "Ghastly Ghosts" + ChatColor.GRAY + " challenge!");
									Bukkit.broadcastMessage(ChatColor.GRAY + "" + player + ChatColor.YELLOW + " completed the " + ChatColor.GOLD + "Ghastly Ghosts" + ChatColor.YELLOW + " challenge!");
								}
								else {
									player.sendMessage(ChatColor.GOLD + "Ghostly Ghasts: " + ChatColor.GRAY + "8 Ghast Tears. Reward: 64 Spawn Bat Eggs. (Troll time >:D)");
								}
							}
						}
					}
					else {
						player.sendMessage(ChatColor.GOLD + "Sorry, but you don't have permission for " + ChatColor.GRAY + "halloween challenges" + ChatColor.GOLD + ".");
					}
				}
				if (halCmd.equalsIgnoreCase("multiblock") || halCmd.equalsIgnoreCase("mb")) {
					if (player.hasPermission("halloween.multiblock")) {
						// Will start coding later. This will be my own project.
					}
					else {
						player.sendMessage(ChatColor.GOLD + "Sorry, but you don't have permission for the" + ChatColor.GRAY + "halloween multiblock" + ChatColor.GOLD + ".");
					}
				}
			}
			else {
				player.sendMessage(ChatColor.GRAY + "Halloween Commands:");
				player.sendMessage(ChatColor.GOLD + "/halloween challenges " + ChatColor.BLACK + "-" + ChatColor.GRAY + " list challenges.");
				// More things to come.
			}
		}
		return true;
	}
}

