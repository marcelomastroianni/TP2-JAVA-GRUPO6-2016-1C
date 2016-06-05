package fiuba.algo3.algoformers.surfaces;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;
import fiuba.algo3.model.algoformers.board.Board;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.surfaces.SuperficieRocosa;
import fiuba.algo3.model.surfaces.Surface;




public class SuperficieRocosaTest {

	@Test
	public void testCrearSuperficieRocosa(){		
		Surface superficieRocosa = new SuperficieRocosa();		
		Cell casillero = new Cell(new Position(0,0),superficieRocosa);		
		Assert.assertEquals("La superficie del casillero deberia ser Superficie Rocosa", superficieRocosa, casillero.getSurface());		
	}
	
	@Test
	public void testCruzarSuperficieRocosa(){		
		Surface superficieRocosa = new SuperficieRocosa();				
		Assert.assertTrue("Modo humanoide deberia poder cruzar superficie rocosa", superficieRocosa.puedeSerCruzadaPorModoHumanoide());
		Assert.assertTrue("Modo alterno terrestre deberia poder cruzar superficie rocosa", superficieRocosa.puedeSerCruzadaPorModoAlternoTerrestre());
		Assert.assertTrue("Modo alterno aereo deberia poder cruzar superficie rocosa", superficieRocosa.puedeSerCruzadaPorModoAlternoAereo());										
	}

	@Test
	public void testModoHumanoideCruzaSuperficieRocosa() {

		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 5), new SuperficieRocosa()));
		tablero.addCell(new Cell(new Position(2, 5), new SuperficieRocosa()));
		tablero.addCell(new Cell(new Position(3, 5), new SuperficieRocosa()));
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(1, 5));
		tablero.add(bumblebee);

		Assert.assertTrue(bumblebee.getActiveMode() instanceof ModeHumanoid);
		Assert.assertTrue("bumblebee deberia estar en la posicion (1,5)", bumblebee.getPosition().equals(new Position(1, 5)));

		bumblebee.move(new Position(3, 5), tablero);

		Assert.assertTrue("bumblebee deberia estar en la posicion (3,5)", bumblebee.getPosition().equals(new Position(3, 5)));
	}

	@Test
	public void testModoAlternoCruzaSuperficieRocosa() {

		Board tablero = new Board(10, 10);
		tablero.addCell(new Cell(new Position(1, 5), new SuperficieRocosa()));
		tablero.addCell(new Cell(new Position(2, 5), new SuperficieRocosa()));
		tablero.addCell(new Cell(new Position(3, 5), new SuperficieRocosa()));
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(1, 5));
		frenzy.transform();
		tablero.add(frenzy);

		Assert.assertTrue(frenzy.getActiveMode() instanceof ModeAlternalTerrestrial);
		Assert.assertTrue("frenzy deberia estar en la posicion (1,5)", frenzy.getPosition().equals(new Position(1, 5)));

		frenzy.move(new Position(3, 5), tablero);

		Assert.assertTrue("frenzy deberia estar en la posicion (3,5)", frenzy.getPosition().equals(new Position(3, 5)));
	}
}
