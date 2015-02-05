package kth.game.othello.rules;

import java.util.ArrayList;
import java.util.List;

import kth.game.othello.board.Node;
import kth.game.othello.board.NodeImpl;
import kth.game.othello.player.Player;
import kth.game.othello.player.Player.Type;

public class MoveHandler {
	private TurnHandler turnHandler;
	private RulesImpl rules;

	public MoveHandler(TurnHandler turnHandler, RulesImpl rules) {
		this.turnHandler = turnHandler;
		this.rules = rules;
	}

	public List<Node> move() {
		List<Node> nodesToAttach = null;
		Player currentPlayer = turnHandler.getCurrentPlayer();
		if (currentPlayer != null && currentPlayer.getType() == Type.COMPUTER) {

			String playerId = currentPlayer.getId();
			Node nodeToPlay = currentPlayer.getMoveStrategy().getNodeToPlay(
					playerId);
			nodesToAttach = this.move(playerId, nodeToPlay.getId());
			turnHandler.setCurrentPlayer(turnHandler.getPlayerInTurn(

			));
		}

		return nodesToAttach;
	}

	public List<Node> move(String playerId, String nodeId) {
		List<Node> nodesToSwap = new ArrayList<>();
		nodesToSwap.add(rules.getBoard().getNodeById(nodeId));
		nodesToSwap.addAll(rules.getNodesToSwap(playerId, nodeId));
		for (Node node : nodesToSwap) {
			((NodeImpl) node).setMarked(true);
			((NodeImpl) node).setOccupantPlayerId(playerId);
		}
		return nodesToSwap;

	}
}
