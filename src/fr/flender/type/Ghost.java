package fr.flender.type;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.flender.data.GhostData;
import fr.flender.functions.Minecraft;
import fr.flender.functions.Utils;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Type;

public class Ghost extends Type {
	
	public Ghost(CustomPlayer customPlayer) {
		super(customPlayer,GhostData.name);
	}


	public void setEffect() {
		if ( customPlayer.getMate() != null) {
			if ( Utils.getDistance(customPlayer, customPlayer.getMate()) <= GhostData.distanceInvisibility ){
				
				boolean test = true;
				
				for ( PotionEffect potionEffect : customPlayer.getPlayer().getActivePotionEffects()) {
					if ( potionEffect.getType().equals(PotionEffectType.INVISIBILITY)) {
						test = false;
					}
				}
								
				if ( test ) {
					customPlayer.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 3600*20, 0, false,false));
					customPlayer.getMate().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 3600*20, 0, false,false));
				}
				
				}else {
				customPlayer.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
				customPlayer.getMate().getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
			}
		}
		
		if ( !(Minecraft.day()) ) {
			
			boolean test = true;
			
			for ( PotionEffect potionEffect : customPlayer.getPlayer().getActivePotionEffects()) {
				if ( potionEffect.getType().equals(PotionEffectType.INCREASE_DAMAGE)) {
					test = false;
				}
			}
			
			if ( test ) {
				customPlayer.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3600*20, 0, false,false));
			}
			
		}else {
			customPlayer.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		}
		
	}

	
		
	
	

}
