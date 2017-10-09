import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class TeamSelection {
	private static class Player implements Comparable<Player> {
		private int jersey_number;
		private int height;

		public Player( int jersey_number, int height ) {
			this.jersey_number = jersey_number;
			this.height = height;
		}

		public int getJersey_Number() {
			return jersey_number;
		}

		public int getHeight() {
			return height;
		}

		@Override
		public int compareTo( Player other ) {
			// this < other --> -
			// this > other --> +
			// this = other --> 0
			return this.height - other.height;
		}

		@Override
		public String toString() {
			return jersey_number + "";
		}

	}

	// ~~~~~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~
	
	

	public static void main( String args[] ) {
		LinkedList<String> lines = new LinkedList<String>();

		File file = new File("in2.txt");
		try {
			Scanner input = new Scanner(file);

			while( input.hasNextLine() )
				lines.add(input.nextLine());
			input.close();

		}
		catch(Exception e) {
			e.printStackTrace();
		}

		int numTests = Integer.parseInt((String)lines.getFirst().getData());
		if( numTests == 0 ) {
			System.out.println("No test cases given");
		}

		

		for( int i = 0; i < numTests; i++ ) { //one iteration of the for loop per test case
			LinkedList<Player> players = new LinkedList<Player>();
			String[] jerseyNumbers = ((String)(lines.get(2*i+1)).getData()).split(" ");
			String[] heights = ((String)(lines.get(2*i+2)).getData()).split(" ");
			for( int j = 0; j < jerseyNumbers.length; j++ ) {
				Player p = new Player(Integer.parseInt(jerseyNumbers[j]), 
					               Integer.parseInt(heights[j]));
				players.add(p);
			}
			for( int k = 0; k < players.size() - 1; k++ ) {
				if( ( (Player)(players.get(k).getData()) ).compareTo( (Player)(players.get(k+1).getData()) ) < 0) {
					players.remove(k);
					k -= 2;
				}
			}
			System.out.println(players);
			
		}

	}
}