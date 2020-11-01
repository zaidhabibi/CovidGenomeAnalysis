/**
 * CovidGenomeAnalysis.java
 * Analyzes the genome of the Coronavirus for Glutamine codons
 * Created 10/18/2020
 * @author Zaid Habibi COSC-1437.202 
 */




import java.util.Scanner;
import java.io.*;

public class CovidGenomeAnalysis{
    public static void main(String [] args) throws IOException{
        
        

        //Create a File class to import covid-19 genome
        File covidData = new File("covid19sequence.txt");
        // Store the data in a Scanner object
        Scanner inputFile = new Scanner(covidData);
        //Instantiate object of class GenomeAnalysis
        GenomeAnalysis covidGenomeAnalysis = new GenomeAnalysis("Glutamine");
        //Set the number of and value of codons we're analyzing for
        covidGenomeAnalysis.setAnalyzeCodons("caa", "cag");

        //While there are still lines in the file, search through and add codons to an array
        while (inputFile.hasNextLine()){
            String covidLine;
            covidLine = inputFile.nextLine();
            covidGenomeAnalysis.genomeToArray(covidLine);
     
        }

        
        //Search through the codons of the COVID-19 genome and sort them into different arrays
        covidGenomeAnalysis.setCodon();
        
        //Print out the attributes and methods of the class
        System.out.println(covidGenomeAnalysis);
    
        //Close the covid19sequence.txt file
        inputFile.close();
    }
    
}


