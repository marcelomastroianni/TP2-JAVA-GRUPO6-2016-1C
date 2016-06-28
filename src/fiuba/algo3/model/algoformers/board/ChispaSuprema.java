package fiuba.algo3.model.algoformers.board;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.exceptions.ModoAlternoNoPuedeCapturarChispaSupremaException;
import fiuba.algo3.model.exceptions.NoPuedeMoverseDondeEstaOtroAlgoformerException;

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
	public void collideWithAlgoformer(Content algoformer) throws NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException {
		Algoformer algo = (Algoformer) algoformer;
		algo.collideWithChiapaSuprema();
	}

}
