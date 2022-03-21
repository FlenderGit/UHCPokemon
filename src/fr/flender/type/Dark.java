package fr.flender.type;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.flender.data.DarkData;
import fr.flender.functions.Minecraft;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Type;

public class Dark extends Type {

	public Dark(CustomPlayer customPlayer) {
		super(customPlayer,DarkData.name);
	}

	public void setEffect() {
		
		if ( !(Minecraft.day()) ) {
			boolean test = true;
			
			for ( PotionEffect potionEffect : customPlayer.getPlayer().getActivePotionEffects()) {
				if ( potionEffect.getType().equals(PotionEffectType.SPEED)) {
					test = false;
				}
			}
			
			if ( test ) {
				customPlayer.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 3600*20, 0, false,false));
			}
		}else {
			customPlayer.getPlayer().removePotionEffect(PotionEffectType.SPEED);
		}
		
		
		if ( customPlayer.getPlayer().getHealth() < 4) {
			
			boolean test = true;
			
			for ( PotionEffect potionEffect : customPlayer.getPlayer().getActivePotionEffects()) {
				if ( potionEffect.getType().equals(PotionEffectType.WEAKNESS)) {
					test = false;
				}
			}
			
			if ( test ) {
				customPlayer.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 3600*20, 2, false,false));
			}
			
		}else {
			customPlayer.getPlayer().removePotionEffect(PotionEffectType.WEAKNESS);
		}
		
	}

}
