package fr.flender.type;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.flender.ability.AbilityCooldown;
import fr.flender.data.FireData;
import fr.flender.data.WaterData;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Type;

public class Water extends Type{
	
	private int timer = 0;

	public Water(CustomPlayer customPlayer) {
		super(customPlayer,WaterData.name);
	}

	public void setEffect() {
		
		boolean test = true;
		
		for ( PotionEffect potionEffect : customPlayer.getPlayer().getActivePotionEffects()) {
			if ( potionEffect.getType().equals(PotionEffectType.SPEED) ) {
				test = false;
			}
		}
		
		
		if ( test ) {
			customPlayer.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 3600*20, 0, false,false));
		}
		
		
		if ( timer == 24) {
			timer = 0;
			
			Player player = customPlayer.getPlayer();
			if ( player.getHealth() < player.getHealthScale()-1) {
				player.setHealth(player.getHealth()+1);
			}
			if (customPlayer.getMate() == null) return;

			Player mate  = customPlayer.getMate().getPlayer();			
			
			if ( mate.getHealth() < mate.getHealthScale()-1) {
				mate.setHealth(mate.getHealth()+1);
			}
		}else {
			timer++;
		}
		
	}

	

}
