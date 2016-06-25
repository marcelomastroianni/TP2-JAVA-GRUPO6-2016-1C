package fiuba.algo3.algoformers.game;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.model.exceptions.*;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.*;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.board.Nothing;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.algoformers.game.Turn;
import fiuba.algo3.model.bonus.Bonus;
import fiuba.algo3.model.bonus.FlashBonus;
import fiuba.algo3.model.bonus.CanonBonus;

import fiuba.algo3.model.surfaces.SurfaceThorn;



public class GameTest {

	int BOARD_X_LENGTH = 20;
	int BOARD_Y_LENGTH = 20;

	private void prepareGame(Game game) throws InvalidPositionException{
		Player player1 = new Player(game, "Juan");
		Player player2 = new Player(game, "Maria");
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
	public void testGame() throws InvalidPositionException{
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
	public void testMoverAlgoformer() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		prepareGame(game);

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);

		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		game.moverAlgoformer(new Position(0,0),new Position(4,0));
		Assert.assertEquals("Algoformer no deberia estar en la posicion (0,0)",new Nothing(new Position(0,0)),  game.getBoard().getContent(new Position(0,0)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,0)",algofomerJugador1.getPosition().equals(new Position(2,0)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (2,0)",algofomerJugador1, game.getBoard().getContent(new Position(2,0)));
	}

	@Test(expected=UsuarioNoSeleccionoAlgoformerException.class)
	public void testMoverAlgoformerUsuarioNoSeleccionoAlgoformer() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		prepareGame(game);

