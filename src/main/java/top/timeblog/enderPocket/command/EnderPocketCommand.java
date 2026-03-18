package top.timeblog.enderPocket.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class EnderPocketCommand implements  CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this.");
            return true;
        }

        Player player = (Player) sender;
        if (!sender.hasPermission("enderpocket.open")) {
            player.sendMessage("No permission.");
            return true;
        }

        if (args.length == 0) {
            player.openInventory(player.getEnderChest());
            return true;
        }

        // /ep open
        if (args.length == 1 && args[0].equalsIgnoreCase("open")) {
            player.openInventory(player.getEnderChest());
            return true;
        }

        // /ep open <player>
        if (args.length == 2 && args[0].equalsIgnoreCase("open")) {
            if (!player.hasPermission("enderpocket.open.it")) {
                player.sendMessage("§cYou don't have permission.");
                return true;
            }

            Player target = getServer().getPlayer(args[1]);

            if (target == null) {
                player.sendMessage("§cPlayer not found or not online.");
                return true;
            }

            player.openInventory(target.getEnderChest());
            player.sendMessage("§aOpened " + target.getName() + "'s Ender Chest.");
            return true;
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> list = new ArrayList<>();

        if (args.length == 1) {
            list.add("open");
        }else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("open")) {
                List<String> players = new ArrayList<>();
                for (Player p : Bukkit.getOnlinePlayers()) {
                    players.add(p.getName());
                }
                return players;
            }
        }

        return list;
    }
}
