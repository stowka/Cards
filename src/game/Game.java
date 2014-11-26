package game;

import set.CardSet;

/**
 * 
 * @author Antoine De Gieter
 *
 */
public class Game {
	public static void main(String[] argv) {
		System.out.println("Game started...");
		CardSet.getInstance().fill();
		CardSet.getInstance().shuffle();
		System.out.println(CardSet.getInstance());
		System.out.println("Game ended...");
	}
}
