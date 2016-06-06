package fiuba.algo3.algoformers.surfaces;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;
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
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(null);
		Surface superficieNube = new SuperficieNube();				
		Assert.assertFalse("Modo humanoide no deberia poder cruzar superficie nube", superficieNube.canBeCrossedBy((ModeHumanoid) optimusPrime.getActiveMode()));
		optimusPrime.transform();
		Assert.assertFalse("Modo alterno terrestre no deberia poder cruzar superficie nube", superficieNube.canBeCrossedBy((ModeAlternalTerrestrial) optimusPrime.getActiveMode()));
		Algoformer megatron = AlgoFormerFactory.getMegatron(null);
		megatron.transform();
		Assert.assertTrue("Modo alterno aereo deberia poder cruzar superficie nube", superficieNube.canBeCrossedBy((ModeAlternalAerial) megatron.getActiveMode()));										
	}
}
