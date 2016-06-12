package fiuba.algo3.model.algoformers;

import java.util.ArrayList;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.surfaces.Surface;

public class ModeAlternalAerial extends Mode{
	
	

	public ModeAlternalAerial(Integer attack, Integer strikingDistance, Integer speed) {
		super(attack,strikingDistance,speed);
	}

	@Override
	public boolean canCrossSurface(Surface surface) {
		return surface.canBeCrossedByModeAlternalAerial();
	}

	@Override
	public boolean reduceSpeedFiftyPercent(Surface surface) {
		return surface.reduceSpeedFiftyPercentModeAlternalAerial();
	}

	@Override
	public boolean reduceLifeFiftyPercent(Surface surface) {
		return surface.reduceLifeFiftyPercentModeAlternalAerial();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeAlternalAerial other = (ModeAlternalAerial) obj;
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

	@Override
	public boolean reduceAttackPowerFortyPercent(Surface surface) {
		return surface.reduceAttackPowerFortyPercentModeAlternalAerial();
	}

}
