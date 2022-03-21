package fr.flender.functions;

import org.bukkit.Location;

import fr.flender.main.CustomPlayer;

public class Utils {
	
	public static double getDistance(CustomPlayer player1 , CustomPlayer player2) {
		Location loc1 = player1.getPlayer().getLocation();
		Location loc2 = player2.getPlayer().getLocation();
		return Math.sqrt( Math.pow( loc1.getX() - loc2.getX() , 2 ) + Math.pow( loc1.getY() - loc2.getY() , 2 ) );
	}

}
