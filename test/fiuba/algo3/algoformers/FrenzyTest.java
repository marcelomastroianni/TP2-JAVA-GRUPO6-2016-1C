package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;

public class FrenzyTest {
	private Board board;
	private Algoformer frenzy;

	@Before
	public void setUp() {
		board = new Board(10, 10);
		frenzy = AlgoFormerFactory.getFrenzy(new Position(0, 0));
	}

	@Test
	public void nametest() {
		Assert.assertEquals("Frenzy", frenzy.getNombre());
	}

	@Test
	public void speedTest() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException {
		board.add(frenzy);
		frenzy.move(new Position(2,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(2, 0),
				frenzy.getPosition());
	}

	@Test
	public void speedAlternalModeTest() throws AlgoformerUsadoEsteTurnoException, InvalidPositionException {
		frenzy.transform();
		frenzy.notifyNextTurn();
		board.add(frenzy);
		frenzy.move(new Position(6,0),board);
		frenzy.notifyNextTurn();
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(6, 0),
				frenzy.getPosition());
	}
}
