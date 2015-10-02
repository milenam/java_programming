import java.util.Scanner;
import java.util.Arrays;

public class EightInts {
	private static Scanner input;

	public static void main(String[] args) {
		// #exercises
		// #1
		
//		int[] numbers = {2,4,6,87,9,33,57,8}; // new int[8]
		
//		System.out.println("from first to last: ");
//		for (int i = 0; i < numbers.length; i++) {
//			System.out.println(numbers[i]);
//		}
//		
//		System.out.println("from last to first: ");
//		for (int i = numbers.length-1; i >= 0; i--) {
//			System.out.println(numbers[i]);
//		}
		
		//#2
		
//		double[] scores = new double[4]; 
//		double number = 0;
//		int count = 0;
//		double total = 0;
//		final int QUIT = 99999;
//		final int MAX = 4;
//		Scanner input = new Scanner(System.in); 
//		System.out.print("Enter number >> "); 
//		number = input.nextInt();
//		while(count < MAX && number != QUIT){
//		  if(number != QUIT) {
//		  scores[count] = number;
//		  total += scores[count]; 
//		  System.out.print("Enter next number " +
//		               QUIT + " to quit >> ");
//		  number = input.nextInt();
//		  }
//		  count++; 
//		  }
//		System.out.println("The numbers entered were:");
//		for(int x = 0; x < count; ++x) 
//			System.out.print(scores[x] + " ");
//		System.out.println("\n The average is " + (total * 1.0 / count)); 
		
		// #3
		String item;
		int pos = 0;
		boolean bool = false;
		String[] avalItems = {"desk","table","dresser","entertainment center"};
		double[] prices = {325,250,420,600};
		
		Scanner input = new Scanner(System.in); 
		System.out.print("Enter the first three characters of a name of an item >> "); 
		item = input.nextLine();
		final String QUIT = "99999";
		
			
			while (!(item.equals(QUIT))) {
			  for (int i = 0; i < avalItems.length; i++) {
				  	
			    //if (item.equals(avalItems[i])) {
				if (avalItems[i].toLowerCase().contains(item.toLowerCase())) {
				  bool = true;
			      pos = i;
			    }
					
			  }
			  
			  if (bool) {
				System.out.println("The price for the " + avalItems[pos] + " is $" + prices[pos]);
				bool = false;
				System.out.print("Enter name of next item or 99999 to quit>> ");
				item = input.nextLine();
			  } else {
				System.out.println("we do not sell this item");
				System.out.print("Enter name of next item or 99999 to quit>> ");
				item = input.nextLine();
			  } 
		   }
	   System.out.println("Bye");
	}
}