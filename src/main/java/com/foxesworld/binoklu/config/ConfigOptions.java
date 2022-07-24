package com.foxesworld.binoklu.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.foxesworld.binoklu.Binoklu.config;
import static com.foxesworld.binoklu.Binoklu.workDir;
import com.foxesworld.binoklu.logger.Logger;
import static com.foxesworld.binoklu.logger.Logger.LOG;
import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AidenFox
 */
public class ConfigOptions {
    
    private static Logger msg;
    
    public static void setDefaults(String jsonFile) throws IOException {
            ObjectMapper mapper = new ObjectMapper(); 
            InputStream is = getResourceAsStream(jsonFile);
            TypeReference<HashMap<String,Object>> typeRef = new TypeReference<HashMap<String,Object>>() {};

            HashMap<String,Object> map = mapper.readValue(is, typeRef); 
            for(Map.Entry<String, Object> entry : map.entrySet()){
                String key = entry.getKey();
                Object value = entry.getValue();
                ConfigOptions.setProperty(key, value);
            }
            ConfigOptions.setProperty("created", new Date());
    }  
    
    public static void setProperty(String key, Object value) {
		if (config.checkProperty(key)) {
			//config.changeProperty(key, value);
                } else {
			config.put(key, value);
                        LOG.info("  - Recording a missing key `" + key + "` with value `"+ value + "`");
                }
	}

	public static String getPropertyString(String key) {
		if (config.checkProperty(key))
			return config.getPropertyString(key);
		return null;
	}

	public static boolean getPropertyBoolean(String key) {
		if (config.checkProperty(key)) {
			return config.getPropertyBoolean(key);
                }
		return false;
	}

	public static int getPropertyInt(String key) {
		if (config.checkProperty(key))
			return config.getPropertyInteger(key);
		return 0;
	}
        /*
	public static int getPropertyInt(String s, int d) {
		File dir = new File(BaseUtils.getAssetsDir().toString());
		if (!dir.exists())
			dir.mkdirs();
		if (config.checkProperty(s))
			return config.getPropertyInteger(s);
		setProperty(s, d);
		return d;
	} */

	public static boolean getPropertyBoolean(String key, boolean value) {
		if (config.checkProperty(key))
			return config.getPropertyBoolean(key);
		return value;
	}
        
    public static String getWorkdir(Integer index){
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
