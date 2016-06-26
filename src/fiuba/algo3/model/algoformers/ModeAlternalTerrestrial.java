package fiuba.algo3.model.algoformers;

import fiuba.algo3.model.exceptions.ModoAlternoNoPuedeCapturarChispaSupremaException;
import fiuba.algo3.model.surfaces.Surface;

public class ModeAlternalTerrestrial extends Mode{

	public ModeAlternalTerrestrial( Integer attack, Integer strikingDistance, Integer speed) {
		super(attack,strikingDistance,speed);
	}

	@Override
	public boolean canCrossSurface(Surface surface) {
		return surface.canBeCrossedByModeAlternalTerrestrial();
	}

	@Override
	public void crossSurface(Surface surface, Algoformer algoformer) {
		surface.crossedByModeAlternalTerrestrial(algoformer);
	}

	@Override
	public void collideWithChispaSuprema(Algoformer algoformer) throws ModoAlternoNoPuedeCapturarChispaSupremaException {
		throw new ModoAlternoNoPuedeCapturarChispaSupremaException();
	}
}