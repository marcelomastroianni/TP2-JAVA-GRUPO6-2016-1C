package fiuba.algo3.model.algoformers.board;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.exceptions.GameOverException;

public class ChispaSuprema implements Content {

	Position position;

	public ChispaSuprema(Position position){
		this.position = position;
	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public void collideWithAlgoformer(Content algoformer) throws GameOverException {
		Algoformer algo = (Algoformer) algoformer;
		algo.collideWithChiapaSuprema(this);

	}

}
