package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Nothing;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.exceptions.InvalidPositionException;


public class BoardTest {
	private Board board;
	private Position firstPosition;
	private Position lastPosition;
	int XBOARDLENGTH = 5;
	int YBOARDLENGTH = 5;

	@Before
	public void setUp(){
		board = new Board(XBOARDLENGTH,YBOARDLENGTH);
		firstPosition = new Position(0,0);
		lastPosition = new Position(4,4);
	}	

	@Test
	public void getContentTest(){
		Assert.assertEquals(new Nothing(firstPosition), board.getContent(firstPosition));
		Assert.assertEquals(new Nothing(lastPosition), board.getContent(lastPosition));
	}

	@Test
	public void isEmptyTest(){
		Assert.assertTrue(board.isEmpty(firstPosition));
		Assert.assertTrue(board.isEmpty(lastPosition));
	}

	@Test
	public void addContentTest(){
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(4,4));
		board.add(optimusPrime);
		Assert.assertTrue(board.isEmpty(firstPosition));
		Assert.assertEquals(optimusPrime, board.getContent(lastPosition));
	}

	@Test(expected= InvalidPositionException.class)
	public void addContentInInvalidPositionTest(){
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(5,5));
		board.add(optimusPrime);
	}

	@Test(expected= InvalidPositionException.class)
	public void addContentInNegativePositionTest(){
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(-5,0));
		board.add(optimusPrime);
	}
	
	@Test(expected= InvalidPositionException.class)
	public void addContentInOccupiedPositionTest(){
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime();
		optimusPrime.setPosition(new Position(2,0));
		board.add(optimusPrime);
		Algoformer megatron= AlgoFormerFactory.getMegatron();
		megatron.setPosition(new Position(2,0));
		board.add(megatron);
	}
	

	@Test
	public void testCentralPosition(){
		Board tablero = new Board(21,20);
		Position centralPosition = tablero.getCentralPosition();
		
		Integer xCentral = 10;
		Integer yCentral = 10;
		
		Assert.assertEquals("Posicion X Central deberia ser la mitad del tablero",xCentral, centralPosition.getX());
		Assert.assertEquals("Posicion Y Central deberia ser la mitad del tablero",yCentral, centralPosition.getY());
	}
	
	@Test
	public void testGetBoardSize(){			
		Assert.assertEquals("Deberia poder obtenerse la dimension X del tablero",XBOARDLENGTH, board.getXLength());
		Assert.assertEquals("Deberia poder obtenerse la dimension Y del tablero",YBOARDLENGTH, board.getXLength());
	}




}
