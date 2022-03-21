package fr.flender.data;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ElectricData {
	
	public static String name = "Electrique";

	public static String nameStone = "Electrique Stone";
	public static String color = "§e";
	
	public static String ability1Name = "Tonnere";
	public static ItemStack ability1Item = new ItemStack(Material.GOLD_BLOCK);
    public static List<String> ability1Description = Arrays.asList("Ceci est","un test","sec");
	public static int ability1Cooldown = 60;
	public static int ability1lenght = 30;
	public static int ability1NextLvl = 10;

}
