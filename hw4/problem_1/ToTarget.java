import java.io.File;
import java.util.*;
import java.util.Arrays;

public class ToTarget {

	public static int[] twoSum( int n, int t, int[] nums ) {
		int[] val = {-1, -1}; //default: index not found

		int mid = t/2;

		HashMap all = new HashMap(n);

		for( int j = 0; j < n; j++ ) {
			all.put(nums[j], j);
		}

		for( int j = 0; j < n; j++ ) {
			if( all.containsKey(t-nums[j]) ) {
				val[0] = j;
				val[1] = (Integer)(all.get(t-nums[j]));
				break;
			}
		}


		return val;
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

	public static void main( String[] args ) {
		LinkedList<String> lines = new LinkedList<String>();

		File file = new File("in1.txt");
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
			int t = Integer.parseInt((((String)lines.get(2*i+1)).split(" "))[1]);
			String[] strNums = ((String)lines.get(2*i+2)).split(" ");
			int[] nums = new int[strNums.length];

			for( int j = 0; j < strNums.length; j++ ) {
				nums[j] = Integer.parseInt(strNums[j]);
			}

			int[] ans = new int[2];
			ans = twoSum(n, t, nums);

			System.out.println(Arrays.toString(ans) + "\n" + i + "~~~~~~~~~~~~~~~~~~~");
		}
	}
}