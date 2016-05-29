package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoformers.AlgoFormerFactory;
import fiuba.algo3.algoformers.Algoformer;
import fiuba.algo3.exceptions.InvalidPositionException;


public class BoardTest {
	private Board board;
	private Position firstPosition;
	private Position lastPosition;

	@Before
	public void setUp(){
		board = new Board(5,5);
		firstPosition = new Position(0,0);
		lastPosition = new Position(4,4);
	}

	@Test
	public void getContentTest(){
		Assert.assertEquals(new Nothing(), board.getContent(firstPosition));
		Assert.assertEquals(new Nothing(), board.getContent(lastPosition));
	}

	@Test
	public void isEmptyTest(){
		Assert.assertTrue(board.isEmpty(firstPosition));
		Assert.assertTrue(board.isEmpty(lastPosition));
	}

	@Test
	public void addContentTest(){
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime();
		optimusPrime.setPosition(new Position(4,4));
		board.add(optimusPrime);
		Assert.assertTrue(board.isEmpty(firstPosition));
		Assert.assertEquals(optimusPrime, board.getContent(lastPosition));
	}

	@Test(expected= InvalidPositionException.class)
	public void addContentInInvalidPositionTest(){
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime();
		optimusPrime.setPosition(new Position(5,5));
		board.add(optimusPrime);
	}

	@Test(expected= InvalidPositionException.class)
	public void addContentInNegativePositionTest(){
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime();
		optimusPrime.setPosition(new Position(-5,0));
		board.add(optimusPrime);
	}



}
