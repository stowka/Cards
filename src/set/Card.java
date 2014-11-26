package set;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Card class - represents a single card
 * @author Antoine De Gieter
 *
 */
public class Card implements Comparable<Card> {
	private Name name;
	private int value;
	private Color color;
	
	
	/*
	 * defines the relation between a card name and its value
	 */
	private static final Map<Name, Integer> nameValue;
	static {
		Map<Name, Integer> tmp = new HashMap<Name, Integer>();
		tmp.put(Name.SEVEN, 0);
		tmp.put(Name.EIGHT, 0);
		tmp.put(Name.NINE, 0);
		tmp.put(Name.TEN, 5);
		tmp.put(Name.KNAVE, 6);
		tmp.put(Name.QUEEN, 7);
		tmp.put(Name.KING, 8);
		tmp.put(Name.ACE, 11);
		nameValue = Collections.unmodifiableMap(tmp);
	}
	
	/**
	 * Card constructor
	 * @param _name name of the card
	 * @param _color color of the card
	 */
	public Card(Name _name, Color _color) {
		name = _name;
		value = nameValue.get(name);
		color = _color;
	}

	/**
	 * @see java.lang.Object.toString()
	 */
	@Override
	public String toString() {
		return name + " of " + color + " [" + value + "]";
	}
	
	/**
	 * @see java.lang.Object.hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + value;
		return result;
	}
	
	/**
	 * @see java.lang.Object.equals(Object obj)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Card)) {
			return false;
		}
		Card other = (Card) obj;
		if (color != other.color) {
			return false;
		}
		if (name != other.name) {
			return false;
		}
		if (value != other.value) {
			return false;
		}
		return true;
	}

	/**
	 * @see java.lang.Comparable.compareTo(Object o)
	 */
	@Override
	public int compareTo(Card card) {
		if (name.ordinal() == card.getName().ordinal())
			return 0;
		else if (name.ordinal() < card.getName().ordinal())
			return -1;
		else
			return 1;
	}

	/**
	 * @return the name of the card
	 */
	public Name getName() {
		return name;
	}

	/**
	 * @return the value of the card
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the color of the card
	 */
	public Color getColor() {
		return color;
	}
}
