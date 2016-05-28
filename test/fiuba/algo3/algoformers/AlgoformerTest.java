package fiuba.algo3.algoformers;

import junit.framework.Assert;
import org.junit.Test;

public class AlgoformerTest {

	@Test
	public void testAlgoformers(){
        Algoformer optimus = new Algoformer();
        
        String nombre = optimus.getNombre();
        Assert.assertEquals("Nombre deberia ser Optimus","Optimus", nombre);
        
	}
	

}
