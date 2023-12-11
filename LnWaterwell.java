package WaterwellProj;
/** Full name, 1/25/23, Prog 1 **/

import java.util.Scanner;
public class LnWaterwell {
 /** scanner necessary to read inputs given **/
    
    public static void main(String[] args) {
     Scanner keyScan = new Scanner(System.in);  
     /** including java main and defining our input reader, scanner**/
     
      System.out.printf("\nEnter the radius of the well in inches\n");
      double radius = keyScan.nextDouble();
      double inchToFeet = radius / 12;
      /** asks for radius from user, reads input then divides by 12 to convert into feet**/
      
      System.out.printf("\nEnter the depth of the well in feet\n");
      double depth = keyScan.nextDouble(); 
      /** asks for depth from user in feet and reads input**/
      
      double volume = 3.14 * (inchToFeet * inchToFeet) * depth;
      double waterInGallons = volume * 7.48;
      System.out.printf("\nThe well can hold %.2f gallons", waterInGallons);
      /**calculates the volume of a cylinder, multiplies that volume by 7.48 to account 
       for gallons of water, then displays the calculation in a readable message **/
    }
    }
     
     