package com.chaka15205.lotteryplus.util;

import com.chaka15205.lotteryplus.config.Config;
import com.chaka15205.lotteryplus.lottery.LotteryManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class ChatLib {

    public static class Message {
        public static final String PREFIX = ChatColor.DARK_GREEN + "[Lottery" + ChatColor.DARK_AQUA + "Plus" + ChatColor.DARK_GREEN + "] " + ChatColor.GREEN;
        public static final String LOTTERY_INFO = PREFIX + "Version " + ChatColor.AQUA + "1.0.0-B25 " + ChatColor.GREEN + "by " + ChatColor.AQUA + "Chaka";
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
        public static void addPlayer(CommandSender source, String playerName, String lotteryName) {
            source.sendMessage(Message.PREFIX + "Successfully added " + ChatColor.AQUA + playerName + ChatColor.GREEN + " to the " + ChatColor.AQUA + lotteryName + ChatColor.GREEN + " lottery.");
        }
        public static void removePlayer(CommandSender source, String playerName, String lotteryName) {
            source.sendMessage(Message.PREFIX + "Successfully removed " + ChatColor.AQUA + playerName + ChatColor.GREEN + " from the " + ChatColor.AQUA + lotteryName + ChatColor.GREEN + " lottery.");
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
            source.sendMessage(Message.PREFIX + "/ladmin create <lottery name> - Creates a new lottery.");
            source.sendMessage(Message.PREFIX + "/ladmin delete <lottery name> - Deletes the specified lottery.");
            source.sendMessage(Message.PREFIX + "/ladmin <close/draw> <lottery name> - Picks a winner from the specifid lottery.");
            source.sendMessage(Message.PREFIX + "/ladmin <add/remove> <player> <lottery name> - Adds or removes a player to a lottery.");
        }
        public static void lotteryHelp(CommandSender source) {
            source.sendMessage(Message.PREFIX + "List of commands.");
            source.sendMessage(ChatColor.GREEN + "/lottery enter <lottery name> - Enters the sender into a lottery.");
            source.sendMessage(ChatColor.GREEN + "/lottery leave <lottery name> - Removes the sender from a lottery.");
            source.sendMessage(ChatColor.GREEN + "/lottery help - This command.");
            source.sendMessage(ChatColor.GREEN + "/ladmin - The lottery admin command.");
        }
        public static void lotteryList(CommandSender source) {
            source.sendMessage(Message.PREFIX + "List of lotteries.");
            for (Object l : LotteryManager.getManager().lotteryList()) {
                source.sendMessage(ChatColor.GREEN + l.toString());
            }
        }
    }
}
