package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;

public class SuperficieNube  implements Surface{

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

}
