package fiuba.algo3.algoformers;

import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Position;

public class AlternalMode implements Mode{

	private Integer life;
	private Integer attack;
	private Integer strikingDistance;
	private Integer speed;
	private Type type;

	public AlternalMode(Integer life, Integer attack, Integer strikingDistance, Integer speed, Type type) {
		this.life = life;
		this.attack = attack;
		this.strikingDistance = strikingDistance;
		this.speed = speed;
		this.type = type;
	}

	@Override
	public Position moveEast(Position inicialPosition, Board board) {
		// TODO Auto-generated method stub
		return null;
	}


}
