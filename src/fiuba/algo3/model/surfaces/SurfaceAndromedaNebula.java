package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;
import fiuba.algo3.model.surfaces.Surface;

public class SurfaceAndromedaNebula implements Surface {

	@Override
	public boolean canBeCrossedBy(ModeHumanoid modeHumanoid) {
		return false;
	}

	@Override
	public boolean canBeCrossedBy(ModeAlternalTerrestrial modeAlternalTerrestrial) {
		return false;
	}

	@Override
	public boolean canBeCrossedBy(ModeAlternalAerial modeAlternalAerial) {
		return true;
	}

	@Override
	public void BeCrossedBy(Algoformer algoformer) {
		algoformer.trap(3);
	}

	@Override
	public boolean reduceSpeedFiftyPercent(ModeHumanoid modeHumanoid) {
		return false;
	}

	@Override
	public boolean reduceSpeedFiftyPercent(ModeAlternalTerrestrial modeAlternalTerrestrial) {
		return false;
	}

	@Override
	public boolean reduceSpeedFiftyPercent(ModeAlternalAerial modeAlternalAerial) {
		return false;
	}

	@Override
	public boolean reduceLifeFiftyPercent(ModeHumanoid modeHumanoid) {
		return false;
	}

	@Override
	public boolean reduceLifeFiftyPercent(ModeAlternalTerrestrial modeAlternalTerrestrial) {
		return false;
	}

	@Override
	public boolean reduceLifeFiftyPercent(ModeAlternalAerial modeAlternalAerial) {
		return false;
	}



}
