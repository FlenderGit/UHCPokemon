package fr.flender.ability;

import java.util.List;

import org.bukkit.inventory.ItemStack;

public class AbilityUnique extends Ability {
	
	boolean use;

	public AbilityUnique(ItemStack item, String name, List<String> description) {
		super(item, name, description);
		this.use = false;
	}

	public boolean getUse() {
		return use;
	}

	public void setUse(boolean use) {
		this.use = use;
	}

}
