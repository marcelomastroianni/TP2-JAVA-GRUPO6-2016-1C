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
	public void superionTurnTes() throws AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, MuyLejosException, InvalidPositionException {
		Assert.assertEquals(game.getActivePlayer(),player1);
		game.combinar();
		Assert.assertTrue(game.getBoard().getContent(new Position(0,1)) instanceof Nothing);
		Assert.assertTrue(game.getBoard().getContent(new Position(0,2)) instanceof Nothing);
		Algoformer algoformerCombinado = (Algoformer) board.getContent(new Position(0,0));
		Assert.assertEquals( algoformerCombinado.getNombre(),"Superion");
		Assert.assertEquals(algoformerCombinado.getSpeed(),3);


		Assert.assertEquals(player1.getAlgoformers().size(), 1);
		Assert.assertEquals(player1.getAlgoformers().get(0).getNombre(), "Superion");

		Assert.assertTrue(algoformerCombinado.isCombined());
		try{
			algoformerCombinado.move(new Position(0,3), board);

		}catch(AlgoformerAtrapadoEsteTurnoException e){}
		Assert.assertEquals(new Position(0,0), algoformerCombinado.getPosition());

		game.nextTurn();

		//primer turno jugador2
		Assert.assertEquals(game.getActivePlayer(),player2);
		game.nextTurn();

		//primer turno jugador 1
		Assert.assertEquals(game.getActivePlayer(),player1);
		Assert.assertEquals(algoformerCombinado.getPlayer(), player1);
		Assert.assertTrue(algoformerCombinado.isCombined());
		try{
			algoformerCombinado.move(new Position(0,3), board);
		}catch(AlgoformerAtrapadoEsteTurnoException e){}
		Assert.assertEquals(new Position(0,0), algoformerCombinado.getPosition());
		game.nextTurn();

		//segundo turno jugador 2
		Assert.assertEquals(game.getActivePlayer(),player2);
		game.nextTurn();

		//segundo turno jugador 1
		Assert.assertEquals(game.getActivePlayer(),player1);
		Assert.assertEquals(algoformerCombinado.getPlayer(), player1);
		Assert.assertTrue(algoformerCombinado.isCombined());
		try{
			algoformerCombinado.move(new Position(0,3), board);
		}catch(AlgoformerAtrapadoEsteTurnoException e){}
		Assert.assertEquals(new Position(0,0), algoformerCombinado.getPosition());
		game.nextTurn();

		//tercer turno jugador 2
		Assert.assertEquals(game.getActivePlayer(),player2);
		game.nextTurn();

		//tercer turno jugador 1
		Assert.assertEquals(game.getActivePlayer(),player1);
		Assert.assertEquals(algoformerCombinado.getPlayer(), player1);
		Assert.assertFalse(algoformerCombinado.isCombined());
		try{
			algoformerCombinado.move(new Position(0,3), board);
		}catch(AlgoformerAtrapadoEsteTurnoException e){}
		Assert.assertEquals(new Position(0,3), algoformerCombinado.getPosition());
		game.nextTurn();

	}

	@Test
	public void menasorTurnTest() throws InvalidPositionException, AlgoformerAtrapadoEsteTurnoException, UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, AlgoformerUsadoEsteTurnoException, MuyLejosException{
		game.nextTurn();

		Assert.assertEquals(game.getActivePlayer(),player2);
		game.combinar();
		Assert.assertTrue(game.getBoard().getContent(new Position(9,1)) instanceof Nothing);
		Assert.assertTrue(game.getBoard().getContent(new Position(9,2)) instanceof Nothing);

		Algoformer algoformerCombinado = (Algoformer) board.getContent(new Position(9,0));
		Assert.assertEquals(algoformerCombinado.getNombre(), "Menasor");
		Assert.assertEquals(algoformerCombinado.getSpeed(), 2);

		Assert.assertEquals(player2.getAlgoformers().size(), 1);
		Assert.assertEquals(player2.getAlgoformers().get(0).getNombre(), "Menasor");

		Assert.assertTrue(algoformerCombinado.isCombined());
		try{
			algoformerCombinado.move(new Position(9,1), board);
		}catch(AlgoformerAtrapadoEsteTurnoException e){}
		Assert.assertEquals(new Position(9,0), algoformerCombinado.getPosition());
		game.nextTurn();

		//primer turno jugador1
		Assert.assertEquals(game.getActivePlayer(),player1);
		game.nextTurn();

		//primer turno jugador2
		Assert.assertEquals(game.getActivePlayer(),player2);
		Assert.assertTrue(algoformerCombinado.isCombined());
		try{
			algoformerCombinado.move(new Position(9,1), board);
		}catch(AlgoformerAtrapadoEsteTurnoException e){}

		Assert.assertEquals(new Position(9,0), algoformerCombinado.getPosition());
		game.nextTurn();

		//segundo turno jugador1
		Assert.assertEquals(game.getActivePlayer(),player1);
		game.nextTurn();

		//segundo turno jugador 2
		Assert.assertTrue(algoformerCombinado.isCombined());
		try{
			algoformerCombinado.move(new Position(9,1), board);
		}catch(AlgoformerAtrapadoEsteTurnoException e){}
		Assert.assertEquals(new Position(9,0), algoformerCombinado.getPosition());
		game.nextTurn();

		//tercer turno jugador1
		Assert.assertEquals(game.getActivePlayer(),player1);
		game.nextTurn();

		//tercer turno jugador2
		Assert.assertFalse(algoformerCombinado.isCombined());
		try{
			algoformerCombinado.move(new Position(9,1), board);
		}catch(AlgoformerAtrapadoEsteTurnoException e){}
		Assert.assertEquals(new Position(9,1), algoformerCombinado.getPosition());
		game.nextTurn();

	}


	@Test
	public void testCanMergeVerticalLine(){
		Position position1 = new Position(0,0);
		Position position2 = new Position(0,1);
		Position position3 = new Position(0,2);
		Assert.assertTrue(optimusPrime.canMerge(position2, position3));
		Assert.assertTrue(bumblebee.canMerge(position1, position3));
		Assert.assertTrue(ratchet.canMerge(position1, position2));

	}

	@Test
	public void testCanMergeHorizontalLine(){
		Position position1 = new Position(0,0);
		Position position2 = new Position(1,0);
		Position position3 = new Position(2,0);

		Algoformer algo1 = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer algo2 = AlgoFormerFactory.getBumblebee(new Position(1,0));
		Algoformer algo3 = AlgoFormerFactory.getRatchet(new Position(2,0));

		Assert.assertTrue(algo1.canMerge(position2, position3));
		Assert.assertTrue(algo2.canMerge(position1, position3));
		Assert.assertTrue(algo3.canMerge(position1, position2));

	}


	@Test
	public void testCanMergeInL(){
		Position position1 = new Position(0,0);
		Position position2 = new Position(1,0);
		Position position3 = new Position(1,1);

		Algoformer algo1 = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer algo2 = AlgoFormerFactory.getBumblebee(new Position(1,0));
		Algoformer algo3 = AlgoFormerFactory.getRatchet(new Position(1,1));

		Assert.assertTrue(algo1.canMerge(position2, position3));
		Assert.assertTrue(algo2.canMerge(position1, position3));
		Assert.assertTrue(algo3.canMerge(position1, position2));

	}

	@Test
	public void testCantMergeDistance2(){
		Position position1 = new Position(0,0);
		Position position2 = new Position(1,0);
		Position position3 = new Position(3,0);
		Algoformer algo1 = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer algo2 = AlgoFormerFactory.getBumblebee(new Position(1,0));
		Algoformer algo3 = AlgoFormerFactory.getRatchet(new Position(3,0));

		Assert.assertFalse(algo1.canMerge(position2, position3));
		Assert.assertFalse(algo2.canMerge(position1, position3));
		Assert.assertFalse(algo3.canMerge(position1, position2));

	}
	@Test
	public void testCantMergeDistance2inL(){
		Position position1 = new Position(0,0);
		Position position2 = new Position(1,0);
		Position position3 = new Position(1,2);

		Algoformer algo1 = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer algo2 = AlgoFormerFactory.getBumblebee(new Position(1,0));
		Algoformer algo3 = AlgoFormerFactory.getRatchet(new Position(1,2));

		Assert.assertFalse(algo1.canMerge(position2, position3));
		Assert.assertFalse(algo2.canMerge(position1, position3));
		Assert.assertFalse(algo3.canMerge(position1, position2));

	}

	@Test
	public void cantMerge() throws InvalidPositionException, AlgoformerAtrapadoEsteTurnoException, UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, AlgoformerUsadoEsteTurnoException, MuyLejosException{
		//primer turno jugador1
		Assert.assertEquals(game.getActivePlayer(),player1);
		game.moverAlgoformer(new Position(0,2), new Position(0,3));
		game.nextTurn();

		//primer turno jugador 2
		Assert.assertEquals(game.getActivePlayer(),player2);
		game.nextTurn();

		//primer turno jugador1
		Assert.assertEquals(game.getActivePlayer(),player1);
		game.combinar();

		Assert.assertEquals(player1.getAlgoformers().size(), 3);
		Assert.assertTrue(board.getContent(new Position(0,0)) instanceof Algoformer);
		Assert.assertTrue(board.getContent(new Position(0,1)) instanceof Algoformer);
		Assert.assertTrue(board.getContent(new Position(0,3)) instanceof Algoformer);
	}




}
