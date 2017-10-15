import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class WhiteWalker {

	private static class Walker implements Comparable<Walker> {
		private int pos;
		private int power;

		public Walker( int pos, int power ) {
			this.pos = pos;
			this.power = power;
		}

		public int getPos() { return pos; }
		public int getPower() { return power; }

		public void reduce() {
			if( power != 0 )
				power--;
		}

		@Override
		public int compareTo( Walker other ) {
			if( this.getPower() > other.getPower() )
				return 1; // keep this
			else if( this.getPower() < other.getPower() )
				return -1; // keep other
			else if( this.getPos() > other.getPos() )
				return -1; // keep other
			else
				return 1; // keep this
		}

		@Override
		public String toString() {
			return pos + "";
		}

	}
	
	public static void main( String args[] ) {

		LinkedList<String> lines = new LinkedList<String>();

		File file = new File("in4.txt");
		// test to see if file is in folder
		try {
			Scanner input = new Scanner(file);

			while( input.hasNextLine() )
				lines.add(input.nextLine());
			input.close();

		}
		catch(Exception e) {
			System.out.println("File not found. Please add in4.txt");
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

		// ~~~~~~~~~~~~~~~~~~~~ TESTING LOOP ~~~~~~~~~~~~~~~~~~~~
		for( int i = 0; i < numTests; i++ ) { //one iteration of the for loop per test case
			//LinkedList<Player> players = new LinkedList<Player>();
			int num_N = Integer.parseInt(((String)(lines.get(2*i+1)).getData()).split(" ")[0]);
			int num_M = Integer.parseInt(((String)(lines.get(2*i+1)).getData()).split(" ")[1]);
			String[] power = ((String)(lines.get(2*i+2)).getData()).split(" ");

			Queue<Walker> walkers = new Queue<Walker>();
			for( int j = 0; j < power.length; j++ ) {
				Walker w = new Walker(j, Integer.parseInt(power[j]));
				walkers.enqueue(w);
			}

			for( int m = 0; m < num_M; m++ ) {
				Queue<Walker> walker_tmp = new Queue<Walker>();
				int power_H = -1;
				int pos_L = -1;
				// for loop to get highest power/pos
				for( int x = 0; x < num_M && !walkers.isEmpty(); x++ ) {
					Walker tmp = (Walker)walkers.dequeue();
					if( tmp.getPower() > power_H ) {
						power_H = tmp.getPower();
						pos_L = tmp.getPos();
					}
					else if( tmp.getPower() == power_H ) {
						if( tmp.getPos() < pos_L )
							pos_L = tmp.getPos();
					}
					walker_tmp.enqueue(tmp);
				}
				// while loop to re-queue
				while( !walker_tmp.isEmpty() ) {
					Walker tmp = (Walker)walker_tmp.dequeue();
					if( power_H == tmp.getPower() && pos_L == tmp.getPos() )
						System.out.print(pos_L + " ");
					else {
						tmp.reduce();
						walkers.enqueue(tmp);
					}
				}

			}
			System.out.print("\n");


			//System.out.println(walkers);
		}

		//System.out.println(lines);

	} //end main
}