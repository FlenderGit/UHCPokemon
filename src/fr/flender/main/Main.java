package fr.flender.main;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import fr.flender.commands.CommandType;
import fr.flender.listeners.ConnectionListeners;
import fr.flender.loader.Recipe;


public class Main extends JavaPlugin {
	
	public ArrayList<CustomPlayer> lsCustomPlayer = new ArrayList<CustomPlayer>();
	
	
	
	@Override
	public void onEnable() {
		System.out.println("Plugin On");
		getCommand("setType").setExecutor(new CommandType(this));
		
		getServer().getPluginManager().registerEvents(new ConnectionListeners(this), this);
		
		
		
		Recipe.loadRecipe();

	}
	
	@Override
	public void onDisable() {
		System.out.println("Plugin Off");
	}

	
	
	public CustomPlayer getCustomPlayer(Player player) {
		boolean find = false;
		int i = 0;
		CustomPlayer customPlayer = null;
		
		while (!(find) && i<lsCustomPlayer.size()) {
			if (player.getUniqueId().equals(lsCustomPlayer.get(i).getPlayer().getUniqueId())) {
				find = true;
				customPlayer = lsCustomPlayer.get(i);
			}
			
			i++;
		}
		return customPlayer;
	}
	
	public void addToList(Player player) {
		lsCustomPlayer.add(new CustomPlayer(player));
	}
	

}
