// Include all relevant import statements here.
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
public class DatasetDiscovery
{
  public static void main(String[] args) 
  {
    // Prepare input and output files for reading/writing.
    // Replace /* your input file */ with .csv input filename.
    try
    {
        File inFile = new File("DOEFI.csv");
        Scanner scan = new Scanner(inFile);
        PrintWriter outFile = new PrintWriter("output.txt"); 
        int x = 1;
        /* Write while loop below to read each line from input file, then print
         * to an output file each line number, followed by the line itself.
         */
        while (scan.hasNext()) 
        {
            outFile.print(x + ". ");
            String csvLine = scan.nextLine();
            outFile.println(csvLine);
            x++;
        }
       // Close scan and outFile.
       scan.close();
       outFile.close();
       
    } catch(Exception e)
    {
        System.out.println("A mistake has been magically discovered in the filename!");
    }
    System.out.println("Test");
   
    
  }
  /*1. Why Did you choose this data set? I was looking through dat sets of technology and this 
   * one caught my eye because it is data on equipment used to create data. It is very meta.
   * The datasate contains information about Reaearch and Development equipment that is 
   * used to devlop or improve processes or products
   * 2. For what kind of research study might this data set be useful? This data set might be
   * usefull to advance scientific research and accelerate technology commercialization. 
   * It can be used to develop new and more efficient ways of assembling basketballs.
   * 
   */
} 
