package net.orenji64.featherfeed.actions;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinHandler {
    public static void playerJoin(PlayerJoinEvent e, FileConfiguration c) {
        if (c.getBoolean("enable-join-message")) {
            e.setJoinMessage(null);
            Message.JoinMessage(e.getPlayer(), c);
        }
        if (c.getBoolean("enable-first-join-message") && !e.getPlayer().hasPlayedBefore()) {
            Message.FirstJoinMessage(e, c);
        }
        if (c.getBoolean("enable-welcome-message")) {
            Message.WelcomeMessage(e, c);
        }
    }
}
