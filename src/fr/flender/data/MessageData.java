package fr.flender.data;

import org.bukkit.entity.Player;

import fr.flender.main.Type;

public class MessageData {
	
	public static String prefix = "§c[UHCP] ";
	
	public static String connection(Player player) {
		return prefix + "§eUn " + player.getDisplayName() + " sauvage apparait !";
	}
	
	public static String deconnection(Player player) {
		return prefix + "§eL'ordinateur de " + player.getDisplayName() + " s'est prit une attaque super efficace !";
	}
	
	public static String evolution(String name) {
		return prefix + "§2Vous evoluez en type " + name + " !";
	}
	
	public static String evolutionMate(String name) {
		return prefix + "§2Votre equipier evolue en type " + name + " !";
	}
	
	public static String death(Player player) {
		return prefix + "§c" + player.getDisplayName() + " s'envole vers d'autre cieux !";
	}
	
	

}
