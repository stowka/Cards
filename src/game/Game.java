package game;

import set.Deck;

/**
 * 
 * @author Antoine De Gieter
 *
 */
public class Game {
	public static void main(String[] argv) {
		System.out.println("Game started...\n");
		Deck.getInstance().fill();
		Deck.getInstance().shuffle();
		System.out.println(Deck.getInstance());
		System.out.println("Game ended...");
	}
}
