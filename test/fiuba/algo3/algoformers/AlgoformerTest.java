package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;


public class AlgoformerTest {


	@Test
	public void testMovement(){
		Board board = new Board(5,5);
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0,0));



		board.add(algoformer);
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial",board.getContent(new Position(0,0)),algoformer);

		algoformer.move(new Position(2,0),board);
		Assert.assertTrue("Algoformer deberia haberse movido a la derecha",board.isEmpty(new Position(0,0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha",board.getContent(new Position(2,0)),algoformer);

		algoformer.move(new Position(0,0),board);
		Assert.assertTrue("Algoformer deberia haberse movido a la izquierda",board.isEmpty(new Position(2,0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la izquierda",board.getContent(new Position(0,0)),algoformer);

		algoformer.move(new Position(0,2),board);
		Assert.assertTrue("Algoformer deberia haberse movido hacia abajo",board.isEmpty(new Position(0,0)));
		Assert.assertEquals("Algoformer deberia haberse movido hacia abajo",board.getContent(new Position(0,2)),algoformer);

		algoformer.move(new Position(0,0),board);
		Assert.assertTrue("Algoformer deberia haberse movido hacia arriba",board.isEmpty(new Position(0,2)));
		Assert.assertEquals("Algoformer deberia haberse movido hacia arriba",board.getContent(new Position(0,0)),algoformer);
	}




	@Test
	public void diagonalMovementTest(){
		Board board = new Board(5,5);
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0,0));

		board.add(algoformer);
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial",board.getContent(new Position(0,0)),algoformer);

		algoformer.move(new Position(2,2),board);
		Assert.assertTrue("Algoformer deberia haberse movido abajo a la derecha",board.isEmpty(new Position(0,0)));
		Assert.assertEquals("Algoformer deberia haberse movido hacia abajo",board.getContent(new Position(2,2)),algoformer);

		algoformer.move(new Position(0,4),board);
		Assert.assertTrue("Algoformer deberia haberse movido abajo a la izquierda",board.isEmpty(new Position(2,2)));
		Assert.assertEquals("Algoformer deberia haberse movido hacia arriba",board.getContent(new Position(0,4)),algoformer);


		algoformer.move(new Position(2,2),board);
		Assert.assertTrue("Algoformer deberia haberse movido arriba a la derecha",board.isEmpty(new Position(0,4)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha",board.getContent(new Position(2,2)),algoformer);

		algoformer.move(new Position(0,0),board);
		Assert.assertTrue("Algoformer deberia haberse movido arriba a la izquierda",board.isEmpty(new Position(2,2)));
		Assert.assertEquals("Algoformer deberia haberse movido a la izquierda",board.getContent(new Position(0,0)),algoformer);


	}
	

	@Test
	public void testInvalidMovement(){
		Board board = new Board(5,5);
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0,0));

		board.add(algoformer);
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial",board.getContent(new Position(0,0)),algoformer);

		algoformer.move(new Position(-2,0),board);
		Assert.assertFalse("Algoformer no deberia haberse movido a la derecha",board.isEmpty(new Position(0,0)));
		Assert.assertEquals("Algoformer sigue en la misma posicion",board.getContent(new Position(0,0)),algoformer);
		Assert.assertTrue("no hay nada en la posicion 2,0",board.isEmpty(new Position(2,0)));
		
	}


	@Test
	public void testTransform(){
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
        Assert.assertEquals("Modo deberia ser humanoide", algoformer.getActiveMode(), algoformer.getHumanoidMode());
        algoformer.transform();
        Assert.assertEquals("Modo deberia ser alterno", algoformer.getActiveMode(), algoformer.getAlternalMode());
        algoformer.transform();
        Assert.assertEquals("Modo deberia ser humanoide", algoformer.getActiveMode(), algoformer.getHumanoidMode());
        algoformer.transform();
        Assert.assertEquals("Modo deberia ser alterno", algoformer.getActiveMode(), algoformer.getAlternalMode());
	}

	@Test
	public void testShootingToAnotherAlgoformer(){

		Board board = new Board(5,5);
		Algoformer algoformer1 = AlgoFormerFactory.getFrenzy(new Position(2,0));
		Algoformer algoformer2 = AlgoFormerFactory.getOptimusPrime(new Position(2,4));

		board.add(algoformer1);
		board.add(algoformer2);

		Assert.assertEquals("La vida de Optimus deberia ser 500", 500, algoformer2.getLife());
		algoformer1.shot(algoformer2);
		Assert.assertEquals("La vida de Optimus deberia ser 490", 490, algoformer2.getLife());
		Assert.assertEquals("La vida de Frenzy deberia ser 400", 400, algoformer1.getLife());
		algoformer2.shot(algoformer1);
		Assert.assertEquals("La vida de Frenzy deberia ser 400", 400, algoformer1.getLife());
	}



}
