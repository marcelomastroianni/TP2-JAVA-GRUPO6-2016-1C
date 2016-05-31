package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Test;

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
	public void distanceBeteewnTwoPositionsTest(){
		Position position1 = new Position(0,0);
		Position position2 = new Position(0,1);
		Position position3 = new Position(2,1);
		Position position4 = new Position(2,2);
		
		Assert.assertTrue(position1.distance(position2).equals(1.0d) );
		Assert.assertEquals(position1.distance(position3).compareTo(2.0d) , 1);
		Assert.assertEquals(position1.distance(position4).compareTo(2.0d) , 1);
		Assert.assertEquals(position3.distance(position4).compareTo(2.0d) , -1);
	}

}
