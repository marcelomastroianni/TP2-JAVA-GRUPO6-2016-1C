package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;

public class Air implements Surface{

	@Override
	public boolean canBeCrossedBy(ModeHumanoid modeHumanoid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canBeCrossedBy(ModeAlternalTerrestrial modeAlternalTerrestrial) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canBeCrossedBy(ModeAlternalAerial modeAlternalAerial) {
		// TODO Auto-generated method stub
		return false;
	}

}
