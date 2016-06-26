package fiuba.algo3.model.algoformers;

import fiuba.algo3.model.exceptions.ModoAlternoNoPuedeCapturarChispaSupremaException;
import fiuba.algo3.model.surfaces.Surface;

public class ModeAlternalAerial extends Mode{

	public ModeAlternalAerial(Integer attack, Integer strikingDistance, Integer speed) {
		super(attack,strikingDistance,speed);
	}

	@Override
	public boolean canCrossSurface(Surface surface) {
		return surface.canBeCrossedByModeAlternalAerial();
	}

	@Override
	public void crossSurface(Surface surface, Algoformer algoformer) {
		surface.crossedByModeAlternalAerial(algoformer);
	}

	@Override
	public void collideWithChispaSuprema(Algoformer algoformer) throws ModoAlternoNoPuedeCapturarChispaSupremaException {
		throw new ModoAlternoNoPuedeCapturarChispaSupremaException();
	}
}