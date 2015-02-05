package kth.game.othello.player;

import kth.game.othello.player.Player.Type;

public class PlayerFactory {

	public PlayerFactory() {
	}

	public static Player createPlayer(Type type, String name, String id) {
		Player player = null;
		switch (type) {
		case COMPUTER:
			player = new Computer(name, id);
		case HUMAN:
			player = new Human(name, id);
		}
		return player;
	}

	public static Player CreatePlayer(Type type) {
		Player player = null;
		switch (type) {
		case COMPUTER:
			player = new Computer("w", "Computer");
			break;
		case HUMAN:
			player = new Human("b", "Human");
			break;
		}
		return player;
	}
}
