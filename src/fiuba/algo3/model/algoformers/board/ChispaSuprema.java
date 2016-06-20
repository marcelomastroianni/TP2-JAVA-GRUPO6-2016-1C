package fiuba.algo3.model.algoformers.board;

import fiuba.algo3.model.algoformers.Algoformer;

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
	public void collideWithAlgoformer(Algoformer algoformer) {
		algoformer.collideWithChiapaSuprema(this);

	}

}
