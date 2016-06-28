package fiuba.algo3.algoformers.surfaces;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.exceptions.AlgoformerAtrapadoEsteTurnoException;
import fiuba.algo3.model.exceptions.AlgoformerCombinandoseEsteTurnoException;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.ModoAlternoNoPuedeCapturarChispaSupremaException;
import fiuba.algo3.model.exceptions.NoPuedeMoverseDondeEstaOtroAlgoformerException;
import fiuba.algo3.model.surfaces.SurfaceRocky;
import fiuba.algo3.model.surfaces.Surface;

public class SuperficieRocosaTest {

	@Test
	public void testCrearSuperficieRocosa(){
		Surface superficieRocosa = new SurfaceRocky();
		Cell casillero = new Cell(new Position(0,0),superficieRocosa);
		Assert.assertEquals("La superficie del casillero deberia ser Superficie Rocosa", superficieRocosa, casillero.getSurface());
	}

	@Test
	public void testCruzarSuperficieRocosa() throws AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(null);
		Surface superficieRocosa = new SurfaceRocky();
		Assert.assertTrue("Modo humanoide deberia poder cruzar superficie rocosa", superficieRocosa.canBeCrossedByModeHumanoid());
		optimusPrime.transform();
		Assert.assertTrue("Modo alterno terrestre deberia poder cruzar superficie rocosa", superficieRocosa.canBeCrossedByModeAlternalTerrestrial());
		Algoformer megatron = AlgoFormerFactory.getMegatron(null);
		megatron.transform();
		Assert.assertTrue("Modo alterno aereo deberia poder cruzar superficie rocosa", superficieRocosa.canBeCrossedByModeAlternalAerial());
	}

	@Test
	public void testModoHumanoideCruzaSuperficieRocosa() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException {

		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 5), new SurfaceRocky()));
		tablero.addCell(new Cell(new Position(2, 5), new SurfaceRocky()));
		tablero.addCell(new Cell(new Position(3, 5), new SurfaceRocky()));
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(1, 5));
		tablero.add(bumblebee);

		Assert.assertTrue(bumblebee.isHumanoidMode());
		Assert.assertTrue("bumblebee deberia estar en la posicion (1,5)", bumblebee.getPosition().equals(new Position(1, 5)));

		bumblebee.move(new Position(3, 5), tablero);

		Assert.assertTrue("bumblebee deberia estar en la posicion (3,5)", bumblebee.getPosition().equals(new Position(3, 5)));
	}

	@Test
	public void testModoAlternoCruzaSuperficieRocosa() throws AlgoformerUsadoEsteTurnoException, InvalidPositionException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException {

		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 5), new SurfaceRocky()));
		tablero.addCell(new Cell(new Position(2, 5), new SurfaceRocky()));
		tablero.addCell(new Cell(new Position(3, 5), new SurfaceRocky()));
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(1, 5));
		frenzy.transform();
		frenzy.notifyNextTurn( );
		tablero.add(frenzy);

		Assert.assertTrue(frenzy.isAlternalMode());
		Assert.assertTrue("frenzy deberia estar en la posicion (1,5)", frenzy.getPosition().equals(new Position(1, 5)));

		frenzy.move(new Position(3, 5), tablero);
		frenzy.notifyNextTurn( );

		Assert.assertTrue("frenzy deberia estar en la posicion (3,5)", frenzy.getPosition().equals(new Position(3, 5)));
	}

}
