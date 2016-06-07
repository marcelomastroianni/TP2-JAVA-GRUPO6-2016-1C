package fiuba.algo3.algoformers.game;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.*;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Player;


public class PlayerTest {


	@Test
	public void testAgregarAlgoformers(){
		Player jugador =  new Player();
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
	public void testAlgoformerPerteneceAJugador(){
		Player jugador =  new Player();
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(0,1));
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(0,2));
		
		Algoformer menasor = AlgoFormerFactory.getMenasor(new Position(0,5));

		
		jugador.addAlgoformer(optimusPrime);
		jugador.addAlgoformer(bumblebee);
		jugador.addAlgoformer(frenzy);
		
		Assert.assertTrue("Algoformer deberia pertenecer a jugador", jugador.hasAlgoformer(optimusPrime));
		Assert.assertTrue("Algoformer deberia pertenecer a jugador", jugador.hasAlgoformer(bumblebee));
		Assert.assertTrue("Algoformer deberia pertenecer a jugador", jugador.hasAlgoformer(frenzy));
		
		Assert.assertFalse("Algoformer no deberia pertenecer a jugador", jugador.hasAlgoformer(menasor));
		
	}


}
