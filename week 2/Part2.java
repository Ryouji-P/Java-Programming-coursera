
/**
 * Write a description of class Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2
{
    // set up start codon and stop codon
    public String startCodon = "ATG";
    public String stopCodon = "TAA";
    public String findSimpleGene(String dna, String startCodon, String stopCodon)
    {
        String result = "";
        // start codon is ATG
        // stop codon is TAA
        String dnaCap = dna.toUpperCase();//capitalized dna
        int capTest = 0;
        if (dnaCap != dna){//if dna string is not capitalized
            capTest = 1;
        }
        int startIndex = dnaCap.indexOf(startCodon);
        if (startIndex == -1){//no ATG
            return "";
        };
        
        int stopIndex = dnaCap.indexOf(stopCodon, startIndex+3);
        if (stopIndex == -1){//no TAA
            return "";
        };
        result = dna.substring(startIndex, stopIndex+3);
        if (result.length() % 3 != 0){//substring not divided by 3
            return "";
        }; 
        return result;
    }
    public void testSimpleGene(){
        String DNAwithnoATG = "ACGCACAGATAA";
        System.out.println("DNA strand is " + DNAwithnoATG);
        String gene = findSimpleGene(DNAwithnoATG, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        String DNAwithnoTAA = "ATGCAGAAGATA";
        System.out.println("DNA strand is " + DNAwithnoTAA);
        gene = findSimpleGene(DNAwithnoTAA, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        String DNAwithnoATGorTAA = "ACGATAGACAT";
        System.out.println("DNA strand is " + DNAwithnoATGorTAA);
        gene = findSimpleGene(DNAwithnoATGorTAA, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        String DNAnotdividedby3 = "ATGTCATGAGTAA";
        System.out.println("DNA strand is " + DNAnotdividedby3);
        gene = findSimpleGene(DNAnotdividedby3, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        String DNAdividedby3 = "ATGTCATGATAA";
        System.out.println("DNA strand is " + DNAdividedby3);
        gene = findSimpleGene(DNAdividedby3, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        String upperTest1 = "ATGGGTTAAGTC";
        System.out.println("DNA strand is " + upperTest1);
        gene = findSimpleGene(upperTest1, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        String upperTest2 = "gatgctataat";
        System.out.println("DNA strand is " + upperTest2);
        gene = findSimpleGene(upperTest2, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
    }
}
