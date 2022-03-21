package fr.flender.tasks;

import org.bukkit.scheduler.BukkitRunnable;

import fr.flender.main.CustomPlayer;
import fr.flender.main.Main;

public class Cooldown extends BukkitRunnable {

	Main main;
	public Cooldown(Main main) {
		this.main = main;
	}
	
	@Override
	public void run() {
		for (CustomPlayer customPlayer : main.lsCustomPlayer) {
			customPlayer.reduceCooldown();
		}
		
	}
	
	
}
