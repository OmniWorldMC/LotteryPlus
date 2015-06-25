package com.chaka15205.lotteryplus.util;

import com.chaka15205.lotteryplus.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ChatLib {

    public static class Message {
        public static final String PREFIX = ChatColor.DARK_GREEN + "[Lottery" + ChatColor.DARK_AQUA + "Plus" + ChatColor.DARK_GREEN + "] " + ChatColor.GREEN;
        public static final String LOTTERY_INFO = PREFIX + "Version " + ChatColor.AQUA + "1.0.0-B23 " + ChatColor.GREEN + "by " + ChatColor.AQUA + "Chaka";
        public static final String INVALID_CMD_SYNTAX = PREFIX + ChatColor.RED + "Invalid Command Syntax.";
        public static final String NO_PERMS = PREFIX + ChatColor.RED + "You do not have permission to use that command.";
        public static final String INVALID_SENDER = PREFIX + ChatColor.RED + "com.chaka15205.lotteryplus.exception.InvalidSenderException: You are not a player.";
    }

    public static class Return {
        public static void createLottery(CommandSender source, String lotteryName) {
            source.sendMessage(Message.PREFIX + "Created new lottery: " + ChatColor.AQUA + lotteryName);
            if (Config.getConfig().getBoolean("announce.openLottery")) {
                Bukkit.broadcastMessage(Message.PREFIX + "A new lottery has been created: " + ChatColor.AQUA + lotteryName);
            }
        }
        public static void enterLottery(CommandSender source, String lotteryName) {
            source.sendMessage(Message.PREFIX + "Successfully entered the " + ChatColor.AQUA + lotteryName + ChatColor.GREEN + " lottery.");
        }
        public static void leaveLottery(CommandSender source, String lotteryName) {
            source.sendMessage(Message.PREFIX + "You have left the " + ChatColor.AQUA + lotteryName + ChatColor.GREEN + " lottery.");
        }
        public static void closeLottery(CommandSender source, String winner, String lotteryName) {
            source.sendMessage(Message.PREFIX + ChatColor.AQUA + winner + ChatColor.GREEN + " has won the "+ lotteryName + ChatColor.GREEN + " lottery.");
            Bukkit.broadcastMessage(Message.PREFIX + ChatColor.AQUA + winner + ChatColor.GREEN + " has won the " + ChatColor.AQUA + lotteryName + ChatColor.GREEN + " lottery.");
        }
        public static void removeLottery(CommandSender source, String lotteryName) {
            source.sendMessage(Message.PREFIX + "Successfully removed: " + ChatColor.AQUA + lotteryName);
        }
        public static void ladminHelp(CommandSender source) {
            source.sendMessage(Message.PREFIX + "/ladmin create <name> - Creates a new lottery.");
            source.sendMessage(Message.PREFIX + "/ladmin delete <name> - Deletes the specified lottery.");
            source.sendMessage(Message.PREFIX + "/ladmin <close/draw> <name> - Picks a winner from the specifid lottery.");
            source.sendMessage(Message.PREFIX + "/ladmin <add/remove> <name> <player> - Adds or removes a player to a lottery.");
        }
    }
}
