package fiuba.algo3.algoformers.bonus;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.surfaces.SuperficieRocosa;

public class CanonBonusTest {
	@Test
	public void createCanonBonus(){	
		final Position position = new Position(0,0);
		CanonBonus canonBonus =CanonBonus.createCanonBonus(position);
		Cell cell= new Cell(position, new SuperficieRocosa()); 
		cell.add(canonBonus);
		Assert.assertEquals("la celda deberia contener un canonBonus",cell.getContent(), canonBonus);
}

}
