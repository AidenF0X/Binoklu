package com.foxesworld.binoklu;

import com.foxesworld.binoklu.config.ConfigUtils;
import com.foxesworld.binoklu.config.ConfigOptions;
import static com.foxesworld.binoklu.output.messageUtils.sendInfo;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author AidenFox
 */
public class Binoklu {
    
    private static String workDir = "Binoklu";
    private static final String cfgName = "main.cfg";
    private static final String cfgPath = "config" + File.separator + cfgName;
    public static ConfigUtils config;
    public static ConfigOptions cfo = new ConfigOptions();

    public static void main(String[] args) throws IOException {
        sendInfo("Binoklu", "I'm born!!!", 0, true);
        config = new ConfigUtils(cfgName, new File(getWorkdir(3) + cfgPath));
        config.load();
        sendInfo(config.getPropertyString("author"), " Created at " + config.getPropertyString("created"), 0, false);

    }
    
    private static String getWorkdir(Integer index){
        String path;
        switch(index){
            case 1:
                //In user's HOMEDIR
                path = System.getProperty("user.home", "") + File.separator + workDir + File.separator;
            break;
            
            case 2:
                //On user's SYSTEMDRIVE
                path = System.getenv("SYSTEMDRIVE") + File.separator + workDir + File.separator;
            break;
            
            default:
                //In a folder launched from
                path = "";
            break;
        
        }
        return path;
    }
}
