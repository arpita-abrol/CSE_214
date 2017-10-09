import java.io.File;
import java.util.Scanner;

public class TeamSelection {
	private class Player implements Comparable<Player> {
		private int jersey_number;
		private int height;

		public Player( int jersey_number, int height ) {
			this.jersey_number = jersey_number;
			this.height = height;
		}

		@Override
		public int compareTo( Player other ) {
			// this < other --> -
			// this > other --> +
			// this = other --> 0
			return this.height - this.height;
		}

	}
	

	public static void main( String args[] ) {
		LinkedList lines = new LinkedList();

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

		System.out.println(lines);

	}
}