package fr.flender.data;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SteelData {
	
	public static String name = "Acier";

	public static String nameStone = "Steel Stone";
	public static String color = "§7";

	public static String ability1Name = "Mur de fer";
	public static ItemStack ability1Item = new ItemStack(Material.IRON_BLOCK);
    public static List<String> ability1Description = Arrays.asList("Ceci est","un test","sec");
	public static int ability1Cooldown = 60;
	public static int ability1lenght = 30;
	public static int ability1NextLvl = 10;
	
	public static int distanceResistance = 10;


}
