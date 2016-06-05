package fiuba.algo3.algoformers.surfaces;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.surfaces.SuperficieRocosa;




public class SuperficieRocosaTest {

	@Test
	public void testCrearSuperficieRocosa(){		
		SuperficieRocosa superficieRocosa = new SuperficieRocosa();		
		Cell casillero = new Cell(new Position(0,0));		
		casillero.setSurface(superficieRocosa);		
		Assert.assertEquals("La superficie del casillero deberia ser Superficie Rocosa", superficieRocosa, casillero.getSurface());		
	}
	
	@Test
	public void testCruzarSuperficieRocosa(){		
		SuperficieRocosa superficieRocosa = new SuperficieRocosa();				
		Assert.assertTrue("Modo humanoide deberia poder cruzar superficie rocosa", superficieRocosa.puedeSerCruzadaPorModoHumanoide());
		Assert.assertTrue("Modo alterno terrestre deberia poder cruzar superficie rocosa", superficieRocosa.puedeSerCruzadaPorModoAlternoTerrestre());
		Assert.assertTrue("Modo alterno aereo deberia poder cruzar superficie rocosa", superficieRocosa.puedeSerCruzadaPorModoAlternoAereo());										
	}
	
	
}
