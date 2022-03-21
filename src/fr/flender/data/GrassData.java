package fr.flender.data;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GrassData {
	
	public static String name = "Plante";

	public static String nameStone = "Grass Stone";
	public static String color = "§7";

	public static String ability1Name = "Soin";
	public static ItemStack ability1Item = new ItemStack(Material.SEEDS );
    public static List<String> ability1Description = Arrays.asList("Ceci est","un test","sec");
	public static int ability1Cooldown = 120;
    public static float ability1PowerLvl1 = 1;
	public static float ability1NextLvl = 1;

}
