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
	int BOARD_X_LENGTH = 5;
	int BOARD_Y_LENGTH = 5;

	@Before
	public void setUp(){
		board = new Board(BOARD_X_LENGTH,BOARD_Y_LENGTH);
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
	

	@Test
	public void testCentralPosition(){
		Board tablero = new Board(21,20);
		Position centralPosition = tablero.getCentralPosition();
		
		Integer x_central = 10;
		Integer y_central = 10;
		
		Assert.assertEquals("Posicion X Central deberia ser la mitad del tablero",x_central, centralPosition.getX());
		Assert.assertEquals("Posicion Y Central deberia ser la mitad del tablero",y_central, centralPosition.getY());
	}
	
	@Test
	public void testObtenerTamañoTablero(){			
		Assert.assertEquals("Deberia poder obtenerse la dimension X del tablero",BOARD_X_LENGTH, board.get_X_Length());
		Assert.assertEquals("Deberia poder obtenerse la dimension Y del tablero",BOARD_Y_LENGTH, board.get_Y_Length());
	}




}
