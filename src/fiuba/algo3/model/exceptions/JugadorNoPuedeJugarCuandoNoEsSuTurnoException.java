package fiuba.algo3.model.exceptions;

@SuppressWarnings("serial")
public class JugadorNoPuedeJugarCuandoNoEsSuTurnoException extends Exception{
	public JugadorNoPuedeJugarCuandoNoEsSuTurnoException(){
		super("Jugador no puede jugar cuando no es su turno");
	}
}
