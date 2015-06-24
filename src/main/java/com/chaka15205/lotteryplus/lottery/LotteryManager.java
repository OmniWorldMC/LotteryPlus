package com.chaka15205.lotteryplus.lottery;

import com.chaka15205.lotteryplus.config.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LotteryManager {

    private static LotteryManager lm;

    private LotteryManager() {}

    public static LotteryManager getManager() {
        if (lm == null) {
            lm = new LotteryManager();
        }
        return lm;
    }

    public void createLottery(UUID uuid, String name) {
        List<UUID> list = new ArrayList<UUID>();
        list.add(uuid);
        Config.getLottery().addDefault(name, null);
        Config.getLottery().addDefault(name + ".players", list);
        Config.getLottery().options().copyDefaults(true);
        try {
            Config.getLottery().save(Config.getLotteryFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
