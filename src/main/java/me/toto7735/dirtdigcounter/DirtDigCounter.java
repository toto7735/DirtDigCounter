package me.toto7735.dirtdigcounter;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DirtDigCounter extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new Listener(), this);
        Map<UUID, Integer> map = new HashMap<>();
        for (String key : this.getConfig().getKeys(false)) map.put(UUID.fromString(key), this.getConfig().getInt(key));
        Utils.setup(map);
        new BukkitRunnable() {
            public void run() {
                for (Player onlinePlayer : Bukkit.getOnlinePlayers())
                    onlinePlayer.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§eYou have dig §6§l" + Utils.getDirtCount(onlinePlayer.getUniqueId()) + " Blocks of dirt §eso far!"));
            }
        }.runTaskTimerAsynchronously(this, 0, 1);
    }

    @Override
    public void onDisable() {
        Utils.getDirtCounts().keySet().forEach(uuid -> this.getConfig().set(uuid.toString(), Utils.getDirtCount(uuid)));
        this.saveConfig();
    }

}
