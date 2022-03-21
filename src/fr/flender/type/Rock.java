package fr.flender.type;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.flender.data.RockData;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Type;

public class Rock extends Type {

	public Rock(CustomPlayer customPlayer) {
		super(customPlayer,RockData.name);
	}

	public void setEffect() {
		
		boolean test = true;
		
		for ( PotionEffect potionEffect : customPlayer.getPlayer().getActivePotionEffects()) {
			if ( potionEffect.getType().equals(PotionEffectType.FAST_DIGGING)) {
				test = false;
			}
		}
		
		if ( test ) {
			customPlayer.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 3600*20, 1, false,false));
		}
	}

}
