package net.achievevoid.corrupteddungeons.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreBoard {
    static ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();

    public static Scoreboard setupScoreboard(Player player) {
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("test", "test2");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "CORRUPTED DUNGEONS");
        String coinText = ChatColor.GOLD + "Coins: %corrupteddungeons_coins%";
        coinText = PlaceholderAPI.setPlaceholders(player, coinText);
        addLine(coinText, objective);
        return scoreboard;
    }

    private static void addLine(String content, Objective objective) {
        Score line = objective.getScore(content);
        line.setScore(1);
    }

}
