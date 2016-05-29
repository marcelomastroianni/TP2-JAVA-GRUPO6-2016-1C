package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Test;


public class NothingTest {
	@Test
	public void compareNothingWithNothingTest(){
		IContent nada1 = new Nothing();
		IContent nada2 = new Nothing();
		Assert.assertEquals(nada1,nada2);
	}

}
