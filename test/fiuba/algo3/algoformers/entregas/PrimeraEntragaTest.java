package fiuba.algo3.algoformers.entregas;

import java.util.List;

import fiuba.algo3.model.exceptions.AlgoformerAtrapadoEsteTurnoException;
import fiuba.algo3.model.exceptions.AlgoformerCombinandoseEsteTurnoException;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;

public class PrimeraEntragaTest {

	//Se ubica un algoformer humanoide en un casillero, se pide que se mueva, se verifica
	//nueva posición acorde a su modo.
	@Test
	public void test01() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {

		Board board = new Board(20,20);
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0,0));

		board.add(algoformer);
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial",board.getContent(new Position(0,0)),algoformer);

		algoformer.move(new Position(2,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha",new Position(2,0),algoformer.getPosition());
	}

	//2. Se ubica un algoformer humanoide se lo transforma, se verifica que se pueda transformar
	//en ambas direcciones.
	@Test
	public void test02() throws AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, InvalidPositionException, AlgoformerCombinandoseEsteTurnoException {
		Board board = new Board(5,5);
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
        Assert.assertTrue("Modo deberia ser humanoide", algoformer.isHumanoidMode());
        algoformer.transform();
        algoformer.notifyNextTurn();
        Assert.assertTrue("Modo deberia ser alterno", algoformer.isAlternalMode());
        algoformer.transform();
        algoformer.notifyNextTurn();
        Assert.assertTrue("Modo deberia ser humanoide", algoformer.isHumanoidMode());
        algoformer.transform();
        algoformer.notifyNextTurn();
        Assert.assertTrue("Modo deberia ser alterno", algoformer.isAlternalMode());
	}


	//3. Se ubica un algoformer en su modo alterno y se pide que se mueva y se verifica que su
	//nueva posición sea acorde.
	@Test
	public void test03() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Board board = new Board(20,20);
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0,0));

		board.add(algoformer);
		algoformer.transform();
		algoformer.notifyNextTurn();
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial",board.getContent(new Position(0,0)),algoformer);
		algoformer.move(new Position(5,0),board);
		algoformer.notifyNextTurn();
		Assert.assertEquals("Algoformer alterno deberia haberse movido a la derecha",new Position(5,0),algoformer.getPosition());
	}

	//4. Crear una prueba de integración en la cual se pueda crear un juego, con 2 jugadores cada
	//uno de ellos con sus 3 algoformers distribuidos en el tablero según el enunciado y la
	//chispa suprema por el centro del tablero.
	@Test
	public void test04() throws InvalidPositionException{
		Game game = new Game();
		game.init("Juan", "Maria");

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

	//5. Combinaciones en modos de: Ubicar un autobot, ubicar un decepticon, pedir que se
	//ataquen respetando ( y no ) las distancias verificando los daños ( o no daños ).
	@Test
	public void test05() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Board board = new Board(5,5);
		Algoformer algoformer1 = AlgoFormerFactory.getFrenzy(new Position(2,0));
		Algoformer algoformer2 = AlgoFormerFactory.getOptimusPrime(new Position(2,4));

		board.add(algoformer1);
		board.add(algoformer2);

		Assert.assertEquals("La vida de Optimus deberia ser 500", 500, algoformer2.getLife());
		algoformer1.shot(algoformer2,board);
		Assert.assertEquals("La vida de Optimus deberia ser 490", 490, algoformer2.getLife());
		Assert.assertEquals("La vida de Frenzy deberia ser 400", 400, algoformer1.getLife());
		algoformer2.shot(algoformer1,board);
		Assert.assertEquals("La vida de Frenzy deberia ser 400", 400, algoformer1.getLife());

	}

}
