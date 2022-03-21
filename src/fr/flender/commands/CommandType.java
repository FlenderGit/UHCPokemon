package fr.flender.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import fr.flender.data.MessageData;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Main;
import fr.flender.type.Bug;
import fr.flender.type.Dark;
import fr.flender.type.Dragon;
import fr.flender.type.Electric;
import fr.flender.type.Fairy;
import fr.flender.type.Fighting;
import fr.flender.type.Fire;
import fr.flender.type.Flying;
import fr.flender.type.Ghost;
import fr.flender.type.Grass;
import fr.flender.type.Ground;
import fr.flender.type.Ice;
import fr.flender.type.Normal;
import fr.flender.type.Poison;
import fr.flender.type.Psychic;
import fr.flender.type.Rock;
import fr.flender.type.Steel;
import fr.flender.type.Water;

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
										
					CustomPlayer customPlayer = main.getCustomPlayer(Bukkit.getServer().getPlayer(arg[0]));
					
					if( customPlayer != null) {
						
						
						for ( PotionEffect potionEffect : customPlayer.getPlayer().getActivePotionEffects() ) {
							customPlayer.getPlayer().removePotionEffect(potionEffect.getType());
						}

						
						switch ( arg[1].toUpperCase() ){
						
						case "BUG":
							customPlayer.setType(new Bug(customPlayer));
							break;
							
						case "DARK":
							customPlayer.setType(new Dark(customPlayer));
							break;
							
						case "DRAGON":
							customPlayer.setType(new Dragon(customPlayer));
							break;
							
						case "ELECTRIC":
							customPlayer.setType(new Electric(customPlayer));
							break;
							
						case "FAIRY":
							customPlayer.setType(new Fairy(customPlayer));
							break;
							
						case "FIGHTING":
							customPlayer.setType(new Fighting(customPlayer));
							break;
						
						case "FIRE":
							customPlayer.setType(new Fire(customPlayer));
							break;
							
						case "FLYING":
							customPlayer.setType(new Flying(customPlayer));
							break;
							
						case "GHOST":
							customPlayer.setType(new Ghost(customPlayer));
							break;
							
						case "GRASS":
							customPlayer.setType(new Grass(customPlayer));
							break;
							
						case "GROUND":
							customPlayer.setType(new Ground(customPlayer));
							break;
							
						case "ICE":
							customPlayer.setType(new Ice(customPlayer));
							break;
							
						case "NORMAL":
							customPlayer.setType(new Normal(customPlayer));
							break;
							
						case "POISON":
							customPlayer.setType(new Poison(customPlayer));
							break;
							
						case "PSYCHIC":
							customPlayer.setType(new Psychic(customPlayer));
							break;
							
						case "ROCK":
							customPlayer.setType(new Rock(customPlayer));
							break;
							
						case "STEEL":
							customPlayer.setType(new Steel(customPlayer));
							break;
							
						case "WATER":
							customPlayer.setType(new Water(customPlayer));
							break;
						
							
						default:
							sender.sendMessage("This type is not known.");
							return false;
						}
						
						customPlayer.getType().getItems(customPlayer);
						sender.sendMessage(MessageData.evolution(customPlayer.getType().getName()));
	
						
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
