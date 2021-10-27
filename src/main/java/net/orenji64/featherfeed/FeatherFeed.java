package net.orenji64.featherfeed;

import net.orenji64.featherfeed.commands.About;
import net.orenji64.featherfeed.commands.Reload;
import net.orenji64.featherfeed.config.ConfFile;
import net.orenji64.featherfeed.config.ConfVals;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class FeatherFeed extends JavaPlugin implements Listener {
    FileConfiguration config = getConfig();
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("§6[FF] Plugin loaded");
        getServer().getPluginManager().registerEvents(this,this);

        ConfFile.setup();
        ConfVals.setup();
        ConfFile.get().options().copyDefaults(true);
        ConfFile.save();
        this.getCommand("featherfeed").setExecutor(new About());
        this.getCommand("featherfeedreload").setExecutor(new Reload());
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        if (config.getBoolean("enable-join-message")) {
            e.setJoinMessage(null);
            Message.JoinMessage(e.getPlayer(), config);
        }
        if (config.getBoolean("enable-first-join-message") && !e.getPlayer().hasPlayedBefore()) {
            Message.FirstJoinMessage(e, config);
        }
        if (config.getBoolean("enable-welcome-message")) {
            Message.WelcomeMessage(e, config);
        }
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        if (config.getBoolean("enable-leave-message")) {
            e.setQuitMessage(null);
            Message.LeaveMessage(e.getPlayer(), config);
        }
    }
}
