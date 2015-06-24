package com.chaka15205.lotteryplus;

import com.chaka15205.lotteryplus.command.LotteryCommand;
import com.chaka15205.lotteryplus.config.Config;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;
import java.util.logging.Level;

public class LotteryPlus extends JavaPlugin {

    @Override
    public void onDisable() {
        Config.saveAllFiles();
        this.getLogger().log(Level.INFO, "Disabled");
    }

    @Override
    public void onEnable() {

        new Config(this);
        Config.createAllFiles();

        if (Config.getConfig().getBoolean("metrics")) {
            try {
                Metrics metrics = new Metrics(this);
                metrics.start();
            } catch (IOException e) {
                this.getLogger().log(Level.WARNING, "Failed to submit metrics.");
                e.printStackTrace();
            }
        }

        this.getCommand("lottery").setExecutor(new LotteryCommand(this));

        this.getLogger().log(Level.INFO, "Enabled");
    }
}
