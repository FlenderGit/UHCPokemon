package fr.flender.data;


import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FireData {
	
	public static String name = "Feu";

	public static String nameStone = "Fire Stone";
	public static String color = "§c";
	
	public static String ability1Name = "Surchauffe";
	public static ItemStack ability1Item = new ItemStack(Material.BLAZE_POWDER);
    public static List<String> ability1Description = Arrays.asList("Ceci est","un test","sec");
	public static int ability1Cooldown = 60;
	public static int ability1lenght = 30;
	public static int ability1NextLvl = 10;
	
	public static String ability2Name = "Boule de feu";
	public static ItemStack ability2Item = new ItemStack(Material.FIREBALL);
    public static List<String> ability2Description = Arrays.asList("Ceci est","un test","sec");
	public static int ability2Cooldown = 5;
    public static float ability2PowerLvl1 = 2;
	public static float ability2NextLvl = 1;

	
}
