package bruhmoment.huntingtonbgc;

 import java.util.Scanner;

public class HuntingtonBGC {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
 /** intializing variables **/
    final double adult_Meal_Cost = 4.75;
    final double child_Meal_Cost = 3.75;
    final double cookie_Cost = 0.50;
    final double brownie_Cost = 0.75;
    int adultMealsSold, childMealsSold, cookiesSold, browniesSold;
    double adultMealsRevenue, childMealsRevenue, cookiesRevenue, browniesRevenue, totalRevenue, profit;

 /** asks user for input with appropiate message and stores user's input **/
    System.out.print("Enter number of adult meals sold: ");
    adultMealsSold = keyboard.nextInt();
    System.out.print("Enter number of child meals sold: ");
    childMealsSold = keyboard.nextInt();
    System.out.print("Enter number of cookies sold: ");
    cookiesSold = keyboard.nextInt();
    System.out.print("Enter number of brownies sold: ");
    browniesSold = keyboard.nextInt();

    /** multiplying sold items via their respective cost and then calculating 
     if a profit was made**/
    adultMealsRevenue = adultMealsSold * adult_Meal_Cost;
    childMealsRevenue = childMealsSold * child_Meal_Cost;
    cookiesRevenue = cookiesSold * cookie_Cost * 2;
    browniesRevenue = browniesSold * brownie_Cost;
    totalRevenue = adultMealsRevenue + childMealsRevenue + cookiesRevenue 
            + browniesRevenue;
    profit = totalRevenue - (adult_Meal_Cost * adultMealsSold + child_Meal_Cost 
            * childMealsSold + cookie_Cost * cookiesSold * 2 + brownie_Cost * browniesSold);

    /** displays the sales report, revenue, and total revenue and the profit
     which was made, basically all the individual information calculated 
     unknown and unseen now displayed for the user **/
    System.out.println("\n=== Sales Report ===");
    System.out.println("Adult Meals Sold: " + adultMealsSold);
    System.out.println("Child Meals Sold: " + childMealsSold);
    System.out.println("Cookies Sold: " + cookiesSold);
    System.out.println("Brownies Sold: " + browniesSold);
            
    System.out.println("\nRevenue:");
    System.out.println("Adult Meals Revenue: $" + adultMealsRevenue);
    System.out.println("Child Meals Revenue: $" + childMealsRevenue);
    System.out.println("Cookies Revenue: $" + cookiesRevenue);
    System.out.println("Brownies Revenue: $" + browniesRevenue);
    
    System.out.println("\nTotal Revenue: $" + totalRevenue);
    System.out.println("Profit: $" + profit);
  }
}