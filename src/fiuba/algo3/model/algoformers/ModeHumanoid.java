package fiuba.algo3.model.algoformers;

import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.exceptions.GameOverException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.surfaces.Surface;

public class ModeHumanoid extends Mode {

	public ModeHumanoid( Integer attack, Integer strikingDistance, Integer speed) {
		super(attack,strikingDistance,speed);
	}

	@Override
	public boolean canCrossSurface(Surface surface) {
		return surface.canBeCrossedByModeHumanoid();
	}

	@Override
	public void crossSurface(Surface surface, Algoformer algoformer) {
		surface.crossedByModeHumanoid(algoformer);
	}

	@Override
	public void collideWithChispaSuprema(Algoformer algoformer) throws  InvalidPositionException, GameOverException {
		algoformer.notifyCathChispaSuprema();
		
	}
}