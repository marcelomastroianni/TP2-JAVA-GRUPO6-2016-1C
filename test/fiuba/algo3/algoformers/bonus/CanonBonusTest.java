package fiuba.algo3.algoformers.bonus;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.algoformers.game.Turn;
import fiuba.algo3.model.bonus.CanonBonus;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeJugarCuandoNoEsSuTurnoException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerException;
import fiuba.algo3.model.surfaces.SuperficieRocosa;

public class CanonBonusTest {
	

	int BOARD_X_LENGTH = 20;
	int BOARD_Y_LENGTH = 20;
	
	private void prepareGame(Game game) throws InvalidPositionException{
		Player player1 = new Player();
		Player player2 = new Player();
		Board board = new Board(BOARD_X_LENGTH,BOARD_Y_LENGTH);
		Turn turn = new Turn(player1, player2);
		
		//Autobots:
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
												
		player1.addAlgoformer(optimusPrime);
		
		//Autobots:
		board.add(optimusPrime);
		
		game.setBoard(board);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setTurn(turn);
	}
	@Test
	public void createCanonBonus(){	
		CanonBonus canonBonus = CanonBonus.createCanonBonus(new Position(0,0));
		Cell cell= new Cell(new Position(0,0), new SuperficieRocosa()); 
		cell.add(canonBonus);
		Assert.assertEquals("la celda deberia contener un canonBonus",cell.getContent(), canonBonus);
	}
	
	@Test
	public void testCapturarCanonBonus() throws  UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException{
		Game game = new Game();		
		prepareGame(game);
		
		game.getBoard().add(CanonBonus.createCanonBonus(new Position(1,0)));
		
		Player jugador1 = game.getPlayer1();		
		Player jugador2 = game.getPlayer2();	
	
		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();			
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);

		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		Assert.assertEquals("El poder de ataque de algoformer deberia ser 50", new Integer(50), algofomerJugador1.getActiveMode().getAttack());
		game.moverAlgoformer(new Position(0,0),new Position(4,0));
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,0)",algofomerJugador1.getPosition().equals(new Position(2,0)));
		Assert.assertTrue("Algoformer deberia tener dobleDamage ", algofomerJugador1.isDobleDamage());
	}
	

	
}
