package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Test;


public class NothingTest {
	@Test
	public void compareNothingWithNothingTest(){
		Content nada1 = new Nothing();
		Content nada2 = new Nothing();
		Assert.assertEquals(nada1,nada2);
	}

}
