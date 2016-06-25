package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Nothing;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.surfaces.SurfaceCloud;
import fiuba.algo3.model.surfaces.SuperficieRocosa;


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
	public void addContentTest() throws InvalidPositionException{
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(4,4));
		board.add(optimusPrime);
		Assert.assertEquals(optimusPrime, board.getContent(lastPosition));
	}

	@Test(expected= InvalidPositionException.class)
	public void addContentInInvalidPositionTest() throws InvalidPositionException{
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(5,5));
		board.add(optimusPrime);
	}

	@Test(expected= InvalidPositionException.class)
	public void addContentInNegativePositionTest() throws InvalidPositionException{
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(-5,0));
		board.add(optimusPrime);
	}
	
	@Test
	public void testValidPosition(){
		Board tablero = new Board(21,20);	
		Assert.assertFalse("(-1,0) no es una posicion valida", tablero.isValidPosition(new Position(-1,0)));
		Assert.assertFalse("(0,-1) no es una posicion valida", tablero.isValidPosition(new Position(0,-1)));
		Assert.assertFalse("(-1,-1) no es una posicion valida", tablero.isValidPosition(new Position(-1,-1)));
		Assert.assertTrue("(0,0) es una posicion valida", tablero.isValidPosition(new Position(0,0)));		
		
		Assert.assertFalse("(23,26) no es una posicion valida", tablero.isValidPosition(new Position(23,26)));						
		Assert.assertFalse("(21,20) no es una posicion valida", tablero.isValidPosition(new Position(21,20)));
		Assert.assertFalse("(21,19) no es una posicion valida", tablero.isValidPosition(new Position(21,19)));
		Assert.assertFalse("(20,20) no es una posicion valida", tablero.isValidPosition(new Position(20,20)));
		Assert.assertTrue("(20,19) es una posicion valida", tablero.isValidPosition(new Position(20,19)));
	}
	
	@Test
	public void testCentralPosition(){
		Board tablero = new Board(21,20);		
		Assert.assertEquals("Posicion central deberia estar en el centro del tablero",new Position(10,10), tablero.getCentralPosition());		
	}
	
	@Test
	public void testGetBoardSize(){			
		Assert.assertEquals("Deberia poder obtenerse la dimension X del tablero",XBOARDLENGTH, board.getXLength());
		Assert.assertEquals("Deberia poder obtenerse la dimension Y del tablero",YBOARDLENGTH, board.getYLength());
	}

	@Test
	public void addCellTest(){
		Board tablero = new Board(10,10);
		

		tablero.addCell(new Cell(new Position(0,0),new SurfaceCloud()));
	
		Assert.assertTrue(tablero.getSurface(new Position(0,0)) instanceof SurfaceCloud );
		Assert.assertFalse(tablero.getSurface(new Position(0,0)) instanceof SuperficieRocosa);
	}

	@Test
	public void getSurfaceTest(){
		Board tablero = new Board(10,10);		
		tablero.addCell(new Cell(new Position(0,0),new SurfaceCloud()));
		Assert.assertTrue(tablero.getSurface(new Position(0,0)) instanceof SurfaceCloud );
		Assert.assertFalse(tablero.getSurface(new Position(0,0)) instanceof SuperficieRocosa);
	}

	@Test
	public void removeAlgoforme() throws InvalidPositionException{
		Board tablero = new Board(5,5);
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(1, 1));
		tablero.add(frenzy);

		Assert.assertTrue("frenzy deberia estar en la posicion (1,1)", frenzy.getPosition().equals(new Position(1, 1)));
		tablero.remove(frenzy);
		Assert.assertEquals("frenzy no deberia estar en el tablero",new Nothing(new Position(1,1)), tablero.getContent(new Position(1,1)));
	}

	@Test(expected=InvalidPositionException.class)
	public void testInvalidPositionclearContent() throws InvalidPositionException{
		Board tablero = new Board(5,5);
		Algoformer bonecrusher = AlgoFormerFactory.getBonecrusher(new Position(1, 1));
		tablero.add(bonecrusher);

		Assert.assertTrue("Bonecrusher deberia estar en la posicion (1,1)", bonecrusher.getPosition().equals(new Position(1, 1)));
		tablero.clearContent(new Position(-1,0));
	}
	
	


}
