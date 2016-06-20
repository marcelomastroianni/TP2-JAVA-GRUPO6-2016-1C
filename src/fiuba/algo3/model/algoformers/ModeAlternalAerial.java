package fiuba.algo3.model.algoformers;

import java.util.ArrayList;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.game.Player;
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
	public void collideWithChispaSuprema(ChispaSuprema chispaSuprema, Player player) {
		// en modo alterno no se puede tomar la chispa suprema

	}
}