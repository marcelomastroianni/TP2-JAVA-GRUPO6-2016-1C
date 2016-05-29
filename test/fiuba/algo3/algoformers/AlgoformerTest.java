package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Position;


public class AlgoformerTest {


	@Test
	public void testgetOptimusPrime(){
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime();
        Assert.assertEquals("Optimus Prime", optimusPrime.getNombre());

	}

	@Test
	public void testMovement(){
		Board board = new Board(5,5);
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime();


		algoformer.setPosition(new Position(0,0));
		board.add(algoformer);
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial",board.getContent(new Position(0,0)),algoformer);

		algoformer.moveEast(board);
		Assert.assertTrue("Algoformer deberia haberse movido a la derecha",board.isEmpty(new Position(0,0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha",board.getContent(new Position(2,0)),algoformer);

		algoformer.moveWest(board);
		Assert.assertTrue("Algoformer deberia haberse movido a la izquierda",board.isEmpty(new Position(2,0)));
		Assert.assertEquals("Algoformer deberia haberse movido a la izquierda",board.getContent(new Position(0,0)),algoformer);

		algoformer.moveSouth(board);
		Assert.assertTrue("Algoformer deberia haberse movido hacia abajo",board.isEmpty(new Position(0,0)));
		Assert.assertEquals("Algoformer deberia haberse movido hacia abajo",board.getContent(new Position(0,2)),algoformer);

		algoformer.moveNorth(board);
		Assert.assertTrue("Algoformer deberia haberse movido hacia arriba",board.isEmpty(new Position(0,2)));
		Assert.assertEquals("Algoformer deberia haberse movido hacia arriba",board.getContent(new Position(0,0)),algoformer);
	}

	@Test
	public void diagonalMovementTest(){
		Board board = new Board(5,5);
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime();


		algoformer.setPosition(new Position(0,0));
		board.add(algoformer);
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial",board.getContent(new Position(0,0)),algoformer);

		algoformer.moveSouthEast(board);
		Assert.assertTrue("Algoformer deberia haberse movido abajo a la derecha",board.isEmpty(new Position(0,0)));
		Assert.assertEquals("Algoformer deberia haberse movido hacia abajo",board.getContent(new Position(2,2)),algoformer);

		algoformer.moveSouthWest(board);
		Assert.assertTrue("Algoformer deberia haberse movido abajo a la izquierda",board.isEmpty(new Position(2,2)));
		Assert.assertEquals("Algoformer deberia haberse movido hacia arriba",board.getContent(new Position(0,4)),algoformer);


		algoformer.moveNorthEast(board);
		Assert.assertTrue("Algoformer deberia haberse movido arriba a la derecha",board.isEmpty(new Position(0,4)));
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha",board.getContent(new Position(2,2)),algoformer);

		algoformer.moveNorthWest(board);
		Assert.assertTrue("Algoformer deberia haberse movido arriba a la izquierda",board.isEmpty(new Position(2,2)));
		Assert.assertEquals("Algoformer deberia haberse movido a la izquierda",board.getContent(new Position(0,0)),algoformer);


	}


	@Test
	public void testTransform(){
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime();
        Assert.assertEquals("Modo deberia ser humanoide", algoformer.getActiveMode(), algoformer.getHumanoidMode());
        algoformer.transform();
        Assert.assertEquals("Modo deberia ser alterno", algoformer.getActiveMode(), algoformer.getAlternalMode());
        algoformer.transform();
        Assert.assertEquals("Modo deberia ser humanoide", algoformer.getActiveMode(), algoformer.getHumanoidMode());
        algoformer.transform();
        Assert.assertEquals("Modo deberia ser alterno", algoformer.getActiveMode(), algoformer.getAlternalMode());
	}



}
