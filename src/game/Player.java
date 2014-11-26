package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

import set.Card;
import set.Color;

/**
 * Player class -
 * 
 * @author Antoine De Gieter
 * @author Fran&ccedil;ois-Xavier B&eacute;ligat
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
	 * 
	 * @param card
	 *            the card
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
	 * 
	 * @return
	 */
	private Card findMax() {
		// select best cards
		ArrayList<Card> bestCards = new ArrayList<Card>();
		for (Color color : hand.keySet()) {
			for (Card card : hand.get(color)) {
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
	 * Finds the best cards of the player's hand
	 * 
	 * @return
	 */
	private Card findMin() {
		// select worst cards
		ArrayList<Card> worstCards = new ArrayList<Card>();
		for (Color color : hand.keySet()) {
			for (Card card : hand.get(color)) {
				if (worstCards.isEmpty())
					worstCards.add(card);
				else {
					if (card.getValue() == worstCards.get(0).getValue())
						worstCards.add(card);
					else if (card.getValue() < worstCards.get(0).getValue()) {
						worstCards.removeAll(worstCards);
						worstCards.add(card);
					}
				}
			}
		}
		Collections.shuffle(worstCards);
		return worstCards.get(0);
	}

	/**
	 * Removes the best card from the player's hand (first round)
	 * 
	 * @return one of the shuffled best cards
	 */
	public Card start() {
		Card best = findMax();
		hand.get(best.getColor()).remove(best);
		return best;
	}

	/**
	 * Plays according to an AI (other rounds): If has better card in same
	 * color, plays the straight higher one Else if has card in same color,
	 * plays the worst one Else plays the worst card whatever the color.
	 * 
	 * @param playedCard
	 * @return
	 */
	public Card reply(Card playedCard) {
		Card card;
		if (0 != hand.get(playedCard.getColor()).size()) {
			if (null != (card = hand.get(playedCard.getColor()).higher(
					playedCard))) {
				hand.get(card.getColor()).remove(card);
				return card;
			} else
				card = hand.get(playedCard.getColor()).first();
		} else {
			card = findMin();
		}
		hand.get(card.getColor()).remove(card);
		return card;
	}

}
