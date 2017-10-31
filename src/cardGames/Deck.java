package cardGames;

import java.util.Collections;
import java.util.Stack;

public class Deck{
	
	Stack<Card> deck = new Stack<>();
	
	public Deck(){

		for(int suit = 1; suit < 5; suit++){
			
			for(int num = 1; num < 14; num++){
				
				deck.push(new Card(num, suit));
				
			}
			
		}
		
	}
	
	public Card draw(){
		
		Card c = deck.pop();
		
		return c;
		
	}
	
	public void add(Card c){
		
		deck.push(c);
		
	}

	public void shuffle(){
		
		Collections.shuffle(deck);
		
	}
	
	public int size(){
		return this.deck.size();
	}

	public void addStack(Stack<Card> c){
		
		int size = c.size();
		
		for(int j=0; j<size; j++){

			this.deck.push(c.pop());
			
		}
		
		
		
	}

	public boolean isEmpty(){
		
		return this.deck.isEmpty();
		
	}
	
}
