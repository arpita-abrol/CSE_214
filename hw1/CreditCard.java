import java.util.Calendar; //Added for 2C

public class CreditCard {
	private String creditCardNumber;
	private String cardHolderName;
	private String bank;
	private int limit;
	private double balance;

	/*
	 * Constructor
	 */
	public CreditCard( String creditCardNumber, String cardHolderName, String bank, 
		               int limit, double balance) {
		this.creditCardNumber = creditCardNumber;
		this.cardHolderName = cardHolderName;
		this.bank = bank;
		this.limit = limit;
		this.balance = balance;
	}

	/*
	 * Accessor Methods
	 */
	public String getCreditCardNumber() { return creditCardNumber; }
	public String getCardHolderName() { return cardHolderName; }
	public String getBank() { return bank; }
	public int getLimit() { return limit; }
	public double getBalance() { return balance; }

	@Override
	public String toString() {
		return "CreditCard [creditCardNumber=" + creditCardNumber
				+ ", cardHolderName=" + cardHolderName + ", bank=" + bank
				+ ", limit=" + limit + ", balance=" + balance + "]"; 
	}

	/*
	 * Action Methods
	 */
	// PROBLEM 2A
	public boolean chargeIt( double price ) {
		if( balance+price <= limit ) {
			balance += price;
			return true;
		}
		System.out.println("Transaction failed");
		return false;
	}

	//PROBLEM 2B, PROBLEM 2C
	public void payment( double amount ) {
		balance -= amount;
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		if( dayOfMonth >= 15 )
			balance += 15; //late fee: $15
			System.out.println("Late fee of $15 added");
	}

	public static void main( String[] args ) {
		CreditCard newCard = new CreditCard("1234123412341234", "Jane Doe", 
											"Generic Bank", 2000, 1500.00);
		System.out.println(newCard);
		newCard.chargeIt(250.50);
		System.out.println(newCard);
		newCard.chargeIt(500);
		System.out.println(newCard);
		newCard.payment(1500.25);
		System.out.println(newCard);
		newCard.chargeIt(500);
		System.out.println(newCard);
	}
}