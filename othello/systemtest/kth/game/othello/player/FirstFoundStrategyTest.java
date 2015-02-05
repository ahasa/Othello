package kth.game.othello.player;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import kth.game.othello.Othello;
import kth.game.othello.board.Board;
import kth.game.othello.board.Node;
import kth.game.othello.board.NodeImpl;
import kth.game.othello.board.SquareBoard;
import kth.game.othello.player.Player.Type;
import kth.game.othello.player.strategy.FirstFoundStrategy;
import kth.game.othello.player.strategy.MoveStrategy;
import kth.game.othello.rules.MoveHandler;
import kth.game.othello.rules.Rules;
import kth.game.othello.rules.RulesImpl;
import kth.game.othello.rules.TurnHandler;

import org.junit.Before;
import org.junit.Test;

public class FirstFoundStrategyTest {
	static List<Node> nodes = new ArrayList<>();
	Board board;
	Rules rules;
	Othello othello;
	Player computer;
	Player human;
	List<Player> players = new ArrayList<>();
	TurnHandler turnHandler;
	MoveHandler moveHandler;
	MoveStrategy moveStrategy;

	@Before
	public void init() {
		nodes.add(new NodeImpl(0, 0, false, null));
		nodes.add(new NodeImpl(1, 0, true, "w"));
		nodes.add(new NodeImpl(2, 0, true, "w"));
		nodes.add(new NodeImpl(3, 0, true, "w"));

		nodes.add(new NodeImpl(0, 1, true, "b"));
		nodes.add(new NodeImpl(1, 1, true, "b"));
		nodes.add(new NodeImpl(2, 1, true, "b"));
		nodes.add(new NodeImpl(3, 1, true, "w"));

		nodes.add(new NodeImpl(0, 2, true, "w"));
		nodes.add(new NodeImpl(1, 2, true, "b"));
		nodes.add(new NodeImpl(2, 2, true, "b"));
		nodes.add(new NodeImpl(3, 2, true, "w"));

		nodes.add(new NodeImpl(0, 3, true, "b"));
		nodes.add(new NodeImpl(1, 3, true, "w"));
		nodes.add(new NodeImpl(2, 3, true, "b"));
		nodes.add(new NodeImpl(3, 3, true, "b"));
		board = new SquareBoard(nodes);
		rules = new RulesImpl(board);
		moveStrategy = new FirstFoundStrategy(rules, board);
		turnHandler = new TurnHandler(players, rules);
		human = PlayerFactory.CreatePlayer(Type.HUMAN);
		computer = PlayerFactory.CreatePlayer(Type.COMPUTER);
		computer.setMoveStrategy(moveStrategy);
		players.add(human);
		players.add(computer);
	}

	@Test
	public void testgetNodeToPlay() {
		assertEquals(moveStrategy.getNodeToPlay("w"), nodes.get(0));
		assertEquals(moveStrategy.getNodeToPlay("b"), null);

	}

}
