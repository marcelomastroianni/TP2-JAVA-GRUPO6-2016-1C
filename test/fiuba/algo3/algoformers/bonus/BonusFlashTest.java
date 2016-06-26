package fiuba.algo3.algoformers.bonus;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.algoformers.game.Turn;
import fiuba.algo3.model.bonus.FlashBonus;
import fiuba.algo3.model.exceptions.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BonusFlashTest {
	int BOARD_X_LENGTH = 20;
	int BOARD_Y_LENGTH = 20;

	private void prepareGame(Game game) throws InvalidPositionException{
		Player player1 = new Player(game, "Juan");
		Player player2 = new Player(game, "Maria");
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
	public void testCapturarBonusFlash() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException {
		Game game = new Game();
		prepareGame(game);

		game.getBoard().add(FlashBonus.createBonusFlash(new Position(1,0)));

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);

		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		Assert.assertEquals("Velocidad de Algoformer deberia ser 2", 2, algofomerJugador1.getSpeed());
		game.moverAlgoformer(new Position(0,0),new Position(4,0));
		game.nextTurn();
		game.nextTurn();
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,0)",algofomerJugador1.getPosition().equals(new Position(2,0)));
		game.moverAlgoformer(new Position(2,0),new Position(8,0));
		Assert.assertTrue("Algoformer deberia estar en la posicion (8,0)",algofomerJugador1.getPosition().equals(new Position(8,0)));
	}
}
