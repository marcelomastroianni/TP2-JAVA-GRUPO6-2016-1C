package fiuba.algo3.algoformers.game;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.*;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.exceptions.InvalidPositionException;


public class PlayerTest {


	@Test
	public void testAgregarAlgoformers(){
		Game game = new Game();
		Player jugador = new Player(game, "Juan");

		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(0,1));
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(0,2));


		jugador.addAlgoformer(optimusPrime);
		jugador.addAlgoformer(bumblebee);
		jugador.addAlgoformer(frenzy);

		List<Algoformer> listaAlgoformersJugador =  jugador.getAlgoformers();

		Assert.assertEquals("Jugador deberia tener 3 algoformers", listaAlgoformersJugador.size(),3);
	}

	@Test
	public void testestGiveMeName() throws InvalidPositionException {
		Game game = new Game();
		Player player1 = new Player(game, "Mariano");
		Player player2 = new Player(game, "Daniel");

		Assert.assertEquals("Mariano",player1.getName());
		Assert.assertEquals("Daniel",player2.getName());
	}
	
	@Test
	public void testAlgoformerPerteneceAJugador(){
		Game game = new Game();
		Player jugador= new Player(game, "Juan");

		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(0,1));
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(0,2));

		Algoformer menasor = AlgoFormerFactory.getMenasor(new Position(0,5),500);


		jugador.addAlgoformer(optimusPrime);
		jugador.addAlgoformer(bumblebee);
		jugador.addAlgoformer(frenzy);

		Assert.assertTrue("Algoformer deberia pertenecer a jugador", jugador.hasAlgoformer(optimusPrime));
		Assert.assertTrue("Algoformer deberia pertenecer a jugador", jugador.hasAlgoformer(bumblebee));
		Assert.assertTrue("Algoformer deberia pertenecer a jugador", jugador.hasAlgoformer(frenzy));

		Assert.assertFalse("Algoformer no deberia pertenecer a jugador", jugador.hasAlgoformer(menasor));
	}

	@Test
	public void testKillAlgoformer() throws InvalidPositionException{
		Game game = new Game();
		game.init("Juan", "Maria");
		Player jugador = new Player(game, "Juan");

		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(0,1));
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(0,2));

		jugador.addAlgoformer(optimusPrime);
		jugador.addAlgoformer(bumblebee);
		jugador.addAlgoformer(frenzy);

		Assert.assertTrue("Algoformer deberia pertenecer a jugador", jugador.hasAlgoformer(optimusPrime));
		Assert.assertTrue("Algoformer deberia pertenecer a jugador", jugador.hasAlgoformer(bumblebee));
		Assert.assertTrue("Algoformer deberia pertenecer a jugador", jugador.hasAlgoformer(frenzy));

		optimusPrime.downHealthPoints(500,game.getBoard());

		Assert.assertFalse("Algoformer ya no deberia pertenecer a jugador", jugador.hasAlgoformer(optimusPrime));
	}

	@Test
	public void testCombinarAlgoformers() throws InvalidPositionException{
		Game game = new Game();
		game.init("Juan", "Maria");
		Player jugador = new Player(game, "Juan");

		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(0,1));
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(0,2));

		jugador.addAlgoformer(optimusPrime);
		jugador.addAlgoformer(bumblebee);
		jugador.addAlgoformer(frenzy);

		Assert.assertTrue("Algoformer deberia pertenecer a jugador", jugador.hasAlgoformer(optimusPrime));
		Assert.assertTrue("Algoformer deberia pertenecer a jugador", jugador.hasAlgoformer(bumblebee));
		Assert.assertTrue("Algoformer deberia pertenecer a jugador", jugador.hasAlgoformer(frenzy));

		jugador.combinar(AlgoFormerFactory.getMenasor(new Position(0,0),500));

		Assert.assertFalse("Algoformer no deberia pertenecer a jugador", jugador.hasAlgoformer(optimusPrime));
		Assert.assertFalse("Algoformer no deberia pertenecer a jugador", jugador.hasAlgoformer(bumblebee));
		Assert.assertFalse("Algoformer no deberia pertenecer a jugador", jugador.hasAlgoformer(frenzy));


		Assert.assertEquals("el jugador deberia tener un solo algoformer",1, jugador.getAlgoformers().size());
		Assert.assertEquals("el algoformer deberia ser mansor","Menasor", jugador.getAlgoformers().get(0).getNombre());
	}

}
