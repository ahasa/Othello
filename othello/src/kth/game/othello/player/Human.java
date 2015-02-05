package kth.game.othello.player;

import kth.game.othello.player.strategy.MoveStrategy;

public class Human implements Player {
	private String name;
	private String id;

	public Human(String id, String name) {
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
		return Type.HUMAN;
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

	@Override
	public MoveStrategy getMoveStrategy() {
		throw new IllegalStateException("This is a human, play by yourself");
	}

	@Override
	public void setMoveStrategy(MoveStrategy moveStrategy) {
		throw new IllegalStateException("This is a human, play by yourself");

	}

}
