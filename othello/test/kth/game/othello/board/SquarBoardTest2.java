package kth.game.othello.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SquarBoardTest2 {
	List<Node> nodes = new ArrayList<>();
	Board board;

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

		board = new SquareBoard(nodes);
	}

	@Test
	public void testNodeExists() {
		assertTrue(board.nodeExists(1, 1));
	}

	@Test
	public void testGetNode() {
		assertEquals(nodes.get(0), board.getNode(0, 0));
	}

	@Test
	public void testGetNodeById() {
		assertEquals(nodes.get(0), board.getNodeById("00"));
	}

}
