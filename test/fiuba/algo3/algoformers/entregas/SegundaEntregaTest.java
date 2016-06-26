package fiuba.algo3.algoformers.entregas;

import static org.junit.Assert.*;
import java.util.List;
import fiuba.algo3.model.algoformers.*;
import fiuba.algo3.model.exceptions.*;
import fiuba.algo3.model.surfaces.SurfaceCloud;
import fiuba.algo3.model.surfaces.SuperficieRocosa;
import fiuba.algo3.model.surfaces.SurfaceAndromedaNebula;
import fiuba.algo3.model.surfaces.SurfaceThorn;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Nothing;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.algoformers.game.Turn;
import fiuba.algo3.model.surfaces.SurfacePsionicStorm;
import fiuba.algo3.model.surfaces.SuperficiePantano;

public class SegundaEntregaTest {

	/**
	 * 1. Llenar una zona rocosa, verificar que todos los algoformers en todos
	 * sus modos la atraviesen sin problemas
	 * @throws InvalidPositionException
	 * @throws AlgoformerUsadoEsteTurnoException
	 * @throws AlgoformerCombinandoseEsteTurnoException 
	 * @throws NoPuedeMoverseDondeEstaOtroAlgoformerException 
	 * @throws GameOverException
	 */
	@Test
	public void test01() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException {
		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 5), new SuperficieRocosa()));
		tablero.addCell(new Cell(new Position(2, 5), new SuperficieRocosa()));
		tablero.addCell(new Cell(new Position(3, 5), new SuperficieRocosa()));
		tablero.addCell(new Cell(new Position(4, 5), new SuperficieRocosa()));
		tablero.addCell(new Cell(new Position(5, 5), new SuperficieRocosa()));

		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(1, 5));
		tablero.add(optimus);
		Assert.assertTrue(optimus.isHumanoidMode());
		Assert.assertTrue("optimus deberia estar en la posicion (1,5)",
				optimus.getPosition().equals(new Position(1, 5)));
		optimus.move(new Position(3, 5), tablero);
		optimus.notifyNextTurn( );
		Assert.assertTrue("optimus deberia estar en la posicion (3,5)",
				optimus.getPosition().equals(new Position(3, 5)));
		optimus.transform();
		optimus.notifyNextTurn( );
		Assert.assertTrue(optimus.isAlternalMode());
		optimus.move(new Position(5, 5), tablero);
		optimus.notifyNextTurn( );
		Assert.assertTrue("optimus deberia estar en la posicion (5,5)",
				optimus.getPosition().equals(new Position(5, 5)));
		tablero.remove(optimus);

		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(1, 6));
		tablero.add(bumblebee);
		Assert.assertTrue(bumblebee.isHumanoidMode());
		Assert.assertTrue("bumblebee deberia estar en la posicion (1,6)",
				bumblebee.getPosition().equals(new Position(1, 6)));
		bumblebee.move(new Position(3, 6), tablero);
		bumblebee.notifyNextTurn( );
		Assert.assertTrue("bumblebee deberia estar en la posicion (3,6)",
				bumblebee.getPosition().equals(new Position(3, 6)));
		bumblebee.transform();
		bumblebee.notifyNextTurn( );
		Assert.assertTrue(bumblebee.isAlternalMode());
		bumblebee.move(new Position(5, 6), tablero);
		bumblebee.notifyNextTurn( );
		Assert.assertTrue("bumblebee deberia estar en la posicion (5,6)",
				bumblebee.getPosition().equals(new Position(5, 6)));
		tablero.remove(bumblebee);

		Algoformer ratchet = AlgoFormerFactory.getRatchet(new Position(1, 7));
		tablero.add(ratchet);
		Assert.assertTrue(ratchet.isHumanoidMode());
		Assert.assertTrue("ratchet deberia estar en la posicion (1,7)",
				ratchet.getPosition().equals(new Position(1, 7)));
		ratchet.move(new Position(2, 7), tablero);
		ratchet.notifyNextTurn( );
		Assert.assertTrue("ratchet deberia estar en la posicion (2,7)",
				ratchet.getPosition().equals(new Position(2, 7)));
		ratchet.transform();
		ratchet.notifyNextTurn( );
		Assert.assertTrue(ratchet.isAlternalMode());
		ratchet.move(new Position(5, 7), tablero);
		ratchet.notifyNextTurn( );
		Assert.assertTrue("ratchet deberia estar en la posicion (5,7)",
				ratchet.getPosition().equals(new Position(5, 7)));
		tablero.remove(ratchet);

		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(1, 4));
		tablero.add(megatron);
		Assert.assertTrue(megatron.isHumanoidMode());
		Assert.assertTrue("megatron deberia estar en la posicion (1,4)",
				megatron.getPosition().equals(new Position(1, 4)));
		megatron.move(new Position(2, 4), tablero);
		megatron.notifyNextTurn( );
		Assert.assertTrue("megatron deberia estar en la posicion (2,4)",
				megatron.getPosition().equals(new Position(2, 4)));
		megatron.transform();
		megatron.notifyNextTurn( );
		Assert.assertTrue(megatron.isAlternalMode());
		megatron.move(new Position(5, 4), tablero);
		megatron.notifyNextTurn( );
		Assert.assertTrue("megatron deberia estar en la posicion (5,4)",
				megatron.getPosition().equals(new Position(5, 4)));
		tablero.remove(megatron);

		Algoformer bonecrusher = AlgoFormerFactory.getBonecrusher(new Position(1, 3));
		tablero.add(bonecrusher);
		Assert.assertTrue(bonecrusher.isHumanoidMode());
		Assert.assertTrue("bonecrusher deberia estar en la posicion (1,3)",
				bonecrusher.getPosition().equals(new Position(1, 3)));
		bonecrusher.move(new Position(2, 3), tablero);
		bonecrusher.notifyNextTurn( );
		Assert.assertTrue("bonecrusher deberia estar en la posicion (2,3)",
				bonecrusher.getPosition().equals(new Position(2, 3)));
		bonecrusher.transform();
		bonecrusher.notifyNextTurn( );
		Assert.assertTrue(bonecrusher.isAlternalMode());
		bonecrusher.move(new Position(5, 3), tablero);
		bonecrusher.notifyNextTurn( );
		Assert.assertTrue("bonecrusher deberia estar en la posicion (5,3)",
				bonecrusher.getPosition().equals(new Position(5, 3)));
		tablero.remove(bonecrusher);

		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(1, 8));
		tablero.add(frenzy);
		Assert.assertTrue(frenzy.isHumanoidMode());
		Assert.assertTrue("frenzy deberia estar en la posicion (1,8)", frenzy.getPosition().equals(new Position(1, 8)));
		frenzy.move(new Position(3, 8), tablero);
		frenzy.notifyNextTurn( );
		Assert.assertTrue("frenzy deberia estar en la posicion (3,8)", frenzy.getPosition().equals(new Position(3, 8)));
		frenzy.transform();
		frenzy.notifyNextTurn( );
		Assert.assertTrue(frenzy.isAlternalMode());
		frenzy.move(new Position(5, 8), tablero);
		frenzy.notifyNextTurn( );
		Assert.assertTrue("frenzy deberia estar en la posicion (5,8)", frenzy.getPosition().equals(new Position(5, 8)));
		tablero.remove(frenzy);
	}

	/**
	 * 2. Llenar una zona pantano, verificar que en modo humanoide no se pueda
	 * atravesar.
	 * @throws InvalidPositionException
	 * @throws AlgoformerUsadoEsteTurnoException
	 * @throws AlgoformerCombinandoseEsteTurnoException 
	 * @throws NoPuedeMoverseDondeEstaOtroAlgoformerException 
	 * @throws GameOverException
	 */
	@Test
	public void test02() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException {
		Board tablero = new Board(20, 20);
		tablero.addCell(new Cell(new Position(3, 3), new SuperficiePantano()));
		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(2, 3));
		tablero.add(optimus);
		Assert.assertTrue(optimus.isHumanoidMode());
		optimus.move(new Position(3, 3), tablero);
		optimus.notifyNextTurn( );

		Assert.assertEquals("Algoformer no deberia estar en la posicion (3,3)",new Nothing(new Position(3,3)),  tablero.getContent(new Position(3, 3)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (3,3)",
				optimus.getPosition().equals(new Position(3, 3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,3)",
				optimus.getPosition().equals(new Position(2, 3)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (2,3)", tablero.getContent(new Position(2, 3)),
				optimus);

		optimus.transform();
		optimus.notifyNextTurn( );
		Assert.assertTrue(optimus.isAlternalMode());
		optimus.move(new Position(3, 3), tablero);
		optimus.notifyNextTurn( );
		Assert.assertFalse("Algoformer no deberia estar en la posicion (2,3)",
				optimus.getPosition().equals(new Position(2, 3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (3,3)",
				optimus.getPosition().equals(new Position(3, 3)));

	}

	/**
	 * 3. LLenar una zona pantano, verificar que en modo alterno las unidades
	 * terrestres tardan el doble que rocoso
	 * @throws InvalidPositionException
	 * @throws AlgoformerUsadoEsteTurnoException
	 * @throws AlgoformerCombinandoseEsteTurnoException 
	 * @throws NoPuedeMoverseDondeEstaOtroAlgoformerException 
	 * @throws GameOverException
	 */
	@Test
	public void test03() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException {

		Board tablero = new Board(20, 20);
		tablero.addCell(new Cell(new Position(3, 3), new SuperficiePantano()));
		tablero.addCell(new Cell(new Position(4, 3), new SuperficiePantano()));
		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(2, 3));
		tablero.add(optimus);

		optimus.transform();
		optimus.notifyNextTurn( );
		Assert.assertTrue(optimus.isAlternalMode());
		optimus.move(new Position(10, 3), tablero);
		optimus.notifyNextTurn( );
		Assert.assertFalse("Algoformer no deberia estar en la posicion (2,3)",
				optimus.getPosition().equals(new Position(2, 3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (5,3)",
				optimus.getPosition().equals(new Position(5, 3)));

		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(2, 8));
		tablero.add(bumblebee);
		tablero.addCell(new Cell(new Position(3, 8), new SuperficiePantano()));
		bumblebee.transform();
		bumblebee.notifyNextTurn( );
		Assert.assertTrue(bumblebee.isAlternalMode());
		bumblebee.move(new Position(10, 8), tablero);
		bumblebee.notifyNextTurn( );
		Assert.assertFalse("Algoformer no deberia estar en la posicion (3,8)",
				bumblebee.getPosition().equals(new Position(3, 8)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (6,8)",
				bumblebee.getPosition().equals(new Position(6, 8)));

	}

	/**
	 * 4. LLenar una zona pantano, verificar que las unidades aéreas las
	 * atraviesan sin problemas
	 * @throws InvalidPositionException
	 * @throws AlgoformerUsadoEsteTurnoException
	 * @throws AlgoformerCombinandoseEsteTurnoException 
	 * @throws NoPuedeMoverseDondeEstaOtroAlgoformerException 
	 * @throws GameOverException
	 */
	@Test
	public void test04() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException {
		Board tablero = new Board(20, 20);
		tablero.addCell(new Cell(new Position(3, 3), new SuperficiePantano()));
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(2, 3));
		tablero.add(megatron);
		megatron.transform();
		megatron.notifyNextTurn( );
		Assert.assertTrue(megatron.isAlternalMode());
		megatron.move(new Position(4, 3), tablero);
		megatron.notifyNextTurn( );
		Assert.assertFalse("Algoformer no deberia estar en la posicion (3,3)",
				megatron.getPosition().equals(new Position(3, 3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,3)",
				megatron.getPosition().equals(new Position(4, 3)));
	}

	/**
	 * 5. Llenar una zona de espinas verificar que todas las unidades terrestres
	 * pierden un 5% de sus vida por cada casillero de estos que atraviesen
	 * @throws InvalidPositionException
	 * @throws AlgoformerUsadoEsteTurnoException
	 * @throws AlgoformerCombinandoseEsteTurnoException 
	 * @throws NoPuedeMoverseDondeEstaOtroAlgoformerException 
	 * @throws GameOverException
	 */
	@Test
	public void test05() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException {
		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 0), new SurfaceThorn()));
		tablero.addCell(new Cell(new Position(2, 0), new SurfaceThorn()));

		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(0, 0));
		tablero.add(optimus);
		optimus.move(new Position(3, 0), tablero);
		optimus.notifyNextTurn( );
		Assert.assertEquals("su vida se ve reducida 5% por cada casillero", 451, optimus.getLife());

		optimus.transform();
		optimus.notifyNextTurn( );

		optimus.move(new Position(1, 0), tablero);
		optimus.notifyNextTurn( );
		Assert.assertEquals("su vida se ve reducida 5% por un casillero de espinas", 428, optimus.getLife());

	}

	/**
	 * 6. LLenar una zona de espinas, verificar que unidades aéreas no tienen
	 * problemas al atravesarlas.
	 * @throws InvalidPositionException
	 * @throws AlgoformerUsadoEsteTurnoException
	 * @throws AlgoformerCombinandoseEsteTurnoException 
	 * @throws NoPuedeMoverseDondeEstaOtroAlgoformerException 
	 * @throws GameOverException
	 */
	@Test
	public void test06() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException {
		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 0), new SurfaceThorn()));
		tablero.addCell(new Cell(new Position(2, 0), new SurfaceThorn()));

		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(0, 0));
		tablero.add(megatron);
		megatron.transform();
		megatron.notifyNextTurn( );

		megatron.move(new Position(3, 0), tablero);
		megatron.notifyNextTurn( );
		Assert.assertEquals(550, megatron.getLife());
	}

	/**
	 * 7. Llenar una zona con nubes, verificar que las unidades aéreas las
	 * atraviesan sin problemas.
	 * @throws InvalidPositionException
	 * @throws AlgoformerUsadoEsteTurnoException
	 * @throws AlgoformerCombinandoseEsteTurnoException 
	 * @throws NoPuedeMoverseDondeEstaOtroAlgoformerException 
	 * @throws GameOverException
	 */
	@Test
	public void test07() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException {
		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 0), new SurfaceCloud()));
		tablero.addCell(new Cell(new Position(2, 0), new SurfaceCloud()));

		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(0, 0));
		tablero.add(megatron);
		megatron.transform();
		megatron.notifyNextTurn( );
		Position newPosition = new Position(3, 0);
		megatron.move(newPosition, tablero);
		megatron.notifyNextTurn( );
		Assert.assertEquals(newPosition, megatron.getPosition());
	}

	/**
	 * 8. Llenar una zona de nebulosa de andrómeda, pasar una unidad aérea,
	 * corroborar que quede 3 turnos atrapada, sin moverse
	 * @throws AlgoformerUsadoEsteTurnoException
	 * @throws InvalidPositionException
	 * @throws AlgoformerCombinandoseEsteTurnoException 
	 * @throws NoPuedeMoverseDondeEstaOtroAlgoformerException 
	 * @throws GameOverException
	 */

	@Test(expected=AlgoformerAtrapadoEsteTurnoException.class)
	public void test08() throws UsuarioNoSeleccionoAlgoformerException,
			JugadorNoPuedeJugarCuandoNoEsSuTurnoException, AlgoformerUsadoEsteTurnoException, InvalidPositionException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException {
		Game game = new Game();
		prepareGame(game);

		Player jugador1 = game.getPlayer1();
		Player jugador2 = game.getPlayer2();

		List<Algoformer> algoformersJugador1 = jugador1.getAlgoformers();
		Algoformer megatron = algoformersJugador1.get(0);
		megatron.transform();
		megatron.notifyNextTurn();

		// Turno jugador 1 se mueve a la nebulosa andromeda
		game.moverAlgoformer( new Position(0, 0), new Position(1, 0));
		game.nextTurn();

		// Turno jugador 2
		game.nextTurn();

		// Turno jugador 1
		game.moverAlgoformer( new Position(1, 0), new Position(1, 1));
		Assert.assertEquals("el algoformer deberia estar atrapado el 1° turno", new Position(1, 0),megatron.getPosition());
		game.nextTurn();

		// Turno jugador 2
		game.nextTurn();

		// Turno jugador 1
		game.moverAlgoformer( new Position(1, 0), new Position(1, 1));
		Assert.assertEquals("el algoformer deberia estar atrapado 2° turno", new Position(1, 0),
				megatron.getPosition());
		game.nextTurn();

		// Turno jugador 2
		game.nextTurn();

		// Turno jugador 1
		game.moverAlgoformer( new Position(1, 0), new Position(1, 1));
		Assert.assertEquals("el algoformer deberia estar atrapado 3° turno", new Position(1, 0),
				megatron.getPosition());
		game.nextTurn();
		// Turno jugador 2
		game.nextTurn();

		// Turno jugador 1
		game.moverAlgoformer( new Position(1, 0), new Position(1, 1));
		Assert.assertEquals("el algoformer finalmente se movio", new Position(1, 1),
				megatron.getPosition());
		game.nextTurn();

	}

	/**
	 * 9. Llenar una zona de tormenta psiónica, pasar un algoformer alterno
	 * aéreo, ver que baje su capacidad de ataque
	 * @throws InvalidPositionException
	 * @throws AlgoformerUsadoEsteTurnoException
	 * @throws AlgoformerCombinandoseEsteTurnoException 
	 * @throws NoPuedeMoverseDondeEstaOtroAlgoformerException 
	 * @throws GameOverException
	 */
	@Test
	public void test09() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException {

		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 0), new SurfacePsionicStorm()));

		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(0, 0));
		tablero.add(megatron);
		megatron.transform();
		megatron.notifyNextTurn( );

		megatron.move(new Position(2, 0), tablero);
		megatron.notifyNextTurn( );
		Assert.assertEquals(
				"el algoformer alterno aereo reduce su poder de ataque un 40% al pasar por una tormenta psionica",
				33, megatron.getAttack());

	}

	/**
	 * 10. {@link #test09() test09} + volver a pasar y ver que no bajó su
	 * capacidad de ataque.
	 */
	@Test
	public void test10() {
	}

	private void prepareGame(Game game) throws InvalidPositionException {
		Player player1 = new Player(game, "Juan");
		Player player2 = new Player(game, "Maria");
		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 0), new SurfaceAndromedaNebula()));
		Turn turn = new Turn(player1, player2);

		// Decepticons:
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(0, 0));
		Algoformer bonecrusher = AlgoFormerFactory.getBonecrusher(new Position(0, 1));
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(0, 2));

		// Autobots:
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(9, 0));
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(9, 1));
		Algoformer ratchet = AlgoFormerFactory.getRatchet(new Position(9, 2));

		player1.addAlgoformer(megatron);
		player1.addAlgoformer(bonecrusher);
		player1.addAlgoformer(frenzy);

		player2.addAlgoformer(optimusPrime);
		player2.addAlgoformer(bumblebee);
		player2.addAlgoformer(ratchet);

		// Autobots:
		tablero.add(optimusPrime);
		tablero.add(bumblebee);
		tablero.add(ratchet);

		// Decepticons:
		tablero.add(megatron);
		tablero.add(bonecrusher);
		tablero.add(frenzy);

		game.setBoard(tablero);
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setTurn(turn);

	}

}
