import java.io.File;
import java.util.Scanner;
import java.util.*;

public class FriendList {
	private static class Friend implements Comparable<Friend>{
		String name;
		int mutualFriends;
		int initial;

		public Friend( String name, int mutualFriends, int initial ) {
			this.name = name;
			this.mutualFriends = mutualFriends;
			this.initial = initial;
		}

		public String getName() { return name; }
		public int getMutualFriends() { return mutualFriends; }
		public int getInitial() { return initial; }

		@Override
		public String toString() {
			return name;
		}

		@Override
		public int compareTo( Friend other ) {
			// this < other --> -
			// this > other --> +
			// this = other --> 0
			if( this.getMutualFriends() - other.getMutualFriends() == 0 )
				return this.getInitial() - other.getInitial();
			else
				return this.getMutualFriends() - other.getMutualFriends();
		}
	}

	/*private static class Bucket {
		int min, max, size;
		public LinkedList<Friend> friends;

		public Bucket( int min, int max ) {
			this.min = min;
			this.max = max;
			friends = new LinkedList<Friend>();
		}

		public boolean checkRange( int num ) {
			if( num >= min && num <= max )
				return true;
			else
				return false;
		}

		@Override
		public String toString() {
			String str = "";
			str += min + "\t" + max + "\n";
			str += friends + "\n";
			return str;
		}

	}*/

	public static Friend[] sortFriends( Friend[] arr ) {
		for( int i = 1; i < arr.length; i++ ) {
			for( int j = i; j > 0; j-- ) {
				if( arr[j].compareTo(arr[j-1]) < 0 ) {
					Friend tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}

	public static Friend[] sortFriendsInput( Friend[] arr ) {
		for( int i = 1; i < arr.length; i++ ) {
			for( int j = i; j > 0; j-- ) {
				if( arr[j].getInitial() < arr[j-1].getInitial() ) {
					Friend tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}

	public static int josephus( int total, int keep ) {
		if( total == 1)
			return total;
		else {
			return ((josephus(total-1, keep) + keep-1 ) % total) + 1;
		}
	}

	public static void printFriends( Friend[] arr ) {
		for( Friend f : arr ) {
			if( f.getInitial() != -1 ) {
				System.out.print(f + " ");
			}
		}
		System.out.print("\n");
	}
	

	// ~~~~~~~~~~~~~~~~~~~~ MAIN METHOD ~~~~~~~~~~~~~~~~~~~~
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

		if( 3*numTests != lines.size() -1 ) {
			System.out.println("Number of test cases given does not match number of test cases specified");
			return;
		}


		// ~~~~~~~~~~~~~~~~~~~~ TESTING LOOP ~~~~~~~~~~~~~~~~~~~~
		for( int i = 0; i < numTests; i++ ) { //one iteration of the for loop per test case
			//LinkedList<Bucket> buckets = new LinkedList<Bucket>();
			// Get data from lines in file, convert as needed
			String[] numMutualTmp = ((String)(lines.get(3*i+3)).getData()).split(" ");

			int num_new = Integer.parseInt(((String)(lines.get(3*i+1)).getData()).split(" ")[0]);
			int num_keep = Integer.parseInt(((String)(lines.get(3*i+1)).getData()).split(" ")[1]);
			String[] names = ((String)(lines.get(3*i+2)).getData()).split(" ");
			int[] numMutual = new int[numMutualTmp.length];
			Friend[] keep = new Friend[num_keep];

			for( int n = 0; n < numMutualTmp.length; n++ ) 
				numMutual[n] = Integer.parseInt(numMutualTmp[n]);

			// Create buckets
			int minMF = numMutual[0];
			int maxMF = numMutual[0];
			for( int num : numMutual ) {
				if( num < minMF )
					minMF = num;
				if( num > maxMF )
					maxMF = num;
			}
			int range = Math.round((maxMF - minMF + 1)/num_keep);
			System.out.println("" + range);
			/*for( int j = 0; j < num_keep; j++ ) {
				if( j == num_keep-1 ) {
					Bucket tmp = new Bucket(minMF+j*range, maxMF);
					buckets.add(tmp);
				}
				else{
					Bucket tmp = new Bucket(minMF+j*range, minMF+(j+1)*range-1);
					buckets.add(tmp);
				}
			}*/

			// Add friends to array; sort them
			Friend[] friendArray = new Friend[num_new];
			for( int k = 0; k < num_new; k++ ) {
				Friend f = new Friend(names[k], numMutual[k], k);
				friendArray[k] = f;
			}
			//System.out.println(Arrays.toString(friendArray));
			friendArray = sortFriends(friendArray);
			//System.out.println(Arrays.toString(friendArray));

			//bucketize and remove
			for( int x = 0; x < num_keep; x++ ) {
				LinkedList<Friend> bucketF = new LinkedList<Friend>();
				for( int y = 0; y < num_new; y++ ) {
					if( x == num_keep-1 ) {
						if( friendArray[y].getMutualFriends() >= minMF+x*range && friendArray[y].getMutualFriends() <= maxMF ) {
							bucketF.add(friendArray[y]);
						}					
					}
					else {
						if( friendArray[y].getMutualFriends() >= minMF+x*range && friendArray[y].getMutualFriends() <= minMF+(x+1)*range-1 ) {
							bucketF.add(friendArray[y]);
						}
					}
				}
				if( bucketF.size() == 0 ) {
					Friend tmpF = new Friend("null", -1, -1);
					keep[x] = tmpF;
				}
				else if( bucketF.size() == 1 ) {
					keep[x] = ((Friend)(bucketF.getFirst().getData()));
				}
				else {
					int safe = josephus(bucketF.size(), num_keep);
					keep[x] = ((Friend)(bucketF.get(safe-1).getData()));
				}
			}
			//resort friends based on init positions
			keep = sortFriendsInput(keep);

			printFriends(keep);

			// Add friends to buckets
			/*for( int k = 0; k < num_new; k++ ) {
				Friend f = friendArray[k];
				for( int b = 0; b < buckets.size(); b++ ) {
					if( ( (Bucket)(buckets.get(b).getData()) ).checkRange(f.getMutualFriends()) )
						( (Bucket)(buckets.get(b).getData()) ).friends.add(f);
				}
			}

			// Remove from buckets
			*/


		} //end testing loop

		//System.out.println(lines);
	} //end main
}