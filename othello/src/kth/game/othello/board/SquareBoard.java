package kth.game.othello.board;

import java.util.List;

public class SquareBoard implements Board {
	private List<Node> nodes;

	public SquareBoard(List<Node> nodes) {
		this.nodes = nodes;
	}

	@Override
	public List<Node> getNodes() {
		return nodes;
	}

	@Override
	public boolean nodeExists(int x, int y) {
		boolean exists = false;
		for (Node n : nodes) {
			if (n.getXCoordinate() == x && n.getYCoordinate() == y)
				exists = true;
		}
		return exists;
	}

	@Override
	public Node getNode(int x, int y) {
		for (Node n : nodes) {
			if (n.getXCoordinate() == x && n.getYCoordinate() == y) {
				return n;
			}
		}
		return null;
	}

	@Override
	public Node getNodeById(String nodeId) {
		Node nodeToAttach = null;
		for (Node node : this.getNodes()) {
			if (node.getId().equals(nodeId))
				nodeToAttach = node;
		}
		return nodeToAttach;
	}

	public void printNodes() {
		int NodesPerRow = (int) Math.sqrt(this.nodes.size());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < this.nodes.size() + 1; i++) {
			if (i % NodesPerRow != 0) {
				if (nodes.get(i - 1).getOccupantPlayerId() != null)
					sb.append(nodes.get(i - 1).getOccupantPlayerId() + " ");
				else
					sb.append("- ");
			} else if (nodes.get(i - 1).getOccupantPlayerId() != null)
				sb.append(nodes.get(i - 1).getOccupantPlayerId() + "\n");
			else
				sb.append("- \n");
		}
		System.out.println(sb.toString());

	}
}
