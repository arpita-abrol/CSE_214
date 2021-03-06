import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;

public class Triples {

	public static int numTriples( int n, int m, int[] nums ) {
		int ctr = 0;

		HashMap all = new HashMap(n);

		int max = findMax(nums);

		for( int i = 0; i < n; i++ ) {
			all.put(i, nums[i]);
		}

		for( int i = 0; i < n; i++ ) {
			for( int j = i+1; j < n; j++ ) {
				int key = ( nums[i] + nums[j] ) % m;

				if( nums[i] == key && nums[j] == key ) {
					int tmp1 = indexOfDouble(nums, key)[0];
					int tmp2 = indexOfDouble(nums, key)[1];
					all.remove(tmp1);
					all.remove(tmp2);
					int tmp = key;
					while( tmp <= max ) {
						if( all.containsValue(tmp) ) {
							if( indexOfTriple(nums, tmp)[2] > j ) {
								ctr++;
								System.out.println(i + "\t" + j + "\t" + indexOfTriple(nums, tmp)[2]);
							}
						}
						tmp += m;
					}
					all.put(tmp1, key);
					all.put(tmp2, key);
				}

				else if( nums[i] == key || nums[j] == key ) {
					int tmp1 = indexOf(nums, key);
					all.remove(tmp1);
					int tmp = key;
					while( tmp <= max ) {
						if( all.containsValue(tmp) ) {
							if( indexOfDouble(nums, tmp)[1] > j ){
								ctr++;
								System.out.println(i + "\t" + j + "\t" + indexOfDouble(nums, tmp)[1]);
							}
						}
						tmp += m;
					}
					all.put(tmp1, key);
				}

				else {
					int tmp = key;
					while( tmp <= max ) {
						if( all.containsValue(tmp) ) {
							if( indexOf(nums, tmp) > j ){
								ctr++;
								System.out.println(i + "\t" + j + "\t" + indexOf(nums, tmp));
							}
						}
						tmp += m;
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

	public static int findMax( int[] arr ) {
		int max = arr[0];
		for( int x : arr ) {
			if( x > max )
				max = x;
		}
		return max;
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