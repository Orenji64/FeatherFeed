package net.orenji64.featherfeed.config;

import net.orenji64.featherfeed.FeatherFeed;
import net.orenji64.featherfeed.commands.About;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

import static org.bukkit.Bukkit.getServer;

public class ConfFile {

    private static File file;
    private static FileConfiguration confFile;

    //Finds or generates the custom config file
    public static void setup(FileConfiguration c){
        file = new File(getServer().getPluginManager().getPlugin("FeatherFeed").getDataFolder(), "config.yml");
        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                //Emptiness
            }
        }
        confFile = c;
    }

    public static FileConfiguration get(){
        return confFile;
    }

    public static void save(){
        try{
            confFile.save(file);
        }catch (IOException e){
            System.out.println("Couldn't save file");
        }
    }

    public static void reload(){
        confFile = YamlConfiguration.loadConfiguration(file);
    }
}
