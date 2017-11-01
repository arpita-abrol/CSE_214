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

		if( operations != lines.size() -1 ) {
			System.out.println("Number of operations given does not match number of operations specified");
			return;
		}


		Tree234 tree = new Tree234();

		for( int i = 0; i < operations; i++ ) { //one iteration of the for loop per operation
			//System.out.println("" + i);

			String[] opTmp = ((String)(lines.get(i+1)).getData()).split(" ");
			int[] op = new int[opTmp.length];

			for( int n = 0; n < opTmp.length; n++ ) 
				op[n] = Integer.parseInt(opTmp[n]);

			if( op[0] == 1 )
				tree.insert(op[1]);
			else if( op[0] == 2 ) {
				if( tree.delete(op[1]) )
					System.out.println("successful");
				else
					System.out.println("failed");
			}
			else if( op[0] == 3 ) {
				if( tree.search(tree.getRoot(), op[1]) )
					System.out.println("successful");
				else
					System.out.println("successful");
			}
			else if( op[0] == 4 ) 
				System.out.println(tree.inorder(tree.getRoot()));
			else if( op[0] == 5 )
				System.out.println(tree.preorder(tree.getRoot()));
			else if( op[0] == 6 )
				System.out.println(tree.postorder(tree.getRoot()));
			else
				System.out.println("Operation not identified");


		}

	} //end main
}