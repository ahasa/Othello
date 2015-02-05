package kth.game.othello.rules;

import java.util.ArrayList;
import java.util.List;

import kth.game.othello.board.Board;
import kth.game.othello.board.Node;
import kth.game.othello.player.Player;

public class RulesImpl implements Rules {
	private Board board;

	public RulesImpl(Board board) {
		this.board = board;
	}

	@Override
	public List<Node> getNodesToSwap(String playerId, String nodeId) {
		List<Node> swaped = new ArrayList<Node>();

		for (int i = -1; i < 2; i++)
			for (int j = -1; j < 2; j++) {
				if (i != 0 || j != 0)
					swaped.addAll(getNodesToSwapInDirection(playerId, nodeId,
							i, j));
			}
		return swaped;
	}

	@Override
	public boolean isMoveValid(String playerId, String nodeId) {
		return getNodesToSwap(playerId, nodeId).size() > 0;
	}

	@Override
	public boolean hasValidMove(String playerId) {
		for (Node n : board.getNodes()) {
			if (isMoveValid(playerId, n.getId())) {
				return true;
			}
		}
		return false;
	}

	public List<Node> getNodesToSwapInDirection(String playerId, String nodeId,
			int dx, int dy) {
		Node node = board.getNodeById(nodeId);
		List<Node> swapedNodes = new ArrayList<Node>();
		Node temp = null;
		if (node.isMarked())
			return new ArrayList<Node>();

		for (int i = 0; i < board.getNodes().size(); i++) {
			if (board.nodeExists(node.getXCoordinate() + (i * dx),
					node.getYCoordinate() + (i * dy))) {
				temp = board.getNode(node.getXCoordinate() + (i * dx),
						node.getYCoordinate() + (i * dy));

				if (temp.isMarked()
						&& !playerId.equals(temp.getOccupantPlayerId())) {
					swapedNodes.add(temp);
				} else if (playerId.equals(temp.getOccupantPlayerId())) {
					return swapedNodes;
				}
			} else
				return new ArrayList<Node>();
		}
		throw new IllegalStateException();
	}

	
	public boolean isActive(List<Player> players) {
		for (Player player : players) {
			if (this.hasValidMove(player.getId()))
				return true;
		}
		return false;
	}

	
	public Board getBoard() {
		return board;
	}

}
