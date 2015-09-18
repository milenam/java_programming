import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double price = getDiscountPrice(keyboard);
		double discount = getDiscountRate(keyboard);
		double savings = computeDiscountInfo(price, discount);		
		
		System.out.println("Special this week on any service over " + price);
	    System.out.println("Discount of " + discount + " percent");
	    System.out.println("That's a savings of at least $" + savings);
	}

	public static double getDiscountPrice (Scanner keyboard) {
		double tempPrice;
		System.out.print("Enter cutoff price for discount >> "); 
		tempPrice = keyboard.nextDouble();
		return tempPrice;
	}
	
	public static double getDiscountRate (Scanner keyboard) {
	   double tempDiscount;
       System.out.print("Enter discount rate as a whole number >> "); 
       tempDiscount = keyboard.nextDouble();
       return tempDiscount;
	}
	
	public static double computeDiscountInfo(double price, double discount) {
		double temp;
		temp = price * discount/100;
		return temp;
	}

}
