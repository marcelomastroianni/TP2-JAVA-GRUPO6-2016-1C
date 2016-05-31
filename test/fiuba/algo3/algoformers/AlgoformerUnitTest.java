package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Position;
import fiuba.algo3.exceptions.InvalidStrikeException;

public class AlgoformerUnitTest {

	private Board board;

	@Before
	public void setUp() {
		board = new Board(10, 10);
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

	@Test
	public void algoformerCanAttackAnotherone(){
		
		Algoformer algoformer1 = AlgoFormerFactory.getFrenzy();
		Algoformer algoformer2 = AlgoFormerFactory.getOptimusPrime();
		
		algoformer1.setPosition(new Position(2,0));
		algoformer2.setPosition(new Position(2,4));
		board.add(algoformer1);
		board.add(algoformer2);
		
		algoformer1.shot(algoformer2);
		Assert.assertEquals("La vida de Optimus deberia ser 490", 490, algoformer2.getLife());
		
	}
	
	@Test(expected = InvalidStrikeException.class)
	public void algoformerCanNotAttackAnotherone() throws InvalidStrikeException{
		
		Algoformer algoformer1 = AlgoFormerFactory.getFrenzy();
		Algoformer algoformer2 = AlgoFormerFactory.getOptimusPrime();
		
		algoformer1.setPosition(new Position(2,0));
		algoformer2.setPosition(new Position(2,4));
		board.add(algoformer1);
		board.add(algoformer2);
		
		algoformer2.resolveDistance(algoformer1);
		
	}


}
