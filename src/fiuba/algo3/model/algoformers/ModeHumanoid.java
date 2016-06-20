package fiuba.algo3.model.algoformers;

import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.exceptions.GameOverException;
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
	public void collideWithChispaSuprema(ChispaSuprema chispaSuprema, Player winner) {
		throw new GameOverException("Felicitaciones "+ winner.getName()+" has ganado!!!!");

	}
}