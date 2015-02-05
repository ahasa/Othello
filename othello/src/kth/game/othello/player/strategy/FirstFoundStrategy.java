package kth.game.othello.player.strategy;

import kth.game.othello.board.Board;
import kth.game.othello.board.Node;
import kth.game.othello.rules.Rules;

public class FirstFoundStrategy implements MoveStrategy {
	private Rules rules;
	private Board board;

	public FirstFoundStrategy(Rules rules, Board board) {
		this.rules = rules;
		this.board = board;
	}

	@Override
	public Node getNodeToPlay(String playerId) {
		Node node = null;
		for (int i = 0; i < board.getNodes().size(); i++) {
			node = board.getNodes().get(i);
			if (rules.isMoveValid(playerId, node.getId())) {
				return node;
			}
		}
		return null;
	}

}
