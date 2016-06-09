package fiuba.algo3.algoformers.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.algoformers.game.Turn;



public class TurnTest{

	@Test
	public void testNextTurn(){
		Player jugador1 = new Player();
		Player jugador2 = new Player();
		Turn turno = new Turn(jugador1,jugador2);
		
		Assert.assertTrue("Jugador activo deberia ser jugador 1", turno.isActivePlayer(jugador1));
		turno.next();
		Assert.assertTrue("Jugador activo deberia ser jugador 2", turno.isActivePlayer(jugador2));
		turno.next();
		Assert.assertTrue("Jugador activo deberia ser jugador 1", turno.isActivePlayer(jugador1));		
	}


}
