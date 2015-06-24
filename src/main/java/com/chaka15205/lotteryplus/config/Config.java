package com.chaka15205.lotteryplus.config;

import com.chaka15205.lotteryplus.LotteryPlus;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class Config {

    private static LotteryPlus plugin;

    private static File dataFolder;

    private static File configFile;
    private static File lotteryFile;

    private static FileConfiguration config;
    private static FileConfiguration lottery;

    @SuppressWarnings("static-access")
    public Config(LotteryPlus plugin) {
        this.plugin = plugin;

        this.dataFolder = plugin.getDataFolder();

        this.configFile = new File(plugin.getDataFolder(), "config.yml");
        this.lotteryFile = new File(plugin.getDataFolder(), "lottery.yml");

        this.config = YamlConfiguration.loadConfiguration(configFile);
        this.lottery = YamlConfiguration.loadConfiguration(lotteryFile);
    }

    public static void createAllFiles() {
        if (!(configFile.exists())) {
            plugin.getLogger().log(Level.INFO, "config.yml not found, Creating new one.");
            plugin.saveResource("config.yml", true);
            plugin.getLogger().log(Level.INFO, "Successfully created config.yml");
        }
        if (!(lotteryFile.exists())) {
            plugin.getLogger().log(Level.INFO, "lottery.yml not found, Creating new one.");
            plugin.saveResource("lottery.yml", true);
            plugin.getLogger().log(Level.INFO, "Successfully created lottery.yml");
        }
    }

    public static File getConfigFile() {
        return configFile;
    }

    public static File getLotteryFile() {
        return lotteryFile;
    }

    public static FileConfiguration getConfig() {
        return config;
    }

    public static FileConfiguration getLottery() {
        return lottery;
    }

    public static FileConfiguration getFileConfig(File file) {
        return YamlConfiguration.loadConfiguration(file);
    }

    public static void saveConfigFile() {
        saveFile(configFile, config);
    }

    public static void saveLotteryFile() {
        saveFile(lotteryFile, lottery);
    }

    public static void saveFile(File file, FileConfiguration config) {
        try {
            config.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void saveAllFiles() {
        saveConfigFile();
        saveLotteryFile();
    }
}
