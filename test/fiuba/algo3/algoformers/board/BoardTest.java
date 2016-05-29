package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


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



}
