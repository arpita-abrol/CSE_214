/*
    Arpita Abrol
    ID: 111504563
    CSE 214
    Shebuti Rayana
    Homework #1
*/

public class hw1_1 {
	
	/*
	** Problem 1a
	*/
	public static void hasPair( int[] arr, int sum ) {				// 
		int test = 0;												// 1
		for(int i=0; i<arr.length; i++ ) {							// n+1
			for(int j=i+1; j<arr.length; j++ ) {					// (n(n+1))/2
				if( arr[i] + arr[j] == sum ) {						// n
					System.out.println("Output: " + arr[i] + " + " 	// 3
						+ arr[j] + " = " + sum + " , true");		// 
					return;											// 
				}													// 
			}														// 
		}															// 
		System.out.println("Output: false");						// 1
	}

	/*
	** Problem 1b
	*/
	public static void hasTriplet( int[] arr, int sum ) {			// 
		int test = 0;												// 1
		for(int i=0; i<arr.length; i++ ) {							// n+1
			for(int j=i+1; j<arr.length; j++ ) {					// (n(n+1))/2
				for( int k=j+1; k<arr.length; k++ ) {				// (n(n+1)(n+2))/6
					if( arr[i] + arr[j] + arr[k] == sum ) {			// n
						System.out.println("Output: " + arr[i] +	// 4
						 " + " + arr[j] + " + " + arr[k] + 			// 
						 " = " + sum + " , true");					// 
						return;										// 
					}												// 
				}													// 
			}														// 
		}															// 
		System.out.println("Output: false");						// 1
	}

	
	/*
	 * Problem 1c
	 *
	for( int i = 0; i < n; i++ ) {				// n+1
		for( int j = 0; j < n; j++ ) {			// (n(n+1))/2
			double sum = 0;						// (n(n+1))/2
			for( int k = 0; k < n; k++ ) {		// (n(n+1)(n+2))/6
				sum += a[i][k] * b[k][j];		// (n(n+1)(n+2))/6
			}									// 
			c[i][j] = sum;						// (n(n+1))/2
		}
	}
	*/



	public static void main( String[] args ) {

		//PROBLEM 1A-----------------------
		System.out.println("Testing: Problem 1a");

		//Test #1 for 1a
		System.out.println("Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16");
		int arr[] = {11, 15, 6, 8, 9, 10};
		int sum = 16;
		hasPair(arr, sum);

		//Test #2 for 1a
		System.out.println("\nInput: arr[] = {11, 15, 6, 8, 9, 10}, x = 27");
		int arr2[] = {11, 15, 6, 8, 9, 10};
		int sum2 = 27;
		hasPair(arr2, sum2);


		//PROBLEM 1B-----------------------
		System.out.println("Testing: Problem 1b");

		//Test #1 for 1b
		System.out.println("\nInput: arr[] = {11, 15, 6, 8, 9, 10}, x = 25");
		int arr3[] = {11, 15, 6, 8, 9, 10};
		int sum3 = 25;
		hasTriplet(arr3, sum3);

		//Test #2 for 1b
		System.out.println("\nInput: arr[] = {11, 15, 6, 8, 9, 10}, x = 39");
		int arr4[] = {11, 15, 6, 8, 9, 10};
		int sum4 = 39;
		hasTriplet(arr4, sum4);

	}
}