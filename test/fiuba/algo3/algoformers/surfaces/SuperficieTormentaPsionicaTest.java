package fiuba.algo3.algoformers.surfaces;

import fiuba.algo3.model.exceptions.AlgoformerAtrapadoEsteTurnoException;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Nothing;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
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
	public void testModoAlternoTerrestreNoCruzaSuperficieTormentaPsionica() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Board tablero = new Board(20,20);
		tablero.addCell(new Cell(new Position(3,3), new SurfacePsionicStorm()));
		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(2,3));
		tablero.add(optimus);
		optimus.transform();
		optimus.notifyNextTurn();
		Assert.assertTrue(optimus.getActiveMode() instanceof ModeAlternalTerrestrial);
		optimus.move(new Position(4,3), tablero);
		optimus.notifyNextTurn();
		Assert.assertEquals("Algoformer no deberia estar en la posicion (4,3)",new Nothing(new Position(4,3)),tablero.getContent(new Position(4,3)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (4,3)",optimus.getPosition().equals(new Position(4,3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,3)",optimus.getPosition().equals(new Position(2,3)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (2,3)",tablero.getContent(new Position(2,3)),optimus);
	}

	@Test
	public void testModoHumanoideNoCruzaSuperficieTormentaPsionica() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Board tablero = new Board(20,20);
		tablero.addCell(new Cell(new Position(3,3), new SurfacePsionicStorm()));
		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(2,3));
		tablero.add(optimus);
		Assert.assertTrue(optimus.getActiveMode() instanceof ModeHumanoid);
		optimus.move(new Position(4,3), tablero);
		Assert.assertEquals("Algoformer no deberia estar en la posicion (4,3)",new Nothing(new Position(4,3)),tablero.getContent(new Position(4,3)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (4,3)",optimus.getPosition().equals(new Position(4,3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,3)",optimus.getPosition().equals(new Position(2,3)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (2,3)",tablero.getContent(new Position(2,3)),optimus);
	}

	@Test
	public void testModoHumanoideMantieneAttackPower() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 0), new SurfacePsionicStorm()));
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(0,0));
		tablero.add(megatron);
		megatron.move(new Position(2,0), tablero);
		megatron.notifyNextTurn();
		Assert.assertEquals("algoformer humanoide debe mantener el mismo poder de ataque",new Integer(10),megatron.getActiveMode().getAttack());
	}

	@Test
	public void testModoAereoAlternoCruzaSuperficieTormentaPsionicaPeroPierdePoderDeAtaque() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 0), new SurfacePsionicStorm()));
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(0,0));
		tablero.add(megatron);
		megatron.transform();
		megatron.notifyNextTurn();
		megatron.move(new Position(2,0), tablero);
		megatron.notifyNextTurn();
		Assert.assertEquals("algoformer alterno aereo deberia reducirse su poder de ataque al pasar por la tormenta psionica",new Integer(33),megatron.getActiveMode().getAttack());
	}

	@Test
	public void testModoAereoAlternoEsInmuneAlCruzaSuperficieTormentaPsionicaPorSegundaVez() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 0), new SurfacePsionicStorm()));
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(0,0));
		tablero.add(megatron);
		megatron.transform();
		megatron.notifyNextTurn();
		megatron.move(new Position(2,0), tablero);
		megatron.notifyNextTurn();
		Assert.assertEquals("algoformer alterno aereo deberia reducirse su poder de ataque al pasar por la tormenta psionica",new Integer(33),megatron.getActiveMode().getAttack());
		megatron.notifyNextTurn();
		megatron.move(new Position(0,0), tablero);
		Assert.assertEquals("algoformer alterno aereo deberia mantener su poder de ataque al pasar por segunda vez por una tormenta psionica",new Integer(33),megatron.getActiveMode().getAttack());
	}
}
