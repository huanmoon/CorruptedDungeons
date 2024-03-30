package net.achievevoid.corrupteddungeons.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class GuiUtils {
    public static final List<ItemStack> shopItems = new ArrayList<>();

    public static void createMenu(int size, String name, HashMap<UUID, Inventory> hashmap, UUID uuid) {
        Inventory inventory = Bukkit.createInventory(null, size, name);
        if(!hashmap.containsKey(uuid))
            hashmap.put(uuid, inventory);
    }

    public static void setItem(Inventory inventory, int x, int y, String name, Material texture, String... lores) {
        int slot = 0;
        for(int i = 0; i < y; i++) {
            slot += 9;
        }
        for(int i = 0; i < x; i++) {
            slot++;
        }
        ItemStack itemStack = new ItemStack(texture);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(Arrays.asList(lores));
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(slot, itemStack);
    }

    public static void setShopItem(Inventory inventory, int x, int y, ItemStack baseItem, int buyingPrice, int sellingPrice) {
        int slot = 0;
        for(int i = 0; i < y; i++) {
            slot += 9;
        }
        for(int i = 0; i < x; i++) {
            slot++;
        }
        ItemStack itemStack = new ItemStack(baseItem);
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> lores = itemMeta.getLore();
        lores.add(ChatColor.GOLD + "Buying Price: " + buyingPrice + ChatColor.DARK_GRAY + " (LEFT CLICK)");
        lores.add(ChatColor.GOLD + "Selling Price: " + sellingPrice + ChatColor.DARK_GRAY + " (RIGHT CLICK)");
        itemMeta.setLore(lores);
        itemStack.setItemMeta(itemMeta);
        if(shopItems.contains(itemStack))
            shopItems.add(itemStack);
        inventory.setItem(slot, itemStack);
    }
}
