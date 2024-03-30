package net.achievevoid.corrupteddungeons.items;

import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTItem;
import net.achievevoid.corrupteddungeons.enums.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DungeonItem {
    public ItemStack createDungeonItem(Rarity rarity, String itemName, Material itemMaterial, String itemCode, String... lore) {
        ItemStack itemStack = new ItemStack(itemMaterial);
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> lores = new ArrayList<>(Arrays.asList(lore));

        switch(rarity) {
            case DUSTY:
                itemMeta.setDisplayName(ChatColor.DARK_GRAY + itemName);
                lores.add(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "DUSTY ITEM");
                break;
            case POLISHED:
                itemMeta.setDisplayName(ChatColor.WHITE + itemName);
                lores.add(ChatColor.WHITE + "" + ChatColor.BOLD + "POLISHED ITEM");
                break;
            case EXOTIC:
                itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + itemName);
                lores.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "EXOTIC ITEM");
                break;
            case STAINLESS:
                itemMeta.setDisplayName(ChatColor.YELLOW + itemName);
                lores.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "STAINLESS ITEM");
                break;
            case SACRED:
                itemMeta.setDisplayName(ChatColor.GOLD + itemName);
                lores.add(ChatColor.GOLD + "" + ChatColor.BOLD + "SACRED ITEM");
                break;
            case MYTHIC:
                itemMeta.setDisplayName(ChatColor.DARK_RED + itemName);
                lores.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "MYTHIC ITEM");
                break;
            case SPECIAL:
                itemMeta.setDisplayName(ChatColor.AQUA + itemName);
                lores.add(ChatColor.AQUA + "" + ChatColor.BOLD + "SPECIAL ITEM");
                break;
        }

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.mergeCompound(new NBTContainer("{ItemCode:" + itemCode + "}"));

        itemMeta.setLore(lores);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
