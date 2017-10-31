import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

public class TestTree {
	

	public static void main( String[] args ) {
	
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

		int operations = 0;
		//test to make sure there is a first line + valid test case
		try {
			operations = Integer.parseInt((String)lines.getFirst().getData());
		}
		catch(Exception e) {
			System.out.println("First line does not contain a number.");
			//e.printStackTrace();
		}

		if( numTests == 0 ) {
			System.out.println("0 operations given");
			return;
		}

		if( operations != lines.size() -1 ) {
			System.out.println("Number of operations given does not match number of operations specified");
			return;
		}


		234Tree tree = new 234Tree();

		for( int i = 0; i < operations; i++ ) { //one iteration of the for loop per operation
			String[] opTmp = ((String)(lines.get(2*i+2)).getData()).split(" ");
			int[] op = new int[opTmp.length];

			for( int n = 0; n < opTmp.length; n++ ) 
				op[n] = Integer.parseInt(opTmp[n]);

			if( op[0] == 1 )
				tree.insert(op[1]);
			else if( op[0] == 2 )
				tree.delete(op[1]);
			else if( op[0] == 3 )
				tree.search(op[1]);
			else if( op[0] == 4 ) 
				tree.inorder();
			else if( op[0] == 5 )
				tree.preorder();
			else if( op[0] == 6 )
				tree.postorder();
			else
				System.out.println("Operation not identified");


		}

	} //end main
}