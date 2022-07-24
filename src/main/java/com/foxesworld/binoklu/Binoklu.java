package com.foxesworld.binoklu;

import com.foxesworld.binoklu.commandLine.CommandLineReader;
import com.foxesworld.binoklu.config.ConfigUtils;
import com.foxesworld.binoklu.config.ConfigOptions;
import static com.foxesworld.binoklu.config.ConfigOptions.getWorkdir;
import static com.foxesworld.binoklu.output.messageUtils.sendInfo;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author AidenFox
 */
public class Binoklu {
    
    public static String workDir = "Binoklu";
    private static final String cfgName = "main.cfg";
    private static final String cfgPath = "config" + File.separator + cfgName;
    public static ConfigUtils config;
    public static ConfigOptions cfo = new ConfigOptions();

    public static void main(String[] args) throws IOException {
        sendInfo("Binoklu", "I'm born!!!", 0, true);
        config = new ConfigUtils(cfgName, new File(getWorkdir(3) + cfgPath)) {};
        config.load();
        sendInfo(config.getPropertyString("author"), " Created at " + config.getPropertyString("created"), 0, false);
        System.out.println("---------------------------------------------------------------------");
        CommandLineReader CLR = new CommandLineReader();
    }

}
