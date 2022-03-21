package fr.flender.data;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PoisonData {
	
	public static String name = "Poison";

	public static String nameStone = "Poison Stone";
	public static String color = "§5";

	public static String ability1Name = "Spore Poison";
	public static ItemStack ability1Item = new ItemStack(Material.BROWN_MUSHROOM);
    public static List<String> ability1Description = Arrays.asList("Ceci est","un test","sec");
	public static int ability1Cooldown = 60;
	public static int ability1NextLvl = 10;
	public static int ability1PowerLvl1 = 3;

	
	public static String ability2Name = "Spore Sommeil";
	public static ItemStack ability2Item = new ItemStack(Material.RED_MUSHROOM);
    public static List<String> ability2Description = Arrays.asList("Ceci est","un test","sec");
	public static int ability2Cooldown = 60;
	public static int ability2PowerLvl1 = 3;
	public static int ability2NextLvl = 10;

}
