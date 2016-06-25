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
		Algoformer algoformerCombinado = (Algoformer) board.getContent(new Position(0,0));
		Assert.assertEquals(algoformerCombinado.getNombre(), "Superion");
		Assert.assertEquals(algoformerCombinado.getSpeed(), 3);
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
		Assert.assertTrue(board.getContent(new Position(9,1)) instanceof Nothing);
		Algoformer algoformerCombinado = (Algoformer)board.getContent(new Position(9,0));
		Assert.assertEquals(algoformerCombinado.getNombre(), "Menasor");
		Assert.assertEquals(player2.getAlgoformers().size(), 1);
		Assert.assertEquals(player2.getAlgoformers().get(0).getNombre(), "Menasor");
	}

	@Test
	public void deadAlgoformerCantMerge() throws InvalidPositionException{
		bumblebee.downHealthPoints(350, board);
		Assert.assertEquals(player1.getAlgoformers().size(), 2);
		game.combinar();
		Assert.assertEquals(player1.getAlgoformers().size(), 2);
		Assert.assertTrue(board.getContent(new Position(0,0)) instanceof Algoformer);
		Assert.assertTrue(board.getContent(new Position(0,2)) instanceof Algoformer);
	}

	@Test
	public void superionTurnTes() throws InvalidPositionException, AlgoformerAtrapadoEsteTurnoException, UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, AlgoformerUsadoEsteTurnoException, MuyLejosException{
		game.combinar();
		Assert.assertTrue(game.getBoard().getContent(new Position(0,1)) instanceof Nothing);
		Assert.assertTrue(game.getBoard().getContent(new Position(0,2)) instanceof Nothing);
		Algoformer algoformerCombinado = (Algoformer) board.getContent(new Position(0,0));
		Assert.assertEquals(algoformerCombinado.getNombre(), "Superion");
		Assert.assertEquals(algoformerCombinado.getSpeed(), 3);
		Assert.assertEquals(player1.getAlgoformers().size(), 1);
		Assert.assertEquals(player1.getAlgoformers().get(0).getNombre(), "Superion");
		game.nextTurn();

		//primer turno jugador2
		Assert.assertEquals(game.getActivePlayer(),player2);
		game.nextTurn();

		//primer turno jugador 1
		Assert.assertEquals(game.getActivePlayer(),player1);
		Assert.assertEquals(algoformerCombinado.getPlayer(), player1);
		game.moverAlgoformer(new Position(0,0), new Position(3,3));
		algoformerCombinado = (Algoformer) board.getContent(new Position(3,3));
		Assert.assertEquals(algoformerCombinado.getSpeed(), 3);
		Assert.assertEquals(algoformerCombinado.getNombre(), "Superion");
		Assert.assertEquals(player1.getAlgoformers().size(), 1);
		Assert.assertEquals(player1.getAlgoformers().get(0).getNombre(), "Superion");
		game.nextTurn();

		//segundo turno jugador2
		game.nextTurn();

		//segundo turno jugador 1
		game.moverAlgoformer(new Position(3,3), new Position(3,0));
		algoformerCombinado = (Algoformer) board.getContent(new Position(3,0));
		Assert.assertEquals(algoformerCombinado.getNombre(), "Superion");
		Assert.assertEquals(player1.getAlgoformers().size(), 1);
		Assert.assertEquals(player1.getAlgoformers().get(0).getNombre(), "Superion");
		game.nextTurn();

		//tercer turno jugador2
		game.nextTurn();

		//tercer turno
		game.moverAlgoformer(new Position(3,0), new Position(3,3));
		Assert.assertEquals(player1.getAlgoformers().size(), 3);
		Assert.assertEquals(player1.getAlgoformers().get(0).getNombre(),"Optimus Prime");
		game.nextTurn();

	}

	@Test
	public void menasorTurnTest() throws InvalidPositionException, AlgoformerAtrapadoEsteTurnoException, UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, AlgoformerUsadoEsteTurnoException, MuyLejosException{
		game.nextTurn();

		game.combinar();
		Assert.assertTrue(game.getBoard().getContent(new Position(9,1)) instanceof Nothing);
		Assert.assertTrue(game.getBoard().getContent(new Position(9,2)) instanceof Nothing);
		Algoformer algoformerCombinado = (Algoformer) board.getContent(new Position(9,0));
		Assert.assertEquals(algoformerCombinado.getNombre(), "Menasor");
		Assert.assertEquals(algoformerCombinado.getSpeed(), 2);
		Assert.assertEquals(player2.getAlgoformers().size(), 1);
		Assert.assertEquals(player2.getAlgoformers().get(0).getNombre(), "Menasor");
		game.nextTurn();

		//primer turno jugador1
		Assert.assertEquals(game.getActivePlayer(),player1);
		game.nextTurn();

		//primer turno jugador2
		Assert.assertEquals(game.getActivePlayer(),player2);
		Assert.assertEquals(algoformerCombinado.getPlayer(), player2);
		game.moverAlgoformer(new Position(9,0), new Position(9,2));
		algoformerCombinado = (Algoformer) board.getContent(new Position(9,2));
		Assert.assertEquals(algoformerCombinado.getSpeed(), 2);
		Assert.assertEquals(algoformerCombinado.getNombre(), "Menasor");
		Assert.assertEquals(player2.getAlgoformers().size(), 1);
		Assert.assertEquals(player2.getAlgoformers().get(0).getNombre(), "Menasor");
		game.nextTurn();

		//segundo turno jugador1
		game.nextTurn();

		//segundo turno jugador 2
		game.moverAlgoformer(new Position(9,2), new Position(9,0));
		algoformerCombinado = (Algoformer) board.getContent(new Position(9,0));
		Assert.assertEquals(algoformerCombinado.getNombre(), "Menasor");
		Assert.assertEquals(player2.getAlgoformers().size(), 1);
		Assert.assertEquals(player2.getAlgoformers().get(0).getNombre(), "Menasor");
		game.nextTurn();

		//tercer turno jugador1
		game.nextTurn();

		//tercer turno jugador2
		game.moverAlgoformer(new Position(9,0), new Position(9,1));
		Assert.assertEquals(player1.getAlgoformers().size(), 3);
		Assert.assertEquals(player1.getAlgoformers().get(0).getNombre(),"Optimus Prime");
		game.nextTurn();

	}



}
