package fiuba.algo3.model.bonus;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.GameConstants;

public class BubbleBonus implements Bonus {

	private Position position;

	public BubbleBonus(Position position){
		this.position = position;
	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public void collideWithAlgoformer(Content algoformer) {
		Algoformer algo = (Algoformer) algoformer;
		algo.protectWithImmaculateBubble(GameConstants.BONUS_INMACULATE_BUBBLE_TURNS);
	}

}
