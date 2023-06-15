# INTRODUCTION TO JAVA, MVN, AND GIT: LOC Counting

this project we used all the knowledge in java, mvn and git to build a code able to calculate the loc(lines of code) and phy(physical lines) of a file or directory. Then, with this information(LOC) no we can calculate our productivity and compare the complexity.
## LOC/H

According to the program there are 268 lines of code in the 3 java classes made, all the time spent coding was around 7 hours

$ 143 / 7 = 20.4$ lines per hour 
## Design 

### class Diagram 

this diagram shows how the classes use each other. This time CountLines is the main class which will be using counter and in it the class LineCounter is summoned to allow the visit to each file in the directory making the acumulation of the lines.

![class diagram](https://github.com/sebasporras14/ARSWloc/blob/master/images/clases.png)


## Running the tests

we run the taste made to check the functionality of the methods done and got the result:

![test report](https://github.com/sebasporras14/ARSWloc/blob/master/images/TestReport.png)

### ejemplo de ejecucion por consola:

java -cp "./target/classes" edu.escuelaing.arsw.app.CountLines type "path" 

### tests
there are 4 test were made to cover the principal functions of the program.

1. Test the counting of physical lines of one .java file
   
2.  Test the counting of code lines of one .java file
 
3.  Test the counting of physical lines of all files in the directory called app

4. Test the counting of the lines of code of all files in app



### coding style tests

these tests were coded using each specific method to prove that the code is doing the rigth counting 
```
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
```
this is an example how it is coded. It will use the method recursiveCount of the class Counter to count the lines of code of all the files in app. using assertEquals it proves the method count the same amount as was expected.

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management
* [java](https://rometools.github.io/rome/) - Used to generate RSS Feeds


## Authors

* **Sebastian Porras**

### Date

06/14/2023 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
