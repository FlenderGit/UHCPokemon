package fr.flender.type;

import fr.flender.ability.Ability;
import fr.flender.ability.AbilityCooldown;
import fr.flender.ability.AbilityWithDuration;
import fr.flender.data.PsychicData;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Type;

public class Psychic extends Type {

	public Psychic(CustomPlayer customPlayer) {
		super(customPlayer,PsychicData.name);
		lsAbility.add(new AbilityCooldown(PsychicData.ability1Item,PsychicData.ability1Name,PsychicData.ability1Cooldown,PsychicData.ability1PowerLvl1,PsychicData.ability1NextLvl,PsychicData.ability1Description));
		lsAbility.add(new AbilityWithDuration(PsychicData.ability2Item,PsychicData.ability2Name,PsychicData.ability2Cooldown,PsychicData.ability2lenght,PsychicData.ability2lenght,PsychicData.ability2NextLvl,PsychicData.ability2Description));
	}

	public void setEffect() {
	}

	

}
