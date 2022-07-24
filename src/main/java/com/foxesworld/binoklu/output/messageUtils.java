package com.foxesworld.binoklu.output;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
/**
 *
 * @author AidenFox
 */
public class messageUtils {   
 
        public static void sendInfo(String title, String msg, Integer index, boolean error){
            String space = " ";
            String MSGtype = "INFO";
            if(!index.equals(0)) {
                for(Integer j = 0; j < index; j++){
                    space+=" ";
                }space+=" - ";
            }
            if(error == true){
                MSGtype = "ERROR";
            }

            System.out.println(space + date() + "[" + title + "/" + MSGtype + "]" + msg);
        }
        
        public static String date() {
		Date now = new Date();
		DateFormat formatter = new SimpleDateFormat("[HH:mm:ss]");
		String s = formatter.format(now);
		return s;
	} 
}
