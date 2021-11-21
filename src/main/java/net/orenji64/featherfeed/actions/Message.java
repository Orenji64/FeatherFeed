package net.orenji64.featherfeed.actions;

import de.themoep.minedown.MineDown;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;
import java.util.Random;

public class Message {

    public static void JoinMessage(Player p, FileConfiguration c) {
        //      Randomly select message
        List<String> messages = c.getStringList("messages.join");
        String message = messages.get(new Random().nextInt(messages.size()));
        //      Broadcast join message
        Bukkit.broadcastMessage("§e"+p.getDisplayName()+" "+message);
    }
    public static void LeaveMessage(Player p, FileConfiguration c) {
        //      Randomly select message
        List<String> messages = c.getStringList("messages.leave");
        String message = messages.get(new Random().nextInt(messages.size()));
        //      Broadcast leave message
        Bukkit.broadcastMessage("§e"+p.getDisplayName()+" "+message);
    }
    public static void WelcomeMessage(PlayerJoinEvent e, FileConfiguration c) {
        Player p = e.getPlayer();
        if (!p.hasPlayedBefore() && !c.getBoolean("enable-welcome-on-first-join")) {
            System.out.println("FF"+p.getDisplayName()+" not welcomed due to config");
        }
        else {
            String message = c.getString("messages.welcome");
            p.spigot().sendMessage(new MineDown(
                    PlaceholderAPI.setPlaceholders(p,message+"\n")
            ).toComponent());
        }


    }
    public static void FirstJoinMessage(PlayerJoinEvent e, FileConfiguration c) {
        Player p = e.getPlayer();
        String message = c.getString("messages.first-join");
        p.spigot().sendMessage(new MineDown(
                PlaceholderAPI.setPlaceholders(p,message+"\n")
        ).toComponent());
    }
}
