package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
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
		Position position2 = new Position(0,2);
		Assert.assertTrue(position1.isInDistance(position2,2));
		Assert.assertFalse(position1.isInDistance(position2,1));
	}

	@Test
	public void getDistanceTest2(){
		Position position1 = new Position(0,0);
		Position position2 = new Position(4,3);
		Assert.assertTrue(position1.isInDistance(position2,4));
		Assert.assertFalse(position1.isInDistance(position2,3));
	}

	@Test
	public void isInRangeTrueTest(){
		Position position = new Position(5,6);
		Assert.assertTrue(position.isInRange(8,8));
	}

	@Test
	public void isInRangeFalseTest(){
		Position position = new Position(5,6);
		Assert.assertFalse(position.isInRange(4,4));
	}

	@Test
	public void isInRangeLimitTest(){
		Position position = new Position(5,6);
		Assert.assertFalse(position.isInRange(5,6));
	}

	@Test
	public void testGiveMePosition(){
		Position position = new Position(7,5);
		Assert.assertEquals("(7,5)", position.toString());
	}

	@Test
	public void testIteradorPosicion(){
		Position position = new Position(5,6);
		Position finalPosition = new Position(10,10);

		Assert.assertTrue("Deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (6,7).", new Position(6,7), position);

		Assert.assertTrue("Deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (7,8).", new Position(7,8), position);

		Assert.assertTrue("Deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (8,9).", new Position(8,9), position);

		Assert.assertTrue("Deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (9,10).", new Position(9,10), position);

		Assert.assertTrue("Deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (10,10).", new Position(10,10), position);

		Assert.assertFalse("No deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (10,10).", new Position(10,10), position);


		position = new Position(10,17);
		finalPosition = new Position(10,10);

		Assert.assertTrue("Deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (10,16).", new Position(10,16), position);

		Assert.assertTrue("Deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (10,15).", new Position(10,15), position);

		Assert.assertTrue("Deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (10,14).", new Position(10,14), position);

		Assert.assertTrue("Deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (10,13).", new Position(10,13), position);

		Assert.assertTrue("Deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (10,12).", new Position(10,12), position);

		Assert.assertTrue("Deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (10,11).", new Position(10,11), position);

		Assert.assertTrue("Deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (10,10).", new Position(10,10), position);

		Assert.assertFalse("No Deberia haber una posicion siguiente", position.hasNext(finalPosition));
		position = position.next(finalPosition);
		Assert.assertEquals("La posicion siguiente deberia ser (10,10).", new Position(10,10), position);
	}
}
