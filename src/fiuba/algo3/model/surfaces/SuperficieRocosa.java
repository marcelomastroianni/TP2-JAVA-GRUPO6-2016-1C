package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;



public class SuperficieRocosa implements Surface {


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

}
