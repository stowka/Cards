package game;

import java.util.ArrayList;
import java.util.Collections;

import set.Card;
import set.Deck;

/**
 * Table class -
 * 
 * @author Antoine De Gieter
 * @author Fran&ccedil;ois-Xavier B&eacute;ligat
 * 
 */
public class Game {
	private ArrayList<Round> history;
	private Turn current;
	private Player one, two;
	private int playerOneScore, playerTwoScore;

	/**
	 * 
	 */
	public Game(Player _one, Player _two) {
		history = new ArrayList<Round>();
		current = null;
		one = _one;
		two = _two;
	}

	/**
	 * 
	 * @param card
	 * @return
	 */
	public Card addCard(Player player, Card card) {
		if (null == current)
			current = new Turn(player, card);
		else {
			history.add(new Round(current, new Turn(player, card)));
			current = null;
		}
		return card;
	}

	/**
	 * @return the history
	 */
	public ArrayList<Round> getHistory() {
		return history;
	}

	public Player scores() {
		for (Round r : history) {
			if (r.getWinner().equals(one))
				playerOneScore += r.getScore();
			else
				playerTwoScore += r.getScore();
		}
		if (playerOneScore == playerTwoScore)
			return null;
		else if (playerOneScore > playerTwoScore)
			return one;
		else
			return two;
	}

	/**
	 * @see java.lang.Object.toString()
	 */
	@Override
	public String toString() {
		// TODO
		return null;
	}

	public static void main(String[] argv) {
		System.out.println("Game started...\n");
		Deck deck = Deck.getInstance();

		Player p1 = new Player("MrPwet");
		Player p2 = new Player("Nabila");

		deck.fill();
		deck.shuffle();

		// DISTRIBUTION
		while (deck.size() > 0) {
			p1.receive(deck.pick());
			p2.receive(deck.pick());
		}

		Game game = new Game(p1, p2);

		// RANDOMIZE FIRST PLAYER TO PLAY
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);
		Collections.shuffle(players);

		while (p1.hasCards() && p2.hasCards()) {
			game.addCard(
					players.get(0),
					players.get(0)
							.reply(game.addCard(players.get(1), players.get(1)
									.start())));
			if (game.getHistory().get(game.getHistory().size() - 1)
					.hasToReplay()
					&& (p1.hasCards() && p2.hasCards()))
				game.addCard(
						players.get(0),
						players.get(0).reply(
								game.addCard(players.get(1), players.get(1)
										.start())));
			else
				game.addCard(
						players.get(1),
						players.get(1).reply(
								game.addCard(players.get(0), players.get(0)
										.start())));
		}

		int i = 1;
		for (Round r : game.getHistory()) {
			System.out.println("==================");
			System.out.println("# Round " + i + "\t#");
			System.out.println("==================");
			System.out.print(r.getFirstTurn().getPlayer().getName() + " (");
			System.out.print(r.getFirstTurn().getCard() + ")\n");
			System.out.println("\tvs.");
			System.out.print(r.getSecondTurn().getPlayer().getName() + " (");
			System.out.print(r.getSecondTurn().getCard() + ")\n");
			System.out.println("\n=> " + r.getWinner().getName() + " wins ("
					+ r.getScore() + " pts)");
			System.out.println();
			i += 1;
		}

		System.out.println("WINNER : " + game.scores().getName());
		System.out.println("\t" + p1.getName() + ":\t"
				+ game.getPlayerOneScore());
		System.out.println("\t" + p2.getName() + ":\t"
				+ game.getPlayerTwoScore());
		System.out.println("Game ended...");
	}

	/**
	 * @return the playerOneScore
	 */
	public int getPlayerOneScore() {
		return playerOneScore;
	}

	/**
	 * @return the playerTwoScore
	 */
	public int getPlayerTwoScore() {
		return playerTwoScore;
	}
}
