package fr.flender.type;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.flender.data.BugData;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Type;

public class Bug extends Type {

	public Bug(CustomPlayer customPlayer) {
		super(customPlayer,BugData.name);
	}

	public void setEffect() {
		
		boolean test = true;
		
		for ( PotionEffect potionEffect : customPlayer.getPlayer().getActivePotionEffects()) {
			if ( potionEffect.getType().equals(PotionEffectType.SPEED)) {
				test = false;
			}
		}
		
		if ( test ) {
			customPlayer.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 3600*20, 0, false,false));
		}
	}

}
