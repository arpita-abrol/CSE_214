//package hw.cse214.cards;

// sort cards S > H > D > C
// sort cards A K Q J 10 9 8 7 6 5 4 3 2

public class Card {
	private String card;

	//constructor
	public Card( String card ) {
		this.card = card;
	}

	//accessor
	public String getCard() { return card; }

	@Override
	public String toString() {
		return card;
	}

	//helper methods
	// getSuit() returns the value of the suit in numeric form. S -> high, C -> low
	public int getSuit() {
		int suit = card.charAt(0);
		//System.out.println(card + "\t[" + suit + "]");
		if( suit == "C".charAt(0) ) { return 0; }
		if( suit == "D".charAt(0) ) { return 1; }
		if( suit == "H".charAt(0) ) { return 2; }
		return 3;
	}

	// getValue() returns the value of the card in numeric form. A - > high, 2 -> low
	public int getValue() {
		int value = card.charAt(1);
		if( value == "A".charAt(0) ) { return 13; } 
		if( value == "K".charAt(0) ) { return 12; }
		if( value == "Q".charAt(0) ) { return 11; }
		if( value == "J".charAt(0) ) { return 10; }
		return Integer.parseInt(card.substring(1));
	}

}