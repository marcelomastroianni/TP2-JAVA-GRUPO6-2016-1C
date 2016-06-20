package fiuba.algo3.model.algoformers.board;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.exceptions.InvalidPositionException;

public interface Content {


	Position getPosition();

	void collideWithAlgoformer(Algoformer algoformer);


}
