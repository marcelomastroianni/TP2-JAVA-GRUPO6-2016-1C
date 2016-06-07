package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;

public interface Surface {
	public boolean canBeCrossedBy(ModeHumanoid modeHumanoid);
	public boolean canBeCrossedBy(ModeAlternalTerrestrial modeAlternalTerrestrial);
	public boolean canBeCrossedBy(ModeAlternalAerial modeAlternalAerial);
	public void BeCrossedBy(Algoformer algoformer);
	
	public boolean reduceSpeedFiftyPercent(ModeHumanoid modeHumanoid);
	public boolean reduceSpeedFiftyPercent(ModeAlternalTerrestrial modeAlternalTerrestrial);
	public boolean reduceSpeedFiftyPercent(ModeAlternalAerial modeAlternalAerial);
	
	
}
