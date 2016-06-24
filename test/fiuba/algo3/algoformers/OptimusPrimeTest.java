package fiuba.algo3.algoformers;

import fiuba.algo3.model.exceptions.AlgoformerAtrapadoEsteTurnoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;

public class OptimusPrimeTest {
	private Board board;
	private Algoformer optimusPrime;

	@Before
	public void setUp() {
		board = new Board(10, 10);
		optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0, 0));
	}

	@Test
	public void nametest() {
		Assert.assertEquals("Optimus Prime", optimusPrime.getNombre());
	}

	@Test
	public void speedTest() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		board.add(optimusPrime);
		optimusPrime.move(new Position(2,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(2, 0),
				optimusPrime.getPosition());
	}

	@Test
	public void speedAlternalModeTest() throws AlgoformerUsadoEsteTurnoException, InvalidPositionException, AlgoformerAtrapadoEsteTurnoException {
		optimusPrime.transform();
		optimusPrime.notifyNextTurn();
		board.add(optimusPrime);
		optimusPrime.move(new Position(1,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(1, 0),
				optimusPrime.getPosition());
	}
	
	@Test
	public void reduceLifeTest() {
		optimusPrime.reduceLifeFivePercent();
		Assert.assertEquals("Algoformer deberia tener una vida de 475 puntos",475,optimusPrime.getLife());
	}
}
