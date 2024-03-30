package net.achievevoid.corrupteddungeons;

import net.achievevoid.corrupteddungeons.listeners.EntityHitListener;
import net.achievevoid.corrupteddungeons.listeners.InventoryClickListener;
import net.achievevoid.corrupteddungeons.listeners.PlayerJoinListener;
import net.achievevoid.corrupteddungeons.utils.PlaceHolders;
import net.achievevoid.corrupteddungeons.utils.Sqlite;
import org.bukkit.Bukkit;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.sql.SQLException;

public class CorruptedDungeons extends JavaPlugin {
    @Override
    public void onEnable() {
        initListeners();

        new PlaceHolders(this).register();

        new BukkitRunnable() {
            @Override
            public void run() {
                initNPCs();
            }
        }.runTaskLater(this, 1); //wait for 1 tick so the world will be ready to spawn npcs

        try {
            Sqlite.init();
        }
        catch (ClassNotFoundException | SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        getLogger().info("CorruptedDungeons enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CorruptedDungeons disabled!");
    }

    public void initListeners() {
        Bukkit.getPluginManager().registerEvents(new EntityHitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    public void initNPCs() {
        for (Witch witch : getPlugin().getServer().getWorld("village").getEntitiesByClass(Witch.class)) {
            witch.remove();
        }
        for (Villager villager : getPlugin().getServer().getWorld("village").getEntitiesByClass(Villager.class)) {
            villager.remove();
        }
        Bukkit.getPluginManager().registerEvents(new net.achievevoid.corrupteddungeons.npcs.Witch(), this);
    }

    public static Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("CorruptedDungeons");
    }
}