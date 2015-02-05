package kth.game.othello.board;

public class NodeImpl implements Node {
	private String id;
	private String occupantPlayerId;
	private int x;
	private int y;
	private boolean isMarked;

	public NodeImpl() {
	}

	public NodeImpl(int x, int y, boolean isMarked, String occupantPlayerId) {
		this.x = x;
		this.y = y;
		this.id = x + "" + y;
		this.isMarked = isMarked;
		this.occupantPlayerId = occupantPlayerId;
	}

	public void setOccupantPlayerId(String occupantPlayerId) {
		this.occupantPlayerId = occupantPlayerId;
	}

	public void setMarked(boolean isMarked) {
		this.isMarked = isMarked;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getOccupantPlayerId() {
		return this.occupantPlayerId;
	}

	@Override
	public int getXCoordinate() {
		return this.x;
	}

	@Override
	public int getYCoordinate() {
		return this.y;
	}

	@Override
	public boolean isMarked() {
		return this.isMarked;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof NodeImpl)) {
			return false;
		} else {
			Node node = (Node) other;
			if (node.getId().equals(this.getId()))
				return true;
			else
				return false;
		}
	}


	
}
