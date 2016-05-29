package fiuba.algo3.algoformers;

import java.util.ArrayList;

import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Cell;
import fiuba.algo3.algoformers.board.Position;
import fiuba.algo3.exceptions.cantCrossException;

public class ModeAerial extends Mode{

	public ModeAerial(Integer attack, Integer strikingDistance, Integer speed) {
		super(attack,strikingDistance,speed);
	}

	@Override
	public void cross(ArrayList<Cell> steps) {
	}

}
