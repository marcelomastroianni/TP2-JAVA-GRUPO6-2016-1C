package fiuba.algo3.model.algoformers;

import java.util.ArrayList;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.surfaces.Surface;

public class ModeHumanoid extends Mode {
	
	public ModeHumanoid( Integer attack, Integer strikingDistance, Integer speed) {
		super(attack,strikingDistance,speed);
	}

	@Override
	public boolean canCrossSurface(Surface surface) {
		return surface.canBeCrossedByModeHumanoid();
	}
	
	@Override
	public void crossSurface(Surface surface, Algoformer algoformer) {
		surface.crossedByModeHumanoid(algoformer);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeHumanoid other = (ModeHumanoid) obj;
		if (attack == null) {
			if (other.attack != null)
				return false;
		} else if (!attack.equals(other.attack))
			return false;
		if (strikingDistance == null) {
			if (other.strikingDistance!= null)
				return false;
		} else if (!strikingDistance.equals(other.strikingDistance))
			return false;
		if (speed == null) {
			if (other.speed != null)
				return false;
		} else if (!speed.equals(other.speed))
			return false;
		return true;
	}
}