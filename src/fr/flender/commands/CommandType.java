package fr.flender.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.flender.main.CustomPlayer;
import fr.flender.main.Main;
import fr.flender.type.Fire;

public class CommandType implements CommandExecutor {
	
	Main main;
	public CommandType(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg) {
		
		if ( sender instanceof Player) {
			
			if ( sender.isOp() ) {
				
				if ( arg.length == 2) {
					sender.sendMessage(arg[0] + ' ' + arg[1]);
										
					CustomPlayer customPlayer = main.getCustomPlayer(Bukkit.getServer().getPlayer(arg[0]));
					
					if( customPlayer != null) {
						
						
						
						switch ( arg[1].toUpperCase() ){
							
						case "FIRE":
							customPlayer.setType(new Fire());
							break;
							
						default:
							sender.sendMessage("This type is not know.");
						}
						
						
					}else {
						sender.sendMessage(arg[0] + " is not a player");
					}

				}else {
					sender.sendMessage("Usage : /settype [player] [type]");
				}
				
				
			}else {
				sender.sendMessage("The command is allow to administrators.");
			}
			
		}else {
			System.out.println("This command is not allow from the shell.");
		}
		
		return false;
	}

}
