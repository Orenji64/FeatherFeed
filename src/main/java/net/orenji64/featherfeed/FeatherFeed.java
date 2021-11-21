package net.orenji64.featherfeed;

import de.themoep.minedown.MineDown;
import net.md_5.bungee.api.chat.BaseComponent;
import net.orenji64.featherfeed.actions.JoinHandler;
import net.orenji64.featherfeed.actions.QuitHandler;
import net.orenji64.featherfeed.commands.About;
import net.orenji64.featherfeed.commands.Reload;
import net.orenji64.featherfeed.config.ConfFile;
import net.orenji64.featherfeed.config.ConfVals;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class FeatherFeed extends JavaPlugin implements Listener {
    FileConfiguration c;
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("§6Loaded");
        getServer().getPluginManager().registerEvents(this,this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        FileConfiguration c = getConfig();

        ConfFile.setup(c);
        ConfVals.set();
        ConfFile.get().options().copyDefaults(true);
        //ConfFile.save();
        this.getCommand("featherfeed").setExecutor(new About());
        this.getCommand("featherfeedreload").setExecutor(new Reload());
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        JoinHandler.playerJoin(e, getConfig());


        /*if (config.getBoolean("enable-join-message")) {
            e.setJoinMessage(null);
            Message.JoinMessage(e.getPlayer(), config);
        }
        if (config.getBoolean("enable-first-join-message") && !e.getPlayer().hasPlayedBefore()) {
            Message.FirstJoinMessage(e, config);
        }
        if (config.getBoolean("enable-welcome-message")) {
            Message.WelcomeMessage(e, config);
        }*/
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        QuitHandler.playerQuit(e, getConfig());
        /*if (config.getBoolean("enable-leave-message")) {
            e.setQuitMessage(null);
            Message.LeaveMessage(e.getPlayer(), config);
        }*/
    }
}
