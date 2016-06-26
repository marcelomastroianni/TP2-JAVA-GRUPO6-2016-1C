package fiuba.algo3.model.bonus;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.GameConstants;

public class BonusDobleCannon implements Bonus{

	private Position position;

	public BonusDobleCannon(Position position){
		this.position = position;
	}

	public static BonusDobleCannon createCanonBonus(Position position){
		return new BonusDobleCannon(position);
	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public void collideWithAlgoformer(Content algoformer) {
		Algoformer algo = (Algoformer) algoformer;
		algo.dobleDamage(GameConstants.BONUS_DOBLE_CANNON_TURNS);
	}

}
