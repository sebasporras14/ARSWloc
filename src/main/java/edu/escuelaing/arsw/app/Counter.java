package edu.escuelaing.arsw.app;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Counter {
    
    
    
    /* 
     * counts the lines according to thje type of count, if the type is not one of the required ones will return a message
     * @param type
     * @param path
     * @param pattern
     */
    public static void CountLines(String type , String path,String pattern){
        try{
            int count;
            if(type.equals("phy")){
                count = recursiveCount(path, pattern, type);
                System.out.println(count);
            } else if(type.equals("loc")){
                count = recursiveCount(path, pattern, type);
                System.out.println(count);
            } else{
                System.out.println("Invalid parameter");
                return;
            }     
        } catch(IOException e){
            System.err.println("error");
        }
        
       

    }
    
    /*
     * count the physical lines of the file or directory provided
     * @param path
     * @return int
     * @throws IOException
     */
    public static int CountPhyLines(String path) throws IOException{
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            while(reader.readLine() != null){
                count = count + 1;
            }
        }
        return count;
    }
    
    /* 
     * count the lines of code of the file or directory provided
     * @param path
     * @return int
     * @throws IOException
     */
    public static int CountCodeLines(String path)throws IOException{
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = reader.readLine()) != null){
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("/*") && !line.startsWith("*") && !line.startsWith("*/")){
                    count = count + 1 ;
                }
            }
        }
        return count;
    }
    
    /*
     * count all the lines of code or physical in the directory or the file according to the type
     * @param path
     * @param pattern
     * @param type
     * @return int
     * @throws IOException
     */
    public static int recursiveCount(String path, String pattern ,String type) throws IOException{
        LineCounter lineCounter = new LineCounter(pattern, type);
        Files.walkFileTree(Paths.get(path), lineCounter);
        return lineCounter.getLineCount();
    }
    
}
