package fr.flender.main;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;

import fr.flender.commands.CommandAbility;
import fr.flender.commands.CommandStart;
import fr.flender.commands.CommandTeam;
import fr.flender.commands.CommandType;
import fr.flender.listeners.AttackListeners;
import fr.flender.listeners.ConnectionListeners;
import fr.flender.listeners.DeathListeners;
import fr.flender.listeners.InventoryListeners;
import fr.flender.listeners.ItemsListeners;
import fr.flender.listeners.ProjectilsListeners;
import fr.flender.loader.Recipe;
import net.minecraft.server.v1_8_R1.ChatComponentText;
import net.minecraft.server.v1_8_R1.PacketPlayOutPlayerListHeaderFooter;


public class Main extends JavaPlugin {
	
	public ArrayList<CustomPlayer> lsCustomPlayer = new ArrayList<CustomPlayer>();
	private Handler handler;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		System.out.println("Plugin On");
		
		handler = new Handler(lsCustomPlayer);
		ScoreboardCustom board = new ScoreboardCustom(handler);
		Packet packet = new Packet("Wesh", "Test2");
		
		board.setPVP(false);
		
		getCommand("setType").setExecutor(new CommandType(this));
		getCommand("start").setExecutor(new CommandStart(this));
		getCommand("setTeam").setExecutor(new CommandTeam(this));
		getCommand("ability").setExecutor(new CommandAbility(this));

		getServer().getPluginManager().registerEvents(new ItemsListeners(this), this);
		getServer().getPluginManager().registerEvents(new ConnectionListeners(this,handler), this);
		getServer().getPluginManager().registerEvents(new AttackListeners(this), this);
		getServer().getPluginManager().registerEvents(new ProjectilsListeners(this), this);
		getServer().getPluginManager().registerEvents(new DeathListeners(this), this);
		getServer().getPluginManager().registerEvents(new InventoryListeners(this), this);

		Recipe.loadRecipe();

		Bukkit.getScheduler().runTaskTimer(this, new BukkitRunnable() {	
			
						
			@Override
			public void run() {
				
				//packet.changePacket("      §4────§c────§e────[  §lUHC Pokemon  §e]────§c────§4────\n\n§eOnline : " + Bukkit.getOnlinePlayers().size() + "/" + getServer().getMaxPlayers() + "\n" + 10 + ":" + 13 + ":" + 23 + "\n§e------------------------" , "§e------------------------\n§7" + 10 + ":" + 34 + "\n\n     §4────§c────§e────[ §7§lPar §5§lFlender §e]────§c────§4────");
				packet.update(handler);
				packet.testPacket();
				board.update();
				
				for(Player player : Bukkit.getOnlinePlayers()){
					
					((CraftPlayer)player.getPlayer()).getHandle().playerConnection.sendPacket(packet.getPacket());
					board.setForPlayer(getCustomPlayer(player));
					player.setScoreboard(board.getScoreboard());
					
				}
				
				handler.nextSecond();
				
			}
		},0,20);
			
			

	}
	
	@Override
	public void onDisable() {
		System.out.println("Plugin Off");
	}
	
	@Override
	public void onLoad() {
		for ( Player player : Bukkit.getOnlinePlayers()) {
			addToList(player);
		}
		super.onLoad();
	}

	
	
	public CustomPlayer getCustomPlayer(Player player) {
		boolean find = false;
		int i = 0;
		CustomPlayer customPlayer = null;
		
		while (!(find) && i<lsCustomPlayer.size()) {
			if (player.getUniqueId().equals(lsCustomPlayer.get(i).getPlayer().getUniqueId())) {
				find = true;
				customPlayer = lsCustomPlayer.get(i);
			}
			
			i++;
		}
		return customPlayer;
	}
	
	public void addToList(Player player) {
		lsCustomPlayer.add(new CustomPlayer(player , handler));
	}
	

}
