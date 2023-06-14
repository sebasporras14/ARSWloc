package edu.escuelaing.arsw.app;

import java.io.IOException;

public class CountLines {

    
    /** 
     * execute the program according the parameters given 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        String type = args[0];
        String path = args[1];
        String pattern = "*.java";
        // use the class counter and method CountLines to start counting according the type
        Counter.CountLines(type, path, pattern);
        System.out.println("phy o loc: " + type + " path: " + path + " pattern: " + pattern );
    }

}   