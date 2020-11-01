/**
 * GenomeAnalysis.java
 * Class that analyzes genomes for any specific amino acid and returns a report
 * Created 10/18/2020
 * @author Zaid Habibi COSC-1437.202 
 */

import java.util.ArrayList;

public class GenomeAnalysis{


    //Amino Acid name that we're looking for
    private String aminoAcid = "";
    

    //This arraylist stores values of the codons we're analyzing for
    private ArrayList<String> analyzeCodons = new ArrayList<>(20);
    //This arraylist stores the total amount of codons for each codon we're analyzing for
    private ArrayList<Integer> aminoCodonTotals = new ArrayList<>();
    //This array stores every codon in the given genome
    private ArrayList<String> genomeCodons = new ArrayList<>();
    //This stores the percentages for each codon we're analyzing for
    private ArrayList<Double> aminoCodonPercentages = new ArrayList<>();

    //constructor
    public GenomeAnalysis(String an){
        aminoAcid = an;
    }
    //constructor with no params
    public GenomeAnalysis(){
        //No-arg constructor so this is empty
        aminoAcid = "";
    }

    /** 
	 * toString
	 * This method overrides the Object class' toString method
	 * @return the genome information as a string.  
	 */ 
    public String toString(){
        String tempString = "";
        
        tempString += (aminoAcid + " Codon Counts: \n\n");
        
        for (int i = 0; i < analyzeCodons.size(); i++){
            tempString += (analyzeCodons.get(i).toUpperCase() +": " + aminoCodonTotals.get(i) + "     " + String.format("%,.2f", calcAminoCodonPercent(i) )+ " percent\n");
        }

        tempString += ("\n" + aminoAcid + " codes for " + String.format("%,.2f", calcTotalCodonPercent()) + " percent of the total genome.\n");

        return tempString;
    }

    /** 
	 * equals
	 * This method overrides the Object class' equals method
	 * @param 	genomeanalysis2	the genome to which to compare this one
	 * @return 	true if genome amino acid are the same between this genome
	 * 			and the passed in genome.  false otherwise.
	 */
    public boolean equals(GenomeAnalysis genomeanalysis2)
	{
        
		    return  this.aminoAcid.equals(genomeanalysis2.aminoAcid);
    }
    

    /** 
	 * genomeToArray
	 * This method converts genome data into a codon array
	 * @param 	genomeLine	The line from the file that will be converted into codons
	 */
    public void genomeToArray(String genomeLine){
        
        int k = 0;
        int j = 3;
            
            for(int i = 0; i < genomeLine.length(); i++){
                while(j <= genomeLine.length()){
                    
                    genomeCodons.add(genomeLine.substring(k,j));
                    k+=3;
                    j+=3;
                    
                }
            }
    }

    /** 
	 * getGenomeArray
	 * This method gets the array of the entire genome
	 * @return  An ArrayList<String> objcet
	 */    
    public ArrayList<String> getGenomeArray(){
        return genomeCodons;
    }

    /** 
	 * getAminoCodonTotals
	 * This method gets the total number of amino acid codons in the genome
	 * @return  the total number amino acid codons as an int
	 */  
    public int getAminoCodonTotals(){
        int sum = 0;

        for (int i = 0; i < aminoCodonTotals.size(); i++){
            sum += aminoCodonTotals.get(i);
        }

        return sum;
    }


    /** 
	 * setAnalyzeCodons
	 * This method adds codons ("ttc") to an array called analyzeCodons
	 * @param  anCod    the string value of codons to be searched for
	 */  
    public void setAnalyzeCodons(String ...anCod){
        for (String codon: anCod){
            analyzeCodons.add(codon);
            
            
        }
        //This private helper method sets the size of arrays dependent on the number of codons we're looking for equal to analyzeCodon's size
        setArraySize();
    }

    /** 
	 * setCodon
	 * This method finds the total of all amino acid codons and specific amino acid codons
	 */  
    public void setCodon(){
        
         for (int g = 0; g < genomeCodons.size(); g++){
            for (int h = 0; h < analyzeCodons.size(); h++){
                if(analyzeCodons.get(h).equals(genomeCodons.get(g))){

                    aminoCodonTotals.set(h, (aminoCodonTotals.get(h)+1));
                }
            }
        }
    }




    /** 
	 * calcAminoCodonPercent
	 * This private helper method calculates what percentage each codon is of the total amino acid codons
	 * @param index     This method will be called during a for loop
     * @return A double value which is the percentage of each amino codon
	 */  
    
    private double calcAminoCodonPercent(int index){

            return (aminoCodonTotals.get(index) / (double)getAminoCodonTotals()* 100);

    }

    /** 
	 * calcTotalCodonPercent
	 * This private helper method finds what percentage your amino acid is of the entire genome
	 * @return  double percentage value of amino acid / total codons
	 */  
    private double calcTotalCodonPercent(){
        double sum = 0;
        for (int y = 0; y < aminoCodonTotals.size(); y++){
            sum += aminoCodonTotals.get(y); 
        }
        return (sum / getGenomeArray().size()) * 100;
    }

    /** 
	 * setArraySize
	 * This private helper method sets the array size of aminoCodonTotals and aminoCodonPercentages to that of analyzeCodons
	 */  
    private void setArraySize(){
        for (int i = 0; i < analyzeCodons.size(); i ++){
            aminoCodonTotals.add(0);
            aminoCodonPercentages.add(0.0);
        }

    
        
    }

}