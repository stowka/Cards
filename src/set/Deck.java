package set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Deck class - 
 * @author Antoine De Gieter
 * @author Béligat François-Xavier
 *
 */
public class Deck {
	private ArrayList<Card> cardSet;
	private static Deck _instance = null;
	
	/**
	 * Singleton constructor
	 */
	private Deck() {
		cardSet = new ArrayList<Card>();
	}
	
	/**
	 * @return the single instance of the card set
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
		for(Card c : cardSet) {
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
		Collections.shuffle(cardSet, new Random(seed));
	}
	
	/**
	 * Adds a card to the set (does not allow duplicates)
	 * @param card
	 */
	public void add(Card card) {
		if (!cardSet.contains(card))
			cardSet.add(card);
		else
			System.out.println("The card " + card + " is already in the set.");
	}
	
	/**
	 * Fills the card set with all possible cards
	 */
	public void fill() {
		for(Color c : Color.values())
			for(Name n : Name.values())
				add(new Card(n, c));
	}
}
