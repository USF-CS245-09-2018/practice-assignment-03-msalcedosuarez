import java.util.Random;


public class Practice03Test {

	protected int count = 0;
	protected double [] arr;


	/**
	 * Constructor
	 */
	public Practice03Test (String [] args) {
		try {
			count = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Defaulting array size to 20.");
			count = 20;
		}
		arr = new double[count];
		generate_array();
	}


	/**
	 * print_array: prints the array of doubles... formatted so it fits
	 * ... on many small screens.
	 */
	public void print_array() {
		System.out.println("------------------------------------");
		System.out.println("Array contains the values:");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%.2f ", arr[i]);
			if (i > 0 && i % 9 == 0)
				System.out.println();
		}
		System.out.println("\n------------------------------------");
	}


	/**
	 * Fills the array with random double instances.
	 */
	public void generate_array() {
		Random rand = new Random();
		double min = 1.0;
		double max = 100.0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = min + rand.nextDouble() * (max-min);
		}
	}


	public int find_min_iterative () {
		int min = 0; //constant running time so O(1)
		for(int i = 1; i < arr.length; i++){ //constant running time so O(1)
			if(arr[i] < arr[min]){ //constant running time, but runs n time so O(n)
				min = i; // constant so 0(1)
			}
		}
		return min; //constant so O(1)
	}
	//O(1+1+n+1+1) ---Answer = O(n)


	public int find_min_recursive () {
		return find_min_recrusive(0, 0);
	}

	//helper method for find_min_recursive()
	public int find_min_recrusive(int current, int minindex){

		if(current == arr.length){ //constant running time, but runs n times so O(n)
			return minindex;//constant so O(1)
		}	
		if(arr[current] < arr[minindex]){ //constant run time O(1)
			return find_min_recrusive(current+1, current); //calling function log
		}
		else{
			return find_min_recrusive(current+1, minindex); //calling function log
		}		
	}
	//O(n+1+1+log+log)----Answer = O(log2n)


	/**
	 * print_min: determines the min iteratively and recursively.
	 * ... and prints them both.
	 */
	public void print_min() {
		System.out.println("Iteratively determined min at index " + find_min_iterative());
		System.out.println("Recursively determined min at index " + find_min_recursive());
	}


	/**
	 * main for Practice 03: print the array and determine the min.
	 */
	public static void main(String [] args) {
		Practice03Test test = new Practice03Test(args);
		test.print_array();
		test.print_min();
	}

}
