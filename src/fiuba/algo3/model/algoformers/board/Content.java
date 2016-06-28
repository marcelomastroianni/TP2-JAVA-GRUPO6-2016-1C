package fiuba.algo3.model.algoformers.board;

import fiuba.algo3.model.exceptions.ModoAlternoNoPuedeCapturarChispaSupremaException;
import fiuba.algo3.model.exceptions.NoPuedeMoverseDondeEstaOtroAlgoformerException;

public interface Content {


	Position getPosition();

	void collideWithAlgoformer(Content algoformer) throws NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException;


}
