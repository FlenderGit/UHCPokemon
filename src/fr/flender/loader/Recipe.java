package fr.flender.loader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import fr.flender.data.BugData;
import fr.flender.data.DarkData;
import fr.flender.data.ElectricData;
import fr.flender.data.FightingData;
import fr.flender.data.FireData;
import fr.flender.data.FlyingData;
import fr.flender.data.GhostData;
import fr.flender.data.GrassData;
import fr.flender.data.GroundData;
import fr.flender.data.IceData;
import fr.flender.data.PoisonData;
import fr.flender.data.PsychicData;
import fr.flender.data.RockData;
import fr.flender.data.FairyData;
import fr.flender.data.SteelData;
import fr.flender.data.WaterData;


public class Recipe {

	public static void loadFireStoneRecipe() {
		ItemStack fire = new ItemStack(Material.MAGMA_CREAM,1);
		ItemMeta itemMetaFire = fire.getItemMeta();
		itemMetaFire.setDisplayName(FireData.color + FireData.nameStone);
		fire.setItemMeta(itemMetaFire);
		
		ShapedRecipe fireStone = new ShapedRecipe(fire);
		fireStone.shape("%*%", "XBX", "%*%");
		fireStone.setIngredient('*', Material.FLINT_AND_STEEL);
		fireStone.setIngredient('%', Material.FLINT);
		fireStone.setIngredient('X', Material.LAVA_BUCKET);
		fireStone.setIngredient('B', Material.TORCH);
				
		Bukkit.getServer().addRecipe(fireStone);
	}
	
	public static void loadElectricStoneRecipe() {
		ItemStack elect = new ItemStack(Material.NETHER_BRICK_ITEM,1);
		
		ItemMeta itemMetaElect = elect.getItemMeta();
		itemMetaElect.setDisplayName(ElectricData.color + ElectricData.nameStone);
		elect.setItemMeta(itemMetaElect);
		
		ShapedRecipe electStone = new ShapedRecipe(elect);
		electStone.shape(" *%", "XBX", "%* ");
		electStone.setIngredient('*', Material.IRON_INGOT);
		electStone.setIngredient('%', Material.STICK);
		electStone.setIngredient('X', Material.GOLD_INGOT);
		electStone.setIngredient('B', Material.IRON_BLOCK);
				
		Bukkit.getServer().addRecipe(electStone);
	}
	
	public static void loadDarkStoneRecipe() {
		
		ItemStack dark = new ItemStack(Material.BLAZE_ROD,1);
		
		ItemMeta itemMetaDark = dark.getItemMeta();
		itemMetaDark.setDisplayName(DarkData.color + DarkData.nameStone);
		dark.setItemMeta(itemMetaDark);
		
		ItemStack blackWool = new ItemStack( Material.WOOL, 1 , (short) 15);

		ShapedRecipe darkStone = new ShapedRecipe(dark);
		darkStone.shape("*%*", "X X", "*%*");
		darkStone.setIngredient('*', blackWool.getData());
		darkStone.setIngredient('%', Material.STRING);
		darkStone.setIngredient('X', Material.BONE);
				
		Bukkit.getServer().addRecipe(darkStone);
		
	}
	
	public static void loadIceStoneRecipe() {
		
		ItemStack ice = new ItemStack(Material.NETHER_STAR,1);
		
		ItemMeta itemMetaIce = ice.getItemMeta();
		itemMetaIce.setDisplayName(IceData.color + IceData.nameStone);
		ice.setItemMeta(itemMetaIce);
		
		ShapedRecipe iceStone = new ShapedRecipe(ice);
		iceStone.shape("*%*", "%X%", "*%*");
		iceStone.setIngredient('*', Material.SNOW_BLOCK);
		iceStone.setIngredient('%', Material.SNOW_BALL);
		iceStone.setIngredient('X', Material.WATER_BUCKET);
				
		Bukkit.getServer().addRecipe(iceStone);
		
	}
	
