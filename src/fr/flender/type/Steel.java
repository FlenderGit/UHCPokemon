package fr.flender.type;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.flender.ability.AbilityWithDuration;
import fr.flender.data.GhostData;
import fr.flender.data.SteelData;
import fr.flender.functions.Utils;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Type;

public class Steel extends Type {

	public Steel(CustomPlayer customPlayer) {
		super(customPlayer,SteelData.name);
	}

	public void setEffect() {
		AbilityWithDuration ability = (AbilityWithDuration) customPlayer.getType().getAbility(0);
		if(!(ability.getState())) {
			customPlayer.getPlayer().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			customPlayer.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 7	*20, 0, false,false));
		}
		
		if ( customPlayer.getMate() != null) {
			if ( Utils.getDistance(customPlayer, customPlayer.getMate()) <= SteelData.distanceResistance ){
				
				boolean test = true;
				
				for ( PotionEffect potionEffect : customPlayer.getPlayer().getActivePotionEffects()) {
					if ( potionEffect.getType().equals(PotionEffectType.DAMAGE_RESISTANCE)) {
						test = false;
					}
				}
				
				if ( test ) {
					customPlayer.getMate().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 3600*20, 0, false,false));
				}
				
				}else {
				customPlayer.getPlayer().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
				customPlayer.getMate().getPlayer().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			}
		}
		
	}

}
