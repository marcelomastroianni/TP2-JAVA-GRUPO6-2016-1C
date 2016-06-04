package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.Mode;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;
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
	public void testLargeDistanceMovement(){
		Board board = new Board(100,100);
		int speed1 = 2;
		
		Mode mode1 = new Mode(50,2,speed1);	
		Algoformer algoformer = new Algoformer("Algoformer 1", mode1,mode1,500,new Position(0,0));			
		board.add(algoformer);
		
		
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial",new Position(0,0),algoformer.getPosition());
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial",board.getContent(new Position(0,0)),algoformer);
		
		algoformer.move(new Position(3,0),board);
		
		Assert.assertTrue("Algoformer no deberia estar en la posicion (0,0)",board.isEmpty(new Position(0,0)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (2,0)",new Position(2,0),algoformer.getPosition());
		Assert.assertEquals("Algoformer deberia estar en la posicion (2,0)",board.getContent(new Position(2,0)),algoformer);

		algoformer.move(new Position(3,0),board);
		Assert.assertTrue("Algoformer no deberia estar en la posicion (2,0)",board.isEmpty(new Position(2,0)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (3,0)",new Position(3,0),algoformer.getPosition());
		Assert.assertEquals("Algoformer deberia estar en la posicion (3,0)",board.getContent(new Position(3,0)),algoformer);				
						
		algoformer.move(new Position(10,10),board);
		Assert.assertTrue("Algoformer no deberia estar en la posicion (3,0)",board.isEmpty(new Position(3,0)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (5,2)",new Position(5,2),algoformer.getPosition());
		Assert.assertEquals("Algoformer deberia estar en la posicion (5,2)",board.getContent(new Position(5,2)),algoformer);
					
		algoformer.move(new Position(10,10),board);
		Assert.assertTrue("Algoformer no deberia estar en la posicion (5,2)",board.isEmpty(new Position(5,2)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (7,4)",new Position(7,4),algoformer.getPosition());
		Assert.assertEquals("Algoformer deberia estar en la posicion (7,4)",board.getContent(new Position(7,4)),algoformer);
				
		algoformer.move(new Position(10,10),board);
		Assert.assertTrue("Algoformer no deberia estar en la posicion (7,4)",board.isEmpty(new Position(7,4)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (9,6)",new Position(9,6),algoformer.getPosition());
		Assert.assertEquals("Algoformer deberia estar en la posicion (9,6)",board.getContent(new Position(9,6)),algoformer);
		
		
		algoformer.move(new Position(10,10),board);
		Assert.assertTrue("Algoformer no deberia estar en la posicion (9,6)",board.isEmpty(new Position(9,6)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (10,8)",new Position(10,8),algoformer.getPosition());
		Assert.assertEquals("Algoformer deberia estar en la posicion (10,8)",board.getContent(new Position(10,8)),algoformer);
		
		
		algoformer.move(new Position(10,10),board);
		Assert.assertTrue("Algoformer no deberia estar en la posicion (10,8)",board.isEmpty(new Position(10,8)));
		Assert.assertEquals("Algoformer deberia estar en la posicion (10,10)",new Position(10,10),algoformer.getPosition());
		Assert.assertEquals("Algoformer deberia estar en la posicion (10,10)",board.getContent(new Position(10,10)),algoformer);
		
		int speed2 = 7;
		Mode mode2 = new Mode(50,2,speed2);	
		Algoformer algoformer2 = new Algoformer("Algoformer 2 ", mode2,mode2,500,new Position(50,50));			
		board.add(algoformer2);
		
		
		Assert.assertEquals("Algoformer 2 deberia estar en su posicion inicial",new Position(50,50),algoformer2.getPosition());
		Assert.assertEquals("Algoformer 2 deberia estar en su posicion inicial",board.getContent(new Position(50,50)),algoformer2);
		
		algoformer2.move(new Position(40,60),board);
		Assert.assertTrue("Algoformer 2 no deberia estar en la posicion (50,50)",board.isEmpty(new Position(50,50)));
		Assert.assertEquals("Algoformer 2 deberia estar en la posicion (43,57)",new Position(43,57),algoformer2.getPosition());
		Assert.assertEquals("Algoformer 2 deberia estar en la posicion (43,57)",board.getContent(new Position(43,57)),algoformer2);
		
		algoformer2.move(new Position(40,60),board);
		Assert.assertTrue("Algoformer 2 no deberia estar en la posicion (43,57)",board.isEmpty(new Position(43,57)));
		Assert.assertEquals("Algoformer 2 deberia estar en la posicion (40,60)",new Position(40,60),algoformer2.getPosition());
		Assert.assertEquals("Algoformer 2 deberia estar en la posicion (40,60)",board.getContent(new Position(40,60)),algoformer2);
		
		
		
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
