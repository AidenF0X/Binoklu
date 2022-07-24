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
    public static ConfigOptions cfo = new ConfigOptions();

    public static void main(String[] args) throws IOException {
       LOG.error(workDir + " was born!!!");
        config = new ConfigUtils(cfgName, new File(getWorkdir(3) + cfgPath)) {};
        config.load();
        LOG.info(config.getPropertyString("author") + " Created me at " + config.getPropertyString("created"));
        System.out.println("---------------------------[ Ready to serve! ]---------------------------");
        //LOG.info("Server listening on port {}", 2345);
        //LOG.error("Unable to display help/usage information");
        //LOG.trace("A GGshnik");
        CommandLineReader CLR = new CommandLineReader();
    }

}
