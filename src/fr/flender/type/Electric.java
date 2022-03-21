package fr.flender.type;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.flender.ability.AbilityWithDuration;
import fr.flender.data.ElectricData;
import fr.flender.data.FireData;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Type;

public class Electric extends Type {

	public Electric(CustomPlayer customPlayer) {
		super(customPlayer,ElectricData.name);
		lsAbility.add(new AbilityWithDuration(ElectricData.ability1Item,ElectricData.ability1Name,ElectricData.ability1Cooldown,ElectricData.ability1lenght,ElectricData.ability1lenght,ElectricData.ability1NextLvl,ElectricData.ability1Description));
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
