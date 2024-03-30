package net.achievevoid.corrupteddungeons.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class Economy {
    public static HashMap<UUID, Integer> coins = new HashMap<>();

    public static void increase(Player player, int amount) throws SQLException {
        int coin = coins.get(player.getUniqueId());
        coins.replace(player.getUniqueId(), coin+amount);
        Sqlite.setInteger("coins", player, coin+amount);
        PlaceholderAPI.setPlaceholders(player, "coins");
    }
}
