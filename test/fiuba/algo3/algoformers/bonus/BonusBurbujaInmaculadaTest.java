package fiuba.algo3.algoformers.bonus;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.algoformers.game.Turn;
import fiuba.algo3.model.bonus.BonusBurbujaInmaculada;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeJugarCuandoNoEsSuTurnoException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerAQuienDispararException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class BonusBurbujaInmaculadaTest {
	int BOARD_X_LENGTH = 20;
	int BOARD_Y_LENGTH = 20;
	
	private void prepareGame(Game game) throws InvalidPositionException{
		Player player1 = new Player();
		Player player2 = new Player();
		Board board = new Board(BOARD_X_LENGTH,BOARD_Y_LENGTH);
		Turn turn = new Turn(player1, player2);
		
		//Autobots:
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(3,0));
												
		player1.addAlgoformer(optimusPrime);
		player2.addAlgoformer(megatron);
		
		//Autobots:
		board.add(optimusPrime);
		
		//Decepticons:
		board.add(megatron);
		
		game.setBoard(board);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setTurn(turn);
	}
	
	@Test
	public void testCapturarBonusBurbujaInmaculada() throws  UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, InvalidPositionException, AlgoformerUsadoEsteTurnoException{
		Game game = new Game();		
		prepareGame(game);
		
		game.getBoard().add(new BonusBurbujaInmaculada (new Position(1,0)));
		
		Player jugador1 = game.getPlayer1();		
		Player jugador2 = game.getPlayer2();	
	
		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();	
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		Algoformer algofomerJugador2 = algoformersJugador2.get(0);
		
		
		Assert.assertTrue("Algoformer 1 deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		Assert.assertTrue("Algoformer 2 deberia estar en la posicion (3,0)",algofomerJugador2.getPosition().equals(new Position(3,0)));
		
		Assert.assertEquals("Vida de Algoformer 1 deberia ser 500", 500, algofomerJugador1.getLife());
		Assert.assertEquals("Vida de Algoformer 2 deberia ser 550", 550, algofomerJugador2.getLife());
		
		//Turno Jugador 1
				
		game.moverAlgoformer(new Position(0,0),new Position(4,0));
		
		Assert.assertTrue("Algoformer 1 deberia estar en la posicion (2,0)",algofomerJugador1.getPosition().equals(new Position(2,0)));
		Assert.assertTrue("Algoformer 2 deberia estar en la posicion (3,0)",algofomerJugador2.getPosition().equals(new Position(3,0)));
		
		Assert.assertEquals("Vida de Algoformer 1 deberia ser 500", 500, algofomerJugador1.getLife());
		Assert.assertEquals("Vida de Algoformer 2 deberia ser 550", 550, algofomerJugador2.getLife());
		
		game.nextTurn();
		//Turno Jugador 2
		
		game.dispararaAlgoformer( new Position(3,0), new Position(2,0));
		
		Assert.assertEquals("Vida de Algoformer 1 deberia ser 500", 500, algofomerJugador1.getLife());
		Assert.assertEquals("Vida de Algoformer 2 deberia ser 550", 550, algofomerJugador2.getLife());
		
		game.nextTurn();
		//Turno Jugador 1
		
		game.nextTurn();
		//Turno Jugador 2
		
		game.dispararaAlgoformer( new Position(3,0), new Position(2,0));
		
		Assert.assertEquals("Vida de Algoformer 1 deberia ser 500", 500, algofomerJugador1.getLife());
		Assert.assertEquals("Vida de Algoformer 2 deberia ser 550", 550, algofomerJugador2.getLife());
		
		
		game.nextTurn();
		//Turno Jugador 1
		
		game.nextTurn();
		//Turno Jugador 2
		
		game.dispararaAlgoformer( new Position(3,0), new Position(2,0));
		
		Assert.assertEquals("Vida de Algoformer 1 deberia ser 490", 490, algofomerJugador1.getLife());
		Assert.assertEquals("Vida de Algoformer 2 deberia ser 550", 550, algofomerJugador2.getLife());
		
		
	}
}
