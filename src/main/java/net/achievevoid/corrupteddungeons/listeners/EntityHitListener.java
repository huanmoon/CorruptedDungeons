package net.achievevoid.corrupteddungeons.listeners;

import net.achievevoid.corrupteddungeons.npcs.Npc;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityHitListener implements Listener {
    @EventHandler
    private void onEntityHit(EntityDamageEvent event) {
        //cancel the attack to the npc
        Entity entity = event.getEntity();
        if(Npc.npcs.contains(entity.getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
