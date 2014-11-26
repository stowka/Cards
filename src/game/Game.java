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
		Deck deck = Deck.getInstance();
		
		
		deck.fill();
		deck.shuffle();
		
		
		
		System.out.println("Game ended...");
	}
}
