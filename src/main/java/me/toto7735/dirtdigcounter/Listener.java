package me.toto7735.dirtdigcounter;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

public class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (!event.getBlock().getType().equals(Material.DIRT)) return;
        Utils.addDirtCount(event.getPlayer().getUniqueId(), 1);
    }

}
