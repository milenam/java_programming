import java.util.Scanner;

public class EightInts {
	private static Scanner input;

	public static void main(String[] args) {
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
		
		double[] scores = new double[4]; 
		double number = 0;
		int count = 0;
		double total = 0;
		final int QUIT = 99999;
		final int MAX = 4;
		Scanner input = new Scanner(System.in); 
		System.out.print("Enter number >> "); 
		number = input.nextInt();
		while(count < MAX && number != QUIT){
		  if(number != QUIT) {
		  scores[count] = number;
		  total += scores[count]; 
		  System.out.print("Enter next number " +
		               QUIT + " to quit >> ");
		  number = input.nextInt();
		  }
		  count++; 
		  }
		System.out.println("The numbers entered were:");
		for(int x = 0; x < count; ++x) 
			System.out.print(scores[x] + " ");
		System.out.println("\n The average is " + (total * 1.0 / count)); 
		
	}
}