package com.chaka15205.lotteryplus.command;

import com.chaka15205.lotteryplus.LotteryPlus;
import com.chaka15205.lotteryplus.lottery.LotteryManager;
import com.chaka15205.lotteryplus.util.ChatLib;
import com.chaka15205.lotteryplus.util.PermLib;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LotteryAdminCommand implements CommandExecutor {

    private final LotteryPlus plugin;

    public LotteryAdminCommand(LotteryPlus plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender source, Command cmd, String alias, String[] args) {

        int length = args.length;

        if (cmd.getName().equalsIgnoreCase("ladmin")) {
            if (length == 0) {
                ChatLib.Return.ladminHelp(source);
                return true;
            }
            if (args[0].equalsIgnoreCase("create")) {
                if (!(source.hasPermission(PermLib.CMD_LOTTERYADMIN_CREATE))) {
                    source.sendMessage(ChatLib.Message.NO_PERMS);
                    return true;
                }
                if (length == 2) {
                    Player player = (Player) source;
                    LotteryManager.getManager().createLottery(player.getName(), args[1]);
                    ChatLib.Return.createLottery(source, args[1]);
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("delete")) {
                if (!(source.hasPermission(PermLib.CMD_LOTTERYADMIN_DELETE))) {
                    source.sendMessage(ChatLib.Message.NO_PERMS);
                    return true;
                }
                if (!(LotteryManager.getManager().isLottery(args[1]))) {
                    ChatLib.Return.invalidLottery(source, args[1]);
                    return true;
                }
                if (length == 2) {
                    LotteryManager.getManager().deleteLottery(args[1]);
                    ChatLib.Return.removeLottery(source, args[1]);
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("close") || args[0].equalsIgnoreCase("draw")) {
                if (!(source.hasPermission(PermLib.CMD_LOTTERYADMIN_CLOSE))) {
                    source.sendMessage(ChatLib.Message.NO_PERMS);
                    return true;
                }
                if (!(LotteryManager.getManager().isLottery(args[1]))) {
                    ChatLib.Return.invalidLottery(source, args[1]);
                    return true;
                }
                if (length == 2) {
                    LotteryManager.getManager().drawLottery(args[1]);
                    String winner = LotteryManager.winner;
                    ChatLib.Return.drawLottery(winner, args[1]);
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("add")) {
                if (!(source.hasPermission(PermLib.CMD_LOTTERYADMIN_ADD))) {
                    source.sendMessage(ChatLib.Message.NO_PERMS);
                    return true;
                }
                if (!(LotteryManager.getManager().isLottery(args[2]))) {
                    ChatLib.Return.invalidLottery(source, args[2]);
                    return true;
                }
                if (length == 3) {
                    LotteryManager.getManager().addPlayer(args[1], args[2]);
                    ChatLib.Return.addPlayer(source, args[1], args[2]);
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("remove")) {
                if (!(source.hasPermission(PermLib.CMD_LOTTERYADMIN_REMOVE))) {
                    source.sendMessage(ChatLib.Message.NO_PERMS);
                    return true;
                }
                if (!(LotteryManager.getManager().isLottery(args[2]))) {
                    ChatLib.Return.invalidLottery(source, args[2]);
                    return true;
                }
                if (length == 3) {
                    LotteryManager.getManager().removePlayer(args[1], args[2]);
                    ChatLib.Return.removePlayer(source, args[1], args[2]);
                    return true;
                }
            } else {
                source.sendMessage(ChatLib.Message.INVALID_CMD_SYNTAX);
                return true;
            }
            return true;
        }
        return false;
    }
}
