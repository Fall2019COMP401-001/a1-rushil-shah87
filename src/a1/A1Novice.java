package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		// Your code follows here.
		
		Scanner scan = new Scanner(System.in);
		int num_customers = scan.nextInt();
		
		// initializing variables for reuse
		String fname = "";
		String lname = "";
		int num_items = 0;
		int quant = 0;
		double price = 0.00;
		double total_cost = 0.00;
		String item = "";
		
		// this loop will run once for each customer
		for (int i=0; i<num_customers; i++) {
			total_cost = 0.00;
			fname = scan.next();
			lname = scan.next();
			num_items = scan.nextInt();
			
			// this loop will run once for each item the customer purchased
			for (int j=0; j<num_items; j++) {
				quant = scan.nextInt();
				item = scan.next();
				price = scan.nextDouble();
				total_cost += (quant*price);
			}
			
			// print customer totals
			System.out.println(fname.charAt(0)+". "+lname+": "+String.format("%.2f",total_cost));
		}
	}
}
