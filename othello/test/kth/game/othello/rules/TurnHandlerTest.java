package kth.game.othello.rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import kth.game.othello.Othello;
import kth.game.othello.OthelloImpl;
import kth.game.othello.board.Board;
import kth.game.othello.board.Node;
import kth.game.othello.board.NodeImpl;
import kth.game.othello.board.SquareBoard;
import kth.game.othello.player.Player;
import kth.game.othello.player.Player.Type;
import kth.game.othello.player.PlayerFactory;

import org.junit.Before;
import org.junit.Test;

public class TurnHandlerTest {
	List<Node> nodes = new ArrayList<>();
	Board board;
	RulesImpl rules;
	Othello othello;
	Player computer;
	Player human;
	List<Player> players = new ArrayList<>();
	TurnHandler turnHandler;
	MoveHandler moveHandler;

	@Before
	public void init() {

		nodes.add(new NodeImpl(0, 0, false, null));
		nodes.add(new NodeImpl(1, 0, true, "w"));
		nodes.add(new NodeImpl(2, 0, false, null));
		nodes.add(new NodeImpl(3, 0, false, null));

		nodes.add(new NodeImpl(0, 1, true, "b"));
		nodes.add(new NodeImpl(1, 1, true, "b"));
		nodes.add(new NodeImpl(2, 1, true, "b"));
		nodes.add(new NodeImpl(3, 1, true, "w"));

		nodes.add(new NodeImpl(0, 2, true, "w"));
		nodes.add(new NodeImpl(1, 2, true, "b"));
		nodes.add(new NodeImpl(2, 2, true, "b"));
		nodes.add(new NodeImpl(3, 2, true, "w"));

		nodes.add(new NodeImpl(0, 3, true, "b"));
		nodes.add(new NodeImpl(1, 3, false, null));
		nodes.add(new NodeImpl(2, 3, true, "b"));
		nodes.add(new NodeImpl(3, 3, true, "b"));
		board = new SquareBoard(nodes);
		rules = new RulesImpl(board);
		turnHandler = new TurnHandler(players, rules);
		human = PlayerFactory.CreatePlayer(Type.HUMAN);
		computer = PlayerFactory.CreatePlayer(Type.COMPUTER);
		players.add(human);
		players.add(computer);
		moveHandler = new MoveHandler(turnHandler, rules);
		othello = new OthelloImpl(board, rules, turnHandler, moveHandler);
		
	}

	@Test
	public void testPlayerInTurn() {
		turnHandler.setCurrentPlayer(computer);
		assertEquals(turnHandler.getPlayerInTurn(), human);
	}

	@Test
	public void testIsGameActive() {
		othello.isActive();
	}

	@Test
	public void testGetPlayerInTurnWhenBoardFull() {
		for (Node node : nodes) {
			if (node.getOccupantPlayerId() == null) {
				((NodeImpl) node).setOccupantPlayerId("b");
				((NodeImpl) node).setMarked(true);
			}
		}
		assertTrue(turnHandler.getPlayerInTurn() == null);
	}

	/*
	 * b w b b b b b w w b b w b - b b
	 */
	@Test
	public void testGetPlayerInTurnWhenCurrentIsWhiteAndBlackHasNoMoves() {
		((NodeImpl) nodes.get(0)).setOccupantPlayerId("b");
		((NodeImpl) nodes.get(2)).setOccupantPlayerId("b");
		((NodeImpl) nodes.get(3)).setOccupantPlayerId("b");
		((NodeImpl) nodes.get(0)).setMarked(true);
		((NodeImpl) nodes.get(2)).setMarked(true);
		((NodeImpl) nodes.get(3)).setMarked(true);
		turnHandler.setCurrentPlayer(human);
		assertEquals(Player.Type.COMPUTER, turnHandler.getPlayerInTurn()
				.getType());
	}

	/*
	 * b w w - b b b w w b b w b b b b
	 */
	@Test
	public void testGetPlayerInTurnWhenOnlyHumanHasMoves() {
		((NodeImpl) nodes.get(0)).setOccupantPlayerId("b");
		((NodeImpl) nodes.get(2)).setOccupantPlayerId("w");
		((NodeImpl) nodes.get(13)).setOccupantPlayerId("b");
		((NodeImpl) nodes.get(0)).setMarked(true);
		((NodeImpl) nodes.get(2)).setMarked(true);
		((NodeImpl) nodes.get(13)).setMarked(true);
		turnHandler.setCurrentPlayer(human);
		assertEquals(Player.Type.HUMAN, turnHandler.getPlayerInTurn().getType());
	}

	/*
	 * b w w - b b b w w b b w b - b b
	 */
	@Test
	public void testGetPlayerInTurnWhenBothHaveMoves() {

		((NodeImpl) nodes.get(0)).setOccupantPlayerId("b");
		((NodeImpl) nodes.get(2)).setOccupantPlayerId("w");

		((NodeImpl) nodes.get(0)).setMarked(true);
		((NodeImpl) nodes.get(2)).setMarked(true);
		((SquareBoard) board).printNodes();

		turnHandler.setCurrentPlayer(computer);
		assertEquals(Player.Type.HUMAN, turnHandler.getPlayerInTurn().getType());
	}
}
