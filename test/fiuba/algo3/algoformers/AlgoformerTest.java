package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.Mode;
import fiuba.algo3.model.algoformers.ModeAlternalTerrestrial;
import fiuba.algo3.model.algoformers.ModeHumanoid;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.surfaces.SurfacePsionicStorm;

public class AlgoformerTest {
	@Test
	public void testMovement(){
		Board board = new Board(5,5);
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0,0));

		board.add(algoformer);
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial",board.getContent(new Position(0,0)),algoformer);

		algoformer.move(new Position(2,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha",new Position(2,0),algoformer.getPosition());

		algoformer.move(new Position(0,0),board);	
		Assert.assertEquals("Algoformer deberia haberse movido a la izquierda",new Position(0,0),algoformer.getPosition());

		algoformer.move(new Position(0,2),board);
		Assert.assertEquals("Algoformer deberia haberse movido hacia abajo",new Position(0,2),algoformer.getPosition());

		algoformer.move(new Position(0,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido hacia arriba",new Position(0,0),algoformer.getPosition());
	}

	@Test
	public void diagonalMovementTest(){
		Board board = new Board(5,5);
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0,0));

		board.add(algoformer);
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial",board.getContent(new Position(0,0)),algoformer);

		algoformer.move(new Position(2,2),board);
		Assert.assertEquals("Algoformer deberia haberse movido hacia abajo",new Position(2,2),algoformer.getPosition());

		algoformer.move(new Position(0,4),board);
		Assert.assertEquals("Algoformer deberia haberse movido hacia arriba",new Position(0,4),algoformer.getPosition());

		algoformer.move(new Position(2,2),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la derecha",new Position(2,2),algoformer.getPosition());

		algoformer.move(new Position(0,0),board);
		Assert.assertEquals("Algoformer deberia haberse movido a la izquierda",new Position(0,0),algoformer.getPosition());
	}	
	
	@Test
	public void testLargeDistanceMovement(){
		Board board = new Board(100,100);
		int speed1 = 2;
		
		Mode mode1 = new ModeHumanoid(50,2,speed1);	
		Algoformer algoformer = new Algoformer("Algoformer 1", mode1,mode1,500,new Position(0,0), Algoformer.Team.AUTOBOTS);			
		board.add(algoformer);
		
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial",new Position(0,0),algoformer.getPosition());
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial",board.getContent(new Position(0,0)),algoformer);
		
		algoformer.move(new Position(3,0),board);
		Assert.assertEquals("Algoformer deberia estar en la posicion (2,0)",new Position(2,0),algoformer.getPosition());

		algoformer.move(new Position(3,0),board);
		Assert.assertEquals("Algoformer deberia estar en la posicion (3,0)",new Position(3,0),algoformer.getPosition());				
						
		algoformer.move(new Position(10,10),board);
		Assert.assertEquals("Algoformer deberia estar en la posicion (5,2)",new Position(5,2),algoformer.getPosition());
					
		algoformer.move(new Position(10,10),board);
		Assert.assertEquals("Algoformer deberia estar en la posicion (7,4)",new Position(7,4),algoformer.getPosition());
				
		algoformer.move(new Position(10,10),board);
		Assert.assertEquals("Algoformer deberia estar en la posicion (9,6)",new Position(9,6),algoformer.getPosition());
		
		algoformer.move(new Position(10,10),board);
		Assert.assertEquals("Algoformer deberia estar en la posicion (10,8)",new Position(10,8),algoformer.getPosition());
		
		algoformer.move(new Position(10,10),board);
		Assert.assertEquals("Algoformer deberia estar en la posicion (10,10)",new Position(10,10),algoformer.getPosition());
		
		int speed2 = 7;
		Mode mode2 = new ModeHumanoid(50,2,speed2);	
		Algoformer algoformer2 = new Algoformer("Algoformer 2 ", mode2,mode2,500,new Position(50,50), Algoformer.Team.AUTOBOTS);			
		board.add(algoformer2);
		
		Assert.assertEquals("Algoformer 2 deberia estar en su posicion inicial",new Position(50,50),algoformer2.getPosition());
		
		algoformer2.move(new Position(40,60),board);
		Assert.assertEquals("Algoformer 2 deberia estar en la posicion (43,57)",new Position(43,57),algoformer2.getPosition());
		
		algoformer2.move(new Position(40,60),board);
		Assert.assertEquals("Algoformer 2 deberia estar en la posicion (40,60)",new Position(40,60),algoformer2.getPosition());
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

	@Test
	public void testDobleDamageActiveOn(){

		Board board = new Board(10,10);
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(5,5));

		board.add(bumblebee);

		Assert.assertEquals("El poder de ataquer de bumblebee deberia ser 40", new Integer(40), bumblebee.getActiveMode().getAttack());
		bumblebee.dobleDamage(2);
		Assert.assertEquals("El poder de ataquer de bumblebee deberia ser 80", new Integer(80), bumblebee.getActiveMode().getAttack());
	}

	@Test
	public void testDobleDamageActiveFor2Turns(){

		Board board = new Board(10,10);
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(5,5));

		board.add(bumblebee);

		Assert.assertEquals("El poder de ataquer de bumblebee deberia ser 40", new Integer(40), bumblebee.getActiveMode().getAttack());
		bumblebee.dobleDamage(2);
		Assert.assertEquals("El poder de ataquer de bumblebee deberia ser 80", new Integer(80), bumblebee.getActiveMode().getAttack());
		bumblebee.notifyNextTurn();
		Assert.assertEquals("El poder de ataquer de bumblebee deberia ser 80", new Integer(80), bumblebee.getActiveMode().getAttack());
		bumblebee.notifyNextTurn();
		Assert.assertEquals("El poder de ataquer de bumblebee deberia ser 80", new Integer(80), bumblebee.getActiveMode().getAttack());
		bumblebee.notifyNextTurn();
		Assert.assertEquals("El poder de ataquer de bumblebee deberia ser 40", new Integer(40), bumblebee.getActiveMode().getAttack());
	}
}

