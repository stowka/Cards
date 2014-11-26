package game;

/**
 * 
 * @author Antoine De Gieter
 *
 */
public class Player {
	private String name;
	
	/**
	 * @param _name
	 */
	public Player(String _name) {
		name = _name;
	}

	/**
	 * @see java.lang.Object.toString()
	 */
	@Override
	public String toString() {
		return "Player [name=" + name + "]";
	}
	
	/**
	 * @return the player name
	 */
	public String getName() {
		return name;
	}
}
