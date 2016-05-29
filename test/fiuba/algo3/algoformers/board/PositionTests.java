package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Test;

public class PositionTests {

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

}
