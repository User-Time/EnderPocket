package top.timeblog.enderPocket;

import org.bukkit.plugin.java.JavaPlugin;
import top.timeblog.enderPocket.command.EnderPocketCommand;
import top.timeblog.enderPocket.listener.playerUseItemEventListener;

public final class EnderPocket extends JavaPlugin  {
    @Override
    public void onEnable() {
        // Plugin startup logic
        // 命令注册
        EnderPocketCommand cmd = new EnderPocketCommand();
        getCommand("enderpocket").setExecutor(cmd);
        getCommand("enderpocket").setTabCompleter(cmd);
        getServer().getPluginManager().registerEvents(new playerUseItemEventListener(), this);
        getLogger().info("Startup successful!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
