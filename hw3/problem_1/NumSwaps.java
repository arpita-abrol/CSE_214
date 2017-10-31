import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class NumSwaps {

	public static String makeInorder( int[] arr, int pos ) {
		String str = "";
		int left = pos*2 + 1;
		int right = pos*2 + 2;

		if( left < arr.length ) {
			str += makeInorder(arr, left);
		}
		str += arr[pos] + " ";
		if( right < arr.length ) {
			str += makeInorder(arr, right);
		}
		return str;
	}

	//Selection Sort with counter
	public static int minSwaps( int[] arr ) {
		int ctr = 0;
			for( int i = 0; i < arr.length; i++ ) {
				int minPos = i;
				int minVal = arr[minPos];
				for( int j = i+1; j < arr.length; j++ ) {
					if( arr[j] < minVal ) {
						minPos = j;
						minVal = arr[j];
					}
				}

				if( i != minPos ) {
					int tmp = arr[i];
					arr[i] = arr[minPos];
					arr[minPos] = tmp;
					ctr++;
				}
				
			}
		return ctr;
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
			numTests = Integer.parseInt((String)lines.getFirst().getData());
		}
		catch(Exception e) {
			System.out.println("First line does not contain a number.");
			//e.printStackTrace();
		}

		if( numTests == 0 ) {
			System.out.println("No test cases given");
			return;
		}

		if( 2*numTests != lines.size() -1 ) {
			System.out.println("Number of test cases given does not match number of test cases specified");
			return;
		}

		for( int i = 0; i < numTests; i++ ) { //one iteration of the for loop per test case
			int numNodes = Integer.parseInt((String)(lines.get(2*i+1).getData()));
			String[] nodesTmp = ((String)(lines.get(2*i+2)).getData()).split(" ");
			int[] nodes = new int[numNodes];

			for( int n = 0; n < numNodes; n++ ) 
				nodes[n] = Integer.parseInt(nodesTmp[n]);

			String[] inorderTmp = (makeInorder(nodes, 0).split(" "));
			int[] inorder = new int[numNodes];

			for( int n = 0; n < numNodes; n++ ) 
				inorder[n] = Integer.parseInt(inorderTmp[n]);

			System.out.println("" + minSwaps(inorder));
		}

	} //end main
}