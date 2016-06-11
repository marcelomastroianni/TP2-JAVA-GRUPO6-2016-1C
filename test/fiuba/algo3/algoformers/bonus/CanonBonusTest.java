package fiuba.algo3.algoformers.bonus;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Nothing;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.surfaces.SuperficieRocosa;

public class CanonBonusTest {
	@Test
	public void createCanonBonus(){	
		CanonBonus canonBonus = new CanonBonus();
		Cell cell= new Cell(new Position(0,0), new SuperficieRocosa()); 
		cell.add(canonBonus);
		Assert.assertEquals("la celda deberia contener un canonBonus",cell.getContent(), canonBonus);
}

}
