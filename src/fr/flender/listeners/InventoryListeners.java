package fr.flender.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.flender.ability.Ability;
import fr.flender.ability.AbilityPower;
import fr.flender.functions.Minecraft;
import fr.flender.main.CustomPlayer;
import fr.flender.main.Main;

public class InventoryListeners implements Listener {

	private Main main;
	public InventoryListeners(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerInteract(InventoryClickEvent  event) {
		
		CustomPlayer player = main.getCustomPlayer((Player)event.getWhoClicked());
				
		if ( player != null) {
			
			
			Inventory inv = event.getInventory();
			ItemStack item = event.getCurrentItem();
			
			if ( item == null) return;
					
			if (inv.getName().equalsIgnoreCase("Shop") == true) {
				
				event.setCancelled(true);
				
				System.out.print("Test inventory");
				
				Ability ability = player.getType().getAbility( (event.getSlot() - 10)/3);
				
				if ( item.getType() == ability.getItem().getType()) {
					
					// Test price
					
					((AbilityPower)ability).increaseLvl();
					player.getPlayer().sendMessage("Your ability " + ability.getName() + " is now level " + ability.getLevel());
				}
				player.getPlayer().closeInventory();
				player.getPlayer().openInventory(Minecraft.makeInventory(player));
			}
			
		}
		
	}
		
	
}
