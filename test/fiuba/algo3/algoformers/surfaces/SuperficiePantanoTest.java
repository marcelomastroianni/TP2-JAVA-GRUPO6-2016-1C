package fiuba.algo3.algoformers.surfaces;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
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
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(null);
		Surface superficiePantano = new SuperficiePantano();				
		Assert.assertFalse("Modo humanoide no deberia poder cruzar superficie pantano", superficiePantano.canBeCrossedByModeHumanoid());
		optimusPrime.transform();
		Assert.assertTrue("Modo alterno terrestre deberia poder cruzar superficie pantano", superficiePantano.canBeCrossedByModeAlternalTerrestrial());
		Algoformer megatron = AlgoFormerFactory.getMegatron(null);
		megatron.transform();
		Assert.assertTrue("Modo alterno aereo deberia poder cruzar superficie pantano", superficiePantano.canBeCrossedByModeAlternalAerial());										
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
		Assert.assertTrue("Algoformer deberia estar en la posicion (3,3)",optimus.getPosition().equals(new Position(3,3)));		
	}
	
	@Test
	public void testModoAlternoTerrestreTardaElDobleEnCruzarSuperficiePantano(){
		
		Board tablero = new Board(20,20);
		tablero.addCell(new Cell(new Position(3,3), new SuperficiePantano()));
		tablero.addCell(new Cell(new Position(4,3), new SuperficiePantano()));
		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(2,3));		
		tablero.add(optimus);

		optimus.transform();
		Assert.assertTrue(optimus.getActiveMode() instanceof ModeAlternalTerrestrial);
		optimus.move(new Position(10,3), tablero);
		Assert.assertTrue("Algoformer deberia estar en la posicion (5,3)",optimus.getPosition().equals(new Position(5,3)));
			
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(2,8));
		tablero.add(bumblebee);
		tablero.addCell(new Cell(new Position(3,8), new SuperficiePantano()));
		bumblebee.transform();
		Assert.assertTrue(bumblebee.getActiveMode() instanceof ModeAlternalTerrestrial);
		bumblebee.move(new Position(10,8), tablero);
		Assert.assertTrue("Algoformer deberia estar en la posicion (6,8)",bumblebee.getPosition().equals(new Position(6,8)));
	}
}
