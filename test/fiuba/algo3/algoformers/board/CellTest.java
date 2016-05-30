package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Test;


public class CellTest {


	@Test
	public void CreateNewCasilleroTest(){
		Cell casillero = new Cell(new Position(0,0));
		Assert.assertNotNull(casillero);
	}

	@Test
	public void getPositionTest(){
		Cell casillero = new Cell(new Position(0,0));
		Assert.assertEquals(new Position(0,0), casillero.getPosition());
	}

	@Test
	public void geContent(){
		Cell casillero = new Cell(new Position(0,0));
		Assert.assertEquals(new Nothing(), casillero.getContent());
	}


}
