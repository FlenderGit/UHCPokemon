package fr.flender.data;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PsychicData {
	
	public static String name = "Psy";

	public static String nameStone = "Psychic Stone";
	public static String color = "§5";

	
	public static String ability1Name = "Teleportation";
	public static int ability1Cooldown = 60;
	public static float ability1PowerLvl1 = 4f;
	public static ItemStack ability1Item = new ItemStack(Material.STICK);
	public static int ability1NextLvl = 1;
    public static List<String> ability1Description = Arrays.asList("Ceci est","un test","sec");
    
    public static String ability2Name = "Plenitude";
	public static ItemStack ability2Item = new ItemStack(Material.EYE_OF_ENDER);
    public static List<String> ability2Description = Arrays.asList("Ceci est","un test","sec");
	public static int ability2Cooldown = 60;
	public static int ability2lenght = 20;
	public static int ability2NextLvl = 10;

}
