package kth.game.othello.player.strategy;

import kth.game.othello.board.Node;

public interface MoveStrategy {

	public Node getNodeToPlay(String playerId);

}
