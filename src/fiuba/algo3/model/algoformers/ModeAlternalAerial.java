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
		if(this.isTrapped()){
			return false;
		}
		return surface.canBeCrossedBy(this);
	}

	@Override
	public boolean reduceSpeedFiftyPercent(Surface surface) {
		return surface.reduceSpeedFiftyPercent(this);
	}

	public void reduceAttackPowerFortyPercent() {
		reduceAttackPower(0.6);
	}

	public void trap(int turns) {
		super.trap(turns);
	}


}
