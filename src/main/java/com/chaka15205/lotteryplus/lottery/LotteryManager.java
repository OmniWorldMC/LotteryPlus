package com.chaka15205.lotteryplus.lottery;

import com.chaka15205.lotteryplus.LotteryPlus;
import com.chaka15205.lotteryplus.config.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LotteryManager {

    private static LotteryManager lm;
    private static LotteryPlus plugin;
    private Random random;

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
        Config.getLottery().options().copyDefaults(true);
        Config.saveLotteryFile();
    }

    public void enterLottery(String playerName, String name) {
        List list = Config.getLottery().getList(name + ".players");
        list.add(playerName);
        Config.saveLotteryFile();
    }

    public void leaveLottery(String playerName, String name) {
        List list = Config.getLottery().getList(name + ".players");
        if (list.contains(playerName)) {
            list.remove(playerName);
        }
        Config.saveLotteryFile();
    }

    public String closeLottery(String name) {
        List list = Config.getLottery().getList(name + ".players");
        int index = random.nextInt(list.size());
        //TODO also remove the lottery
        return String.valueOf(list.get(index));
    }
}
