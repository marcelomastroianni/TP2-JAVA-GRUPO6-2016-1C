package fiuba.algo3.algoformers.surfaces;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.surfaces.SuperficiePantano;
import fiuba.algo3.model.surfaces.Surface;

public class SuperficiePantanoTest {

	@Test
	public void testCrearSuperficiePantano(){		
		Surface superficiePantano = new SuperficiePantano();		
		Cell casillero = new Cell(new Position(0,0));		
		casillero.setSurface(superficiePantano);		
		Assert.assertEquals("La superficie del casillero deberia ser Superficie Pantano", superficiePantano, casillero.getSurface());		
	}
	
	@Test
	public void testCruzarSuperficiePantano(){		
		Surface superficiePantano = new SuperficiePantano();				
		Assert.assertFalse("Modo humanoide no deberia poder cruzar superficie pantano", superficiePantano.puedeSerCruzadaPorModoHumanoide());
		Assert.assertTrue("Modo alterno terrestre deberia poder cruzar superficie pantano", superficiePantano.puedeSerCruzadaPorModoAlternoTerrestre());
		Assert.assertTrue("Modo alterno aereo deberia poder cruzar superficie pantano", superficiePantano.puedeSerCruzadaPorModoAlternoAereo());										
	}
}