	public static void loadSteelStoneRecipe() {
		
		ItemStack steel = new ItemStack(2262,1);
		
		ItemMeta itemMetaSteel = steel.getItemMeta();
		itemMetaSteel.setDisplayName(SteelData.color + SteelData.nameStone);
		steel.setItemMeta(itemMetaSteel);
		
		ShapedRecipe steelStone = new ShapedRecipe(steel);
		steelStone.shape("*%*", "%X%", "*%*");
		steelStone.setIngredient('*', Material.IRON_INGOT);
		steelStone.setIngredient('%', Material.IRON_FENCE);
		steelStone.setIngredient('X', Material.IRON_BLOCK);
				
		Bukkit.getServer().addRecipe(steelStone);
		
	}
	
public static void loadFightingStoneRecipe() {
		
		ItemStack fighting = new ItemStack(2257,1);
		
		ItemMeta itemMetaFighting = fighting.getItemMeta();
		itemMetaFighting.setDisplayName(FightingData.color + FightingData.nameStone);
		fighting.setItemMeta(itemMetaFighting);
		
		ShapedRecipe fightingStone = new ShapedRecipe(fighting);
		fightingStone.shape(" % ", "XB*", " $ ");
		fightingStone.setIngredient('*', Material.STRING);
		fightingStone.setIngredient('%', Material.ROTTEN_FLESH);
		fightingStone.setIngredient('X', Material.BONE);
		fightingStone.setIngredient('B', Material.DIAMOND_SWORD);
		fightingStone.setIngredient('$', Material.SULPHUR);
				
		Bukkit.getServer().addRecipe(fightingStone);
		
	}

public static void loadWaterStoneRecipe() {
	
	ItemStack water = new ItemStack(Material.EMPTY_MAP,1);
	
	ItemMeta itemMetaWater = water.getItemMeta();
	itemMetaWater.setDisplayName(WaterData.color + WaterData.nameStone);
	water.setItemMeta(itemMetaWater);
	
    ItemStack bottle = new ItemStack(Material.POTION, 1, (byte)0);
	
	ShapedRecipe waterStone = new ShapedRecipe(water);
	waterStone.shape(" % ", "XBX", " % ");
	waterStone.setIngredient('%', Material.RAW_FISH);
	waterStone.setIngredient('X', Material.WATER_BUCKET);
	waterStone.setIngredient('B', bottle.getData());

	Bukkit.getServer().addRecipe(waterStone);
	
}
	
	
	
	public static void loadBugStoneRecipe() {
		
		ItemStack bug = new ItemStack(Material.DIODE,1);
		
		ItemMeta itemMetaBug = bug.getItemMeta();
		itemMetaBug.setDisplayName(BugData.color + BugData.nameStone);
		bug.setItemMeta(itemMetaBug);

		ShapedRecipe bugStone = new ShapedRecipe(bug);
		bugStone.shape("*%*", "%B%", "*%*");
		bugStone.setIngredient('*', Material.APPLE);
		bugStone.setIngredient('%', Material.LEAVES);
		bugStone.setIngredient('B', Material.GOLDEN_APPLE);
		
		Bukkit.getServer().addRecipe(bugStone);
		
	}
	
	public static void loadGrassStoneRecipe() {
		
		ItemStack grass = new ItemStack(Material.FIREBALL,1);
		
		ItemMeta itemMetaGrass = grass.getItemMeta();
		itemMetaGrass.setDisplayName(GrassData.color + GrassData.nameStone);
		grass.setItemMeta(itemMetaGrass);

		ShapedRecipe grassStone = new ShapedRecipe(grass);
		grassStone.shape("*%*", "XBX", "*%*");
		grassStone.setIngredient('*', Material.LOG);
		grassStone.setIngredient('%', Material.GOLDEN_APPLE);
		grassStone.setIngredient('X', Material.LEAVES);
		grassStone.setIngredient('B', Material.SAPLING);
		
		Bukkit.getServer().addRecipe(grassStone);
		
	}
	
	public static void loadFairyStoneRecipe() {
		
		ItemStack fairy = new ItemStack(2256,1);
		
		ItemMeta itemMetaFairy = fairy.getItemMeta();
		itemMetaFairy.setDisplayName(FairyData.color + FairyData.nameStone);
		fairy.setItemMeta(itemMetaFairy);

		ItemStack pinkWool = new ItemStack( Material.WOOL, 1 , (short) 6);
		ItemStack purpleWool = new ItemStack( Material.WOOL, 1 , (short) 10);

		
		ShapedRecipe fairyStone = new ShapedRecipe(fairy);
		fairyStone.shape("*%*", "%B%", "*%*");
		fairyStone.setIngredient('*', pinkWool.getData());
		fairyStone.setIngredient('%', purpleWool.getData());
		fairyStone.setIngredient('B', Material.GLASS_BOTTLE);
		
		Bukkit.getServer().addRecipe(fairyStone);
		
	}
	
	public static void loadFlyingStoneRecipe() {
		
		ItemStack flying = new ItemStack(2260,1);
		
		ItemMeta itemMetaFlying = flying.getItemMeta();
		itemMetaFlying.setDisplayName(FlyingData.color + FlyingData.nameStone);
		flying.setItemMeta(itemMetaFlying);

		ShapedRecipe flyingStone = new ShapedRecipe(flying);
		flyingStone.shape("*%*", "% %", "*%*");
		flyingStone.setIngredient('*', Material.FEATHER);
		flyingStone.setIngredient('%', Material.STRING);
		
		Bukkit.getServer().addRecipe(flyingStone);
		
	}
	
