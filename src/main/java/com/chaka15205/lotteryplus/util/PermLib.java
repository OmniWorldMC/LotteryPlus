package com.chaka15205.lotteryplus.util;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

public class PermLib {

    public static void init(PluginManager pm) {
        pm.addPermission(CMD_LOTTERYADMIN_CREATE);
        pm.addPermission(CMD_LOTTERY_ENTER);
        pm.addPermission(CMD_LOTTERY_LEAVE);
        pm.addPermission(CMD_LOTTERYADMIN_DELETE);
        pm.addPermission(CMD_LOTTERYADMIN_CLOSE);
        pm.addPermission(CMD_LOTTERYADMIN_ADD);
        pm.addPermission(CMD_LOTTERYADMIN_REMOVE);
        pm.addPermission(CMD_LOTTERY_LIST);
    }

    public static final Permission CMD_LOTTERY_ENTER = new Permission("lotteryplus.cmd.lottery.enter");
    public static final Permission CMD_LOTTERY_LEAVE = new Permission("lotteryplus.cmd.lottery.leave");
    public static final Permission CMD_LOTTERYADMIN_CLOSE = new Permission("lotteryplus.cmd.lotteryadmin.close");
    public static final Permission CMD_LOTTERYADMIN_CREATE = new Permission("lotteryplus.cmd.lotteryadmin.create");
    public static final Permission CMD_LOTTERYADMIN_DELETE = new Permission("lotteryplus.cmd.lotteryadmin.delete");
    public static final Permission CMD_LOTTERYADMIN_ADD = new Permission("lotteryplus.cmd.lotteryadmin.add");
    public static final Permission CMD_LOTTERYADMIN_REMOVE = new Permission("lotteryplus.cmd.lotteryadmin.remove");
    public static final Permission CMD_LOTTERY_LIST = new Permission("lotteryplus.cmd.lottery.list");
}
