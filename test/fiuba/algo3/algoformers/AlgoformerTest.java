package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Position;


public class AlgoformerTest {


	@Test
	public void testgetOptimusPrime(){
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime();
        Assert.assertEquals("Optimus Prime", optimusPrime.getNombre());

	}

	@Test
	public void eastMovementAlgoformerTest(){
		Board board = new Board(5,5);
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime();
		Position initialPosition = new Position(0,0);
		Position finalPosition = new Position(2,0);

		board.putContent(initialPosition, optimusPrime);
		Assert.assertEquals(board.getContent(initialPosition),optimusPrime);
		board.moveAlgoformerRight(initialPosition);
		Assert.assertTrue(board.isEmpty(initialPosition));
		Assert.assertEquals(board.getContent(finalPosition),optimusPrime);
	}
	
	
	@Test
	public void testTransform(){
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime();
				
        Assert.assertEquals("Modo deberia ser humanoide", algoformer.getActiveMode(), algoformer.getHumanoidMode());        
        algoformer.transform();
        Assert.assertEquals("Modo deberia ser alterno", algoformer.getActiveMode(), algoformer.getAlternalMode());
        algoformer.transform();
        Assert.assertEquals("Modo deberia ser humanoide", algoformer.getActiveMode(), algoformer.getHumanoidMode());
        algoformer.transform();
        Assert.assertEquals("Modo deberia ser alterno", algoformer.getActiveMode(), algoformer.getAlternalMode());
	}



}
