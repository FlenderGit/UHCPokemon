package fr.flender.loader;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import fr.flender.data.FireData;


public class Recipe {
	
	
	
	@SuppressWarnings("deprecation")
	public static void loadRecipe() {
		
		ItemStack fire = new ItemStack(Material.MAGMA_CREAM,1);
		
		ItemMeta itemMeta = fire.getItemMeta();
		itemMeta.setDisplayName(FireData.nameStone);
		fire.setItemMeta(itemMeta);
		
		ShapedRecipe fireStone = new ShapedRecipe(fire);
		fireStone.shape("%*%", "XBX", "%*%");
		fireStone.setIngredient('*', Material.FLINT_AND_STEEL);
		fireStone.setIngredient('%', Material.FLINT);
		fireStone.setIngredient('X', Material.LAVA_BUCKET);
		fireStone.setIngredient('B', Material.TORCH);
		Bukkit.getServer().addRecipe(fireStone);

		
		
		System.out.print("Recipes loaded");
		
	}
	


}
