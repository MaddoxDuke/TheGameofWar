import java.util.Random;

public class War {
	
	public static int p1Count = 0;
	public static int p2Count = 0;

	public static void main(String[] args) {
		
		int round = 1;
		int maxRound = 3;
		int numCards = 52;
		
		Card[] deck = new Card[numCards];
		deck = makeDeck(numCards);
		
		Stack p1Stack = new Stack();
		Stack p2Stack = new Stack();
		Stack p1Win = new Stack();
		Stack p2Win = new Stack();
		
		while (round <= maxRound) {
			System.out.println("Current round: " + round);
			for (int i = 0; i < 10; i++) shuffle(deck);
			
			deal(deck, p1Stack, p2Stack);
			playHand(p1Stack, p2Stack, p1Win, p2Win);
			round++;
		}
		System.out.println("Player 1 won " + p1Count + " times.");
		System.out.println("Player 2 won " + p2Count + " times.");

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
		Random rand = new Random();
		 for(var i = 0; i < deck.length; i++){
	            var randomIndexToSwap = rand.nextInt(deck.length);
	            Card temp = deck[randomIndexToSwap];
	            
	            deck[randomIndexToSwap] = deck[i];

	            deck[i] = temp;
		 }
		
	}
	
	public static void deal(Card[] deck, Stack p1, Stack p2) {
			for (int i = 0; i < deck.length; i+=2) {
					p1.push(deck[i+1]);
					p2.push(deck[i]);
			}
		
	}
	
	public static boolean checkEmpty(Stack p1Hand, Stack p1Win) {
		if (p1Hand.isEmpty() && p1Win.isEmpty()) return true;
		else if (!p1Hand.isEmpty()) {
			while (p1Hand.isEmpty()) {
				p1Hand.push(p1Win.pop());
			}
		}
		return false;
	}
	
	public static void playHand(Stack p1Hand, Stack p2Hand, Stack p1Win, Stack p2Win) {
		
		Stack center = new Stack();
		
		while (!p1Hand.isEmpty() && !p2Hand.isEmpty()) {
			//System.out.println("New hand started");
			boolean tied = false;

			Card temp1 = p1Hand.pop();
			Card temp2 = p2Hand.pop();
			
			if (temp1.getValue() > temp2.getValue()) {
				p1Win.push(temp2);
				p1Win.push(temp1);

				//System.out.println("Hand won by p1");
			}
			if (temp1.getValue() < temp2.getValue()) {
				p2Win.push(temp2);
				p2Win.push(temp1);

				//System.out.println("Hand won by p2");
			}
			else {
				tied = true;
				center.push(temp2);
				center.push(temp1);
				//System.out.println("Tie, starting tie-breaker");
			}
			while (tied) {

				if (p1Hand.isEmpty() && !checkEmpty(p2Hand, p2Win)) {
                    System.out.println("Player 2 has won the game due to insufficient cards in Player 1's hand.");
					p2Count++;
                    return;
                }
                if (p2Hand.isEmpty() && !checkEmpty(p1Hand, p1Win)) {
                    System.out.println("Player 1 has won the game due to insufficient cards in Player 2's hand.");
					p1Count++;
                    return;
                }

				Card tieCard1 = p1Hand.pop();
				Card tieCard2 = p2Hand.pop();

				center.push(tieCard2);
				center.push(tieCard1);

				if (tieCard1.getValue() > tieCard2.getValue()) {
					moveStack(center,p1Win);
                   // System.out.println("Tie-break won by Player 1");
                    tied = false;
				}
				else if (tieCard1.getValue() < tieCard2.getValue()) {
					moveStack(center, p2Win);
                   // System.out.println("Tie-break won by Player 2");
                    tied = false;
				}
				else {
					//System.out.println("Another tie-breaker round");
				}
			}
			if (p1Hand.isEmpty() && !p1Win.isEmpty()) {
                checkEmpty(p1Hand, p1Win);
				p1Count++;
				System.out.println("Player 1 has won the game!");
				return;
            }
            if (p2Hand.isEmpty() && !p2Win.isEmpty()) {
                checkEmpty(p2Hand, p2Win);
				p2Count++;
				System.out.println("Player 2 has won the game!");
				return;
            }
		}
	}
	
	private static void moveStack(Stack centerStack, Stack winningsStack) {
		//System.out.println("move stack started");    
		while (!centerStack.isEmpty()) {
			winningsStack.push(centerStack.pop());
		}
		
	
	}
	private static void printStack(Stack stack) {
		Stack acc = new Stack();
		while (!stack.isEmpty()) {
			Card c = (Card) stack.pop();
			System.out.println(c.getValue() + c.getSuit());
			acc.push(c);
		}
	}
}
