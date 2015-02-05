package kth.game.othello.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import kth.game.othello.ObjectCreator;

import org.junit.Before;
import org.junit.Test;

public class SquarBoardTest {
	List<Node> nodes = new ArrayList<>();
	Board board;

	@Before
	public void init() {
		board = ObjectCreator.createBoard();
		nodes = ObjectCreator.createPlayer();
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
