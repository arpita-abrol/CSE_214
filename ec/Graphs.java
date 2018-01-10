import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;

public class Graphs {
	


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

			i++;
			int source = Integer.parseInt((((String)lines.get(i)).split(" "))[0]);
			int destination = Integer.parseInt((((String)lines.get(i)).split(" "))[1]);

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

			Algo test = new Algo( n, matrixN, source, destination );

			System.out.println(n + "\t" + source + "\t" + destination);
		}
	} //end main

} //end class

class Algo {
	private int N;
	private int SOURCE;
	private int DESTINATION;
	private int[][] MATRIX;
	private LinkedList<Integer> PATH = new LinkedList<Integer>();
	private LinkedList<Point> visit = new LinkedList<Point>();
	private LinkedList<Point> left = new LinkedList<Point>();
	private Point[] points;

	private class Point {
		int index;
		int distance;
		Point parent;

		public Point( int index, int distance ) {
			this.index = index;
			this.distance = distance;
		}

	}

	public Algo( int n, int[][] matrixN, int source, int destination ) {
		N = n;
		SOURCE = source;
		DESTINATION = destination;
		MATRIX = new int[n][n];
		for( int i = 0; i < n; i++ ) {
			for( int j = 0; j < n; j++ ) {
				MATRIX[i][j] = matrixN[i][j];
			}
		}
		int distance = 999;
		for( int i = 0; i < N; i++ ) {
			Point tmp = new Point(i, distance);
			//left.add(tmp, distance);
			points[i] = tmp;
		}
		points[source].parent = null;
		left.get(source).distance = 0;
	}

	public void dijkstra() {
		for( int i = 0; i < N-1; i++ ) {
			Point n = findMin();
		}
	}

	//helper--find min val
	public Point findMin() {
		return points[0];
	}


} //end class