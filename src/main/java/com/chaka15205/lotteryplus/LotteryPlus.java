package com.chaka15205.lotteryplus;

import com.chaka15205.lotteryplus.command.LotteryCommand;
import com.chaka15205.lotteryplus.config.Config;
import org.bukkit.plugin.java.JavaPlugin;

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

        this.getCommand("lottery").setExecutor(new LotteryCommand(this));

        this.getLogger().log(Level.INFO, "Enabled");
    }
}