		Player jugador1 = game.getPlayer1();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);

		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		game.moverAlgoformer(new Position(1,0),new Position(4,0));
	}

	@Test
	public void testActivePlayer() throws InvalidPositionException {
		Game game = new Game();
		Player player1 = new Player(game, "Florencia");
		Player player2 = new Player(game, "Sofia");
		Turn turn = new Turn(player1, player2);

		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setTurn(turn);

		Assert.assertEquals(game.getActivePlayer(),player1 );
		game.nextTurn();
		Assert.assertEquals(game.getActivePlayer(),player2 );
	}

	@Test(expected=JugadorNoPuedeJugarCuandoNoEsSuTurnoException.class)
	public void testJugadorIntentaMoverAlgoformerQueNoEsSuyo() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		prepareGame(game);

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);

		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		//Turno jugador 1
		game.moverAlgoformer(new Position(0,1),new Position(4,0));

		game.nextTurn();

		//Turno jugador 2. Intenta mover algoformer de jugador 1
		game.moverAlgoformer(new Position(0,0),new Position(4,0));
	}

	@Test(expected=JugadorNoPuedeJugarCuandoNoEsSuTurnoException.class)
	public void testJugadorIntentaJugarCuandoNoEsSuTurno() throws JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		prepareGame(game);

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);

		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		//Turno jugador 1
		game.moverAlgoformer(new Position(19,0),new Position(4,0));
	}

	@Test(expected=JugadorNoPuedeJugarCuandoNoEsSuTurnoException.class)
	public void testJugadorIntentaJugarDosVecesSeguidas() throws JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		prepareGame(game);

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);

		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		//Turno jugador 1
		game.moverAlgoformer(new Position(0,0),new Position(4,0));

		game.nextTurn();

		//Turno jugador 2
		game.moverAlgoformer(new Position(0,1),new Position(4,1));
	}

	@Test
	public void testDispararAAlgoformer() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Game game = new Game();
		Player player1 = new Player(game, "Juan");
		Player player2 = new Player(game, "Maria");
		Board board = new Board(BOARD_X_LENGTH,BOARD_Y_LENGTH);
		Turn turn = new Turn(player1, player2);

		//Autobots:
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		//Decepticons:
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(1,0));

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

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		Algoformer algofomerJugador2 = algoformersJugador2.get(0);

		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (1,0)",algofomerJugador2.getPosition().equals(new Position(1,0)));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 550 puntos de vida",550,algofomerJugador2.getLife());
		//Turno jugador 1
		game.dispararaAlgoformer(new Position(0,0),new Position(1,0));

		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 500 puntos de vida",500,algofomerJugador2.getLife());

		game.nextTurn();

		//Turno jugador 2
		game.dispararaAlgoformer(new Position(1,0),new Position(0,0));

		Assert.assertEquals("Algoformer jugador 1 deberia tener 490 puntos de vida",490,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 500 puntos de vida",500,algofomerJugador2.getLife());

		game.nextTurn();
		//Turno jugador 1
		game.dispararaAlgoformer(new Position(0,0),new Position(1,0));

		Assert.assertEquals("Algoformer jugador 1 deberia tener 490 puntos de vida",490,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 450 puntos de vida",450,algofomerJugador2.getLife());
	}

	@Test
	public void testTransformaraAlgoformer() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		Player player1 = new Player(game, "Juan");
		Player player2 = new Player(game, "Maria");
		Board board = new Board(BOARD_X_LENGTH,BOARD_Y_LENGTH);
		Turn turn = new Turn(player1, player2);

		//Autobots:
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		//Decepticons:
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(1,0));

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

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		Algoformer algofomerJugador2 = algoformersJugador2.get(0);

		Assert.assertTrue("Modo algoformer 1 deberia ser humanoide", algofomerJugador1.isHumanoidMode());
		Assert.assertTrue("Modo algoformer 2 deberia ser humanoide", algofomerJugador2.isHumanoidMode());
		//Turno jugador 1
		game.transformaraAlgoformer(new Position(0,0));

		Assert.assertTrue("Modo algoformer 1 deberia ser alterno", algofomerJugador1.isAlternalMode());
		Assert.assertTrue("Modo algoformer 2 deberia ser humanoide", algofomerJugador2.isHumanoidMode());

		game.nextTurn();

		//Turno jugador 2
		game.transformaraAlgoformer(new Position(1,0));


		Assert.assertTrue("Modo algoformer 1 deberia ser alterno", algofomerJugador1.isAlternalMode());
		Assert.assertTrue("Modo algoformer 2 deberia ser alterno", algofomerJugador2.isAlternalMode());

		game.nextTurn();

		//Turno jugador 1
		game.transformaraAlgoformer(new Position(0,0));
		Assert.assertTrue("Modo algoformer 1 deberia ser humanoide", algofomerJugador1.isHumanoidMode());
		Assert.assertTrue("Modo algoformer 2 deberia ser alterno", algofomerJugador2.isAlternalMode());
	}

	@Test
	public void testJugabilidad() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		Player player1 = new Player(game, "Juan");
		Player player2 = new Player(game, "Maria");
		Board board = new Board(BOARD_X_LENGTH,BOARD_Y_LENGTH);
		Turn turn = new Turn(player1, player2);

		//Autobots:
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		//Decepticons:
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(10,0));

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

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		Algoformer algofomerJugador2 = algoformersJugador2.get(0);

		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (10,0)",algofomerJugador2.getPosition().equals(new Position(10,0)));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 550 puntos de vida",550,algofomerJugador2.getLife());


		//Turno jugador 1
		game.dispararaAlgoformer(new Position(0,0),new Position(10,0));

		//Algoformer 2 esta fuera de radio de ataque de algoformer 1
		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (10,0)",algofomerJugador2.getPosition().equals(new Position(10,0)));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 550 puntos de vida",550,algofomerJugador2.getLife());

		game.nextTurn();

		//Turno jugador 2
		game.dispararaAlgoformer(new Position(10,0),new Position(0,0));

		//Algoformer 1 esta fuera de radio de ataque de algoformer 2
		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (10,0)",algofomerJugador2.getPosition().equals(new Position(10,0)));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 550 puntos de vida",550,algofomerJugador2.getLife());

		game.nextTurn();

		//Turno jugador 1
		game.moverAlgoformer(new Position(0,0),new Position(10,0));

		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (2,0)",algofomerJugador1.getPosition().equals(new Position(2,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (10,0)",algofomerJugador2.getPosition().equals(new Position(10,0)));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 550 puntos de vida",550,algofomerJugador2.getLife());

		game.nextTurn();

		//Turno jugador 2
		game.transformaraAlgoformer(new Position(10,0));

		Assert.assertTrue("Modo algoformer 1 deberia ser humanoide", algofomerJugador1.isHumanoidMode());
		Assert.assertTrue("Modo algoformer 2 deberia ser alterno", algofomerJugador2.isAlternalMode());
		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (2,0)",algofomerJugador1.getPosition().equals(new Position(2,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (10,0)",algofomerJugador2.getPosition().equals(new Position(10,0)));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 550 puntos de vida",550,algofomerJugador2.getLife());

		game.nextTurn();

		//Turno jugador 1
		game.moverAlgoformer(new Position(2,0),new Position(10,0));

		Assert.assertTrue("Modo algoformer 1 deberia ser humanoide", algofomerJugador1.isHumanoidMode());
		Assert.assertTrue("Modo algoformer 2 deberia ser alterno", algofomerJugador2.isAlternalMode());
		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (4,0)",algofomerJugador1.getPosition().equals(new Position(4,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (10,0)",algofomerJugador2.getPosition().equals(new Position(10,0)));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 550 puntos de vida",550,algofomerJugador2.getLife());

		game.nextTurn();

		//Turno jugador 2
		game.moverAlgoformer(new Position(10,0),new Position(5,0));

		Assert.assertTrue("Modo algoformer 1 deberia ser humanoide", algofomerJugador1.isHumanoidMode());
		Assert.assertTrue("Modo algoformer 2 deberia ser alterno", algofomerJugador2.isAlternalMode());
		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (4,0)",algofomerJugador1.getPosition().equals(new Position(4,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (5,0)",algofomerJugador2.getPosition().equals(new Position(5,0)));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 550 puntos de vida",550,algofomerJugador2.getLife());

		game.nextTurn();

		//Turno jugador 1
		game.dispararaAlgoformer(new Position(4,0),new Position(5,0));

		Assert.assertTrue("Modo algoformer 1 deberia ser humanoide", algofomerJugador1.isHumanoidMode());
		Assert.assertTrue("Modo algoformer 2 deberia ser alterno", algofomerJugador2.isAlternalMode());
		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (4,0)",algofomerJugador1.getPosition().equals(new Position(4,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (5,0)",algofomerJugador2.getPosition().equals(new Position(5,0)));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 500 puntos de vida",500,algofomerJugador2.getLife());

		game.nextTurn();

		//Turno jugador 2
		game.dispararaAlgoformer(new Position(5,0),new Position(4,0));
		Assert.assertTrue("Modo algoformer 1 deberia ser humanoide", algofomerJugador1.isHumanoidMode());
		Assert.assertTrue("Modo algoformer 2 deberia ser alterno", algofomerJugador2.isAlternalMode());
		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (4,0)",algofomerJugador1.getPosition().equals(new Position(4,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (5,0)",algofomerJugador2.getPosition().equals(new Position(5,0)));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 445 puntos de vida",445,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 500 puntos de vida",500,algofomerJugador2.getLife());

	}

	@Test(expected=AlgoformerUsadoEsteTurnoException.class)
	public void testNoPuedeMoverElMismoAlgoformerEnEsteTurno() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		prepareGame(game);

		Player jugador1 = game.getPlayer1();

		//Turno jugador
		game.moverAlgoformer(new Position(0,2),new Position(1,2));
		game.transformaraAlgoformer(new Position(1,2));
	}

	@Test(expected=InvalidPositionException.class)
	public void testInvalidInitialPositionMove() throws InvalidPositionException, AlgoformerAtrapadoEsteTurnoException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerException, AlgoformerUsadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		prepareGame(game);

		game.moverAlgoformer(new Position(-1,0),new Position(2,0));
	}

	@Test(expected=InvalidPositionException.class)
	public void testInvalidFinalPositionMove() throws InvalidPositionException, AlgoformerAtrapadoEsteTurnoException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerException, AlgoformerUsadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		prepareGame(game);

		game.moverAlgoformer(new Position(0,0),new Position(0,-1));
	}

	@Test(expected=InvalidPositionException.class)
	public void testInvalidMovement() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		prepareGame(game);

		Player jugador1 = game.getPlayer1();

		//Turno jugador
		game.moverAlgoformer(new Position(0,2),new Position(-2,0));
	}

	@Test(expected=InvalidPositionException.class)
	public void testInvalidInitialPositionShot() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, AlgoformerCombinandoseEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Game game = new Game();
		prepareGame(game);

		Player jugador1 = game.getPlayer1();

		//Turno jugador
		game.dispararaAlgoformer(new Position(-1,0),new Position(2,0));
	}

	@Test(expected=InvalidPositionException.class)
	public void testInvalidFinalPositionShot() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, AlgoformerCombinandoseEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Game game = new Game();
		prepareGame(game);

		Player jugador1 = game.getPlayer1();

		//Turno jugador
		game.dispararaAlgoformer(new Position(0,0),new Position(0,-2));
	}
	@Test
	public void testColicionarConAlgoformer() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		prepareGame(game);
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(1,0));
		game.getPlayer1().addAlgoformer(bumblebee);
		game.getBoard().add(bumblebee);

		//game.getBoard().add(new CanonBonus(new Position(1,0)));

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();


		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);

		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		game.moverAlgoformer(new Position(0,0),new Position(4,0));
		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
	}

	@Test
	public void testColicionarConAlgoformerNoGeneraUnEstadoInvadido() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		prepareGame(game);
		game.getBoard().addCell(new Cell(new Position(1, 0), new SurfaceThorn()));
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(1,0));
		game.getPlayer1().addAlgoformer(bumblebee);
		game.getBoard().add(bumblebee);
		Player jugador1 = game.getPlayer1();
		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		Assert.assertEquals("Vida de Algoformer deberia ser 500",500, algofomerJugador1.getLife());
		game.moverAlgoformer(new Position(0,0),new Position(4,0));
		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		Assert.assertEquals("Superficie espina no deberia haber afecatado la vida ya que Algoformer no se pudo mover por estar ocupada la celda por otro Algoformer.",500, algofomerJugador1.getLife());
	}

	@Test
	public void testCapturarBonusDeUnaPosicionIntermediaLoBorraDelTablero() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {

		Game game = new Game();
		Player player1 = new Player(game, "Juan");
		Player player2 = new Player(game, "Maria");
		Board board = new Board(BOARD_X_LENGTH,BOARD_Y_LENGTH);
		Turn turn = new Turn(player1, player2);

		//Autobots:
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		//Decepticons:
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(1,0));

		Bonus cannonBonus = CanonBonus.createCanonBonus(new Position(0,1));

		player1.addAlgoformer(optimusPrime);
		player2.addAlgoformer(megatron);

		//Autobots:
		board.add(optimusPrime);
		//Decepticons:
		board.add(megatron);
		//DobleDamage
		board.add(cannonBonus);

		game.setBoard(board);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setTurn(turn);

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		Algoformer algofomerJugador2 = algoformersJugador2.get(0);

		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 550 puntos de vida",550,algofomerJugador2.getLife());
		Assert.assertEquals("Algoformer jugador 1 deberia tener 50 puntos de poder de ataque",50,algofomerJugador1.getAttack());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 10 puntos de poder de ataque",10,algofomerJugador2.getAttack());
		Assert.assertTrue("Bonus deberia estar en la posicion (0,1)", game.getBoard().getContent(new Position(0,1)) instanceof Bonus);

		//Turno jugador 1
		game.moverAlgoformer(new Position(0,0),new Position(0,2));
		Assert.assertFalse("Bonus no deberia estar en la posicion (0,1)", game.getBoard().getContent(new Position(0,1)) instanceof Bonus);

		game.nextTurn();
		//Turno jugador 2
		game.moverAlgoformer(new Position(1,0),new Position(2,0));

		game.nextTurn();
		//Turno jugador 1
		game.dispararaAlgoformer(new Position(0,2),new Position(2,0));

		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 450 puntos de vida",450,algofomerJugador2.getLife());

		game.nextTurn();
		//Turno jugador 2
		game.dispararaAlgoformer(new Position(2,0),new Position(0,2));

		Assert.assertEquals("Algoformer jugador 1 deberia tener 490 puntos de vida",490,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 450 puntos de vida",450,algofomerJugador2.getLife());

		game.nextTurn();
		//Turno jugador 1
		game.dispararaAlgoformer(new Position(0,2),new Position(2,0));

		Assert.assertEquals("Algoformer jugador 1 deberia tener 490 puntos de vida",490,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 350 puntos de vida",350,algofomerJugador2.getLife());
	}


	@Test
	public void testCapturarBonusDeUnaPosicionFinalLoBorraDelTablero() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		Player player1 = new Player(game, "Juan");
		Player player2 = new Player(game, "Maria");
		Board board = new Board(BOARD_X_LENGTH,BOARD_Y_LENGTH);
		Turn turn = new Turn(player1, player2);

		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(0,0));

		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(1,0));

		Bonus cannonBonus = CanonBonus.createCanonBonus(new Position(1,1));

		player1.addAlgoformer(bumblebee);
		player2.addAlgoformer(frenzy);

		board.add(bumblebee);
		board.add(frenzy);
		board.add(cannonBonus);

		game.setBoard(board);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setTurn(turn);

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		Algoformer algofomerJugador2 = algoformersJugador2.get(0);

		Assert.assertEquals("Algoformer jugador 1 deberia tener 350 puntos de vida",350,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 400 puntos de vida",400,algofomerJugador2.getLife());
		Assert.assertEquals("Algoformer jugador 1 deberia tener 40 puntos de poder de ataque",40,algofomerJugador1.getAttack());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 10 puntos de poder de ataque",10,algofomerJugador2.getAttack());
		Assert.assertTrue("Bonus deberia estar en la posicion (1,1)", game.getBoard().getContent(new Position(1,1)) instanceof Bonus);

		//Turno jugador 1
		game.dispararaAlgoformer(new Position(0,0),new Position(1,0));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 350 puntos de vida",350,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 360 puntos de vida",360,algofomerJugador2.getLife());

		game.nextTurn();
		//Turno jugador 2
		game.moverAlgoformer(new Position(1,0),new Position(1,1));
		Assert.assertFalse("Bonus no deberia estar en la posicion (1,1)", game.getBoard().getContent(new Position(1,1)) instanceof Bonus);

		game.nextTurn();
		//Turno jugador 1
		game.dispararaAlgoformer(new Position(0,0),new Position(1,1));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 350 puntos de vida",350,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 320 puntos de vida",320,algofomerJugador2.getLife());

		game.nextTurn();
		//Turno jugador 2
		game.dispararaAlgoformer(new Position(1,1),new Position(0,0));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 330 puntos de vida",330,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 320 puntos de vida",320,algofomerJugador2.getLife());
	}

	@Test
	public void testShotExceptions() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, AlgoformerCombinandoseEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Game game = new Game();
		Player player1 = new Player(game, "Carlos");
		Player player2 = new Player(game, "Brenda");
		Board board = new Board(BOARD_X_LENGTH,BOARD_Y_LENGTH);
		Turn turn = new Turn(player1, player2);

		//Autobots:
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		//Decepticons:
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(1,0));

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

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		Algoformer algofomerJugador2 = algoformersJugador2.get(0);

		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (1,0)",algofomerJugador2.getPosition().equals(new Position(1,0)));
		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 550 puntos de vida",550,algofomerJugador2.getLife());
		//Turno jugador 1
		try{
			game.dispararaAlgoformer(new Position(0,0),new Position(-1,0));
		}catch(InvalidPositionException e){}

		try{
			game.dispararaAlgoformer(new Position(5,0),new Position(1,0));
		}catch(UsuarioNoSeleccionoAlgoformerException e){}

		try{
			game.dispararaAlgoformer(new Position(1,0),new Position(0,0));
		}catch(JugadorNoPuedeJugarCuandoNoEsSuTurnoException e){}

		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (1,0)",algofomerJugador2.getPosition().equals(new Position(1,0)));
	}

	@Test
	public void testTransforExceptions() throws InvalidPositionException, AlgoformerAtrapadoEsteTurnoException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerException, AlgoformerUsadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		Player player1 = new Player(game, "Felipe");
		Player player2 = new Player(game, "Diego");
		Board board = new Board(BOARD_X_LENGTH,BOARD_Y_LENGTH);
		Turn turn = new Turn(player1, player2);

		//Autobots:
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		//Decepticons:
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(1,0));

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

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		Algoformer algofomerJugador2 = algoformersJugador2.get(0);

		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (1,0)",algofomerJugador2.getPosition().equals(new Position(1,0)));
		try{
			game.transformaraAlgoformer(new Position(-1,0));
		}catch(InvalidPositionException e){}

		try{
			game.transformaraAlgoformer(new Position(2,0));
		}catch(UsuarioNoSeleccionoAlgoformerException e){}

		try{
			game.transformaraAlgoformer(new Position(1,0));
		}catch(JugadorNoPuedeJugarCuandoNoEsSuTurnoException e){}
	}

	@Test(expected=UsuarioNoSeleccionoAlgoformerAQuienDispararException.class)
	public void testUsuarioNoSeleccionoAlgoformerAQuienDisparar() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Game game = new Game();
		prepareGame(game);

		Player jugador1 = game.getPlayer1();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);

		Assert.assertTrue("Algoformer deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		game.dispararaAlgoformer( new Position(0,0), new Position(4,0));
	}



	public void playerLostTheGame() throws InvalidPositionException{
		Game game = new Game();
		prepareGame(game);

		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());

		Player jugador1 = game.getPlayer1();
		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algoformersJugador1.get(0).getLife());
		algoformersJugador1.get(0).downHealthPoints(500,game.getBoard());

		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());

		Assert.assertEquals("Algoformer jugador 1 deberia tener 350 puntos de vida",350,algoformersJugador1.get(0).getLife());
		algoformersJugador1.get(0).downHealthPoints(350,game.getBoard());

		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());

		Assert.assertEquals("Algoformer jugador 1 deberia tener 150 puntos de vida",150,algoformersJugador1.get(0).getLife());
		algoformersJugador1.get(0).downHealthPoints(150,game.getBoard());

		Assert.assertTrue("El juego deberia estar terminado",game.isOver());
		Assert.assertEquals("Jugador 2 deberia ser el ganador",game.getPlayer2(),game.getWinner());
	}

	@Test
	public void gameOverPlayer1Win() throws InvalidPositionException{
		Game game = new Game();
		prepareGame(game);

		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());

		Player jugador2 = game.getPlayer2();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();
		Assert.assertEquals("Algoformer jugador 1 deberia tener 550 puntos de vida",550,algoformersJugador2.get(0).getLife());
		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());
		algoformersJugador2.get(0).downHealthPoints(550,game.getBoard());

		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());

		Assert.assertEquals("Algoformer jugador 1 deberia tener 200 puntos de vida",200,algoformersJugador2.get(0).getLife());
		algoformersJugador2.get(0).downHealthPoints(200,game.getBoard());

		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());
		Assert.assertEquals("Algoformer jugador 1 deberia tener 400 puntos de vida",400,algoformersJugador2.get(0).getLife());

		algoformersJugador2.get(0).downHealthPoints(400,game.getBoard());

		Assert.assertTrue("El juego deberia estar terminado",game.isOver());
		Assert.assertEquals("Jugador 1 deberia ser el ganador",game.getPlayer1(),game.getWinner());
	}

	@Test

	public void gameOverPlayer2Win() throws InvalidPositionException{
		Game game = new Game();
		prepareGame(game);

		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());

		Player jugador1 = game.getPlayer1();
		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algoformersJugador1.get(0).getLife());
		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());
		algoformersJugador1.get(0).downHealthPoints(500,game.getBoard());

		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());

		Assert.assertEquals("Algoformer jugador 1 deberia tener 350 puntos de vida",350,algoformersJugador1.get(0).getLife());
		algoformersJugador1.get(0).downHealthPoints(350,game.getBoard());

		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());
		Assert.assertEquals("Algoformer jugador 1 deberia tener 150 puntos de vida",150,algoformersJugador1.get(0).getLife());

		algoformersJugador1.get(0).downHealthPoints(150,game.getBoard());

		Assert.assertTrue("El juego deberia estar terminado",game.isOver());
		Assert.assertEquals("Jugador 1 deberia ser el ganador",game.getPlayer2(),game.getWinner());
	}

	@Test
	public void catchChispaSupremaTest() throws AlgoformerAtrapadoEsteTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();

		Player player1 = new Player(game, "Juan");
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		player1.addAlgoformer(algoformer);


		game.setPlayer1(player1);
		game.setPlayer2(new Player(game,"Maria"));

		Board board = new Board(5,5);
		board.add(algoformer);

		ChispaSuprema chispaSuprema = new ChispaSuprema(new Position(2,0));
		board.add(chispaSuprema);

		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());

		algoformer.move(new Position(2,0),board);

		Assert.assertTrue("El juego deberia estar terminado",game.isOver());
		Assert.assertEquals("Jugador 1 deberia ser el ganador",game.getPlayer1(),game.getWinner());

		Assert.assertEquals("Algoformer deberia estar en la posicion de la chispa suprema",new Position(2,0),algoformer.getPosition());
		Assert.assertEquals("La chispa suprema no deberia estar en el tablero",algoformer,board.getContent(new Position(2,0)));
	}

	@Test
	public void testPlayer2CatchChispaSupremaTest() throws AlgoformerAtrapadoEsteTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		Board board = new Board(5,5);
		Player player1 = new Player(game, "Luis");
		Player player2 = new Player(game, "Gloria");
		Turn turn = new Turn(player1, player2);

		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(1,0));
		ChispaSuprema chispaSuprema = new ChispaSuprema(new Position(2,0));


		player1.addAlgoformer(optimusPrime);
		player2.addAlgoformer(megatron);
		board.add(optimusPrime);
		board.add(megatron);
		board.add(chispaSuprema);

		game.setBoard(board);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setTurn(turn);

		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());
		game.nextTurn();
		megatron.move(new Position(2,0),board);

		Assert.assertTrue("El juego deberia estar terminado",game.isOver());
		Assert.assertEquals("Jugador 2 deberia ser el ganador",game.getPlayer2(),game.getWinner());
		Assert.assertEquals("Algoformer deberia estar en la posicion de la chispa suprema",new Position(2,0),megatron.getPosition());
		Assert.assertEquals("La chispa suprema no deberia estar en el tablero",megatron,board.getContent(new Position(2,0)));
	}

	@Test
	public void aerialModeCantCathcChispaSupremaTest() throws AlgoformerAtrapadoEsteTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		Player player1 = new Player(game, "Jose");
		Player player2 = new Player(game, "Jorge");
		Turn turn = new Turn(player1, player2);
		Algoformer algoformer = AlgoFormerFactory.getMegatron(new Position(0,0));
		player1.addAlgoformer(algoformer);

		Board board = new Board(5,5);
		board.add(algoformer);


		ChispaSuprema chispaSuprema = new ChispaSuprema(new Position(2,0));
		board.add(chispaSuprema);

		game.setBoard(board);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setTurn(turn);

		algoformer.transform();
		game.nextTurn();
		game.nextTurn();
		algoformer.move(new Position(2,0),board);

		Assert.assertFalse("El juego no deberia estar terminado",game.isOver());

		Assert.assertEquals("Algoformer deberia estar en la posicion (1,0)",algoformer,board.getContent(new Position(1,0)));

		Assert.assertEquals("Chispa suprema deberia estar en la posicion (2,0)",new Position(2,0),chispaSuprema.getPosition());
		Assert.assertEquals("Chispa suprema deberia estar en la posicion (2,0)",chispaSuprema,board.getContent(new Position(2,0)));
	}

	@Test
	public void cantCathcChispaSupremaTest() throws AlgoformerAtrapadoEsteTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Game game = new Game();
		Player player1 = new Player(game, "Juan");
		Player player2 = new Player(game, "Maria");
		Turn turn = new Turn(player1, player2);
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		player1.addAlgoformer(algoformer);

		Board board = new Board(5,5);
		board.add(algoformer);


		ChispaSuprema chispaSuprema = new ChispaSuprema(new Position(2,0));
		board.add(chispaSuprema);

		game.setBoard(board);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setTurn(turn);

		algoformer.transform();
		game.nextTurn();
		game.nextTurn();
		algoformer.move(new Position(2,0),board);


		Assert.assertEquals("Algoformer deberia estar en la posicion (1,0)",new Position(1,0),algoformer.getPosition());
		Assert.assertEquals("Algoformer deberia estar en la posicion (1,0)",algoformer,board.getContent(new Position(1,0)));

		Assert.assertEquals("Chispa suprema deberia estar en la posicion (2,0)",new Position(2,0),chispaSuprema.getPosition());
		Assert.assertEquals("Chispa suprema deberia estar en la posicion (2,0)",chispaSuprema,board.getContent(new Position(2,0)));
	}

	@Test
	public void testMatarAlgoformerLoSacaDelTablero() throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Game game = new Game();
		Player player1 = new Player(game, "Juan");
		Player player2 = new Player(game, "Maria");
		Board board = new Board(BOARD_X_LENGTH,BOARD_Y_LENGTH);
		Turn turn = new Turn(player1, player2);

		//Autobots:
		Mode humanoidMode = new ModeHumanoid(550,2,2);
		Mode alternalMode = new ModeAlternalTerrestrial(15,4,5);
		Algoformer optimusPrime = new Algoformer("Optimus Prime", humanoidMode,alternalMode,500,new Position(0,0), Algoformer.Team.AUTOBOTS);

		//Decepticons:

		Mode humanoidMode2 = new ModeHumanoid(10,3,1);
		Mode alternalMode2 = new ModeAlternalAerial(55,2,8);
		Algoformer megatron =  new Algoformer("Megatron", humanoidMode2,alternalMode2,550,new Position(1,0), Algoformer.Team.DECEPTICONS);

		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(3,3));

		player1.addAlgoformer(optimusPrime);
		player2.addAlgoformer(megatron);
		player2.addAlgoformer(frenzy);

		//Autobots:
		board.add(optimusPrime);
		//Decepticons:
		board.add(megatron);
		board.add(frenzy);

		game.setBoard(board);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setTurn(turn);

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		List<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();
		Algoformer algofomerJugador1 = algoformersJugador1.get(0);
		Algoformer algofomerJugador2 = algoformersJugador2.get(0);

		Assert.assertTrue("Algoformer jugador 1 deberia estar en la posicion (0,0)",algofomerJugador1.getPosition().equals(new Position(0,0)));
		Assert.assertTrue("Algoformer jugador 2 deberia estar en la posicion (1,0)",algofomerJugador2.getPosition().equals(new Position(1,0)));
		Assert.assertEquals("Algoformer jugador 1 deberia estar en la posicion (0,0)",algofomerJugador1, game.getBoard().getContent(new Position(0,0)));
		Assert.assertEquals("Algoformer jugador 2 deberia estar en la posicion (1,0)",algofomerJugador2, game.getBoard().getContent(new Position(1,0)));

		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 550 puntos de vida",550,algofomerJugador2.getLife());
		//Turno jugador 1
		game.dispararaAlgoformer(new Position(0,0),new Position(1,0));

		Assert.assertEquals("Algoformer jugador 1 deberia tener 500 puntos de vida",500,algofomerJugador1.getLife());
		Assert.assertEquals("Algoformer jugador 2 deberia tener 0 puntos de vida",0,algofomerJugador2.getLife());
		Assert.assertEquals("Algoformer jugador 1 deberia estar en la posicion (0,0)",algofomerJugador1, game.getBoard().getContent(new Position(0,0)));
		Assert.assertEquals("Algoformer jugador 2 no deberia estar en la posicion (1,0)",new Nothing(new Position(1,0)), game.getBoard().getContent(new Position(1,0)));
	}
}


