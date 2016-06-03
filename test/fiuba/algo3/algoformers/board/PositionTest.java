package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.board.Position;

public class PositionTest {


	@Test
	public void compareTwoEqualPositionsTest(){
		Position position1 = new Position(0,0);
		Position position2 = new Position(0,0);
		Assert.assertEquals(position1, position2);
	}

	@Test
	public void compareTwoDiferentPositionsTest(){
		Position position1 = new Position(0,0);
		Position position2 = new Position(0,1);
		Assert.assertFalse(position1.equals(position2));
	}
	
	@Test
	public void getDistanceTest(){
		Position position1 = new Position(0,0);
		Position position2 = new Position(0,1);
		Assert.assertEquals(position1.distance(position2),new Double(1));			
	}
	
	@Test
	public void getDistanceTest2(){
		Position position1 = new Position(0,0);
		Position position2 = new Position(4,3);
		Assert.assertEquals(position1.distance(position2),new Double(5));			
	}



}
