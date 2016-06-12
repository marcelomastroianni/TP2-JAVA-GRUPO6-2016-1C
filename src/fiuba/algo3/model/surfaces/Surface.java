package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;

public interface Surface {
	public boolean canBeCrossedByModeHumanoid();
	public boolean canBeCrossedByModeAlternalTerrestrial();
	public boolean canBeCrossedByModeAlternalAerial();
	
	public boolean reduceSpeedFiftyPercentModeHumanoid();
	public boolean reduceSpeedFiftyPercentModeAlternalTerrestrial();
	public boolean reduceSpeedFiftyPercentModeAlternalAerial();
	
	public boolean reduceLifeFiftyPercentModeHumanoid();
	public boolean reduceLifeFiftyPercentModeAlternalTerrestrial();
	public boolean reduceLifeFiftyPercentModeAlternalAerial();
		
	public boolean reduceAttackPowerFortyPercentModeHumanoid();
	public boolean reduceAttackPowerFortyPercentModeAlternalTerrestrial();
	public boolean reduceAttackPowerFortyPercentModeAlternalAerial();
	
	public boolean traps();
}
