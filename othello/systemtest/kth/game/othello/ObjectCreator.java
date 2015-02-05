package kth.game.othello;

import java.util.ArrayList;
import java.util.List;

import kth.game.othello.board.Board;
import kth.game.othello.board.Node;
import kth.game.othello.board.NodeImpl;
import kth.game.othello.board.SquareBoard;
import kth.game.othello.rules.Rules;
import kth.game.othello.rules.RulesImpl;

public class ObjectCreator {

	public ObjectCreator() {
	}

	public static Board createBoard() {
		return new SquareBoard(ObjectCreator.createPlayer());
	}

	public static List<Node> createPlayer() {
		List<Node> nodes = new ArrayList<>();
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
		return nodes;
	}

	public static Rules createRules() {
		return new RulesImpl(ObjectCreator.createBoard());
	}

}
