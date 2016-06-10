package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;

public class SurfaceCloud  implements Surface{

	@Override
	public boolean canBeCrossedBy(ModeHumanoid modeHumanoid) {
		return false;
	}

	@Override
	public boolean canBeCrossedBy(ModeAlternalAerial modeAlternalAerial) {
		return true;
	}

	@Override
	public boolean canBeCrossedBy(ModeAlternalTerrestrial modeAlternalTerrestrial) {
		return false;
	}

	@Override
	public void BeCrossedBy(Algoformer algoformer) {
		// TODO Auto-generated method stub
		
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
