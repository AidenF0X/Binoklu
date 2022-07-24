package com.foxesworld.binoklu.commandLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author AidenFox
 */
public final class CommandLineReader {
    
    private static final String PROMPT = "> ";
    private static final String QUIT_COMMAND = "quit";
 
    public CommandLineReader() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
           while (line.equalsIgnoreCase(QUIT_COMMAND) == false) {
               System.out.print(PROMPT);
               line = in.readLine();
               
               switch(line){
                   case "help":
                   case "?":
                        System.out.println("Need help!!!");
                    break;
                    
                   default:
                       System.out.println("Unknown command, for help write `help`");
                   break;
               } 
           }
           in.close();
    }
    
}
