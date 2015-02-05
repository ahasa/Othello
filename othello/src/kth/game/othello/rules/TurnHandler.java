package kth.game.othello.rules;

import java.util.List;

import kth.game.othello.player.Player;

public class TurnHandler {
	private List<Player> players;
	private Player currentPlayer;
	private Rules rules;

	public TurnHandler(List<Player> players, Rules rules) {
		this.players = players;
		this.rules = rules;
	}

	public Player getPlayerInTurn() {

		if (players.size() == 2) {
			Player playerOne = players.get(0);
			Player playerTwo = players.get(1);

			if (playerOne.equals(currentPlayer)

			&& rules.hasValidMove(playerTwo.getId())) {
				currentPlayer = playerTwo;
			} else if (playerOne.equals(currentPlayer)

			&& !rules.hasValidMove(playerTwo.getId())

			&& rules.hasValidMove(playerOne.getId())) {
				currentPlayer = playerOne;

			} else if (playerTwo.equals(currentPlayer)
					&& rules.hasValidMove(playerOne.getId())) {
				currentPlayer = playerOne;
			} else if (playerTwo.equals(currentPlayer)
					&& !rules.hasValidMove(playerOne.getId())
					&& rules.hasValidMove(playerTwo.getId())) {
				currentPlayer = playerTwo;
			} else {
				currentPlayer = null;
			}
			return currentPlayer;
		}
		throw new IllegalStateException("Player number not right");
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}
}
