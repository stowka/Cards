package game;

import set.Card;

/**
 * Turn class -
 * 
 * @author Antoine De Gieter
 * @author Fran&ccedil;ois-Xavier B&eacute;ligat
 * 
 */
public class Turn {
	private Player player;
	private Card card;

	/**
	 * Constructor
	 * 
	 * @param _player
	 * @param _card
	 */
	public Turn(Player _player, Card _card) {
		player = _player;
		card = _card;
	}

	/**
	 * @see java.lang.Object.toString()
	 */
	@Override
	public String toString() {
		// TODO: can do better
		return "Turn [player=" + player + ", card=" + card + "]";
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return the card
	 */
	public Card getCard() {
		return card;
	}
}
