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
	public void speedTest() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		board.add(bonecrusher);
		bonecrusher.move(new Position(1,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(1, 0),
				bonecrusher.getPosition());
	}

	@Test
	public void speedAlternalModeTest() throws AlgoformerUsadoEsteTurnoException, InvalidPositionException, AlgoformerAtrapadoEsteTurnoException {
		bonecrusher.transform();
		bonecrusher.notifyNextTurn(board);
		board.add(bonecrusher);
		bonecrusher.move(new Position(8,0),board);
		bonecrusher.notifyNextTurn(board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(8, 0),
				bonecrusher.getPosition());
	}

	@Test
	public void reduceLifeTest() {
		bonecrusher.reduceLifeFivePercent();
		Assert.assertEquals("Algoformer deberia tener una vida de 475 puntos",190,bonecrusher.getLife());

	}
}
