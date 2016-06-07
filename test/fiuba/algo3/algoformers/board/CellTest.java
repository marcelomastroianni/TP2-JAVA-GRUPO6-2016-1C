package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Nothing;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.surfaces.Air;
import fiuba.algo3.model.surfaces.Cloud;
import fiuba.algo3.model.surfaces.SuperficieRocosa;
import fiuba.algo3.model.surfaces.Surface;


public class CellTest {


	@Test
	public void CreateNewCasilleroTest(){
		Cell casillero = new Cell(new Position(0,0),new SuperficieRocosa());
		Assert.assertNotNull(casillero);
	}

	@Test
	public void testGetPositionTest(){
		Cell casillero = new Cell(new Position(0,0),new SuperficieRocosa());
		Assert.assertEquals(new Position(0,0), casillero.getPosition());
	}
	

	@Test
	public void testGetContent(){
		Cell casillero = new Cell(new Position(0,0),new SuperficieRocosa());
		Assert.assertEquals(new Nothing(new Position(0,0)), casillero.getContent());
	}
	
	@Test
	public void testGetSurface(){
		Cell casillero = new Cell(new Position(0,0),new SuperficieRocosa());
		Assert.assertTrue( casillero.getSurface() instanceof SuperficieRocosa );
		Assert.assertFalse( casillero.getSurface() instanceof Cloud);
	}
	
	@Test
	public void testSetSurfaceTest(){
		Cell casillero = new Cell(new Position(0,0),new SuperficieRocosa());
		casillero.setSurface(new Air());
		Assert.assertFalse( casillero.getSurface() instanceof Cloud);
		Assert.assertTrue( casillero.getSurface() instanceof Air );
		
	}

}
