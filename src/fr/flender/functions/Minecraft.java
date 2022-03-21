package fr.flender.functions;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.Vector;

import fr.flender.ability.Ability;
import fr.flender.main.CustomPlayer;

public class Minecraft {
	
	public static void spawnFireball(CustomPlayer player) {
		Location location = player.getPlayer().getLocation();
		location.setY(location.getY()+1);
		Fireball fireball = player.getPlayer().getWorld().spawn(location, Fireball.class);
        Vector vel = fireball.getDirection();
        fireball.setBounce(false);

        fireball.setVelocity(vel.multiply(5));
        
        fireball.setDirection(vel.multiply(5));

        fireball.setShooter(player.getPlayer());
	}
	
	public static boolean day() {
	    Server server = Bukkit.getServer();
	    long time = server.getWorld("world").getTime();
	    return time < 12300 || time > 23850;
	}
	
	public static Inventory makeInventory(CustomPlayer player) {
		
		Inventory inv = Bukkit.createInventory(null, 27, "Shop");
		
		ItemStack glassB = new ItemStack(Material.STAINED_GLASS_PANE , 1 , (short) 15);
		
		for ( int i = 0 ; i < 4 ; i++) {
			inv.setItem(i, glassB);
		}
		
		ItemStack skull = Minecraft.getPlayerHead(player.getPlayer());
		ItemMeta skullMeta = skull.getItemMeta();
		skullMeta.setDisplayName(player.getPlayer().getDisplayName() + " " + player.getType().getClass().getSimpleName());
		skullMeta.setLore(Arrays.asList(player.getToken() + " tokens"));
		skull.setItemMeta(skullMeta);
		inv.setItem(4, skull);
		
		for ( int i = 5 ; i < 10 ; i++) {
			inv.setItem(i, glassB);
		}
		for ( int i = 17 ; i < 27 ; i++) {
			inv.setItem(i, glassB);
		}
		
		for ( int i = 0 ; i < player.getType().getLsAbility().size() ; i++) {
			Ability ability = player.getType().getLsAbility().get(i);
			ItemStack item = ability.getItem();
			ItemMeta itemMeta = item.getItemMeta();
			itemMeta.setDisplayName(ability.getName());
			itemMeta.setLore(ability.getDescription());
			item.setItemMeta(itemMeta);
			inv.setItem(10+i*3,item);

		}
		return inv;
	}
	
	public static ItemStack getPlayerHead(Player player) {
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(player.getDisplayName());
        skull.setItemMeta(meta);
        return skull;
	}

}
