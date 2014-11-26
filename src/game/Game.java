package game;

import set.Card;
import set.Deck;

/**
 * Game class -
 * 
 * @author Antoine De Gieter
 * @author Fran&ccedil;ois-Xavier B&eacute;ligat
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

		// DISTRIBUTION
		while (deck.size() > 0) {
			p1.receive(deck.pick());
			p2.receive(deck.pick());
		}

		System.out.println(p1);
		System.out.println(p2);

		Card card = p1.start();
		System.out.println(card);
		card = p2.reply(card);
		System.out.println(card);

		System.out.println(p1);
		System.out.println(p2);

		System.out.println("Game ended...");
	}
}
