package net.orenji64.featherfeed.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfFile {

    private static File file;
    private static FileConfiguration confFile;

    //Finds or generates the custom config file
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("FeatherFeed").getDataFolder(), "config.yml");

        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        confFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return confFile;
    }

    public static void save(){
        try{
            confFile.save(file);
        }catch (IOException e){
            System.out.println("File could not be saved");
        }
    }

    public static void reload(){
        confFile = YamlConfiguration.loadConfiguration(file);
    }

}
