package fiuba.algo3.model.surfaces;


import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;

public class SurfaceThorn implements Surface {
	
	@Override
	public boolean canBeCrossedByModeHumanoid() {
		return true;
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
		return true;
	}

	@Override
	public boolean reduceLifeFiftyPercentModeAlternalTerrestrial() {
		return true;
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
		return false;
	}


}
