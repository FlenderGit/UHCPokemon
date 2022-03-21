package fr.flender.type;

import fr.flender.ability.AbilityCooldown;
import fr.flender.data.FightingData;
import fr.flender.data.PoisonData;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Type;

public class Poison extends Type {

	public Poison(CustomPlayer customPlayer) {
		super(customPlayer,PoisonData.name);
		lsAbility.add(new AbilityCooldown(PoisonData.ability1Item,PoisonData.ability1Name,PoisonData.ability1Cooldown,PoisonData.ability1PowerLvl1,PoisonData.ability1NextLvl,PoisonData.ability1Description));
		lsAbility.add(new AbilityCooldown(PoisonData.ability2Item,PoisonData.ability2Name,PoisonData.ability2Cooldown,PoisonData.ability2PowerLvl1,PoisonData.ability2NextLvl,PoisonData.ability2Description));
	}

	public void setEffect() {		
	}

}
