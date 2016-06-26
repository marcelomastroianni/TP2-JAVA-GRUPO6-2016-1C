package fiuba.algo3.algoformers;

import fiuba.algo3.model.exceptions.AlgoformerAtrapadoEsteTurnoException;
import fiuba.algo3.model.exceptions.AlgoformerCombinandoseEsteTurnoException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.NoPuedeMoverseDondeEstaOtroAlgoformerException;

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
	public void speedTest() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException {
		board.add(bumblebee);
		bumblebee.move(new Position(2,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(2, 0),
				bumblebee.getPosition());
	}

	@Test
	public void speedAlternalModeTest() throws AlgoformerUsadoEsteTurnoException, InvalidPositionException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException {
		bumblebee.transform();
		bumblebee.notifyNextTurn();
		board.add(bumblebee);
		bumblebee.move(new Position(5,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha", new Position(5, 0),
				bumblebee.getPosition());

	}

}
