package fr.flender.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.flender.data.MessageData;
import fr.flender.main.Main;


public class AutoStart extends BukkitRunnable {

	Main main;
	public AutoStart(Main main) {
		this.main = main;
	}
	
	int timer = 10;
	
	@Override
	public void run() {
		
		for(Player player : Bukkit.getOnlinePlayers()) {
			player.setLevel(timer);	
		}
		
		if(timer == 30 || timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1) {
			Bukkit.broadcastMessage(MessageData.prefix + "§eLancement dans " + timer + " secondes.");
			
		}
		
		if(timer == 0) {
			Bukkit.broadcastMessage(MessageData.prefix + "§eBonne partie à tous");
			GameEffects effectCycle = new GameEffects(main);
			effectCycle.runTaskTimer(main, 0, 5 * 20);
			Cooldown cooldown = new Cooldown(main);
			cooldown.runTaskTimer(main, 0, 20);
			cancel();
		}

		timer--;
		
	}

}
