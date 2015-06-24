package com.chaka15205.lotteryplus.command;

import com.chaka15205.lotteryplus.LotteryPlus;
import com.chaka15205.lotteryplus.lottery.LotteryManager;
import com.chaka15205.lotteryplus.util.ChatLib;
import com.chaka15205.lotteryplus.util.PermLib;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LotteryCommand implements CommandExecutor {

    private final LotteryPlus plugin;

    public LotteryCommand(LotteryPlus plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender source, Command cmd, String alias, String[] args) {

        int length = args.length;

        if (cmd.getName().equalsIgnoreCase("lottery")) {
            if (length == 0) {
                source.sendMessage(ChatLib.Message.LOTTERY_INFO);
                return true;
            }

            if (args[0].equalsIgnoreCase("create")) {
                if (!(source.hasPermission(PermLib.CMD_LOTTERY_CREATE))) {
                    source.sendMessage(ChatLib.Message.NO_PERMS);
                    return true;
                }
                if (!(source instanceof Player)) {
                    source.sendMessage(ChatLib.Message.INVALID_SENDER);
                    return true;
                }
                if (length == 2) {
                    Player player = (Player) source;
                    LotteryManager.getManager().createLottery(player.getUniqueId(), args[1]);
                    ChatLib.Return.createLottery(source, args[1]);
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("enter")) {
                if (!(source.hasPermission(PermLib.CMD_LOTTERY_ENTER))) {
                    source.sendMessage(ChatLib.Message.NO_PERMS);
                    return true;
                }
                if (!(source instanceof Player)) {
                    source.sendMessage(ChatLib.Message.INVALID_SENDER);
                }
                if (length == 2) {
                    Player player = (Player) source;
                    String name = args[1];
                }
            } else if (args[0].equalsIgnoreCase("leave")) {
                if (!(source.hasPermission(PermLib.CMD_LOTTERY_LEAVE))) {
                    source.sendMessage(ChatLib.Message.NO_PERMS);
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("remove")) {
                if (!(source.hasPermission(PermLib.CMD_LOTTERY_REMOVE))) {
                    source.sendMessage(ChatLib.Message.NO_PERMS);
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("close")) {
                if (!(source.hasPermission(PermLib.CMD_LOTTERY_CLOSE))) {
                    source.sendMessage(ChatLib.Message.NO_PERMS);
                    return true;
                }
            } else {
                if (length > 0) {
                    source.sendMessage(ChatLib.Message.INVALID_CMD_SYNTAX);
                }
            }
            return true;
        }
        return false;
    }
}
