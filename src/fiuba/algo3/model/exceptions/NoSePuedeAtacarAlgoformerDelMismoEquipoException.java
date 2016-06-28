package fiuba.algo3.model.exceptions;

@SuppressWarnings("serial")
public class NoSePuedeAtacarAlgoformerDelMismoEquipoException extends Exception{
	public NoSePuedeAtacarAlgoformerDelMismoEquipoException(){
		super("No se puede atacar al mismo equipo");
	}
}
