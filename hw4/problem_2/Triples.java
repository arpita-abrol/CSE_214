import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class Triples {


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
			int m = Integer.parseInt((((String)lines.get(2*i+1)).split(" "))[1]);
			String[] strNums = ((String)lines.get(2*i+2)).split(" ");
			int[] nums = new int[strNums.length];

			for( int j = 0; j < strNums.length; j++ ) {
				nums[j] = Integer.parseInt(strNums[j]);
			}

			System.out.println("" + Arrays.toString(nums));

		}
	}

}