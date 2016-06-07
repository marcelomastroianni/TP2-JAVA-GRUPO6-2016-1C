package fiuba.algo3.algoformers.entregas;

import static org.junit.Assert.*;
import fiuba.algo3.model.algoformers.*;
import fiuba.algo3.model.surfaces.SurfaceCloud;
import fiuba.algo3.model.surfaces.SuperficieRocosa;
import fiuba.algo3.model.surfaces.SurfaceThorn;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.surfaces.SuperficiePantano;

public class SegundaEntregaTest {

	/**
	 * 1. Llenar una zona rocosa, verificar que todos los algoformers en 
	 * todos sus modos la atraviesen sin problemas
	 */
	@Test
	public void test01() {
		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 5), new SuperficieRocosa()));
		tablero.addCell(new Cell(new Position(2, 5), new SuperficieRocosa()));
		tablero.addCell(new Cell(new Position(3, 5), new SuperficieRocosa()));
		tablero.addCell(new Cell(new Position(4, 5), new SuperficieRocosa()));
		tablero.addCell(new Cell(new Position(5, 5), new SuperficieRocosa()));

		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(1, 5));
		tablero.add(optimus);
		Assert.assertTrue(optimus.getActiveMode() instanceof ModeHumanoid);
		Assert.assertTrue("optimus deberia estar en la posicion (1,5)", optimus.getPosition().equals(new Position(1, 5)));
		optimus.move(new Position(3, 5), tablero);
		Assert.assertTrue("optimus deberia estar en la posicion (3,5)", optimus.getPosition().equals(new Position(3, 5)));
		optimus.transform();
		Assert.assertTrue(optimus.getActiveMode() instanceof ModeAlternalTerrestrial);
		optimus.move(new Position(5, 5), tablero);
		Assert.assertTrue("optimus deberia estar en la posicion (5,5)", optimus.getPosition().equals(new Position(5, 5)));
		tablero.remove(optimus);

		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(1, 5));
		tablero.add(bumblebee);
		Assert.assertTrue(bumblebee.getActiveMode() instanceof ModeHumanoid);
		Assert.assertTrue("bumblebee deberia estar en la posicion (1,5)", bumblebee.getPosition().equals(new Position(1, 5)));
		bumblebee.move(new Position(3, 5), tablero);
		Assert.assertTrue("bumblebee deberia estar en la posicion (3,5)", bumblebee.getPosition().equals(new Position(3, 5)));
		bumblebee.transform();
		Assert.assertTrue(bumblebee.getActiveMode() instanceof ModeAlternalTerrestrial);
		bumblebee.move(new Position(5, 5), tablero);
		Assert.assertTrue("bumblebee deberia estar en la posicion (5,5)", bumblebee.getPosition().equals(new Position(5, 5)));
		tablero.remove(bumblebee);

		Algoformer ratchet = AlgoFormerFactory.getRatchet(new Position(1, 5));
		tablero.add(ratchet);
		Assert.assertTrue(ratchet.getActiveMode() instanceof ModeHumanoid);
		Assert.assertTrue("ratchet deberia estar en la posicion (1,5)", ratchet.getPosition().equals(new Position(1, 5)));
		ratchet.move(new Position(2, 5), tablero);
		Assert.assertTrue("ratchet deberia estar en la posicion (2,5)", ratchet.getPosition().equals(new Position(2, 5)));
		ratchet.transform();
		Assert.assertTrue(ratchet.getActiveMode() instanceof ModeAlternalAerial);
		ratchet.move(new Position(5, 5), tablero);
		Assert.assertTrue("ratchet deberia estar en la posicion (5,5)", ratchet.getPosition().equals(new Position(5, 5)));
		tablero.remove(ratchet);

		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(1, 5));
		tablero.add(megatron);
		Assert.assertTrue(megatron.getActiveMode() instanceof ModeHumanoid);
		Assert.assertTrue("megatron deberia estar en la posicion (1,5)", megatron.getPosition().equals(new Position(1, 5)));
		megatron.move(new Position(2, 5), tablero);
		Assert.assertTrue("megatron deberia estar en la posicion (2,5)", megatron.getPosition().equals(new Position(2, 5)));
		megatron.transform();
		Assert.assertTrue(megatron.getActiveMode() instanceof ModeAlternalAerial);
		megatron.move(new Position(5, 5), tablero);
		Assert.assertTrue("megatron deberia estar en la posicion (5,5)", megatron.getPosition().equals(new Position(5, 5)));
		tablero.remove(megatron);

		Algoformer bonecrusher = AlgoFormerFactory.getBonecrusher(new Position(1, 5));
		tablero.add(bonecrusher);
		Assert.assertTrue(bonecrusher.getActiveMode() instanceof ModeHumanoid);
		Assert.assertTrue("bonecrusher deberia estar en la posicion (1,5)", bonecrusher.getPosition().equals(new Position(1, 5)));
		bonecrusher.move(new Position(2, 5), tablero);
		Assert.assertTrue("bonecrusher deberia estar en la posicion (2,5)", bonecrusher.getPosition().equals(new Position(2, 5)));
		bonecrusher.transform();
		Assert.assertTrue(bonecrusher.getActiveMode() instanceof ModeAlternalTerrestrial);
		bonecrusher.move(new Position(5, 5), tablero);
		Assert.assertTrue("bonecrusher deberia estar en la posicion (5,5)", bonecrusher.getPosition().equals(new Position(5, 5)));
		tablero.remove(bonecrusher);

		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(1, 5));
		tablero.add(frenzy);
		Assert.assertTrue(frenzy.getActiveMode() instanceof ModeHumanoid);
		Assert.assertTrue("frenzy deberia estar en la posicion (1,5)", frenzy.getPosition().equals(new Position(1, 5)));
		frenzy.move(new Position(3, 5), tablero);
		Assert.assertTrue("frenzy deberia estar en la posicion (3,5)", frenzy.getPosition().equals(new Position(3, 5)));
		frenzy.transform();
		Assert.assertTrue(frenzy.getActiveMode() instanceof ModeAlternalTerrestrial);
		frenzy.move(new Position(5, 5), tablero);
		Assert.assertTrue("frenzy deberia estar en la posicion (5,5)", frenzy.getPosition().equals(new Position(5, 5)));
		tablero.remove(frenzy);
	}
	
	/**
	 * 2. Llenar una zona pantano, verificar que en modo humanoide no se pueda atravesar.
	 */
	@Test
	public void test02() {
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

		optimus.transform();
		Assert.assertTrue(optimus.getActiveMode() instanceof ModeAlternalTerrestrial);
		optimus.move(new Position(3,3), tablero);
		Assert.assertTrue("Algoformer no deberia estar en la posicion (2,3)",tablero.isEmpty(new Position(2,3)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (2,3)",optimus.getPosition().equals(new Position(2,3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (3,3)",optimus.getPosition().equals(new Position(3,3)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (3,3)",tablero.getContent(new Position(3,3)),optimus);
		
		
	}
	
	/**
	 * 3. LLenar una zona pantano, verificar que en modo alterno las unidades 
	 * terrestres tardan el doble que rocoso
	 */
	@Test
	public void test03() {
		
		Board tablero = new Board(20,20);
		tablero.addCell(new Cell(new Position(3,3), new SuperficiePantano()));
		tablero.addCell(new Cell(new Position(4,3), new SuperficiePantano()));
		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(2,3));		
		tablero.add(optimus);

		optimus.transform();
		Assert.assertTrue(optimus.getActiveMode() instanceof ModeAlternalTerrestrial);
		optimus.move(new Position(10,3), tablero);
		Assert.assertTrue("Algoformer no deberia estar en la posicion (2,3)",tablero.isEmpty(new Position(2,3)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (2,3)",optimus.getPosition().equals(new Position(2,3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (5,3)",optimus.getPosition().equals(new Position(5,3)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (5,3)",tablero.getContent(new Position(5,3)),optimus);
	
		
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(2,8));
		tablero.add(bumblebee);
		tablero.addCell(new Cell(new Position(3,8), new SuperficiePantano()));
		bumblebee.transform();
		Assert.assertTrue(bumblebee.getActiveMode() instanceof ModeAlternalTerrestrial);
		bumblebee.move(new Position(10,8), tablero);
		Assert.assertTrue("Algoformer no deberia estar en la posicion (3,8)",tablero.isEmpty(new Position(3,8)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (3,8)",bumblebee.getPosition().equals(new Position(3,8)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (6,8)",bumblebee.getPosition().equals(new Position(6,8)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (6,8)",tablero.getContent(new Position(6,8)),bumblebee);
		
	}
	
	/**
	 * 4. LLenar una zona pantano, verificar que las unidades aéreas las atraviesan sin problemas
	 */
	@Test
	public void test04() {
		Board tablero = new Board(20,20);
		tablero.addCell(new Cell(new Position(3,3), new SuperficiePantano()));
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(2,3));		
		tablero.add(megatron);
		megatron.transform();
		Assert.assertTrue(megatron.getActiveMode() instanceof ModeAlternalAerial);
		megatron.move(new Position(4,3), tablero);
		
		Assert.assertTrue("Algoformer no deberia estar en la posicion (3,3)",tablero.isEmpty(new Position(3,3)));
		Assert.assertFalse("Algoformer no deberia estar en la posicion (3,3)",megatron.getPosition().equals(new Position(3,3)));
		Assert.assertTrue("Algoformer deberia estar en la posicion (2,3)",megatron.getPosition().equals(new Position(4,3)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (2,3)",tablero.getContent(new Position(4,3)),megatron);

	}
	
	/**
	 * 5. Llenar una zona de espinas verificar que todas las unidades terrestres pierden un 5% de sus 
	 * vida por cada casillero de estos que atraviesen
	 */
	@Test
	public void test05() {
		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 0), new SurfaceThorn()));
		tablero.addCell(new Cell(new Position(2, 0), new SurfaceThorn()));

		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(0, 0));
		tablero.add(optimus);
		optimus.move(new Position(3,0), tablero);
		Assert.assertEquals("su vida se ve reducida 5% por cada casillero",451, optimus.getLife());
		
		optimus.transform();
		
		optimus.move(new Position(1,0), tablero);
		Assert.assertEquals("su vida se ve reducida 5% por un casillero de espinas",428, optimus.getLife());
		
	}
	
	/**
	 * 6. LLenar una zona de espinas, verificar que unidades aéreas no tienen problemas al 
	 * atravesarlas.
	 */
	@Test
	public void test06() {
		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 0), new SurfaceThorn()));
		tablero.addCell(new Cell(new Position(2, 0), new SurfaceThorn()));

		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(0,0));
		tablero.add(megatron);
		megatron.transform();
		megatron.move(new Position(3,0), tablero);
		Assert.assertEquals(550, megatron.getLife() );
	}
	
	/**
	 * 7. Llenar una zona con nubes, verificar que las unidades aéreas las atraviesan sin problemas.
	 */
	@Test
	public void test07() {
		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 0), new SurfaceCloud()));
		tablero.addCell(new Cell(new Position(2, 0), new SurfaceCloud()));

		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(0,0));
		tablero.add(megatron);
		megatron.transform();
		Position newPosition = new Position(3,0);
		megatron.move(newPosition, tablero);
		Assert.assertEquals(newPosition, megatron.getPosition() );
	}
	
	/**
	 * 8. Llenar una zona de nebulosa de andrómeda, pasar una unidad aérea, corroborar que 
	 * quede 3 turnos atrapada, sin moverse
	 */
	@Test
	public void test08() {
	}
	
	/**
	 * 9. Llenar una zona de tormenta psiónica, pasar un algoformer alterno aéreo, ver que baje su 
	 * capacidad de ataque
	 */
	@Test
	public void test09() {
	}
	
	/**
	 * 10. {@link #test09() test09} + volver a pasar y ver que no bajó su capacidad de ataque.
	 */
	@Test
	public void test10() {
	}

}
