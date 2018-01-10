import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;

public class PrisonBreak {

	/*
		0 -- free
		1 -- wall
		2 -- marked
	*/

	public static int pathCounter( int n, int[][] matrixN, int x, int y ) {
		//System.out.println(x + "\t" + y);
		int paths = 0;

		if( x == n-1 && y == n-1 ) {
			//System.out.println("---");
			return 1; //increment-- reached the exit successfully
		}

		//if( x < 0 || y < 0 || x > n-1 || y > n-1 ) {
		//	return 0; //out of bounds
		//}

		//matrixN[x][y] = 2; //mark spot

		if( x+1 < n && matrixN[x+1][y] == 0 ) {
			matrixN[x][y] = 2; //mark spot
			paths += pathCounter(n, matrixN, x+1, y);
			matrixN[x][y] = 0; //reset path-- backtracking
		}
		if( x-1 > -1 && matrixN[x-1][y] == 0 ) {
			matrixN[x][y] = 2; //mark spot
			paths += pathCounter(n, matrixN, x-1, y);
			matrixN[x][y] = 0; //reset path-- backtracking
		}
		if( y+1 < n && matrixN[x][y+1] == 0 ) {
			matrixN[x][y] = 2; //mark spot
			paths += pathCounter(n, matrixN, x, y+1);
			matrixN[x][y] = 0; //reset path-- backtracking
		}
		if( y-1 > -1 && matrixN[x][y-1] == 0 ) {
			matrixN[x][y] = 2; //mark spot
			paths += pathCounter(n, matrixN, x, y-1);
			matrixN[x][y] = 0; //reset path-- backtracking
		}
		
		//matrixN[x][y] = 0; //reset path-- backtracking

		return paths;
	}

	public static void main( String[] args ) {

		LinkedList<String> lines = new LinkedList<String>();

		File file = new File("in1.txt");
		int numTests = 0;
		int numLines = 0;
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

		numLines = lines.size();

		/*one iteration of the for loop per test case-- note that i is incremented
		  during the loop as well 
		*/
		for( int i = 1; i < numLines; i++ ) { 
			int n = Integer.parseInt((((String)lines.get(i)).split(" "))[0]);

			//check for issues with n
			if( n < 1 ) {
				System.out.println("0");
				break;
			}

			//create matrix; make matrix into ints for simplicity
			String[][] matrixS = new String[n][n];
			int[][] matrixN = new int[n][n];
			for( int j = 0; j < n; j++ ) {
				i++;
				matrixS[j] = lines.get(i).split(" ");
			}
			for( int j = 0; j < n; j++ ) {
				for( int k = 0; k < n; k ++ ) {
					matrixN[j][k] = Integer.parseInt(matrixS[j][k]);
				}
			}

			//check if start and end are free
			if( matrixN[0][0] != 0 || matrixN[n-1][n-1] != 0 ) {
				System.out.println("0");
				break;	
			}


			int outputs = pathCounter(n, matrixN, 0, 0);

			System.out.println(outputs);
		}

	} //end main

} //end file