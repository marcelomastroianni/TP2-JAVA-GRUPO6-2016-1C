package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Position;

public class RatchetTest {
	private Board board;
	private Algoformer ratchet;

	@Before
	public void setUp() {
		board = Board.getInstance();
		ratchet = AlgoFormerFactory.getRatchet();
	}

	@Test
	public void nametest() {
		Assert.assertEquals("Ratchet", ratchet.getNombre());
	}

	@Test
	public void speedTest() {
		ratchet.setPosition(new Position(0, 0));
		board.add(ratchet);
		ratchet.moveEast(board);
		Assert.assertTrue("Algoformer deberia haberse movido a la derecha", board.isEmpty(new Position(0, 0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", board.getContent(new Position(1, 0)),
				ratchet);
	}


	@Test
	public void speedAlternalModeTest() {
		ratchet.transform();
		ratchet.setPosition(new Position(0, 0));
		board.add(ratchet);
		ratchet.moveEast(board);
		Assert.assertTrue("Algoformer deberia haberse movido a la derecha", board.isEmpty(new Position(0, 0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", board.getContent(new Position(8, 0)),
				ratchet);

	}

}
