package net.orenji64.featherfeed.actions;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitHandler {
    public static void playerQuit(PlayerQuitEvent e, FileConfiguration c) {
        if (c.getBoolean("enable-leave-message")) {
            e.setQuitMessage(null);
            Message.LeaveMessage(e.getPlayer(), c);
        }
    }
}
