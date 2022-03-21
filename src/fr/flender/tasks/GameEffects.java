package fr.flender.tasks;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.flender.main.CustomPlayer;
import fr.flender.main.Main;
import fr.flender.type.Fire;

public class GameEffects extends BukkitRunnable {
	
	Main main;
	public GameEffects(Main main) {
		this.main = main;
	}

	@Override
	public void run() {
		
		for (CustomPlayer customPlayer : main.lsCustomPlayer) {
			customPlayer.getType().setEffect();
		}
		
	}

}
