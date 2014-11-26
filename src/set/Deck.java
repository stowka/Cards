package set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Deck class - 
 * @author Antoine De Gieter
 * @author B&eacute;ligat Fran&ccedil;ois-Xavier
 *
 */
public class Deck {
	private ArrayList<Card> deck;
	private static Deck _instance = null;
	
	/**
	 * Singleton constructor
	 */
	private Deck() {
		deck = new ArrayList<Card>();
	}
	
	/**
	 * @return the single instance of the deck
	 */
	public static Deck getInstance() {
		if (null == _instance)
			_instance = new Deck();
		return _instance;
	}
	
	/**
	 * @see java.lang.Object.toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Card c : deck) {
			sb.append(c);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * Shuffles the card set
	 */
	public void shuffle() {
		long seed = System.nanoTime();
		Collections.shuffle(deck, new Random(seed));
	}
	
	/**
	 * Adds a card to the deck (does not allow duplicates)
	 * @param card
	 */
	public void add(Card card) {
		if (!deck.contains(card))
			deck.add(card);
		else
			System.out.println("The card " + card + " is already in the set.");
	}
	
	/**
	 * Picks a card from the deck
	 */
	public Card pick() {
		return deck.remove(0);
	}
	
	/**
	 * @return the number of cards in the deck
	 */
	public int size() {
		return deck.size();
	}
	
	/**
	 * Fills the deck with all possible cards
	 */
	public void fill() {
		for(Color c : Color.values())
			for(Name n : Name.values())
				add(new Card(n, c));
	}
}
