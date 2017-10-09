import java.io.File;
import java.util.Scanner;

public class LeakyStack {
	
	public static void main( String args[] ) {
		LinkedList<String> lines = new LinkedList<String>();

		File file = new File("in3.txt");
		// test to see if file is in folder
		try {
			Scanner input = new Scanner(file);

			while( input.hasNextLine() )
				lines.add(input.nextLine());
			input.close();

		}
		catch(Exception e) {
			System.out.println("File not found. Please add in3.txt");
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
			int size = Integer.parseInt((String)(lines.get(2*i+1).getData()));
			String[] operations = ((String)(lines.get(2*i+2)).getData()).split(" ");

			Stack leaky = new Stack(size);
			for( int j = 0; j < operations.length; j++ ) {
				leaky.push(operations[j]);
				//System.out.println(leaky);
			}

			System.out.println(leaky);
		}

	}
}