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
		
		Player p1 = new Player("MrPwet");
		Player p2 = new Player("Stowka");
		
		deck.fill();
		deck.shuffle();
		
		while (deck.size() > 0) {
			p1.receive(deck.pick());
			p2.receive(deck.pick());
		}
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("Game ended...");
	}
}
