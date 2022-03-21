package fr.flender.ability;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.flender.data.SteelData;
import fr.flender.data.TypeData;

public class AbilityWithDuration extends AbilityCooldown {
	
	private int duration;
	private boolean state;

	public AbilityWithDuration(ItemStack item,String name, int cooldown,int duration,float power,float powerNext , List<String> description) {
		super(item,name,cooldown,power,powerNext,description);
		this.duration = duration;
	}
	
	public void reduceCooldown() {
		if ( cooldown == cooldownMax ) {
			state = false;
		}
		if ( cooldown > 0) {
			cooldown-=1;
		}
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public boolean testAbilityCooldown(Player player, int totalCooldown) {
		
		if ( this.state ) {
			player.sendMessage(cooldown+ "You are currently using this ability");
		}else if ( this.getCooldown() == 0 ) {
			this.setState(true);
			this.setCooldown(totalCooldown);
			player.sendMessage("Activation de la competence : ");
		}else {
			player.sendMessage(TypeData.cooldown(this.getCooldown()));
		}
		
		return this.state;
		
	}

}
