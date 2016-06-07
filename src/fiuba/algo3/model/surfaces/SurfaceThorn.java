package fiuba.algo3.model.surfaces;


import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;

public class SurfaceThorn implements Surface {
	
	private boolean terrestial;
	
	@Override
	public boolean canBeCrossedBy(ModeHumanoid modeHumanoid) {
		terrestial = true;
		return true;
	}

	@Override
	public boolean canBeCrossedBy(ModeAlternalTerrestrial modeAlternalTerrestrial) {
		terrestial = true;
		return true;
	}

	@Override
	public boolean canBeCrossedBy(ModeAlternalAerial modeAlternalAerial) {
		terrestial = false;
		return true;
	}

	@Override
	public void BeCrossedBy(Algoformer algoformer) {
		if(terrestial){
			algoformer.reduceLife();
		}
		
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

}
