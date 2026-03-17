package top.timeblog.enderPocket;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
import top.timeblog.enderPocket.listener.playerUseItemEventListener;

public final class EnderPocket extends JavaPlugin  {
    public Server server(){
        return this.getServer();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new playerUseItemEventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
