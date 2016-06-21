package fiuba.algo3.model.algoformers;

import java.util.ArrayList;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.exceptions.GameOverException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
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
	public void collideWithChispaSuprema(Algoformer algoformer) throws InvalidPositionException, GameOverException {
		// en modo alterno no se puede tomar la chispa suprema
		throw new InvalidPositionException();
	}
}