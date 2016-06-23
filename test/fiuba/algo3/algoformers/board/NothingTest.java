package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Nothing;
import fiuba.algo3.model.algoformers.board.Position;


public class NothingTest {
	@Test
	public void compareNothingWithNothingTest(){
		Content nada1 = new Nothing(new Position(0,0));
		Content nada2 = new Nothing(new Position(0,0));
		Assert.assertEquals(nada1,nada2);
	}

	@Test
	public void testPosition() {
		Content nothing = new Nothing(new Position(0, 0));
		Assert.assertEquals(nothing.getPosition(), new Position(0, 0));
	}
}
