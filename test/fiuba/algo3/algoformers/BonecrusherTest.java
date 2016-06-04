package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;

public class BonecrusherTest {
	private Board board;
	private Algoformer bonecrusher;

	@Before
	public void setUp() {
		board = new Board(10, 10);
		bonecrusher = AlgoFormerFactory.getBonecrusher(new Position(0, 0));

	}

	@Test
	public void nametest() {
		Assert.assertEquals("Bonecrusher", bonecrusher.getNombre());
	}

	@Test
	public void speedTest() {

		board.add(bonecrusher);
		bonecrusher.move(new Position(1,0),board);
		Assert.assertTrue("Algoformer deberia haberse movido a la derecha", board.isEmpty(new Position(0, 0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", board.getContent(new Position(1, 0)),
				bonecrusher);
	}

	@Test
	public void speedAlternalModeTest() {
		bonecrusher.transform();
		board.add(bonecrusher);
		bonecrusher.move(new Position(8,0),board);
		Assert.assertTrue("Algoformer deberia haberse movido a la derecha", board.isEmpty(new Position(0, 0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", board.getContent(new Position(8, 0)),
				bonecrusher);

	}

}
