package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;
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
	public boolean reduceSpeedFiftyPercentModeHumanoid() {
		return false;
	}

	@Override
	public boolean reduceSpeedFiftyPercentModeAlternalTerrestrial() {
		return false;
	}

	@Override
	public boolean reduceSpeedFiftyPercentModeAlternalAerial() {
		return false;
	}

	@Override
	public boolean reduceLifeFiftyPercentModeHumanoid() {
		return false;
	}

	@Override
	public boolean reduceLifeFiftyPercentModeAlternalTerrestrial() {
		return false;
	}

	@Override
	public boolean reduceLifeFiftyPercentModeAlternalAerial() {
		return false;
	}

	@Override
	public boolean traps() {
		return false;
	}
	
	@Override
	public boolean reduceAttackPowerFortyPercentModeHumanoid() {
		return false;
	}

	@Override
	public boolean reduceAttackPowerFortyPercentModeAlternalTerrestrial() {
		return false;
	}

	@Override
	public boolean reduceAttackPowerFortyPercentModeAlternalAerial() {
		return true;
	}


}
