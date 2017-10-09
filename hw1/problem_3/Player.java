//package hw.cse214.cards;

// sort cards S > H > D > C
// sort cards A K Q J 10 9 8 7 6 5 4 3 2

public class Player {
	private Card[] cards = new Card[13];
	private int id;

	// constructor
	public Player( int id ) {
		this.id = id;
	}

	// action methods
	public void setCards( Card[] cards ) {
		for( int i = 0; i < cards.length; i++ ) {
			this.cards[i] = cards[i];
		}
	}

	public void printCards() {
		for( int i = 0; i < cards.length; i++ ) {
			System.out.print(cards[i] + " ");
		}
		System.out.print("\n");
	}

	public void sortCards() {
		// STEP 1: Sort by suit
		Card key = cards[0];
		Card curr = cards[0];
		for( int i = 0; i < cards.length; i++ ) {
			for( int j = i+1; j < cards.length; j++ ) {
				//System.out.println(curr + "\t" + curr.getSuit() + "\t" + key + "\t" + key.getSuit());
				key = cards[i];
				curr = cards[j];
				if( key.getSuit() < curr.getSuit() ) {
					//System.out.println(curr.getSuit() + "\t" + key.getSuit());
					cards[i] = curr;
					cards[j] = key;
					//break;
				}
				//printCards();
			}
		}
		// STEP 2: Sort by Value
		for( int i = 0; i < cards.length; i++ ) {
			for( int j = i+1; j < cards.length; j++ ) {
				//System.out.println(curr + "\t" + curr.getSuit() + "\t" + key + "\t" + key.getSuit());
				key = cards[i];
				curr = cards[j];
				if( key.getSuit() == curr.getSuit() && key.getValue() < curr.getValue() ) {
					//System.out.println(curr.getSuit() + "\t" + key.getSuit());
					cards[i] = curr;
					cards[j] = key;
				}
				//printCards();
			}
		}
	}


}