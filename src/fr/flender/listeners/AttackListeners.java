package fr.flender.listeners;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.flender.ability.AbilityWithDuration;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Main;
import fr.flender.type.Bug;
import fr.flender.type.Electric;
import fr.flender.type.Fairy;
import fr.flender.type.Fire;
import fr.flender.type.Flying;
import fr.flender.type.Grass;
import fr.flender.type.Poison;
import fr.flender.type.Psychic;
import fr.flender.type.Steel;
import fr.flender.type.Ground;
import fr.flender.type.Ice;

public class AttackListeners implements Listener {
	
	Random rd = new Random();
	private Main main;
	public AttackListeners(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerDamageFromPlayer(EntityDamageByEntityEvent  event) {
		
		if ( event.getDamager() instanceof Player) {
			
			
			CustomPlayer attacker = main.getCustomPlayer( (Player) event.getDamager() ) ;
			
			if ( attacker.getType() instanceof Fire && ((AbilityWithDuration)attacker.getType().getAbility(0)).getState() == true ) {
				event.getEntity().setFireTicks( 4 * 20);
				
			} else if (attacker.getType() instanceof Fire) {
				event.setDamage(event.getDamage()*.9);
			}else if (event.getEntity() instanceof Player) {
				
				if ( attacker.getType() instanceof Grass) {
					attacker.getPlayer().setHealth(attacker.getPlayer().getHealth() + event.getDamage() * 1);
				}else if ( attacker.getType() instanceof Ground) {
					if (rd.nextBoolean()) return;
					event.setDamage(event.getDamage()*1.5);
				}
				
			}

			
		}else if (event.getEntity() instanceof Player) {
			
			CustomPlayer player = main.getCustomPlayer((Player) event.getEntity());
			
			if ( player.getType() instanceof Poison || player.getMate().getType() instanceof Poison) {
				
				if ( !(event.getDamager() instanceof Player)) {
					event.setCancelled(true);
				}
				
			}else if ( player.getType() instanceof Ground) {
	            player.getPlayer().setVelocity(player.getPlayer().getLocation().getDirection().multiply(.9));

			}
		
		
		
		}else if ( event.getDamager() instanceof Arrow) {
			
			Arrow arrow = (Arrow) event.getDamager();
			
			CustomPlayer attacker = main.getCustomPlayer( (Player) arrow.getShooter() ) ;

			if ( attacker.getMate() != null) {
				if ( (attacker.getType() instanceof Psychic && ((AbilityWithDuration)attacker.getType().getAbility(1)).getState() == true) ||
						(attacker.getMate().getType() instanceof Psychic && ((AbilityWithDuration)attacker.getMate().getType().getAbility(1)).getState() == true)) {
					event.setDamage(event.getDamage()*1.2);
				}
				
			}
			
			if ( attacker.getType() instanceof Fairy){
				event.setDamage(event.getDamage()*1.2);
			}else if ( attacker.getType() instanceof Grass){
	            //event.getEntity().setVelocity(event.getEntity().getLocation().getDirection().multiply(-10));
				event.getEntity().setVelocity(arrow.getVelocity().normalize().multiply(0.47 + new Random().nextDouble() / 70 + arrow.getKnockbackStrength() / 1.42).setY(0.400023).multiply(-1));
				arrow.remove();
				event.setCancelled(true);

			}else if ( attacker.getType() instanceof Electric){
				if (rd.nextFloat() < .3 && 	((AbilityWithDuration) attacker.getType().getAbility(0)).getState() ) {
					arrow.getWorld().strikeLightning(arrow.getLocation());
				}
			}else if ( attacker.getType() instanceof Ice){
				if ( !(event.getEntity() instanceof Player) ) return;
				if (rd.nextFloat() < .3 ) {
					((Player)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2*20, 0, false,false));
				}
			}
			
			
		}
		
	}
	
	@EventHandler
	public void onPlayerDamageFromOther(EntityDamageEvent event) {
		
		Entity entity = event.getEntity();
		
		if ( entity instanceof Player) {
			
			CustomPlayer player = main.getCustomPlayer((Player)entity);
						
			
			DamageCause cause = event.getCause();

			if ( player.getType() instanceof Steel) {
		        
		        if ( cause.equals(DamageCause.LAVA)) {
		        	
		        	event.setDamage(event.getDamage()*1.2);
		        	
		        }
			}else if ( player.getType() instanceof Bug) {
				
				if ( cause.equals(DamageCause.FALL)) {
		        	
		        	event.setDamage(0);
		        	
		        }
				
			}else if ( player.getType() instanceof Flying) {
				
				if ( cause.equals(DamageCause.FALL)) {
		        	
		        	event.setDamage(event.getDamage()*0.9);
		        	
		        }
				
			}
			
	        

		}
		
	}

}
