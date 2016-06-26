package fiuba.algo3.model.bonus;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.GameConstants;

public class BonusFlash implements Bonus {

	private Position position;

	public BonusFlash(Position position){
		this.position = position;
	}

	public static BonusFlash createBonusFlash(Position position){
		return new BonusFlash(position);
	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public void collideWithAlgoformer(Content algoformer) {
		Algoformer algo = (Algoformer) algoformer;
		algo.haste(GameConstants.BONUS_FLASH_TURNS);
	}

}