	public static void loadGhostStoneRecipe() {
		
		ItemStack ghost = new ItemStack(2258,1);
		
		ItemMeta itemMetaGhost = ghost.getItemMeta();
		itemMetaGhost.setDisplayName(GhostData.color + GhostData.nameStone);
		ghost.setItemMeta(itemMetaGhost);

		ItemStack spruce = new ItemStack( Material.LOG, 1 , (short) 5);
		
		ShapedRecipe ghostStone = new ShapedRecipe(ghost);
		ghostStone.shape("*%*", "X X", "*%*");
		ghostStone.setIngredient('*', spruce.getData());
		ghostStone.setIngredient('%', Material.BONE);
		ghostStone.setIngredient('X', Material.ROTTEN_FLESH);

		Bukkit.getServer().addRecipe(ghostStone);
		
	}
	
	public static void loadGroundStoneRecipe() {
		
		ItemStack ground = new ItemStack(2266,1);
		
		ItemMeta itemMetaGround = ground.getItemMeta();
		itemMetaGround.setDisplayName(GroundData.color + GroundData.nameStone);
		ground.setItemMeta(itemMetaGround);

		ItemStack diorite = new ItemStack( Material.STONE, 1 , (short) 3);
		ItemStack granite = new ItemStack( Material.LOG, 1 , (short) 1);

		ShapedRecipe groundStone = new ShapedRecipe(ground);
		groundStone.shape("*%$", "BXN", "$L*");
		groundStone.setIngredient('*', Material.IRON_INGOT);
		groundStone.setIngredient('%', Material.DIRT);
		groundStone.setIngredient('$', Material.STONE_BUTTON);
		groundStone.setIngredient('B', granite.getData());
		groundStone.setIngredient('X', Material.IRON_PICKAXE);
		groundStone.setIngredient('N', diorite.getData());
		groundStone.setIngredient('L', Material.COBBLESTONE);
		
		Bukkit.getServer().addRecipe(groundStone);
		
	}
	
	public static void loadPoisonStoneRecipe() {
		
		ItemStack poison = new ItemStack(Material.FIREBALL,1);
		
		ItemMeta itemMetaPoison = poison.getItemMeta();
		itemMetaPoison.setDisplayName(PoisonData.color + PoisonData.nameStone);
		poison.setItemMeta(itemMetaPoison);

		ShapedRecipe poisonStone = new ShapedRecipe(poison);
		poisonStone.shape("   ", "XBX", "*%*");
		poisonStone.setIngredient('*', Material.VINE);
		poisonStone.setIngredient('%', Material.BOWL);
		poisonStone.setIngredient('X', Material.RED_MUSHROOM);
		poisonStone.setIngredient('B', Material.APPLE);
		
		Bukkit.getServer().addRecipe(poisonStone);
		
	}
	
	public static void loadPsychicStoneRecipe() {
		
		ItemStack psychic = new ItemStack(2256,1);
		
		ItemMeta itemMetaPsychic = psychic.getItemMeta();
		itemMetaPsychic.setDisplayName(PsychicData.color + PsychicData.nameStone);
		psychic.setItemMeta(itemMetaPsychic);

		ShapedRecipe psychicStone = new ShapedRecipe(psychic);
		psychicStone.shape("*%*", "%B%", "*%*");
		psychicStone.setIngredient('*', Material.PAPER);
		psychicStone.setIngredient('%', Material.OBSIDIAN);
		psychicStone.setIngredient('B', Material.ENDER_PEARL);
		
		Bukkit.getServer().addRecipe(psychicStone);
		
	}
	
public static void loadRockStoneRecipe() {
		
		ItemStack rock = new ItemStack(2256,1);
		
		ItemMeta itemMetaRock = rock.getItemMeta();
		itemMetaRock.setDisplayName(RockData.color + RockData.nameStone);
		rock.setItemMeta(itemMetaRock);

		ShapedRecipe rockStone = new ShapedRecipe(rock);
		rockStone.shape("*%*", "%B%", "*%*");
		rockStone.setIngredient('*', Material.STONE);
		rockStone.setIngredient('%', Material.IRON_INGOT);
		rockStone.setIngredient('B', Material.DIAMOND);
		
		Bukkit.getServer().addRecipe(rockStone);
		
	}
	
	
	
	
	
	public static void loadRecipe() {
		loadBugStoneRecipe();
		loadDarkStoneRecipe();
		//loadDragonStoneRecipe();
		loadElectricStoneRecipe();
		loadFairyStoneRecipe();
		loadFightingStoneRecipe();
		loadFireStoneRecipe();
		loadFlyingStoneRecipe();
		loadGhostStoneRecipe();
		loadGrassStoneRecipe();
		loadGroundStoneRecipe();
		loadIceStoneRecipe();
		// normal
		loadPoisonStoneRecipe();
		loadPsychicStoneRecipe();
		loadRockStoneRecipe();
		loadSteelStoneRecipe();
		loadWaterStoneRecipe();
		
		System.out.print("Recipes loaded");
		
	}
	


}
