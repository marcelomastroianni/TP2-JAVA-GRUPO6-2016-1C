package fiuba.algo3.algoformers.entregas;

import static org.junit.Assert.*;

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

public class SegundaEntregaTest {

	/**
	 * 1. Llenar una zona rocosa, verificar que todos los algoformers en 
	 * todos sus modos la atraviesen sin problemas
	 */
	@Test
	public void test01() {
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
	}
	
	/**
	 * 4. LLenar una zona pantano, verificar que las unidades aéreas las atraviesan sin problemas
	 */
	@Test
	public void test04() {
	}
	
	/**
	 * 5. Llenar una zona de espinas verificar que todas las unidades terrestres pierden un 5% de sus 
	 * vida por cada casillero de estos que atraviesen
	 */
	@Test
	public void test05() {
	}
	
	/**
	 * 6. LLenar una zona de espinas, verificar que unidades aéreas no tienen problemas al 
	 * atravesarlas.
	 */
	@Test
	public void test06() {
	}
	
	/**
	 * 7. Llenar una zona con nubes, verificar que las unidades aéreas las atraviesan sin problemas.
	 */
	@Test
	public void test07() {
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
