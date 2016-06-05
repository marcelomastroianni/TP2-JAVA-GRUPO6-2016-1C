package fiuba.algo3.algoformers.surfaces;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.surfaces.SuperficiePantano;
import fiuba.algo3.model.surfaces.Surface;

public class SuperficiePantanoTest {

	@Test
	public void testCrearSuperficiePantano(){		
		Surface superficiePantano = new SuperficiePantano();		
		Cell casillero = new Cell(new Position(0,0),superficiePantano);		
		Assert.assertEquals("La superficie del casillero deberia ser Superficie Pantano", superficiePantano, casillero.getSurface());		
	}
	
	@Test
	public void testCruzarSuperficiePantano(){		
		Surface superficiePantano = new SuperficiePantano();				
		Assert.assertFalse("Modo humanoide no deberia poder cruzar superficie pantano", superficiePantano.puedeSerCruzadaPorModoHumanoide());
		Assert.assertTrue("Modo alterno terrestre deberia poder cruzar superficie pantano", superficiePantano.puedeSerCruzadaPorModoAlternoTerrestre());
		Assert.assertTrue("Modo alterno aereo deberia poder cruzar superficie pantano", superficiePantano.puedeSerCruzadaPorModoAlternoAereo());										
	}
	
	@Test
	public void testModoHumanoideNoCruzaSuperficiePantano(){		
		
		Board tablero = new Board(20,20);
		tablero.addCell(new Cell(new Position(3,3), new SuperficiePantano()));
		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(2,3));		
		tablero.add(optimus);
		Assert.assertTrue(optimus.getActiveMode() instanceof ModeHumanoid);
		optimus.move(new Position(3,3), tablero);
		
		Assert.assertTrue("Algoformer no deberia estar en la posicion (3,3)",tablero.isEmpty(new Position(3,3)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (3,3)",optimus.getPosition().equals(new Position(3,3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,3)",optimus.getPosition().equals(new Position(2,3)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (2,3)",tablero.getContent(new Position(2,3)),optimus);
		
	}
	
	@Test
	public void testModoAlternoTerrestreCruzaSuperficiePantano(){		
		Board tablero = new Board(20,20);
		tablero.addCell(new Cell(new Position(3,3), new SuperficiePantano()));
		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(2,3));		
		tablero.add(optimus);
		Assert.assertTrue(optimus.getActiveMode() instanceof ModeHumanoid);		
		optimus.transform();
		Assert.assertTrue(optimus.getActiveMode() instanceof ModeAlternalTerrestrial);
		optimus.move(new Position(3,3), tablero);
		Assert.assertTrue("Algoformer no deberia estar en la posicion (2,3)",tablero.isEmpty(new Position(2,3)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (2,3)",optimus.getPosition().equals(new Position(2,3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (3,3)",optimus.getPosition().equals(new Position(3,3)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (3,3)",tablero.getContent(new Position(3,3)),optimus);
		
	}
	
}
