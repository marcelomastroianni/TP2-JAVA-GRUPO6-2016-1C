package fiuba.algo3.model.algoformers;

import java.util.ArrayList;

import fiuba.algo3.model.algoformers.board.Cell;

public class ModeHumanoid extends Mode {

	public ModeHumanoid( Integer attack, Integer strikingDistance, Integer speed) {
		super(attack,strikingDistance,speed);
	}

	@Override
	public void cross(ArrayList<Cell> steps) {
	}

}
