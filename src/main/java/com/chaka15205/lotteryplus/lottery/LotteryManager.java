package com.chaka15205.lotteryplus.lottery;

import com.chaka15205.lotteryplus.LotteryPlus;
import com.chaka15205.lotteryplus.config.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
        UUID id = UUID.randomUUID();
        Config.getLottery().set(name + ".players", list);
        Config.getLottery().set(name + ".id", id.toString());
        if (Config.getLottery().getList("lotteries") == null) {
            List lotteries = new ArrayList();
            lotteries.add(name);
            Config.getLottery().set("lotteries", lotteries);
        } else {
            List lotteries = Config.getLottery().getList("lotteries");
            lotteries.add(name);
            Config.getLottery().set("lotteries", lotteries);
        }
        Config.saveLotteryFile();
    }

    public List<?> lotteryList() {
        return Config.getLottery().getList("lotteries");
    }

    public void addPlayer(String playerName, String name) {
        List list = Config.getLottery().getList(name + ".players");
        list.add(playerName);
        Config.saveLotteryFile();
    }

    public void removePlayer(String playerName, String name) {
        List list = Config.getLottery().getList(name + ".players");
        if (list.contains(playerName)) {
            list.remove(playerName);
        }
        Config.saveLotteryFile();
    }

    public void deleteLottery(String name) {
        Config.getLottery().set(name, null);
        List lot = Config.getLottery().getList("lotteries");
        lot.remove(name);
        Config.getLottery().set("lotteries", lot);
        Config.saveLotteryFile();
    }

    public void drawLottery(String name) {
        List list = Config.getLottery().getList(name + ".players");
        int index = random.nextInt(list.size());
        winner = String.valueOf(list.get(index));
    }

    public boolean isLottery(String name) {
        if (lotteryList().contains(name)) {
            return true;
        }
        return false;
    }
}
