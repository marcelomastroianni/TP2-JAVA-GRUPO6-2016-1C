package fiuba.algo3.algoformers.game;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.*;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.exceptions.JugadorNoPuedeMoverAlgoformerQueNoEsSuyoException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerParaMoverException;



public class GameTest {


	@Test
	public void testGame(){
		Game game = new Game();		
		game.init();
		
		Player jugador1 = game.getPlayer1();
		Assert.assertTrue("El juego deberia tener un jugador 1",jugador1!=null);
		
		Player jugador2 = game.getPlayer2();			
		Assert.assertTrue("El juego deberia tener un jugador 2",jugador2!=null);
		
		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		Assert.assertEquals("Jugador 1 deberia tener 3 algoformers",3,algoformersJugador1.size());
		
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();			
		Assert.assertEquals("Jugador 2 deberia tener 3 algoformers",3,algoformersJugador2.size());
		
		Board tablero = game.getBoard();
		Assert.assertTrue("El juego deberia tener un tablero",tablero!=null);
		
		Position posicionCentral = tablero.getCentralPosition();
		Assert.assertTrue("El tablero deberia tener una posicion central",posicionCentral!=null);
		
		Assert.assertTrue("La chispa suprema deberia estar en el centro del tablero",tablero.getContent(posicionCentral) instanceof ChispaSuprema );
	
		Assert.assertTrue("Los algoformers deberian estar en los extremos del tablero",tablero.getContent(new Position(0,0)) instanceof Algoformer );
		Assert.assertTrue("Los algoformers deberian estar en los extremos del tablero",tablero.getContent(new Position(0,1)) instanceof Algoformer );
		Assert.assertTrue("Los algoformers deberian estar en los extremos del tablero",tablero.getContent(new Position(0,2)) instanceof Algoformer );
		
		Assert.assertTrue("Los algoformers deberian estar en los extremos del tablero",tablero.getContent(new Position(tablero.getXLength()-1,0)) instanceof Algoformer );
		Assert.assertTrue("Los algoformers deberian estar en los extremos del tablero",tablero.getContent(new Position(tablero.getXLength()-1,1)) instanceof Algoformer );
		Assert.assertTrue("Los algoformers deberian estar en los extremos del tablero",tablero.getContent(new Position(tablero.getXLength()-1,2)) instanceof Algoformer );
	}

	@Test
	public void testMoverAlgoformer() throws JugadorNoPuedeMoverAlgoformerQueNoEsSuyoException, UsuarioNoSeleccionoAlgoformerParaMoverException{
		Game game = new Game();		
		game.init();
		
		Player jugador1 = game.getPlayer1();		
		Player jugador2 = game.getPlayer2();			
		
		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();			
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		
		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		game.moverAlgoformer(jugador1,new Position(0,0),new Position(4,0));
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,0)",algofomerJugador1.getPosition().equals(new Position(2,0)));
	}

	@Test(expected=UsuarioNoSeleccionoAlgoformerParaMoverException.class)
	public void testMoverAlgoformerUsuarioNoSeleccionoAlgoformer() throws JugadorNoPuedeMoverAlgoformerQueNoEsSuyoException, UsuarioNoSeleccionoAlgoformerParaMoverException {
		Game game = new Game();		
		game.init();
		
		Player jugador1 = game.getPlayer1();				
		
		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();			
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		
		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		game.moverAlgoformer(jugador1,new Position(1,0),new Position(4,0));		
	}

	@Test(expected=JugadorNoPuedeMoverAlgoformerQueNoEsSuyoException.class)
	public void testJugadorIntentaMoverAlgoformerQueNoEsSuyo() throws JugadorNoPuedeMoverAlgoformerQueNoEsSuyoException, UsuarioNoSeleccionoAlgoformerParaMoverException {
		Game game = new Game();		
		game.init();
		
		Player jugador1 = game.getPlayer1();	
		Player jugador2 = game.getPlayer2();	
		
		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();			
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		
		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		game.moverAlgoformer(jugador2,new Position(0,0),new Position(4,0));		
	}


}
