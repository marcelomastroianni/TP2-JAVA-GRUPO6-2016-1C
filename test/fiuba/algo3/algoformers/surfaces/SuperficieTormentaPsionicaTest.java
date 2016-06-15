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
import fiuba.algo3.model.surfaces.SurfacePsionicStorm;
import fiuba.algo3.model.surfaces.Surface;

public class SuperficieTormentaPsionicaTest {

	@Test
	public void testCrearSuperficieTormentaPsionica(){		
		Surface superficieTormentaPsionica = new SurfacePsionicStorm();		
		Cell casillero = new Cell(new Position(0,0),superficieTormentaPsionica);		
		Assert.assertEquals("La superficie del casillero deberia ser Superficie Tormenta Psionica", superficieTormentaPsionica, casillero.getSurface());		
	}

	@Test
	public void testModoAlternoTerrestreNoCruzaSuperficieTormentaPsionica(){
		Board tablero = new Board(20,20);
		tablero.addCell(new Cell(new Position(3,3), new SurfacePsionicStorm()));
		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(2,3));		
		tablero.add(optimus);
		optimus.transform();
		optimus.notifyNextTurn();
		Assert.assertTrue(optimus.getActiveMode() instanceof ModeAlternalTerrestrial);
		optimus.move(new Position(4,3), tablero);
		optimus.notifyNextTurn();
		Assert.assertTrue("Algoformer no deberia estar en la posicion (4,3)",tablero.isEmpty(new Position(4,3)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (4,3)",optimus.getPosition().equals(new Position(4,3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,3)",optimus.getPosition().equals(new Position(2,3)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (2,3)",tablero.getContent(new Position(2,3)),optimus);												
	}
	
	@Test
	public void testModoHumanoideNoCruzaSuperficieTormentaPsionica(){
		Board tablero = new Board(20,20);
		tablero.addCell(new Cell(new Position(3,3), new SurfacePsionicStorm()));
		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(2,3));		
		tablero.add(optimus);
		Assert.assertTrue(optimus.getActiveMode() instanceof ModeHumanoid);
		optimus.move(new Position(4,3), tablero);
		Assert.assertTrue("Algoformer no deberia estar en la posicion (4,3)",tablero.isEmpty(new Position(4,3)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (4,3)",optimus.getPosition().equals(new Position(4,3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,3)",optimus.getPosition().equals(new Position(2,3)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (2,3)",tablero.getContent(new Position(2,3)),optimus);							
	}
	
	@Test
	public void testModoAereoAlternoCruzaSuperficieTormentaPsionicaPeroPierdePoderDeAtaque(){
		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 0), new SurfacePsionicStorm()));
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(0,0));
		tablero.add(megatron);
		megatron.transform();
		megatron.notifyNextTurn();
		megatron.move(new Position(2,0), tablero);
		megatron.notifyNextTurn();
		//Assert.assertEquals(33,megatron.getActiveMode().getAttack());
	}

	
}
