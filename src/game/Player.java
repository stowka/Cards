package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

import set.Card;
import set.Color;

/**
 * 
 * @author Antoine De Gieter
 *
 */
public class Player {
	private long id;
	private String name;
	private HashMap<Color, TreeSet<Card>> hand;
	
	/**
	 * @param _name
	 */
	public Player(String _name) {
		id = System.currentTimeMillis();
		name = _name;
		hand = new HashMap<Color, TreeSet<Card>>(4);
		for (Color c : Color.values())
			hand.put(c, new TreeSet<Card>());
	}

	/**
	 * @see java.lang.Object.toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Player: " + name + "\n");
		for (Color color : hand.keySet()) {
			sb.append(color + "\n");
			sb.append("=========\n");
			for (Card card : hand.get(color)) {
				sb.append("\t");
				sb.append(card);
				sb.append("\n");
			}
			sb.append("=========\n");
		}
		return sb.toString();
	}
	
	/**
	 * @return the player name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Add a card to the player's hand
	 * @param card the card
	 */
	public void receive(Card card) {
		if (!hand.get(card.getColor()).contains(card))
			hand.get(card.getColor()).add(card);
	}
	
	/**
	 * @return the number of cards in the player's hand
	 */
	public int size() {
		int count = 0;
		for (Color color : hand.keySet())
			count += hand.get(color).size();
		return count;
	}
	
	/**
	 * Finds the best cards of the player's hand
	 * @return
	 */
	private Card findMax() {
		// select best cards
		ArrayList<Card> bestCards = new ArrayList<Card>();
		for(Color color : hand.keySet()) {
			for(Card card : hand.get(color)) {
				if (bestCards.isEmpty())
					bestCards.add(card);
				else {
					if (card.getValue() == bestCards.get(0).getValue())
						bestCards.add(card);
					else if (card.getValue() > bestCards.get(0).getValue()) {
						bestCards.removeAll(bestCards);
						bestCards.add(card);
					}
				}
			}
		}
		Collections.shuffle(bestCards);
		return bestCards.get(0);
	}
	
	/**
	 * Removes the best card from the player's hand (first round)
	 * @return one of the shuffled best cards 
	 */
	public Card start() {
		Card best = findMax();
		hand.get(best.getColor()).remove(best);
		return best;
	}
	
	public Card reply() {
		// TODO
		return null;
	}
	
	
}
