
public class Card {
	private String number = "";
	private char suit = ' ';
	private int value = 0;
	private Card next = null;
	
	public Card(String n, char s, int v) {
		setNumber(n);
		setSuit(s);
		setValue(v);
	}
	public void setNext(Card n) {
		next = n;
	}
	public Card getNext() {
		return next;
	}

	private int getValue() {
		return value;
	}

	private void setValue(int value) {
		this.value = value;
	}

	private char getSuit() {
		return suit;
	}

	private void setSuit(char suit) {
		this.suit = suit;
	}

	private String getNumber() {
		return number;
	}

	private void setNumber(String number) {
		this.number = number;
	}
	
}
