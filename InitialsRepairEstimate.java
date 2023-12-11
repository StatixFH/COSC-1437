package bruhmoment.initialsrepairestimate;

/**
  Full Name
 3/2/2023
 MP Prog #4
 **/
import java.util.Scanner;

public class InitialsRepairEstimate {
    public static final double laborRate = 43.50;
    public static final double travelRate = 9.25;
    public static final double discountRate = 0.125;
    public static final double taxRate = 0.0825;
    public static final double finalTravelRate = 2.0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for job and materials
        System.out.print("Enter job name: ");
        String jobName = input.nextLine();

        System.out.print("Enter itemized list of materials (each item, quantity, and price):\n");
        double materialCost = 0.0;
        while (true) {
            System.out.print("Enter item (or 'stop' to finish): ");
            String item = input.nextLine();
            if (item.equalsIgnoreCase("stop")) {
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();
            input.nextLine(); // stores newline character

            System.out.print("Enter price: ");
            double price = input.nextDouble();
            input.nextLine(); // stores newline character

            materialCost += quantity * price;
        }

        // ask for estimated labor & travel time
        System.out.print("Enter estimated labor time (in hours): ");
        double laborTime = input.nextDouble();

        System.out.print("Enter estimated travel time (in hours): ");
        double travelTime = input.nextDouble();

        // calculates estimate
        double totalCost = compute(laborTime, travelTime, materialCost);

        // discount for veterans
        System.out.print("Are you a veteran? (Y/N): ");
        String veteranAnswer = input.next();
        if (veteranAnswer.equalsIgnoreCase("Y")) {
            totalCost *= 1 - discountRate;
        }

        // Display estimates
        System.out.println("\nHenderson's Repair Service");
        System.out.println("Job name: " + jobName);
        System.out.println("Itemized list of materials: $" + materialCost);
        System.out.println("Labor cost: $" + laborTime * laborRate);
        System.out.println("Travel cost: $" + (travelTime > 0.5 ? (travelTime - 0.5) * travelRate : 0));
        System.out.println("Total estimated price: $" + totalCost);
    }

    public static double compute(double laborTime, double travelTime, double materialCost) {
        double totalCost = materialCost + laborTime * laborRate;
        if (travelTime > 0.5) {
            double travelCost = (travelTime - 0.5) * travelRate;
            totalCost += travelCost;
            if (travelTime > finalTravelRate) {
                System.out.println("The distance is too far. Job not accepted.");
                System.exit(0);
            }
        }
        totalCost *= 1 + taxRate;
        return totalCost;
    }
}