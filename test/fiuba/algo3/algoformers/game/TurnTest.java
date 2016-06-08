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
		
		Assert.assertEquals("Jugador activo deberia ser jugador 1", jugador1,turno.getActivePlayer());
		Assert.assertEquals("Jugador activo deberia ser jugador 1", jugador1,turno.getActivePlayer());
		turno.next();
		Assert.assertEquals("Jugador activo deberia ser jugador 2", jugador2,turno.getActivePlayer());
		Assert.assertEquals("Jugador activo deberia ser jugador 2", jugador2,turno.getActivePlayer());
		turno.next();
		Assert.assertEquals("Jugador activo deberia ser jugador 1", jugador1,turno.getActivePlayer());
		Assert.assertEquals("Jugador activo deberia ser jugador 1", jugador1,turno.getActivePlayer());		
	}


}
