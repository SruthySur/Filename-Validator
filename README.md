# File Name Validator

The program validates the filename. If the file is invalid, it prints the error details along with the status of the file as passed or failed.
The file name format is matched with the below:
Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>.csv


## To run application
The application can be run in 2 ways after placing input file in specified path:
  1) java -jar validator-0.0.1-SNAPSHOT.jar arg, the arg passed should be the filename
     Eg:
        java -jar validator-0.0.1-SNAPSHOT.jar Test_A_07121987.csv

  2) Import the code to IDE (Intellij, Eclipse) as maven project & run Application.java with filename in program arguments

## How to build software
jar file is attached which can be run in java environment.
To build, run :    mvn clean install
