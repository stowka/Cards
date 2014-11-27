package game;

/**
 * Round class -
 * 
 * @author Antoine De Gieter
 * @author Fran&ccedil;ois-Xavier B&eacute;ligat
 * 
 */
public class Round {
	private Turn firstTurn, secondTurn;
	private Player winner;
	private int score;

	/**
	 * Constructor
	 * 
	 * @param _firstTurn
	 * @param _secondTurn
	 */
	public Round(Turn _firstTurn, Turn _secondTurn) {
		firstTurn = _firstTurn;
		secondTurn = _secondTurn;
		if (0 < (score = firstTurn.getCard().getValue()
				- secondTurn.getCard().getValue()))
			winner = firstTurn.getPlayer();
		else
			winner = secondTurn.getPlayer();
		score = Math.abs(score);
	}
	
	/**
	 * @return whether the player who has just played has to replay
	 */
	public boolean hasToReplay() {
		return winner.equals(firstTurn.getPlayer());
	}

	/**
	 * @return the first turn
	 */
	public Turn getFirstTurn() {
		return firstTurn;
	}

	/**
	 * @return the second turn
	 */
	public Turn getSecondTurn() {
		return secondTurn;
	}

	/**
	 * @return the winner
	 */
	public Player getWinner() {
		return winner;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
}
