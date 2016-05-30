package fiuba.algo3.algoformers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Position;

public class AlgoformerUnitTest {

	private Board board;

	@Before
	public void setUp() {
		board = Board.getInstance();
	}

	@Test
	public void addToBoartTest() {
		Algoformer algoformer = AlgoFormerFactory.getBumblebee();
		algoformer.setPosition(new Position(0, 0));
		board.add(algoformer);
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial", board.getContent(new Position(0, 0)),
				algoformer);
	}

	@Test
	public void activeModeTest() {
		Algoformer algoformer = AlgoFormerFactory.getMegatron();
		Assert.assertEquals("Modo deberia ser humanoide", algoformer.getActiveMode(), algoformer.getHumanoidMode());
	}

	@Test
	public void transformationTest() {
		Algoformer algoformer = AlgoFormerFactory.getFrenzy();
		algoformer.transform();
		Assert.assertEquals("Modo deberia ser alterno", algoformer.getActiveMode(), algoformer.getAlternalMode());
	}


	@After
	public void tearDown(){
		board.reset();
	}

}
