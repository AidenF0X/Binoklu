package com.foxesworld.binoklu;

import com.foxesworld.binoklu.commandLine.CommandLineReader;
import com.foxesworld.binoklu.config.ConfigUtils;
import com.foxesworld.binoklu.config.ConfigOptions;
import static com.foxesworld.binoklu.config.ConfigOptions.getWorkdir;
import static com.foxesworld.binoklu.logger.Logger.LOG;
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
    public static ConfigOptions cfo;

    public static void main(String[] args) throws IOException {
       LOG.error(workDir + " was born!!!");
        config = new ConfigUtils(new File(getWorkdir(3) + cfgPath), "assets/config.json"){};
        cfo = new ConfigOptions(config);
        LOG.info(cfo.getProperty("author", "String") + " Created me at " + cfo.getProperty("created", "String"));
        System.out.println("---------------------------[ Ready to serve! ]---------------------------");
        CommandLineReader CLR = new CommandLineReader();
    }

}
