package fr.flender.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.flender.data.Error;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Main;

public class CommandTeam implements CommandExecutor {

	Main main;
	public CommandTeam(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg) {

		if ( !(sender instanceof Player) || sender.isOp()) {
			
			if ( arg.length == 3) {
				
				CustomPlayer customPlayer1 = main.getCustomPlayer(Bukkit.getServer().getPlayer(arg[0]));
				CustomPlayer customPlayer2 = main.getCustomPlayer(Bukkit.getServer().getPlayer(arg[1]));
				String color = ChatColor.translateAlternateColorCodes('&', arg[2]);

				
				if ( customPlayer1 != null && customPlayer2 != null) {
					
					if ( color != null) {
						
						if ( customPlayer1.getMate() != null) {
							customPlayer1.getMate().setMate(null);
						}
						
						if ( customPlayer2.getMate() != null) {
							customPlayer2.getMate().setMate(null);
						}
						
						// Set mate
						customPlayer1.setMate(customPlayer2);
						customPlayer2.setMate(customPlayer1);
						sender.sendMessage(customPlayer1.getPlayer().getCustomName() + " and " + customPlayer2.getPlayer().getCustomName() + " are now in the same team");
						
						// Set Tab
						customPlayer1.getPlayer().setPlayerListName(color + customPlayer1.getPlayer().getCustomName() );
						customPlayer2.getPlayer().setPlayerListName(color + customPlayer2.getPlayer().getCustomName() );

						
					}else {
						sender.sendMessage(Error.unknown("color"));
					}
					
					
					

				}
				
			}else {
				sender.sendMessage("Usage : /setTeam [player] [player] [color]");
			}
			
			
			
		}else {
			sender.sendMessage(Error.errorPermission);
		}
		
		return false;
	}

}
