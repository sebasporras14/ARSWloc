package edu.escuelaing.arsw.app;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class LineCounter extends SimpleFileVisitor<Path>{
    private int count = 0;
    private PathMatcher pathMatcher;
    private String type;

    public LineCounter(String pattern, String type){
        this.type = type;
        this.pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
    }
    
    /* 
     * visit eacth file and calculate the acumulated count
     * @param file
     * @param attributes
     * @return FileVisitResult
     * @throws IOException
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException{
        if (pathMatcher.matches(file.getFileName())){
            if("loc".equals(type)){
                count = count + Counter.CountCodeLines(file.toString());
            } else if ("phy".equals(type)){
                count = count + Counter.CountPhyLines(file.toString());
            }
        }
        return FileVisitResult.CONTINUE;
    }
    
    /*
     * if it fails due there is a problem with the acces this method will let you know
     * @param file
     * @param e
     * @return FileVisitResult
     * @throws IOException
     */
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException e) throws IOException{
        System.err.println("Failed to access: " + file);
        return FileVisitResult.CONTINUE;
    }
    
    /* 
     * return the count
     * @return int
     */
    public int getLineCount(){
        return count;
    }
}