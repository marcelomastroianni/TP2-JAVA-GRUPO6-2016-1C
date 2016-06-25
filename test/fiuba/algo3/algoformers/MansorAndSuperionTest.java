package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.board.Nothing;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.algoformers.game.Turn;
import fiuba.algo3.model.exceptions.AlgoformerAtrapadoEsteTurnoException;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeJugarCuandoNoEsSuTurnoException;
import fiuba.algo3.model.exceptions.MuyLejosException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerException;

public class MansorAndSuperionTest {
	private Game game;
	private Player player1;
	private Player player2;
	private Board board;

	private Algoformer optimusPrime;
	private Algoformer bumblebee;
	private Algoformer ratchet;

	private Algoformer megatron;
	private Algoformer bonecrusher;
	private Algoformer frenzy;


	@Before
	public void setUp() throws InvalidPositionException{
		this.game = new Game();
		this.player1 = new Player(game, "Juan");
		this.player2 = new Player(game, "Maria");
		this.board = new Board(10,10);
		Turn turn = new Turn(player1, player2);

		//Autobots:
		optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		bumblebee = AlgoFormerFactory.getBumblebee(new Position(0,1));
		ratchet = AlgoFormerFactory.getRatchet(new Position(0,2));

		player1.addAlgoformer(optimusPrime);
		player1.addAlgoformer(bumblebee);
		player1.addAlgoformer(ratchet);

		board.add(optimusPrime);
		board.add(bumblebee);
		board.add(ratchet);

		//Decepticons:
		megatron = AlgoFormerFactory.getMegatron(new Position(9,0));
		bonecrusher = AlgoFormerFactory.getBonecrusher(new Position(9,1));
		frenzy = AlgoFormerFactory.getFrenzy(new Position(9,2));

		player2.addAlgoformer(megatron);
		player2.addAlgoformer(bonecrusher);
		player2.addAlgoformer(frenzy);

		board.add(megatron);
		board.add(bonecrusher);
		board.add(frenzy);

		game.setBoard(board);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setTurn(turn);
	}

	@Test
	public void combinedSuperionTest() throws InvalidPositionException, AlgoformerAtrapadoEsteTurnoException, UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, AlgoformerUsadoEsteTurnoException, MuyLejosException{
		game.combinar();
		Assert.assertTrue(game.getBoard().getContent(new Position(0,1)) instanceof Nothing);
		Algoformer algoformerCombinado = (Algoformer) game.getBoard().getContent(new Position(0,0));
		Assert.assertEquals(algoformerCombinado.getNombre(), "Superion");
		Assert.assertEquals(player1.getAlgoformers().size(), 1);
		Assert.assertEquals(player1.getAlgoformers().get(0).getNombre(), "Superion");
	}


	@Test
	public void combinedMenasorTest() throws InvalidPositionException, AlgoformerAtrapadoEsteTurnoException, UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, AlgoformerUsadoEsteTurnoException, MuyLejosException{
		//Turno jugador1
		game.moverAlgoformer(new Position(0,0), new Position(1,1));
		game.nextTurn();
		//Turno jugador 2
		game.combinar();
		Assert.assertTrue(game.getBoard().getContent(new Position(9,1)) instanceof Nothing);
		Algoformer algoformerCombinado = (Algoformer) game.getBoard().getContent(new Position(9,0));
		Assert.assertEquals(algoformerCombinado.getNombre(), "Menasor");
		Assert.assertEquals(player2.getAlgoformers().size(), 1);
		Assert.assertEquals(player2.getAlgoformers().get(0).getNombre(), "Menasor");
	}

	@Test
	public void deadAlgoformerCantMerge() throws InvalidPositionException, MuyLejosException{
		bumblebee.downHealthPoints(350, board);
		Assert.assertEquals(player1.getAlgoformers().size(), 2);
		game.combinar();
		Assert.assertEquals(player1.getAlgoformers().size(), 2);
	}


//	@Test
//	public void superionTestDistance() throws InvalidPositionException{
//		Game game = new Game();
//		Player player1 = new Player(game, "Juan");
//
//
//		Algoformer algoformer1 = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
//		Algoformer algoformer2 = AlgoFormerFactory.getBumblebee(new Position(0,1));
//		Algoformer algoformer3 = AlgoFormerFactory.getRatchet(new Position(3,3));
//
//
//		player1.addAlgoformer(algoformer1);
//		player1.addAlgoformer(algoformer2);
//		player1.addAlgoformer(algoformer3);
//
//
//		player1.mergeTransformers(new Board(10,10));
//		Assert.assertEquals(player1.getAlgoformers().size(), 3);
//	}

}
