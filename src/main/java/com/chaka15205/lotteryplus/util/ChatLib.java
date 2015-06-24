package com.chaka15205.lotteryplus.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ChatLib {

    public static class Message {
        public static final String PREFIX = ChatColor.DARK_GREEN + "[Lottery" + ChatColor.DARK_AQUA + "Plus" + ChatColor.DARK_GREEN + "] " + ChatColor.GREEN;
        public static final String LOTTERY_INFO = PREFIX + "Version " + ChatColor.AQUA + "1.0.0-B7 " + ChatColor.GREEN + "by " + ChatColor.AQUA + "Chaka";
        public static final String INVALID_CMD_SYNTAX = PREFIX + ChatColor.RED + "Invalid Command Syntax.";
        public static final String NO_PERMS = PREFIX + ChatColor.RED + "You do not have permission to use that command.";
        public static final String INVALID_SENDER = PREFIX + ChatColor.RED + "com.chaka15205.lotteryplus.exception.InvalidSenderException: You are not a player.";
    }

    public static class Return {
        public static void createLottery(CommandSender source, String lotteryName) {
            source.sendMessage(Message.PREFIX + "Created new lottery: " + ChatColor.AQUA + lotteryName);
        }
        public static void enterLotterySuccess(CommandSender source, String lotteryName) {
            source.sendMessage(Message.PREFIX + "Successfully entered lottery: " + ChatColor.AQUA + lotteryName);
        }
        public static void enterLotteryFail(CommandSender source, String lotteryName) {
            source.sendMessage(Message.PREFIX + ChatColor.RED + "Failed to enter lottery: " + ChatColor.AQUA + lotteryName);
        }
    }
}
