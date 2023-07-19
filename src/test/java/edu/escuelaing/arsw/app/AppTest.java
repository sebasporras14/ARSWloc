package edu.escuelaing.arsw.app;

import junit.framework.TestCase;


/*
 * Unit test for each principal method of the program.
 * @author Sebastian Porras Rozo
 * @version 14.6.2023 
 */
public class AppTest 
    extends TestCase
{
    /*
    * Test the counting of physical lines of one .java file
    * @param filePath location of the file/directory
    * @param expectedCount number of lines of code expected 
    */
    public void testCountPhysicalLines() {
        String filePath = "src\\main\\java\\edu\\escuelaing\\arsw\\app\\LineCounter.java";
        int expectedCount = 55;

        try {
            int actualCount = Counter.CountPhyLines(filePath);
            assertEquals(expectedCount, actualCount);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    /*
     * Test the counting of code lines of one .java file
     * @param filePath location of the file/directory
     * @param expectedCount number of lines of code expected 
     */
    
    public void testCountCodeLines() {
        String filePath = "src\\main\\java\\edu\\escuelaing\\arsw\\app\\LineCounter.java";
        int expectedCount = 32;
        try {
            int actualCount = Counter.CountCodeLines(filePath);
            assertEquals(expectedCount, actualCount);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    /*
     *Test the counting of physical lines of all files in the directory called app
     * @param filePath location of the file/directory
     * @param expectedCount number of lines of code expected 
     * @param type type of count required. can be "phy" or "loc"
     */
    public void testrecursiveCountLines() {
        String filePath = "src\\main\\java\\edu\\escuelaing\\arsw\\app";
        int expectedCount = 166;
        String type = "phy";

        try {
            int actualCount = Counter.recursiveCount(filePath, "*.java", type);
            assertEquals(expectedCount, actualCount);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    /*
    * Test the counting of the lines of code of all files in app
    * @param filePath location of the file/directory
    * @param expectedCount number of lines of code expected 
    * @param type type of count required. can be "phy" or "loc"
    */
    public void testrecursiveCountCodeLines() {
        String filePath = "src\\main\\java\\edu\\escuelaing\\arsw\\app";
        int expectedCount = 95;
        String type = "loc";

        try {
            int actualCount = Counter.recursiveCount(filePath, "*.java", type);
            assertEquals(expectedCount, actualCount);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
