package fr.flender.type;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.flender.ability.Ability;
import fr.flender.ability.AbilityCooldown;
import fr.flender.ability.AbilityWithDuration;
import fr.flender.data.FireData;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Type;

public class Fire extends Type {
		
	public Fire(CustomPlayer customPlayer) {
		super(customPlayer,FireData.name);
		lsAbility.add(new AbilityWithDuration(FireData.ability1Item,FireData.ability1Name,FireData.ability1Cooldown,FireData.ability1lenght,FireData.ability1lenght,FireData.ability1NextLvl,FireData.ability1Description));
		lsAbility.add(new AbilityCooldown(FireData.ability2Item,FireData.ability2Name,FireData.ability2Cooldown,FireData.ability2PowerLvl1,FireData.ability2NextLvl,FireData.ability2Description));
	}

	public void setEffect() {
		boolean test = true;
		
		for ( PotionEffect potionEffect : customPlayer.getPlayer().getActivePotionEffects()) {
			if ( potionEffect.getType().equals(PotionEffectType.FIRE_RESISTANCE) ) {
				test = false;
			}
		}
		
		
		if ( test ) {
			customPlayer.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600*20, 0, false,false));
		}
	}

}
