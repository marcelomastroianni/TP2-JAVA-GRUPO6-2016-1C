package fiuba.algo3.algoformers.surfaces;

import fiuba.algo3.model.exceptions.AlgoformerAtrapadoEsteTurnoException;
import fiuba.algo3.model.exceptions.AlgoformerCombinandoseEsteTurnoException;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Nothing;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.ModoAlternoNoPuedeCapturarChispaSupremaException;
import fiuba.algo3.model.exceptions.NoPuedeMoverseDondeEstaOtroAlgoformerException;
import fiuba.algo3.model.surfaces.SurfaceAndromedaNebula;
import fiuba.algo3.model.surfaces.Surface;


public class SuperficieNebulosaAndromedaTest {

	@Test
	public void testCrearSuperficieNebulosaAndromeda(){
		Surface superficieNebulosaAndromeda = new SurfaceAndromedaNebula();
		Cell casillero = new Cell(new Position(0,0),superficieNebulosaAndromeda);
		Assert.assertEquals("La superficie del casillero deberia ser Superficie Nebulosa Andromeda", superficieNebulosaAndromeda, casillero.getSurface());
	}

	@Test
	public void testModoAlternoTerrestreNoCruzaSuperficieNebulosaAndromeda() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException {
		Board tablero = new Board(20,20);
		tablero.addCell(new Cell(new Position(3,3), new SurfaceAndromedaNebula()));
		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(2,3));
		tablero.add(optimus);
		optimus.transform();
		optimus.notifyNextTurn();
		Assert.assertTrue(optimus.isAlternalMode());
		optimus.move(new Position(4,3), tablero);
		optimus.notifyNextTurn();
		Assert.assertEquals("Algoformer no deberia estar en la posicion (4,3)",new Nothing(new Position(4,3)),  tablero.getContent(new Position(4,3)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (4,3)",optimus.getPosition().equals(new Position(4,3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,3)",optimus.getPosition().equals(new Position(2,3)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (2,3)",tablero.getContent(new Position(2,3)),optimus);
	}

	@Test
	public void testModoHumanoideNoCruzaSuperficieNebulosaAndromeda() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException {
		Board tablero = new Board(20,20);
		tablero.addCell(new Cell(new Position(3,3), new SurfaceAndromedaNebula()));
		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(2,3));
		tablero.add(optimus);
		Assert.assertTrue(optimus.isHumanoidMode());
		optimus.move(new Position(4,3), tablero);

		Assert.assertEquals("Algoformer no deberia estar en la posicion (4,3)",new Nothing(new Position(4,3)), tablero.getContent(new Position(4,3)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (4,3)",optimus.getPosition().equals(new Position(4,3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,3)",optimus.getPosition().equals(new Position(2,3)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (2,3)",tablero.getContent(new Position(2,3)),optimus);
	}

	@Test
	public void testModoAereoSeQuedaAtrapadoEnSuperficieNebulosaAndromeda() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException {
		Board tablero = new Board(20,20);
		tablero.addCell(new Cell(new Position(3,3), new SurfaceAndromedaNebula()));
		Algoformer ratchet = AlgoFormerFactory.getRatchet(new Position(2,3));
		tablero.add(ratchet);
		Assert.assertTrue(ratchet.isHumanoidMode());
		ratchet.transform();
		ratchet.notifyNextTurn();
		Assert.assertTrue(ratchet.isAlternalMode());
		ratchet.move(new Position(4,3), tablero);
		Assert.assertEquals("Algoformer no deberia estar en la posicion (2,3)",new Nothing(new Position(2,3)), tablero.getContent(new Position(2,3)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (2,3)",ratchet.getPosition().equals(new Position(2,3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (3,3)",ratchet.getPosition().equals(new Position(3,3)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (3,3)",tablero.getContent(new Position(3,3)),ratchet);
	}
}
