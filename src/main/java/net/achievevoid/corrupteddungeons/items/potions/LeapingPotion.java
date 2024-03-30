package net.achievevoid.corrupteddungeons.items.potions;

import net.achievevoid.corrupteddungeons.enums.Rarity;
import net.achievevoid.corrupteddungeons.items.DungeonItem;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class LeapingPotion extends DungeonItem {
    public ItemStack createLeapingPotion() {
        return super.createDungeonItem(Rarity.POLISHED, "Leaping Potion", Material.POTION, "leaping_potion", "");
    }
}
