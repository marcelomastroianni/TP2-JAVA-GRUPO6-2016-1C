package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Nothing;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.surfaces.SurfaceCloud;
import fiuba.algo3.model.surfaces.SurfaceRocky;
import fiuba.algo3.model.surfaces.Surface;


public class CellTest {


	@Test
	public void CreateNewCasilleroTest(){
		Cell casillero = new Cell(new Position(0,0),new SurfaceRocky());
		Assert.assertNotNull(casillero);
	}

	@Test
	public void testGetPositionTest(){
		Cell casillero = new Cell(new Position(0,0),new SurfaceRocky());
		Assert.assertEquals(new Position(0,0), casillero.getPosition());
	}
	

	@Test
	public void testGetContent(){
		Cell casillero = new Cell(new Position(0,0),new SurfaceRocky());
		Assert.assertEquals(new Nothing(new Position(0,0)), casillero.getContent());
	}
	
	@Test
	public void testGetSurface(){
		Cell casillero = new Cell(new Position(0,0),new SurfaceRocky());
		Assert.assertTrue( casillero.getSurface() instanceof SurfaceRocky );
		Assert.assertFalse( casillero.getSurface() instanceof SurfaceCloud);
	}
	
	@Test
	public void testSetSurfaceTest(){
		Cell casillero = new Cell(new Position(0,0),new SurfaceRocky());
		casillero.setSurface(new SurfaceCloud());
		Assert.assertTrue( casillero.getSurface() instanceof SurfaceCloud);
	
		
	}

}
