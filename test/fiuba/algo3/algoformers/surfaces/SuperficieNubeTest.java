package fiuba.algo3.algoformers.surfaces;

import fiuba.algo3.model.exceptions.AlgoformerAtrapadoEsteTurnoException;
import fiuba.algo3.model.exceptions.AlgoformerCombinandoseEsteTurnoException;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.surfaces.SurfaceCloud;
import fiuba.algo3.model.surfaces.Surface;

public class SuperficieNubeTest {

	@Test
	public void testCrearSuperficieNube(){		
		Surface superficieNube = new SurfaceCloud();		
		Cell casillero = new Cell(new Position(0,0),superficieNube);		
		Assert.assertEquals("La superficie del casillero deberia ser Superficie Rocosa", superficieNube, casillero.getSurface());		
	}
	
	@Test
	public void testCruzarSuperficieNube() throws AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(null);
		Surface superficieNube = new SurfaceCloud();				
		Assert.assertFalse("Modo humanoide no deberia poder cruzar superficie nube", superficieNube.canBeCrossedByModeHumanoid());
		optimusPrime.transform();
		Assert.assertFalse("Modo alterno terrestre no deberia poder cruzar superficie nube", superficieNube.canBeCrossedByModeAlternalTerrestrial());
		Algoformer megatron = AlgoFormerFactory.getMegatron(null);
		megatron.transform();
		Assert.assertTrue("Modo alterno aereo deberia poder cruzar superficie nube", superficieNube.canBeCrossedByModeAlternalAerial());										
	}
}
