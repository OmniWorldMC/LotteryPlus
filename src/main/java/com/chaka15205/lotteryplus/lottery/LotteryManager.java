package com.chaka15205.lotteryplus.lottery;

import com.chaka15205.lotteryplus.LotteryPlus;
import com.chaka15205.lotteryplus.config.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LotteryManager {

    private static LotteryManager lm;
    private static LotteryPlus plugin;
    private Random random = new Random();
    public static String winner = null;

    public static LotteryManager getManager() {
        if (lm == null) {
            lm = new LotteryManager();
        }
        return lm;
    }

    public void createLottery(String playerName, String name) {
        List<String> list = new ArrayList<String>();
        list.add(playerName);
        Config.getLottery().set(name + ".players", list);
        if (Config.getLottery().get("lotteries") == null) {
            List<String> lotteries = new ArrayList<String>();
            Config.getLottery().set("lotteries", lotteries);
        } else {
            List lot = Config.getLottery().getList("lotteries");
            lot.add(name);
        }
        Config.getLottery().options().copyDefaults(true);
        Config.saveLotteryFile();
    }

    public List<?> lotteryList() {
        return Config.getLottery().getList("lotteries");
    }

    //TODO Rename to addPlayer
    public void enterLottery(String playerName, String name) {
        List list = Config.getLottery().getList(name + ".players");
        list.add(playerName);
        Config.saveLotteryFile();
    }

    //TODO Rename to removePlayer
    public void leaveLottery(String playerName, String name) {
        List list = Config.getLottery().getList(name + ".players");
        if (list.contains(playerName)) {
            list.remove(playerName);
        }
        Config.saveLotteryFile();
    }

    //TODO Rename to deleteLottery
    public void removeLottery(String name) {
        Config.getLottery().set(name, null);
        Config.saveLotteryFile();
    }

    //TODO Rename to drawLottery
    public void closeLottery(String name) {
        List list = Config.getLottery().getList(name + ".players");
        int index = random.nextInt(list.size());
        winner = String.valueOf(list.get(index));
        if (Config.getConfig().getBoolean("removeOnClose")) {
            removeLottery(name);
        }
    }
}
