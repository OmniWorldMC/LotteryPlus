package com.chaka15205.lotteryplus.util;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

public class PermLib {

    public static void init(PluginManager pm) {
        pm.addPermission(CMD_LOTTERY_CREATE);
        pm.addPermission(CMD_LOTTERY_ENTER);
        pm.addPermission(CMD_LOTTERY_LEAVE);
        pm.addPermission(CMD_LOTTERY_REMOVE);
        pm.addPermission(CMD_LOTTERY_CLOSE);
    }

    public static final Permission CMD_LOTTERY_CREATE = new Permission("lotteryplus.cmd.lottery.create");
    public static final Permission CMD_LOTTERY_ENTER = new Permission("lotteryplus.cmd.lottery.enter");
    public static final Permission CMD_LOTTERY_LEAVE = new Permission("lotteryplus.cmd.lottery.leave");
    public static final Permission CMD_LOTTERY_REMOVE = new Permission("lotteryplus.cmd.lottery.remove");
    public static final Permission CMD_LOTTERY_CLOSE = new Permission("lotteryplus.cmd.lottery.close");
}
