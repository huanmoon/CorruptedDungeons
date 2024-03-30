package net.achievevoid.corrupteddungeons.placeholders;

import com.avaje.ebean.validation.NotNull;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.achievevoid.corrupteddungeons.CorruptedDungeons;
import org.bukkit.OfflinePlayer;

public class EconomyPlaceHolder extends PlaceholderExpansion {
    private final CorruptedDungeons plugin;

    public EconomyPlaceHolder(CorruptedDungeons plugin) {
        this.plugin = plugin;
    }

    @Override
    @NotNull
    public String getAuthor() {
        return String.join(", ", plugin.getDescription().getAuthors()); //
    }

    @Override
    @NotNull
    public String getIdentifier() {
        return "corrupteddungeons";
    }

    @Override
    @NotNull
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (params.equalsIgnoreCase("placeholder1")) {
            return plugin.getConfig().getString("placeholders.placeholder1", "default1"); //
        }

        if (params.equalsIgnoreCase("placeholder2")) {
            return plugin.getConfig().getString("placeholders.placeholder1", "default1"); //
        }

        return null;
    }
}