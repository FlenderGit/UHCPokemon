package fr.flender.ability;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AbilityCooldown extends AbilityPower {
	
	protected int cooldownMax;
	protected int cooldown;
	
	public AbilityCooldown(ItemStack item,String name,int cooldown,float power,float powerNext, List<String> description) {
		super(item,name,power,powerNext,description);
		this.cooldownMax = cooldown;
	}
	
	public void reduceCooldown() {
		if ( cooldown > 0) {
			cooldown-=1;
		}
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	

	
	
	
	

}
