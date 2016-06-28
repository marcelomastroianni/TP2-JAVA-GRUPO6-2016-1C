package fiuba.algo3.model.exceptions;

@SuppressWarnings("serial")
public class NoPuedeMoverseDondeEstaOtroAlgoformerException extends Exception{
	public NoPuedeMoverseDondeEstaOtroAlgoformerException(){
		super("No puede moverse donde esta otro Algoformer");
	}
}
