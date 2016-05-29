package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Position;

public class FrenzyTests {
	private Board board;
	private Algoformer frenzy;

	@Before
	public void setUp() {
		board = new Board(10, 10);
		frenzy = AlgoFormerFactory.getFrenzy();

	}

	@Test
	public void nametest() {
		Assert.assertEquals("Frenzy", frenzy.getNombre());
	}

	@Test
	public void speedTest() {
		frenzy.setPosition(new Position(0, 0));
		board.add(frenzy);
		frenzy.moveEast(board);
		Assert.assertTrue("Algoformer deberia haberse movido a la derecha", board.isEmpty(new Position(0, 0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", board.getContent(new Position(2, 0)),
				frenzy);
	}

	@Test
	public void speedAlternalModeTest() {
		frenzy.transform();
		frenzy.setPosition(new Position(0, 0));
		board.add(frenzy);
		frenzy.moveEast(board);
		Assert.assertTrue("Algoformer deberia haberse movido a la derecha", board.isEmpty(new Position(0, 0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", board.getContent(new Position(6, 0)),
				frenzy);

	}


}
