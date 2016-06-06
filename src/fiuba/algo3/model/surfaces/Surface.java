package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;

public interface Surface {
	public boolean canBeCrossedBy(ModeHumanoid modeHumanoid);
	public boolean canBeCrossedBy(ModeAlternalTerrestrial modeAlternalTerrestrial);
	public boolean canBeCrossedBy(ModeAlternalAerial modeAlternalAerial);
}
