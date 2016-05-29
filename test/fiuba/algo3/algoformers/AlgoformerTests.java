package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

public class AlgoformerTests {

	@Test
	public void testAlgoformers(){
        Algoformer optimus = new Algoformer();
        String nombre = optimus.getNombre();
        Assert.assertEquals("Nombre deberia ser Optimus","Optimus", nombre);
        
	}
	
	@Test
	public void testCrearAlgoformers(){
		Algoformer optimus = new Algoformer();

		optimus.setNombre("Optimus");
		optimus.setPuntosVida(500);

		ModoTerrestre optimusHumanoide = new ModoTerrestre();
		optimusHumanoide.setNombre("Humanoide");
		optimusHumanoide.setDescripcion("Humanoide");
		optimusHumanoide.setAtaque(50);
		optimusHumanoide.setDistanciaAtaque(2);
		optimusHumanoide.setVelocidad(2);

		ModoTerrestre optimusAlterno = new ModoTerrestre();
		optimusAlterno.setNombre("Alterno");
		optimusAlterno.setDescripcion("Peterbilt 379 azul con llamas rojas");
		optimusAlterno.setAtaque(15);
		optimusAlterno.setDistanciaAtaque(4);
		optimusAlterno.setVelocidad(5);


		optimus.setModoHumanoide(optimusHumanoide);
		optimus.setModoAlterno(optimusAlterno);


		//////////////////////////////////////////////////////////////////////////////////////



		Algoformer ratchet = new Algoformer();

		optimus.setNombre("Ratchet");
		optimus.setPuntosVida(150);

		ModoTerrestre ratchetHumanoide = new ModoTerrestre();
		ratchetHumanoide.setNombre("Humanoide");
		ratchetHumanoide.setDescripcion("Humanoide");
		ratchetHumanoide.setAtaque(5);
		ratchetHumanoide.setDistanciaAtaque(5);
		ratchetHumanoide.setVelocidad(1);

		ModoAereo ratchetAlterno = new ModoAereo();
		ratchetAlterno.setNombre("Alterno");
		ratchetAlterno.setDescripcion("F22 raptor");
		ratchetAlterno.setAtaque(35);
		ratchetAlterno.setDistanciaAtaque(2);
		ratchetAlterno.setVelocidad(8);


		ratchet.setModoHumanoide(ratchetHumanoide);
		ratchet.setModoAlterno(ratchetAlterno);
        
	}
	

		
}
