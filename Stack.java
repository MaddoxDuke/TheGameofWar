
public class Stack {
//push, pop, empty, notEmpty
	
	Card head = null;
	
	public void push(Card c) {
		c.setNext(head);
		head = c;
	}
	public Card pop() {
		Card c = head;
		head = head.getNext();
		
		return c;
	}
	public boolean isEmpty() {		
		if (head == null) return true;
		else return false;
	}
	public boolean notEmpty() {
		if (head != null) return true;
		else return false;
	}
}
