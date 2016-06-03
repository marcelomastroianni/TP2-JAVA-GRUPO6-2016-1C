package fiuba.algo3.algoformers.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.algoformers.game.Turn;



public class TurnTest{

	private Turn turno;
	private Game game;
	private Player jugador1;
	private Player jugador2;
	@Before
	public void setUp(){
		game = new Game();
		game.init();

		jugador1 = game.getPlayer1();
		jugador2 = game.getPlayer2();
		turno = new Turn(jugador1,jugador2);

	}

	@Test
	public void firstTurntest(){
		Assert.assertEquals("El primer turno deberia ser del primer jugador",turno.getActivePlayer(),jugador1);

	}

	@Test
	public void AlternTurntest(){
		turno.getActivePlayer();
		Assert.assertEquals("El segundo turno deberia ser del segundo jugador",turno.getActivePlayer(),jugador2);
	}

	@Test
	public void theThirdTurnIsPlayer1Again(){
		turno.getActivePlayer();
		turno.getActivePlayer();
		Assert.assertEquals("El tercer turno deberia ser del primer jugador",turno.getActivePlayer(),jugador1);
	}

}
