package fr.flender.type;

import fr.flender.ability.AbilityCooldown;
import fr.flender.data.GrassData;
import fr.flender.data.WaterData;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Type;

public class Grass extends Type {

	public Grass(CustomPlayer customPlayer) {
		super(customPlayer,GrassData.name);
		lsAbility.add(new AbilityCooldown(GrassData.ability1Item,GrassData.ability1Name,GrassData.ability1Cooldown,GrassData.ability1PowerLvl1,GrassData.ability1NextLvl,GrassData.ability1Description));
	}

	
	
	
	public void setEffect() {		
	}

}
