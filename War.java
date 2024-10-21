import java.util.Random;

public class War {

	public static void main(String[] args) {
		
		int round = 0;
		int maxRound = 500;
		int numPlayers = 2;
		int numCards = 52;
		
		Card[] deck = new Card[numCards];
		deck = makeDeck(numCards);
		shuffle(deck);
		shuffle(deck);
		shuffle(deck);
		shuffle(deck);
		
		Stack p1Stack = new Stack();
		Stack p2Stack = new Stack();
		
		while (round < maxRound) {
			deal(deck, p1Stack, p2Stack);
			
			round++;
		}
	}
	public static Card[] makeDeck(int numCards) {
		Card[] deck = new Card[numCards];
		int cardIndex = 0;
		
		for (int i = 0; i <= 3; i++) {
			String n = "";
			char suit = ' ';
			switch (i) {
			case 0://Spade
				suit = (char)'\u2660';
				break;
			case 1://Diamond
				suit = (char)'\u2666';
				break;
			case 2://Club
				suit = (char)'\u2663';
				break;
			case 3: //Heart
				suit = (char)'\u2764';
				break;
			}
			
			for (int j = 2; j <= 14; j++) {
				if (j == 11) n = "J";
				else if (j == 12) n = "Q";
				else if (j == 13) n = "K";
				else if (j == 14) n = "A";
				else n = "" + j;
				
				Card c = new Card(n, suit, j);
				deck[cardIndex] = c;
				cardIndex++;
			}
		}
		
		
		return deck;
	}
	
	public static void shuffle(Card[] deck) {
		
		
	}
	
	public static void deal(Card[] deck, Stack p1, Stack p2) {
		
		for (int i = 0; i < deck.length; i++) {
			p1.push(deck.pop());
			p2.push(deck.pop());
		}
		
	}
	
	void checkEmpty(Stack p1hand, Stack p1win) {
		if (p1hand == null) return;
		else {
			while (p1win != null) {
				p1hand.push(p1win.pop());
			}
		}
	}
	
	void playHand(Stack p1Hand, Stack p2Hand, Stack p1Win, Stack p2Win) {
		
		while () {
			if (p1Hand.isEmpty()) return;
			if (p2Hand.isEmpty()) return;
			//then pop card1 and card2, get values, then compare.
			//if v1 > v2, push card1, card2 to p1s win stack
			// else if v1 < v2 push card2, card1 to p2s win stack
			//else it is a tie.
			//tied = true
			//while tied {
			//push cards onto center stack. If cards are tied, continue.
			//else tied = false
			//push card1, card2 to the winner and move the center stack to winner.
			// end while.
		}
	}
	
	private void moveStack(Stack winningsStack, Stack centerStack) {
		while (!centerStack.isEmpty()) {
			Card card = (Card) centerStack.pop();
			if (card == null) return;
			
			winningsStack.push(card);
		}
	}
	private void printStack(Stack stack) {
		Stack acc = new Stack();
		while (!stack.isEmpty()) {
			Card c = (Card) stack.pop();
			System.out.println(c.getNumber() + c.getSuite());
			acc.push(c);
		}
	}

}
