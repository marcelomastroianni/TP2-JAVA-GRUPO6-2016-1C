package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;

public class OptimusPrimeTest {
	private Board board;
	private Algoformer optimusPrime;

	@Before
	public void setUp() {
		board = new Board(10, 10);
		optimusPrime = AlgoFormerFactory.getOptimusPrime();

	}

	@Test
	public void nametest() {
		Assert.assertEquals("Optimus Prime", optimusPrime.getNombre());
	}


	@Test
	public void speedTest() {
		optimusPrime.setPosition(new Position(0, 0));
		board.add(optimusPrime);
		optimusPrime.move(new Position(2,0),board);
		Assert.assertTrue("Algoformer deberia haberse movido a la derecha", board.isEmpty(new Position(0, 0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", board.getContent(new Position(2, 0)),
				optimusPrime);
	}

	@Test
	public void speedAlternalModeTest() {
		optimusPrime.transform();
		optimusPrime.setPosition(new Position(0, 0));
		board.add(optimusPrime);
		optimusPrime.move(new Position(0,0),board);
		Assert.assertTrue("Algoformer deberia haberse movido a la derecha", board.isEmpty(new Position(0, 0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", board.getContent(new Position(5, 0)),
				optimusPrime);

	}

}
