package fr.flender.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.flender.main.CustomPlayer;
import fr.flender.main.Main;

public class ConnectionListeners implements Listener {
	
	private Main main;
	public ConnectionListeners(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		CustomPlayer player = main.getCustomPlayer(event.getPlayer());
		
		if (player != null) {
			System.out.println("Bienvenue " + event.getPlayer() + main.lsCustomPlayer.size());
			
		}else {
			main.addToList(event.getPlayer());
			System.out.println("Ajout de " + event.getPlayer() + main.lsCustomPlayer.size());
		}
		
		
	}

}
