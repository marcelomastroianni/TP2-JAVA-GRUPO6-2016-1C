package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;
import fiuba.algo3.model.surfaces.Surface;

public class SuperficiePantano implements Surface {

	@Override
	public boolean canBeCrossedByModeHumanoid() {
		return false;
	}

	@Override
	public boolean canBeCrossedByModeAlternalTerrestrial() {
		return true;
	}

	@Override
	public boolean canBeCrossedByModeAlternalAerial() {
		return true;
	}

	@Override
	public void crossedByModeHumanoid(Algoformer algoformer) {
		algoformer.reduceSpeedFiftyPercent();
	}

	@Override
	public void crossedByModeAlternalTerrestrial(Algoformer algoformer) {
		algoformer.reduceSpeedFiftyPercent();		
	}

	@Override
	public void crossedByModeAlternalAerial(Algoformer algoformer) {
		
	}


}
