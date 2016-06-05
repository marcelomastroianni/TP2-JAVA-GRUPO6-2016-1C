package fiuba.algo3.model.algoformers;

import java.util.ArrayList;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.surfaces.Surface;

public class ModeHumanoid extends Mode {

	public ModeHumanoid( Integer attack, Integer strikingDistance, Integer speed) {
		super(attack,strikingDistance,speed);
	}

	@Override
	public void cross(ArrayList<Cell> steps) {
	}

	@Override
	public boolean canCrossSurface(Surface surface) {
		return surface.puedeSerCruzadaPorModoHumanoide();
	}
	
}
