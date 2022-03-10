package fr.flender.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CustomPlayer {
	
	private Player player;
	private Player mate;
	private Type type;
	
	
	public CustomPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getMate() {
		return mate;
	}

	public void setMate(Player mate) {
		this.mate = mate;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CustomPlayer [player=" + player.getDisplayName() + ", type=" + type + "]";
	}
	
	
	
	

}
