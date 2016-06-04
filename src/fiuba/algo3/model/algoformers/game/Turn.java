package fiuba.algo3.model.algoformers.game;

public class Turn {

	private Player activePlayer;
	private Player nonActivePlayer;

	public Turn(Player jugador1, Player jugador2) {
		activePlayer = jugador1;
		nonActivePlayer = jugador2;
	}
	public Player getActivePlayer() {
		Player active = activePlayer;
		activePlayer = nonActivePlayer;
		nonActivePlayer = active;

		return active;
	}


}
