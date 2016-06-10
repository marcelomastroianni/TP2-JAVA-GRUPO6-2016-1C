package fiuba.algo3.model.surfaces;


import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;

public class SurfaceThorn implements Surface {
	
	@Override
	public boolean canBeCrossedBy(ModeHumanoid modeHumanoid) {
		return true;
	}

	@Override
	public boolean canBeCrossedBy(ModeAlternalTerrestrial modeAlternalTerrestrial) {
		return true;
	}

	@Override
	public boolean canBeCrossedBy(ModeAlternalAerial modeAlternalAerial) {
		return true;
	}

	@Override
	public void BeCrossedBy(Algoformer algoformer) {
		
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
		return true;
	}

	@Override
	public boolean reduceLifeFiftyPercent(ModeAlternalTerrestrial modeAlternalTerrestrial) {
		return true;
	}

	@Override
	public boolean reduceLifeFiftyPercent(ModeAlternalAerial modeAlternalAerial) {
		return false;
	}



}
