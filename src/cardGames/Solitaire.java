package cardGames;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import cardGames.Deck;

public class Solitaire {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char choice;
		int from;
		int to;

		gameDeck.shuffle();
		createPlayingField();
		createHomeField();

		// Main runtime Loop
		while (!finished) {

			// ---------Display GameBoard----------//

			printEntireGame();

			// ----------Player Commands-----------//

			System.out.println("(e) Exit");
			System.out.println("(f) Flip top 3 cards to the discard pile.");
			System.out.println("(m) Move a card");
			choice = sc.next().charAt(0);

			switch (choice) {
			case ('e'):
				setFinished(true);
				break;
			case ('f'):
				flipTopCards();
				break;
			case ('m'):
				System.out.println("Which card would you like to move?");
				System.out.println("(1-7) Playing Field Piles");
				System.out.println("(8)   Discard Pile");
				from = sc.nextInt();
				System.out.println("Where would you like to place the card?");
				System.out.println("(1-7)  Playing Field Piles");
				System.out.println("(8-11) Home Field");
				to = sc.nextInt();

				break;
			default:
				break;
			}

		}

		sc.close();

	}

	private static boolean finished = false;
	private static Deck gameDeck = new Deck();
	private static Stack<Card> discardPile = new Stack<>();
	private static ArrayList<Stack<Card>> playingField = new ArrayList<Stack<Card>>();
	private static ArrayList<Stack<Card>> homeField = new ArrayList<Stack<Card>>();

	private static void setFinished(boolean b) {

		finished = b;

	}

	// Creates the 7 rows of cards that make up the playing field
	// creates an array list of Stacks. But I will edit it at some point to
	// change them to Decks Possibly.
	private static void createPlayingField() {

		for (int i = 1; i < 8; i++) {

			Stack<Card> tempStack = new Stack<>();

			for (int j = i; j > 0; j--) {

				tempStack.push(gameDeck.draw());

			}

			playingField.add(tempStack);

		}

	}

	// Creates the 4 rows where player places A, 2, 3, 4 ... in that order based
	// on suit.
	private static void createHomeField() {

		for (int i = 0; i < 4; i++) {
			homeField.add(new Stack<Card>());
		}

	}

	// Flips 3 cards unless stated otherwise
	private static void flipTopCards() {

		if (gameDeck.isEmpty()) {
			gameDeck.addStack(discardPile);
		} else {
			for (int i = 0; i < 3; i++) {

				if (gameDeck.isEmpty()) {
					return;
				}
				discardPile.push(gameDeck.draw());

			}
		}

	}

	//when a card is moved this will just pop it from one stack and place it on the other if its valid.
//	private static void moveCard(int from, int to) {
//
//		if (from < 8) {// from is the playing field
//
//			if (to < 8) {// to is the playing field
//				
//				if (isValidMove(playingField.get(from - 1).peek(), playingField.get(to - 1).peek(), true)) {
//					playingField.get(to - 1).push(playingField.get(from - 1).pop());
//				}
//				
//			} else {// to is the home field
//				homeField.get(to - 8).push(playingField.get(from - 1).pop());
//			}
//
//		} else {// from is the discard pile
//
//			if (to < 8) {// to is the playing field
//
//			} else {// to is the home field
//
//			}
//
//		}
//
//	}

	//Checks to see if card can even be placed where the user is moving it to.
	//returns boolean
//	private static boolean isValidMove(Card a, Card b, boolean where) {
//
//	}

	// Prints only the top cards of each pile in the playingField. Will
	// eventually display all of the face down cards
	private static void printPlayingField() {

		for (int i = 0; i < 7; i++) {

			System.out.print(playingField.get(i).peek().display() + "  ");

		}

	}

	// Prints the last card placed on the piles in homeField.
	private static void printHomeField() {

		for (int i = 0; i < 4; i++) {

			if (homeField.get(i).isEmpty()) {
				System.out.print("---" + "  ");
			} else {
				System.out.print(homeField.get(i).peek().display() + "  ");
			}

		}

	}

	// Prints the Top card of the Discard Pile.
	private static void printDiscardPile() {

		if (discardPile.isEmpty()) {
			System.out.print("---" + "  ");
			return;
		} else {
			System.out.print(discardPile.peek().display());
		}

	}

	// Prints using the above Print Functions but organizes it so I dont have to
	// edit the order later on.
	private static void printEntireGame() {

		printHomeField();
		System.out.print("          ");
		printDiscardPile();

		System.out.println();

		printPlayingField();

		System.out.println();

	}

}
