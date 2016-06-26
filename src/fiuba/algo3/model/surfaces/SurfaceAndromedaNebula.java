package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.game.GameConstants;
import fiuba.algo3.model.surfaces.Surface;

public class SurfaceAndromedaNebula implements Surface {

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
		algoformer.trap(GameConstants.SURFACE_ANDROMEDA_NEBULA_TRAPS_TURNS);
	}

}
