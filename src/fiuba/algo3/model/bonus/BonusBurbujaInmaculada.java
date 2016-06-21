package fiuba.algo3.model.bonus;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;

public class BonusBurbujaInmaculada implements Bonus {

	private Position position;

	public BonusBurbujaInmaculada(Position position){
		this.position = position;
	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public void collideWithAlgoformer(Content algoformer) {
		Algoformer algo = (Algoformer) algoformer;
		algo.protectWithImmaculateBubble(2);
	}

}
