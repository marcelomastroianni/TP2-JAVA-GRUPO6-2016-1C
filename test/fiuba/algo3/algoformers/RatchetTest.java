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
import fiuba.algo3.model.exceptions.GameOverException;
import fiuba.algo3.model.exceptions.InvalidPositionException;

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
	public void speedTest() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, GameOverException {
		board.add(ratchet);
		ratchet.move(new Position(1,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(1, 0),
				ratchet.getPosition());
	}

	@Test
	public void speedAlternalModeTest() throws AlgoformerUsadoEsteTurnoException, InvalidPositionException, AlgoformerAtrapadoEsteTurnoException, GameOverException {
		ratchet.transform();
		ratchet.notifyNextTurn();
		board.add(ratchet);
		ratchet.move(new Position(8,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(8, 0),
				ratchet.getPosition());

	}

}
