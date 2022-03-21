package fr.flender.main;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;


public class ScoreboardCustom {

	private ScoreboardManager manager = Bukkit.getScoreboardManager();
	private Scoreboard board = manager.getNewScoreboard();
	
	private Handler handler;
	
	private Team timer;
	private Team nbplayer;
	private Team nbteam;
	private Team type;
	private Team nbkill;
	private Team pvp;
	private Team episode;

	
	
	public ScoreboardCustom(Handler handler) {
		
		this.handler = handler;
		this.timer = board.registerNewTeam("timer");
		this.nbplayer = board.registerNewTeam("nbplayer");
		this.nbteam = board.registerNewTeam("nbteam");
		this.type = board.registerNewTeam("type");
		this.nbkill = board.registerNewTeam("nbkill");
		this.pvp = board.registerNewTeam("pvp");
		this.episode = board.registerNewTeam("episode");

		createScoreboard();
		
	}
	
	public void createScoreboard() {
		
		Objective objective = board.registerNewObjective("Scoreglobal", "dummy");

		objective.setDisplayName("§7>> §l§eUHC Pokemon §7<<");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		Score empty = objective.getScore("         ");
		empty.setScore(15);
		
		Score temps = objective.getScore("§lTEMPS");
		temps.setScore(14);
		
		timer.setPrefix("");
		timer.addEntry(" §7| §fTimer : §e");
		objective.getScore(" §7| §fTimer : §e").setScore(13);

		episode.setPrefix("");
		episode.addEntry(" §7| §fEpisode : §e");
		objective.getScore(" §7| §fEpisode : §e").setScore(12);
		
		Score empty2 = objective.getScore("        ");
		empty2.setScore(11);
		
		Score info = objective.getScore("§lINFO");
		info.setScore(10);
		
		pvp.setPrefix("");
		pvp.addEntry(" §7| §fPvp : ");
		objective.getScore(" §7| §fPvp : ").setScore(9);
		
		nbplayer.setSuffix("");
		nbplayer.addEntry(" §7| §fPlayer : §e");
		objective.getScore(" §7| §fPlayer : §e").setScore(8);
		
		nbteam.setSuffix("");
		nbteam.addEntry(" §7| §fTeam : §e");
		objective.getScore(" §7| §fTeam : §e").setScore(7);
		
		type.setSuffix("");
		type.addEntry(" §7| §fType : §e");
		objective.getScore(" §7| §fType : §e").setScore(6);
		
		nbkill.setSuffix("");
		nbkill.addEntry(" §7| §fKill : §e");
		objective.getScore(" §7| §fKill : §e").setScore(5);
		
		Team bordure = board.registerNewTeam("bordure");
		bordure.setSuffix("");
		bordure.setSuffix("");
		bordure.addEntry(" §7| §fBordure : §e");
		objective.getScore(" §7| §fBordure : §e").setScore(4);
		
		
	}
	
	public Scoreboard getScoreboard() {
		return board;
	}
	
	public void update() {
		timer.setSuffix(handler.getHours() + ":"+ handler.getMinutes() + ":"+handler.getSeconds());
		nbplayer.setSuffix(""+handler.getNbPlayerAlive());
		nbteam.setSuffix(""+handler.getNbTeamAlive());
		episode.setSuffix(""+handler.getEpisode());
	}
	
	public ScoreboardCustom setForPlayer( CustomPlayer player) {
		nbkill.setSuffix(""+ player.getKill());
		type.setSuffix(""+ player.getType().getName());
		return this;
	}
	
	public void setPVP( boolean bool ) {
		if (bool ) {
			pvp.setSuffix("§a✓");
		}else {
			pvp.setSuffix("§c✗");
		}
	}
	
	

	
}
