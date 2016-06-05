package fiuba.algo3.algoformers.surfaces;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.surfaces.SuperficieNube;
import fiuba.algo3.model.surfaces.Surface;





public class SuperficieNubeTest {

	@Test
	public void testCrearSuperficieNube(){		
		Surface superficieNube = new SuperficieNube();		
		Cell casillero = new Cell(new Position(0,0),superficieNube);		
		Assert.assertEquals("La superficie del casillero deberia ser Superficie Rocosa", superficieNube, casillero.getSurface());		
	}
	
	@Test
	public void testCruzarSuperficieNube(){		
		Surface superficieNube = new SuperficieNube();				
		Assert.assertFalse("Modo humanoide no deberia poder cruzar superficie nube", superficieNube.puedeSerCruzadaPorModoHumanoide());
		Assert.assertFalse("Modo alterno terrestre no deberia poder cruzar superficie nube", superficieNube.puedeSerCruzadaPorModoAlternoTerrestre());
		Assert.assertTrue("Modo alterno aereo deberia poder cruzar superficie nube", superficieNube.puedeSerCruzadaPorModoAlternoAereo());										
	}
}
