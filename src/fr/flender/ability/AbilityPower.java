package fr.flender.ability;

import java.util.List;

import org.bukkit.inventory.ItemStack;

public class AbilityPower extends Ability {
	
	protected float power;
	protected float powerNext;


	public AbilityPower(ItemStack item, String name, float power, float powerNext, List<String> description) {
		super(item, name, description);
		this.power = power;
		this.powerNext = powerNext;
	}
	
	public void increaseLvl() {
		level++;
		power+=powerNext;
	}
	
	public void setPower(float power) {
		this.power = power;
	}

	public float getPower() {
		return power;
	}

}
