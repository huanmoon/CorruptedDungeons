package net.achievevoid.corrupteddungeons.npcs;

import net.achievevoid.corrupteddungeons.CorruptedDungeons;
import net.achievevoid.corrupteddungeons.items.potions.LeapingPotion;
import net.achievevoid.corrupteddungeons.utils.GuiUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.UUID;

public class Witch extends Npc implements Listener {
    private static final HashMap<UUID, Inventory> inventories = new HashMap<>();

    public Witch() {
        super(ChatColor.YELLOW + "Witch", EntityType.WITCH, new Location(CorruptedDungeons.getPlugin().getServer().getWorld("village"), 0, 60 ,0));
    }

    @EventHandler
    protected void onNPCInteract(PlayerInteractEntityEvent event) {
        event.setCancelled(true);
        Player player = event.getPlayer();

        //witch shop
        GuiUtils.createMenu(9, "Witch Shop", inventories, player.getUniqueId());
        LeapingPotion leapingPotion = new LeapingPotion();
        GuiUtils.setShopItem(inventories.get(player.getUniqueId()), 4, 0, leapingPotion.createLeapingPotion(), 0, 0);

        player.openInventory(inventories.get(player.getUniqueId()));
    }
}
