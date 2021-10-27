package net.orenji64.featherfeed.config;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class ConfVals {

    public static void setup() {
        FileConfiguration c = ConfFile.get();

        c.addDefault("enable-join-message",true);
        c.addDefault("enable-leave-message",true);
    }

}
