package cardGames;

public class Card {

	// 1, 2, 3...10, 11, 12, 13
	private int number;
	// a1=spade
	// b2=hearts
	// c3=diamonds
	// d4=clubs
	private int suit;
	// This is so when i go to display cards they can use unicode images
	// private String hexNum;
	// private String hexSuit;
	// private String cardImage;
	boolean up;

	public Card(int num, int soot) {

		this.number = num;
		this.suit = soot;
		// this.hexNum = Integer.toHexString(num);
		// this.hexSuit = Integer.toHexString(soot + 9);
		// this.cardImage = "u1F0" + hexNum + hexSuit;

	}
	
	public boolean getUp(){
		return this.up;
	}
	
	public void setUp(boolean u){
		this.up = u;
	}

	public int getNumber() {
		return number;
	}

	public int getSuit() {
		return suit;
	}

	public String display() {

		String title;
		
		switch (number) {
		case (11):
			title = "J,";
			break;
		case (12):
			title = "Q,";
			break;
		case (13):
			title = "K,";
			break;
		case (1):
			title = "A,";
			break;
		default:
			title = this.getNumber() + ",";
			break;
		}
		
		switch(suit){
		case(1): 
			title += "s";
			break;
		case(2): 
			title += "h";
			break;
		case(3):
			title += "d";
			break;
		case(4):
			title += "c";
			break;
		}

		return title;

	}

}
