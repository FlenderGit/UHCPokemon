package fr.flender.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.flender.data.MessageData;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Handler;
import fr.flender.main.Main;

public class ConnectionListeners implements Listener {
	
	private Main main;
	private Handler handler;
	public ConnectionListeners(Main main,Handler handler) {
		this.main = main;
		this.handler = handler;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		CustomPlayer player = main.getCustomPlayer(event.getPlayer());
		

		if (player == null) {
			main.addToList(event.getPlayer());
			System.out.println("Ajout de " + event.getPlayer() + main.lsCustomPlayer.size());
			handler.setNbPlayerAlive(handler.getNbPlayerAlive()+1);
		
		}
		
		event.setJoinMessage(MessageData.connection(event.getPlayer()));

		
		
	}
	
	@EventHandler
	public void onLeft(PlayerQuitEvent event) {
		CustomPlayer player = main.getCustomPlayer(event.getPlayer());
		if ( player != null ) {
			handler.setNbPlayerAlive(handler.getNbPlayerAlive()-1);
		}
		event.setQuitMessage(MessageData.deconnection(event.getPlayer()));
	}

}
