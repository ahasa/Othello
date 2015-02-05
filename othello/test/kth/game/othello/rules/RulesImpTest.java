package kth.game.othello.rules;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import kth.game.othello.board.Board;
import kth.game.othello.board.Node;
import kth.game.othello.board.NodeImpl;
import kth.game.othello.board.SquareBoard;
import kth.game.othello.player.Player;
import kth.game.othello.player.Player.Type;
import kth.game.othello.player.PlayerFactory;

import org.junit.Before;
import org.junit.Test;

public class RulesImpTest {
	List<Node> nodes = new ArrayList<>();
	Board board;
	Rules rules;

	List<Player> players = new ArrayList<>();

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

		Player human = PlayerFactory.CreatePlayer(Type.HUMAN);
		Player computer = PlayerFactory.CreatePlayer(Type.COMPUTER);
		players.add(human);
		players.add(computer);
	}

	@Test
	public void testGetNodesToSwapInDirections() {
		List<Node> result = rules.getNodesToSwap("w", "13");
		List<Node> expected = new ArrayList<>();
		expected.add(new NodeImpl(1, 1, true, "b"));
		expected.add(new NodeImpl(1, 2, true, "b"));
		expected.add(new NodeImpl(2, 2, true, "b"));
		assertTrue(result.containsAll(expected) && expected.containsAll(result));

	}

	@Test
	public void testHasValidMove() {
		assertTrue(rules.hasValidMove("b"));
		assertTrue(rules.hasValidMove("w"));
	}

	@Test
	public void testIsMoveValid() {
		assertTrue(rules.isMoveValid("b", "30"));
	}

	@Test
	public void testIsActive() {
		assertTrue(((RulesImpl) rules).isActive(players));
	}

}
