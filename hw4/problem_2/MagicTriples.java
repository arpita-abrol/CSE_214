import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Hashtable;

public class MagicTriples {

	private static class Triple {
		int num1, num2, num3;

		public Triple( int num1, int num2, int num3 ) {
			this.num1 = num1;
			this.num2 = num2;
			this.num3 = num3;
		}

		public int getVal() {
			return num1 + num2;
		}

		public String toString() {
			return "[" + num1 + "," + num2 + "," + num3 + "]";
		}

		public boolean equals( Object object ) {
			Triple t = (Triple)(object);
			if( this.num1 == t.num1 && this.num2 == t.num2 && this.num3 == t.num3 )
				return true;
			return false;
		}

		public int hashCode() {
			return num1 + num2;
		}
	}

	private static class Double {
		int num1, num2;

		public Double( int num1, int num2 ) {
			this.num1 = num1;
			this.num2 = num2;
		}

		public int getVal() {
			return num1 + num2;
		}

		public String toString() {
			return "[" + num1 + "," + num2 + "]";
		}

		public boolean equals( Object object ) {
			Double t = (Double)(object);
			if( this.num1 == t.num1 && this.num2 == t.num2  )
				return true;
			return false;
		}

		public int hashCode() {
			return num1 + num2;
		}
	}

	public static int numTriples( int n, int m, int[] nums ) {
		int ctr = 0;

		Hashtable<Integer, LinkedList<Double>> two = new Hashtable<Integer, LinkedList<Double>>();
		Hashtable<Triple, Integer> three = new Hashtable<Triple, Integer>();

		for( int i = 0; i < n-1; i++ ) {
			for( int j = i+1; j < n; j++ ) {
				int key = ( nums[i] + nums[j] ) % m;

				Double pair = new Double(i, j);
				LinkedList<Double> l = two.getOrDefault(key, new LinkedList<Double>());
				l.add(pair);
				two.put(key, l);
			}
		}

		for( int i = 0; i < n; i++ ) {
			int key2 = (m - (nums[i] % m)) % m;

			if( two.containsKey(key2) ) {
				LinkedList<Double> l = two.get(key2);
				for( Double x : l ) {
					if( x.num1 != i && x.num2 != i ) {
						int[] all = { x.num1, x.num2, i };
						Arrays.sort(all);
						Triple t = new Triple(all[0], all[1], all[2]);

						if( !(three.containsKey(t)) ) {
							three.put(t, 0);
							System.out.println(Arrays.toString(all));
							ctr++;
						}
					}
				}
			}
		}


		return ctr;
	}

	public static int indexOf( int[] arr, int num ) {
		for( int i = 0; i < arr.length; i++ ) {
			if( arr[i] == num ) {
				return i;
			}
		}
		return -1;
	}

	public static int[] indexOfDouble( int[] arr, int num ) {
		int[] val = {-1, -1};
		for( int i = 0; i < arr.length; i++ ) {
			if( arr[i] == num ) {
				val[0] = i;
				break;
			}
		}
		for( int i = val[0]+1; i < arr.length; i++ ) {
			if( arr[i] == num ) {
				val[1] = i;
				break;
			}
		}
		return val;
	}

	public static int[] indexOfTriple( int[] arr, int num ) {
		int[] val = {-1, -1, -1};
		for( int i = 0; i < arr.length; i++ ) {
			if( arr[i] == num ) {
				val[0] = i;
				break;
			}
		}
		for( int i = val[0]+1; i < arr.length; i++ ) {
			if( arr[i] == num ) {
				val[1] = i;
				break;
			}
		}
		for( int i = val[1]+1; i < arr.length; i++ ) {
			if( arr[i] == num ) {
				val[2] = i;
				break;
			}
		}
		return val;
	}


	public static void main( String[] args ) {
		LinkedList<String> lines = new LinkedList<String>();

		File file = new File("in2.txt");
		// test to see if file is in folder
		try {
			Scanner input = new Scanner(file);

			while( input.hasNextLine() )
				lines.add(input.nextLine());
			input.close();

		}
		catch(Exception e) {
			System.out.println("File not found. Please add in1.txt");
			//e.printStackTrace();
			return;
		}

		int numTests = 0;
		//test to make sure there is a first line + valid test case
		try {
			numTests = Integer.parseInt((String)lines.getFirst());
		}
		catch(Exception e) {
			System.out.println("First line does not contain a number.");
			//e.printStackTrace();
		}

		if( numTests == 0 ) {
			System.out.println("No test cases given");
			return;
		}

		if( 2*numTests != lines.size() - 1 ) {
			System.out.println("Number of test cases given does not match number of test cases specified");
			return;
		}

		for( int i = 0; i < numTests; i++ ) { //one iteration of the for loop per test case

			int n = Integer.parseInt((((String)lines.get(2*i+1)).split(" "))[0]);
			int m = Integer.parseInt((((String)lines.get(2*i+1)).split(" "))[1]);
			String[] strNums = ((String)lines.get(2*i+2)).split(" ");
			int[] nums = new int[strNums.length];

			for( int j = 0; j < strNums.length; j++ ) {
				nums[j] = Integer.parseInt(strNums[j]);
			}

			//Arrays.sort(nums);

			int numTrip = numTriples(n, m, nums);

			System.out.println("" + Arrays.toString(nums) + "\n" + numTrip);

		}
	}

}