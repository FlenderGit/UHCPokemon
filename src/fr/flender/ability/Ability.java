package fr.flender.ability;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Ability {
	
	protected int level;
	private ItemStack item;
	protected String name;
	private List description;
	
	public Ability(ItemStack item , String name,List<String> description) {
		this.item = item;
		this.name = name;
		this.description = description;
		this.level = 0;
	}
	
	public List<String> getDescription() {
		return Arrays.asList((String)description.get(0) , description.get(1) + " " + power + description.get(2) , "Next level : " + (power+powerNext) + description.get(2) );
	}
	
	public String getName() {
		return name;
	}
	
	

	public int getLevel() {
		return level;
	}

	public ItemStack getItem() {
		return item;
	}
	
	
	
	
	
	

}
