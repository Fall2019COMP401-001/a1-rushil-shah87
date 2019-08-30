package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		// Your code follows here.
		
		Scanner scan = new Scanner(System.in);
		int num_items = scan.nextInt();
		
		// initializing arrays for inventory
		String[] item_names = new String[num_items];
		double[] item_prices = new double[num_items];
		
		// fill out arrays with items and prices
		for (int i=0; i<num_items; i++) {
			item_names[i] = scan.next();
			item_prices[i] = scan.nextDouble();
		}
		
		int num_customers = scan.nextInt();
		
		// initializing arrays for customer names and total costs
		String[] names = new String[num_customers];
		double[] total_costs = new double[num_customers];
		
		
		// initializing variables for reuse
		String fname;
		String lname;
		int cart_size;
		double total_cost;
		String item_name;
		int item_quant;
		
		// this loop runs per customer
		for (int a=0; a<num_customers; a++) {
			fname = scan.next();
			lname = scan.next();
			names[a] = fname + " " + lname;
			cart_size = scan.nextInt();
			total_cost = 0.00;
			
			// this loop runs per item in the customer's cart
			for (int b=0; b<cart_size; b++) {
				item_quant = scan.nextInt();
				item_name = scan.next();
				
				// this loop runs to obtain the price of each item 
				for (int c=0; c<num_items; c++) {
					if(item_name.equals(item_names[c])) {
						total_cost += (item_quant*item_prices[c]);
						c = num_items+1;
					}
				}
			}
			total_costs[a] = total_cost;
		}
				
		// calculate and print max cost
		double max_cost = findValueMax(total_costs);
		String max_spender = "";
		for (int f=0; f<num_customers; f++) {
			if(max_cost == (total_costs[f])) {
				max_spender = names[f];
				
			}
		}
		System.out.println("Biggest: "+max_spender+" ("+String.format("%.2f",max_cost)+")");
		
		// calculate and print min cost
		double min_cost = findValueMin(total_costs);
		String min_spender = "";
		for (int g=0; g<num_customers; g++) {
			if(min_cost == total_costs[g]) {
				min_spender = names[g];
			}
		}
		System.out.println("Smallest: "+min_spender+" ("+String.format("%.2f",min_cost)+")");
		
		// calculate average
		double average_cost = (calculateValueSum(total_costs)/num_customers);
		System.out.println("Average: "+String.format("%.2f",average_cost));		
	}
	
	/* calculateValueSum doubles
	 * Calculates the sum on an array of integers
	 * Input: array of double vals
	 * Output: double sum of values in vals
	 * Preconditions:
	 * Input array must not be null.
	 */
	static double calculateValueSum(double[] vals) {
		
		double sum = 0.0;
		
		for (int i=0; i<vals.length; i++) {
			sum += vals[i];
		}
		return sum;
	}
	
	/* findValueMin
	 * Finds and returns the minimum value in an array of integers
	 * Input: array of integers vals
	 * Output: minimum value found within the array
	 * Preconditions:
	 * Input array must not be null and must contain at least one value.
	 */
	static double findValueMin(double[] vals) {
		
		// Initialize current minimum to first value in array.
		double cur_min = vals[0];
		
		// Starting with second value (if any), compare each value
		// in array with current minimum and replace if smaller.
		
		for (int i=1; i < vals.length; i++) {
			if (vals[i] < cur_min) {
				cur_min = vals[i];
			}
		}
		
		return cur_min;
	}

	/* findValueMax
	 * Finds and returns the maximum value in an array of integers
	 * Input: array of integers vals
	 * Output: maximum value found within the array
	 * Preconditions:
	 * Input array must not be null and must contain at least one value.
	 */
	static double findValueMax(double[] vals) {
		
		// Initialize current minimum to first value in array.
		double cur_max = vals[0];
		
		// Starting with second value (if any), compare each value
		// in array with current minimum and replace if smaller.
		
		for (int i=1; i < vals.length; i++) {
			if (vals[i] > cur_max) {
				cur_max = vals[i];
			}
		}
		
		return cur_max;
	}
}
