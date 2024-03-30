package net.achievevoid.corrupteddungeons.npcs;

import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTEntity;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Npc implements Listener {
    public static List<UUID> npcs = new ArrayList<>();

    String npcName;
    EntityType npcType;
    Location location;
    Entity npc;

    public Npc(String npcName, EntityType npcType, Location location) {
        this.npcName = npcName;
        this.location = location;
        this.npcType = npcType;
        Entity npc = location.getWorld().spawnEntity(location, npcType);
        this.npc = npc;

        npc.setCustomName(npcName);

        NBTEntity nbtEntity = new NBTEntity(npc);
        nbtEntity.mergeCompound(new NBTContainer("{Silent:1b, NoAI:1b, IsNPC: 1b}"));

        npcs.add(npc.getUniqueId());
    }
}
