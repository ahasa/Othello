package kth.game.othello;

import java.util.List;

import kth.game.othello.board.Board;
import kth.game.othello.board.Node;
import kth.game.othello.player.Player;
import kth.game.othello.rules.MoveHandler;
import kth.game.othello.rules.Rules;
import kth.game.othello.rules.TurnHandler;

public class OthelloImpl implements Othello {

	private Board board;
	private Rules rules;
	private TurnHandler turnHandler;
	private MoveHandler moveHandler;

	public OthelloImpl(Board board, Rules rules, TurnHandler turnHandler) {
		this.board = board;
		this.rules = rules;
		this.turnHandler = turnHandler;
		moveHandler = new MoveHandler(turnHandler, rules);
	}

	@Override
	public Board getBoard() {
		return board;
	}

	@Override
	public List<Node> getNodesToSwap(String playerId, String nodeId) {
		return rules.getNodesToSwap(playerId, nodeId);
	}

	@Override
	public Player getPlayerInTurn() {
		return turnHandler.getPlayerInTurn();
	}

	@Override
	public List<Player> getPlayers() {
		return turnHandler.getPlayers();
	}

	@Override
	public boolean hasValidMove(String playerId) {
		return rules.hasValidMove(playerId);
	}

	@Override
	public boolean isActive() {
		return rules.isActive(getPlayers());
	}

	@Override
	public boolean isMoveValid(String playerId, String nodeId) {
		return rules.isMoveValid(playerId, nodeId);
	}

	@Override
	public List<Node> move() {
		return moveHandler.move();

	}

	@Override
	public List<Node> move(String playerId, String nodeId)

	throws IllegalArgumentException {
		return moveHandler.move(playerId, nodeId);
	}

	@Override
	public void start() {
	}

	@Override
	public void start(String playerId) {

	}

}
