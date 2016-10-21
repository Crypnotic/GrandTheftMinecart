package me.ToastHelmi.GrandTheftMinecart.Util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreBoardUtil {

	private static ScoreBoardUtil instance;
	private final ScoreboardManager manager;

	private ScoreBoardUtil() {
		instance = this;
		manager = Bukkit.getScoreboardManager();
	}

	public static ScoreBoardUtil getInstance() {
		if (instance == null)
			instance = new ScoreBoardUtil();

		return instance;
	}

	@SuppressWarnings("deprecation")
	public void setScoreBoard(Player p, DisplaySlot s, String name, int score) {
		Scoreboard board = manager.getNewScoreboard();

		Objective o = board.registerNewObjective(name, "dummy");
		o.setDisplaySlot(s);
		o.setDisplayName(name);
		o.getScore(p).setScore(score);
		p.setScoreboard(board);

	}
	public void unregisterScoreBoard(Player p, String name) {
		p.getScoreboard().getObjective(name).unregister();
	}
}
