package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;

public class BumblebeeTest {
	private Board board;
	private Algoformer bumblebee;

	@Before
	public void setUp() {
		board = new Board(10, 10);
		bumblebee = AlgoFormerFactory.getBumblebee(new Position(0, 0));

	}

	@Test
	public void nametest() {
		Assert.assertEquals("Bumblebee", bumblebee.getNombre());
	}

	@Test
	public void speedTest() {
		board.add(bumblebee);
		bumblebee.move(new Position(2,0),board);
		Assert.assertTrue("Algoformer deberia haberse movido a la derecha", board.isEmpty(new Position(0, 0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", board.getContent(new Position(2, 0)),
				bumblebee);
	}

	@Test
	public void speedAlternalModeTest() {
		bumblebee.transform();
		board.add(bumblebee);
		bumblebee.move(new Position(5,0),board);
		Assert.assertTrue("Algoformer deberia haberse movido a la derecha", board.isEmpty(new Position(0, 0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", board.getContent(new Position(5, 0)),
				bumblebee);

	}

}
