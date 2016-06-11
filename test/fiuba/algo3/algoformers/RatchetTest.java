package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;

public class RatchetTest {
	private Board board;
	private Algoformer ratchet;

	@Before
	public void setUp() {
		board = new Board(10, 10);
		ratchet = AlgoFormerFactory.getRatchet(new Position(0, 0));
	}

	@Test
	public void nametest() {
		Assert.assertEquals("Ratchet", ratchet.getNombre());
	}

	@Test
	public void speedTest() {
		board.add(ratchet);
		ratchet.move(new Position(1,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(1, 0),
				ratchet.getPosition());
	}

	@Test
	public void speedAlternalModeTest() {
		ratchet.transform();
		board.add(ratchet);
		ratchet.move(new Position(8,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(8, 0),
				ratchet.getPosition());

	}

}
