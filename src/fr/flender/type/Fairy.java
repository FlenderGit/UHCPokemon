package fr.flender.type;

import fr.flender.ability.Ability;
import fr.flender.ability.AbilityUnique;
import fr.flender.data.FairyData;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Type;

public class Fairy extends Type {

	public Fairy(CustomPlayer customPlayer) {
		super(customPlayer,FairyData.name);
		lsAbility.add(new AbilityUnique(FairyData.ability1Item,FairyData.ability1Name,FairyData.ability1Description));
	}


	public void setEffect() {		
	}

}
