package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;

public interface Surface {
	public boolean canBeCrossedByModeHumanoid();
	public boolean canBeCrossedByModeAlternalTerrestrial();
	public boolean canBeCrossedByModeAlternalAerial();
	
	public void crossedByModeHumanoid(Algoformer algoformer);
	public void crossedByModeAlternalTerrestrial(Algoformer algoformer);
	public void crossedByModeAlternalAerial(Algoformer algoformer);
}
