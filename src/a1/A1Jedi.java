package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		// Your code follows here.
		
		Scanner scan = new Scanner(System.in);
		int num_items = scan.nextInt();
		
		// initializing arrays for inventory
		String[] item_names = new String[num_items];
		int[] item_total = new int[num_items];
		int[] cust_total = new int[num_items];
		double skip;
		
		// fill out arrays with items and prices
		for (int i=0; i<num_items; i++) {
			item_names[i] = scan.next();
			skip = scan.nextDouble();
			item_total[i] = 0;
			cust_total[i] = 0;
		}
		
		int num_customers = scan.nextInt();
		
		// initializing arrays for customer names and total costs
		String[] names = new String[num_customers];
		
		
		// initializing variables for reuse
		String fname;
		String lname;
		int cart_size;
		String item_name;
		int item_quant;
		
		// this loop runs per customer
		for (int a=0; a<num_customers; a++) {
			fname = scan.next();
			lname = scan.next();
			names[a] = fname + " " + lname;
			cart_size = scan.nextInt();
			
			// this loop runs per item in the customer's cart
			for (int b=0; b<cart_size; b++) {
				item_quant = scan.nextInt();
				item_name = scan.next();
				
				
				// this loop runs to obtain the price of each item 
				for (int c=0; c<num_items; c++) {
					if(item_name.equals(item_names[c])) {
						item_total[c] += item_quant;
						cust_total[c] += 1;
						c = num_items+1;
					}
				}
			}
		}
		for (int f=0; f<num_items; f++) {
			if(item_total[f] == 0) {
				System.out.println("No customers bought "+item_names[f]);
			} else {
				System.out.println(cust_total[f] +" customers bought "+ item_total[f] +" "+ item_names[f]);
			}
		}
	}
}
