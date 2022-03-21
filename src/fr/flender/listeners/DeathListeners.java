package fr.flender.listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import fr.flender.data.MessageData;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Main;
import fr.flender.type.Psychic;

public class DeathListeners implements Listener {
	
	CustomPlayer player;
	
	private Random rd;
	private Main main;
	public DeathListeners(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerInteract(EntityDamageByEntityEvent  event) {
		
		if ( !(event.getDamager() instanceof Player)) return; 

		
		LivingEntity entity = (LivingEntity) event.getEntity();
		CustomPlayer player = main.getCustomPlayer((Player)event.getDamager());		

		
		
		
		if ( entity.getHealth() - event.getDamage() > 0) return;
		
		int token = 0;
		
		if ( player.getMate() == null) return;
			
		
		switch(entity.getName()) {
		
		case "Player":
			return;
			
		case "Zombie":
			token = 10;
			break;
		
		}
		
		if ( (player.getType() instanceof Psychic || player.getMate().getType() instanceof Psychic) && rd.nextFloat() < .5 ) token *= .6;

		
		player.addToken(token);
		player.getPlayer().sendMessage(" §e+" + token + " jetons");
		
		
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerDeathEvent event) {
		MessageData.death(event.getEntity());
	}

}
