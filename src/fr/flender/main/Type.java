package fr.flender.main;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.flender.ability.Ability;
import fr.flender.ability.AbilityCooldown;

public abstract class Type {
	
	protected CustomPlayer customPlayer;
	protected ArrayList<Ability> lsAbility = new ArrayList<Ability>();
	private String name;

	
	public Type(CustomPlayer customPlayer,String name) {
		this.customPlayer = customPlayer;
		this.name = name;
	}
	
	public void reduceCooldown() {
		for ( Ability ability : lsAbility) {
			if ( ability instanceof AbilityCooldown) {
				((AbilityCooldown)ability).reduceCooldown();
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public Ability getAbility(int ability) {
		return lsAbility.get(ability);
	}
	
	
	public ArrayList<Ability> getLsAbility() {
		return lsAbility;
	}

	public abstract void setEffect();
	
	public void getItems(CustomPlayer player) {
		for ( Ability ability : player.getType().getLsAbility()) {
			ItemStack itemAdd = new ItemStack(ability.getItem());
			ItemMeta itemMeta = itemAdd.getItemMeta();
			itemMeta.setDisplayName(ability.getName());
			itemAdd.setItemMeta(itemMeta);
			player.getPlayer().getInventory().addItem(itemAdd);
		}
		player.getPlayer().updateInventory();
	}
	
}
