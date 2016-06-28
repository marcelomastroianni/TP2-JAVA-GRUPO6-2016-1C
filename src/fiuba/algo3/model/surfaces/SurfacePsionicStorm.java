package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.surfaces.Surface;

public class SurfacePsionicStorm implements Surface {

	@Override
	public boolean canBeCrossedByModeHumanoid() {
		return false;
	}

	@Override
	public boolean canBeCrossedByModeAlternalTerrestrial() {
		return false;
	}

	@Override
	public boolean canBeCrossedByModeAlternalAerial() {
		return true;
	}

	@Override
	public void crossedByModeHumanoid(Algoformer algoformer) {
		
	}

	@Override
	public void crossedByModeAlternalTerrestrial(Algoformer algoformer) {
		
	}

	@Override
	public void crossedByModeAlternalAerial(Algoformer algoformer) {
		algoformer.reduceAttackPowerFortyPercent();
	}

}
