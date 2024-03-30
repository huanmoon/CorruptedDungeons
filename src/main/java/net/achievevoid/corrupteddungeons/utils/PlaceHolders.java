package net.achievevoid.corrupteddungeons.utils;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.achievevoid.corrupteddungeons.CorruptedDungeons;
import org.bukkit.OfflinePlayer;

public class PlaceHolders extends PlaceholderExpansion {
    private final CorruptedDungeons plugin;

    public PlaceHolders(CorruptedDungeons plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getAuthor() {
        return String.join(", ", plugin.getDescription().getAuthors()); //
    }

    @Override
    public String getIdentifier() {
        return "corrupteddungeons";
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (params.equalsIgnoreCase("coins")) {
            return Economy.coins.get(player.getUniqueId()).toString();
        }

        return null;
    }
}