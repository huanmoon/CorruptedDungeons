package net.achievevoid.corrupteddungeons.listeners;

import net.achievevoid.corrupteddungeons.utils.Economy;
import net.achievevoid.corrupteddungeons.utils.ScoreBoard;
import net.achievevoid.corrupteddungeons.utils.Sqlite;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

import java.sql.SQLException;

public class PlayerJoinListener implements Listener {
    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) throws SQLException {
        Player player = event.getPlayer();
        if(!Sqlite.doesPlayerExist(player)) {
            Sqlite.addPlayer(player);
        }
        int coins = Sqlite.getInteger("coins", player);
        Economy.coins.put(player.getUniqueId(), coins);

        Scoreboard scoreboard = ScoreBoard.setupScoreboard(player);
        player.setScoreboard(scoreboard);
    }
}
