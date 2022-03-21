package fr.flender.type;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.flender.ability.AbilityCooldown;
import fr.flender.ability.AbilityWithDuration;
import fr.flender.data.FightingData;
import fr.flender.data.FireData;
import fr.flender.data.GhostData;
import fr.flender.data.PsychicData;
import fr.flender.functions.Utils;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Type;

public class Fighting extends Type{

	public Fighting(CustomPlayer customPlayer) {
		super(customPlayer,FightingData.name);
		lsAbility.add(new AbilityCooldown(FightingData.ability1Item,FightingData.ability1Name,FightingData.ability1Cooldown,FightingData.ability1PowerLvl1,FightingData.ability1NextLvl,FightingData.ability1Description));
		lsAbility.add(new AbilityWithDuration(FightingData.ability2Item,FightingData.ability2Name,FightingData.ability2Cooldown,FightingData.ability2lenght,FightingData.ability2lenght,FightingData.ability2NextLvl,FightingData.ability2Description));
	}

	public void setEffect() {
		
		if ( customPlayer.getPlayer().getHealth() < 4 || ( ((AbilityWithDuration)getAbility(1)).getState() )) {
			
			boolean test = true;
			
			for ( PotionEffect potionEffect : customPlayer.getPlayer().getActivePotionEffects()) {
				if ( potionEffect.getType().equals(PotionEffectType.INCREASE_DAMAGE)) {
					test = false;
				}
			}
			
			if ( test ) {
				customPlayer.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3600*20, 1, false,false));
			}
			
		}else {
			customPlayer.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		}
				
	}

}
