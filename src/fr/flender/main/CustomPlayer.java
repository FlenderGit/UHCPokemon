package fr.flender.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.flender.type.Neutral;

public class CustomPlayer {
	
	private Player player;
	private CustomPlayer mate;
	private Type type;
	private int token;
	private int kill;
	
	public int getKill() {
		return kill;
	}
	
	
	
	public int getToken() {
		return token;
	}

	public void addToken(int token) {
		this.token += token;
	}

	public CustomPlayer(Player player , Handler handler) {
		this.player = player;
		this.type = new Neutral(this);
		this.token = 0;
		this.mate = null;
	}
	
	public void reduceCooldown() {
		type.reduceCooldown();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public CustomPlayer getMate() {
		return mate;
	}

	public void setMate(CustomPlayer mate) {
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
