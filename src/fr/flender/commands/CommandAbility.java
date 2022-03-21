package fr.flender.commands;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import fr.flender.ability.Ability;
import fr.flender.functions.Minecraft;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Main;
import net.minecraft.server.v1_8_R1.BlockStainedGlass;

public class CommandAbility implements CommandExecutor {
	
	Main main;
	public CommandAbility(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg) {

		if ( sender instanceof Player) {
			
			CustomPlayer player = main.getCustomPlayer((Player) sender);
			
			if ( player != null) {
				
				player.getPlayer().openInventory(Minecraft.makeInventory(player));
			
			}
			
			
			
		}
		
		
		return false;
	}

}
