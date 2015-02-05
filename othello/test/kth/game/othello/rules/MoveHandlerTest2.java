package kth.game.othello.rules;

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

public class MoveHandlerTest2 {
	List<Node> nodes = new ArrayList<>();
	Board board;
	Rules rules;
	Othello othello;
	Player computer;
	Player human;
	List<Player> players = new ArrayList<>();
	TurnHandler turnHandler;
	MoveHandler moveHandler;

	@Before
	public void init() {
		nodes.add(new NodeImpl(0, 0, true, "b"));
		nodes.add(new NodeImpl(1, 0, true, "w"));
		nodes.add(new NodeImpl(2, 0, true, "b"));
		nodes.add(new NodeImpl(3, 0, true, "b"));

		nodes.add(new NodeImpl(0, 1, true, "b"));
		nodes.add(new NodeImpl(1, 1, true, "b"));
		nodes.add(new NodeImpl(2, 1, true, "b"));
		nodes.add(new NodeImpl(3, 1, true, "w"));

		nodes.add(new NodeImpl(0, 2, true, "w"));
		nodes.add(new NodeImpl(1, 2, true, "b"));
		nodes.add(new NodeImpl(2, 2, true, "b"));
		nodes.add(new NodeImpl(3, 2, true, "w"));

		nodes.add(new NodeImpl(0, 3, true, "b"));
		nodes.add(new NodeImpl(1, 3, true, "b"));
		nodes.add(new NodeImpl(2, 3, true, "b"));
		nodes.add(new NodeImpl(3, 3, true, "b"));
		/*
		 * - w - - b b b w w b b w b - b b
		 */
		board = new SquareBoard(nodes);
		rules = new RulesImpl(board);
		turnHandler = new TurnHandler(players, rules);
		human = PlayerFactory.CreatePlayer(Type.HUMAN);
		computer = PlayerFactory.CreatePlayer(Type.COMPUTER);
		players.add(human);
		players.add(computer);
		othello = new OthelloImpl(board, rules, turnHandler);
		// moveHandler = new MoveHandler(new FirstFoundStrategy(rules, board),
		// turnHandler);
	}

	@Test
	public void testMove() {
		List<Node> expected = new ArrayList<>();
		expected.add(new NodeImpl(1, 1, true, "b"));
		expected.add(new NodeImpl(1, 2, true, "b"));
		expected.add(new NodeImpl(2, 2, true, "b"));
		expected.add(new NodeImpl(1, 3, true, "w"));

		// assertTrue(expected.containsAll(othello.move())
		// && othello.move().containsAll(expected));

	}

}
