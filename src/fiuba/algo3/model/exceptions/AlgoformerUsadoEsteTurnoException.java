package fiuba.algo3.model.exceptions;

@SuppressWarnings("serial")
public class AlgoformerUsadoEsteTurnoException extends Exception {
	public AlgoformerUsadoEsteTurnoException(){
		super("El algoformer ya fue usado en este turno");
	}
}
