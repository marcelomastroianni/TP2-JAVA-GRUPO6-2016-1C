package fiuba.algo3.algoformers.bonus;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.Bonus;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;

public class BonusFlash implements Bonus {

	private Position position;
	
	private BonusFlash(Position position){
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
		Algoformer algo = (Algoformer)algoformer;
		if (!algo.flash())
		{
			algo.haste(3);
		}
	}

}
