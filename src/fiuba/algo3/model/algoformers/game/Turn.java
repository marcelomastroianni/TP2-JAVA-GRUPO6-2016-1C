package fiuba.algo3.model.algoformers.game;

public class Turn {

	private Player activePlayer;
	private Player nonActivePlayer;

	public Turn(Player jugador1, Player jugador2) {
		this.activePlayer = jugador1;
		this.nonActivePlayer = jugador2;
	}

	
	public boolean isActivePlayer(Player player){
		return this.activePlayer.equals(player);
	}
	
	public void next() {
		Player active = this.activePlayer;
		this.activePlayer = this.nonActivePlayer;
		this.nonActivePlayer = active;		
		
		this.activePlayer.notifyNextTurn();
	}


}
