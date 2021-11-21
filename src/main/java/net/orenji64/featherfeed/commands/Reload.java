package net.orenji64.featherfeed.commands;

import de.themoep.minedown.MineDown;
import net.md_5.bungee.api.chat.BaseComponent;
import net.orenji64.featherfeed.FeatherFeed;
import net.orenji64.featherfeed.config.ConfFile;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Reload implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        ConfFile.reload();

        BaseComponent[] confirmmd = MineDown.parse("##&#5E16F7-#25CFCF&**FeatherFeed**&r &r&#8fb9c4&successfully reloaded##");
        String confirmcn = "§x§5§8§2§6§f§3§o§lF§x§5§3§3§7§e§f§o§le§x§4§e§4§8§e§c§o§la§x§4§9§5§9§e§8§o§lt§x§4§4§6§a§e§4§o§lh§x§3§e§7§a§e§1§o§le§x§3§9§8§b§d§d§o§lr§x§3§4§9§c§d§9§o§lF§x§2§f§a§d§d§6§o§le§x§2§a§b§e§d§2§o§le§x§2§4§c§f§c§f§o§ld §x§8§f§b§9§c§4successfully reloaded";

        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.spigot().sendMessage(confirmmd);
        }
        else if (sender instanceof ConsoleCommandSender) {
            Bukkit.getConsoleSender().sendMessage(confirmcn);
        }

        return true;
    }

}
