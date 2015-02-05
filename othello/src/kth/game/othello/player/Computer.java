package kth.game.othello.player;

import kth.game.othello.board.Node;
import kth.game.othello.player.strategy.MoveStrategy;

public class Computer implements Player {
	private String name;
	private String id;
	private MoveStrategy moveStrategy;

	public Computer(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Type getType() {
		return Type.COMPUTER;
	}

	public Node getNodeToPlay() {
		return this.moveStrategy.getNodeToPlay(this.id);
	}

	public MoveStrategy getMoveStrategy() {
		return moveStrategy;
	}

	public void setMoveStrategy(MoveStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Player)) {
			return false;
		} else {
			Player player = (Player) other;
			if (player.getId().equals(this.getId()))
				return true;
			else
				return false;
		}
	}
}
