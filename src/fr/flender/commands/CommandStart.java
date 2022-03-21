package fr.flender.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.flender.main.Main;
import fr.flender.tasks.AutoStart;

public class CommandStart implements CommandExecutor {
	
	Main main;
	public CommandStart(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg) {
		
		
		if ( sender instanceof Player ) {
			

			
			if ( sender.isOp()) {
				
				AutoStart start = new AutoStart(main);
				start.runTaskTimer(main, 0, 20);
				
				sender.sendMessage("Test");
				
			}
			
		}
		
		return false;
	}

}
