import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class ConcertMoney {
	

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
			System.out.println("File not found. Please add in2.txt");
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
			int numRows = Integer.parseInt(((String)(lines.get(2*i+1).getData())).split(" ")[0]);
			int numFans = Integer.parseInt(((String)(lines.get(2*i+1).getData())).split(" ")[1]);
			String[] rowsTmp = ((String)(lines.get(2*i+2)).getData()).split(" ");
			int[] rows = new int[numRows];

			for( int n = 0; n < numRows; n++ ) 
				rows[n] = Integer.parseInt(rowsTmp[n]);

			maxHeap heap = new maxHeap(numRows);
			for( int n = 0; n < numRows; n++ ) {
				heap.insert(rows[n]);
			}

			int money = 0;

			while( numFans > 0 ) {
				int tmp = heap.deleteMax();
				heap.insert(tmp-1);
				money += tmp;
				numFans--;
			}

			System.out.println(money);
		}

	} //end main
}