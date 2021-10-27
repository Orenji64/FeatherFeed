package net.orenji64.featherfeed.commands;

import de.themoep.minedown.MineDown;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.jetbrains.annotations.NotNull;

import java.io.Console;

public class About implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        String v = Bukkit.getServer().getPluginManager().getPlugin("FeatherFeed").getDescription().getVersion();

        BaseComponent[] aboutmd = MineDown.parse(
                        "\n"+
                        "&#5E16F7-#25CFCF&━━━━━ **FeatherFeed** ━━━━━&r&#8fb9c4&"+
                        "\n**Plugin version**: ##"+v+"##"+
                        "\n**Commands**:\n - [/ffinfo    Displays this message](/ff) \n - [/ffrl    Reloads the config](/ffrl)"
        );
        String aboutcn = (
                "\n"+
                "§x§5§b§1§e§f§5§l━§x§5§9§2§6§f§3§l━§x§5§6§2§e§f§1§l━§x§5§4§3§6§f§0§l━§x§5§1§3§e§e§e§l━ §x§4§c§4§e§e§a§lF§x§4§a§5§6§e§9§le§x§4§7§5§e§e§7§la§x§4§5§6§6§e§5§lt§x§4§2§6§e§e§3§lh§x§4§0§7§6§e§2§le§x§3§d§7§e§e§0§lr§x§3§b§8§6§d§e§lF§x§3§8§8§e§d§c§le§x§3§6§9§6§d§b§le§x§3§3§9§e§d§9§ld §x§2§e§a§e§d§5§l━§x§2§c§b§6§d§4§l━§x§2§9§b§e§d§2§l━§x§2§7§c§6§d§0§l━§x§2§5§c§e§c§f§l━"+
                "\n§x§8§f§b§9§c§4Plugin version: "+v+
                "\n§x§8§f§b§9§c§4Commands:\n §x§8§f§b§9§c§4- /ff    Displays this message \n §x§8§f§b§9§c§4- /ffrl    Reloads the config"
        );

        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.spigot().sendMessage(aboutmd);
        }
        else if (sender instanceof ConsoleCommandSender) {
            Bukkit.getConsoleSender().sendMessage(aboutcn);
        }
        return true;
    }
}
