package fiuba.algo3.model.surfaces;


import fiuba.algo3.model.algoformers.Algoformer;

public class SurfaceThorn implements Surface {
	
	@Override
	public boolean canBeCrossedByModeHumanoid() {
		return true;
	}

	@Override
	public boolean canBeCrossedByModeAlternalTerrestrial() {
		return true;
	}

	@Override
	public boolean canBeCrossedByModeAlternalAerial() {
		return true;
	}

	@Override
	public void crossedByModeHumanoid(Algoformer algoformer) {
		algoformer.reduceLifeFivePercent();
	}

	@Override
	public void crossedByModeAlternalTerrestrial(Algoformer algoformer) {
		algoformer.reduceLifeFivePercent();
	}

	@Override
	public void crossedByModeAlternalAerial(Algoformer algoformer) {
	}

}
