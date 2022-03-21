package fr.flender.data;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FightingData {
	
	public static String name = "Combat";

	public static String nameStone = "Fighting Stone";
	public static String color = "§4";

	
	public static String ability1Name = "Dash";
	public static ItemStack ability1Item = new ItemStack(Material.STICK);
    public static List<String> ability1Description = Arrays.asList("Ceci est","un test","sec");
	public static int ability1Cooldown = 40;
	public static int ability1PowerLvl1 = 3;
	public static int ability1NextLvl = 1;
	
	public static String ability2Name = "Surpuissance";
	public static ItemStack ability2Item = new ItemStack(Material.BONE);
    public static List<String> ability2Description = Arrays.asList("Ceci est","un test","sec");
	public static int ability2Cooldown = 60;
	public static int ability2lenght = 30;
	public static int ability2NextLvl = 10;
	
	
}
