package fiuba.algo3.model.bonus;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;

public class FlashBonus implements Bonus {

	private Position position;

	public FlashBonus(Position position){
		this.position = position;
	}

	public static FlashBonus createBonusFlash(Position position){
		return new FlashBonus(position);
	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public void collideWithAlgoformer(Content algoformer) {
		Algoformer algo = (Algoformer) algoformer;
		algo.haste(3);
	}

}
