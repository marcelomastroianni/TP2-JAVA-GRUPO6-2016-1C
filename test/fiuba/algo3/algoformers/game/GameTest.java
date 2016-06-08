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
import fiuba.algo3.model.algoformers.game.Turn;
import fiuba.algo3.model.exceptions.JugadorNoPuedeJugarCuandoNoEsSuTurnoException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeMoverAlgoformerQueNoEsSuyoException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerParaMoverException;



public class GameTest {

	int BOARD_X_LENGTH = 20;
	int BOARD_Y_LENGTH = 20;
	
	private void prepareGame(Game game){
		Player player1 = new Player();
		Player player2 = new Player();
		Board board = new Board(BOARD_X_LENGTH,BOARD_Y_LENGTH);
		Turn turn = new Turn(player1, player2);
		
		//Autobots:
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(0,1));
		Algoformer ratchet = AlgoFormerFactory.getRatchet(new Position(0,2));	
								
		//Decepticons:
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(board.getXLength()-1,0));		
		Algoformer bonecrusher = AlgoFormerFactory.getBonecrusher(new Position(board.getXLength()-1,1));
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(board.getXLength()-1,2));
								
		player1.addAlgoformer(optimusPrime);
		player1.addAlgoformer(bumblebee);
		player1.addAlgoformer(ratchet);
		
		player2.addAlgoformer(megatron);
		player2.addAlgoformer(bonecrusher);
		player2.addAlgoformer(frenzy);
		
		ChispaSuprema chispaSuprema = new ChispaSuprema(board.getCentralPosition());
		
		board.add(chispaSuprema);
		
		//Autobots:
		board.add(optimusPrime);
		board.add(bumblebee);
		board.add(ratchet);
		
		//Decepticons:
		board.add(megatron);
		board.add(bonecrusher);
		board.add(frenzy);
		
		game.setBoard(board);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setTurn(turn);
	}
	
	
	
	@Test
	public void testGame(){
		Game game = new Game();		
		prepareGame(game);
		
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
	public void testMoverAlgoformer() throws JugadorNoPuedeMoverAlgoformerQueNoEsSuyoException, UsuarioNoSeleccionoAlgoformerParaMoverException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException{
		Game game = new Game();		
		prepareGame(game);
		
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
	public void testMoverAlgoformerUsuarioNoSeleccionoAlgoformer() throws JugadorNoPuedeMoverAlgoformerQueNoEsSuyoException, UsuarioNoSeleccionoAlgoformerParaMoverException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException {
		Game game = new Game();		
		prepareGame(game);
		
		Player jugador1 = game.getPlayer1();				
		
		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();			
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		
		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		game.moverAlgoformer(jugador1,new Position(1,0),new Position(4,0));		
	}

	@Test(expected=JugadorNoPuedeMoverAlgoformerQueNoEsSuyoException.class)
	public void testJugadorIntentaMoverAlgoformerQueNoEsSuyo() throws JugadorNoPuedeMoverAlgoformerQueNoEsSuyoException, UsuarioNoSeleccionoAlgoformerParaMoverException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException {
		Game game = new Game();		
		prepareGame(game);
		
		Player jugador1 = game.getPlayer1();	
		Player jugador2 = game.getPlayer2();	
		
		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();			
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		
		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		//Turno jugador 1
		game.moverAlgoformer(jugador1,new Position(0,1),new Position(4,0));
		//Turno jugador 2. Intenta mover algoformer de jugador 1
		game.moverAlgoformer(jugador2,new Position(0,0),new Position(4,0));		
	}

	@Test(expected=JugadorNoPuedeJugarCuandoNoEsSuTurnoException.class)
	public void testJugadorIntentaJugarCuandoNoEsSuTurno() throws JugadorNoPuedeJugarCuandoNoEsSuTurnoException,JugadorNoPuedeMoverAlgoformerQueNoEsSuyoException, UsuarioNoSeleccionoAlgoformerParaMoverException {
		Game game = new Game();		
		prepareGame(game);
		
		Player jugador1 = game.getPlayer1();	
		Player jugador2 = game.getPlayer2();	
		
		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();			
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		
		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		//Turno jugador 1
		game.moverAlgoformer(jugador2,new Position(5,0),new Position(4,0));		
	}
	
	@Test(expected=JugadorNoPuedeJugarCuandoNoEsSuTurnoException.class)
	public void testJugadorIntentaJugarDosVecesSeguidas() throws JugadorNoPuedeJugarCuandoNoEsSuTurnoException,JugadorNoPuedeMoverAlgoformerQueNoEsSuyoException, UsuarioNoSeleccionoAlgoformerParaMoverException {
		Game game = new Game();		
		prepareGame(game);
		
		Player jugador1 = game.getPlayer1();	
		Player jugador2 = game.getPlayer2();	
		
		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();			
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		
		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		//Turno jugador 1
		game.moverAlgoformer(jugador1,new Position(0,0),new Position(4,0));
		//Turno jugador 2
		game.moverAlgoformer(jugador1,new Position(0,1),new Position(4,1));
	}

}
