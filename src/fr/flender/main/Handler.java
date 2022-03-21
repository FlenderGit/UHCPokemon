package fr.flender.main;

import java.util.ArrayList;

public class Handler {
	
	private int nbPlayerAlive;
	private int nbTeamAlive;
	
	private int seconds;
	private int minutes;
	private int hours;
	
	public Handler(ArrayList<CustomPlayer> lsPlayer) {
		this.nbPlayerAlive = lsPlayer.size();
		this.nbTeamAlive = lsPlayer.size()/2;
		
		this.seconds = 0;
		this.minutes = 0;
		this.hours = 0;
	}
	
	public void nextSecond() {
		seconds++;
		if(seconds == 60) {
			seconds = 0;
			minutes++;
			if(minutes == 60) {
				hours++;
			}
		}
	}
	
	public String getSeconds() {
		return (seconds < 10 ? "0" : "")+seconds;
	}
	
	public String getMinutes() {
		return (minutes < 10 ? "0" : "")+minutes;
	}
	
	public String getHours() {
		return (hours < 10 ? "0" : "")+hours;
	}

	public int getNbPlayerAlive() {
		return nbPlayerAlive;
	}

	public int getNbTeamAlive() {
		return nbTeamAlive;
	}

	public void setNbPlayerAlive(int nbPlayerAlive) {
		this.nbPlayerAlive = nbPlayerAlive;
	}

	public int getEpisode() {
		return ((int) minutes/20 + hours*3);
	}
	
	
	
	

}
