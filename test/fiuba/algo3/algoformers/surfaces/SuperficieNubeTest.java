package fiuba.algo3.algoformers.surfaces;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.surfaces.SuperficieNube;





public class SuperficieNubeTest {

	@Test
	public void testCrearSuperficieNube(){		
		SuperficieNube superficieNube = new SuperficieNube();		
		Cell casillero = new Cell(new Position(0,0));		
		casillero.setSurface(superficieNube);		
		Assert.assertEquals("La superficie del casillero deberia ser Superficie Rocosa", superficieNube, casillero.getSurface());		
	}
	
	@Test
	public void testCruzarSuperficieNube(){		
		SuperficieNube superficieNube = new SuperficieNube();				
		Assert.assertFalse("Modo humanoide no deberia poder cruzar superficie nube", superficieNube.puedeSerCruzadaPorModoHumanoide());
		Assert.assertFalse("Modo alterno terrestre no deberia poder cruzar superficie nube", superficieNube.puedeSerCruzadaPorModoAlternoTerrestre());
		Assert.assertTrue("Modo alterno aereo deberia poder cruzar superficie nube", superficieNube.puedeSerCruzadaPorModoAlternoAereo());										
	}
}
