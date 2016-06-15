package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;

public class MegatronTest {
	private Board board;
	private Algoformer megatron;

	@Before
	public void setUp() {
		board = new Board(10, 10);
		megatron = AlgoFormerFactory.getMegatron(new Position(0, 0));

	}

	@Test
	public void nameTest() {
		Assert.assertEquals("Megatron", megatron.getNombre());
	}

	@Test
	public void speedTest() {
		board.add(megatron);
		megatron.move(new Position(1,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(1, 0),
				megatron.getPosition());
	}

	@Test
	public void speedAlternalModeTest() {
		megatron.transform();
		megatron.notifyNextTurn();
		board.add(megatron);
		megatron.move(new Position(8,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(8, 0),
				megatron.getPosition());

	}


}
