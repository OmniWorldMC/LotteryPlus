package com.chaka15205.lotteryplus.listener;

import com.chaka15205.lotteryplus.LotteryPlus;
import com.chaka15205.lotteryplus.config.Config;
import com.chaka15205.lotteryplus.lottery.LotteryManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    private final LotteryPlus plugin;

    public PlayerListener(LotteryPlus plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (Config.getConfig().getBoolean("lotteryAutoJoin.use")) {
            LotteryManager.getManager().addPlayer(player.getName(), Config.getConfig().getString("lotteryAutoJoin.lottery"));
            Config.saveAllFiles();
        }
    }
}
