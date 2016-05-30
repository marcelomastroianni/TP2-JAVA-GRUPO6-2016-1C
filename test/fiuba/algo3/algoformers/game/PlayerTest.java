package fiuba.algo3.algoformers.game;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.*;
import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Position;


public class PlayerTest {


	@Test
	public void testAgregarAlgoformers(){
		Player jugador =  new Player();
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime();
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee();
		Algoformer frenzy = AlgoFormerFactory.getFrenzy();

		
		jugador.addAlgoformer(optimusPrime);
		jugador.addAlgoformer(bumblebee);
		jugador.addAlgoformer(frenzy);
		
		List<Algoformer> listaAlgoformersJugador =  jugador.getAlgoformers();
		
		Assert.assertEquals("Jugador deberia tener 3 algoformers", listaAlgoformersJugador.size(),3);
		
	}






}
