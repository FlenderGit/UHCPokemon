package fr.flender.listeners;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import fr.flender.ability.AbilityCooldown;
import fr.flender.main.Main;

import org.bukkit.entity.Player;

public class ProjectilsListeners implements Listener {
	
	private Main main;
	public ProjectilsListeners(Main main) {
		this.main = main;
	}
	
	@EventHandler   
    public void hitfireball(ProjectileHitEvent evento) {
        EntityType fball = evento.getEntityType();
        if( fball != null && fball.equals(EntityType.FIREBALL)) {
            Fireball f = (Fireball) evento.getEntity();
            Location location = f.getLocation();
            if ( f.getShooter() instanceof Player ) {
            	AbilityCooldown ability = (AbilityCooldown) main.getCustomPlayer((Player) f.getShooter() ).getType().getAbility(1);
                f.getWorld().createExplosion(location, Float.valueOf( ability.getPower() ));
            }
                   
        }
    }

}
