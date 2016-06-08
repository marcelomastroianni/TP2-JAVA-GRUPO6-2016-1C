package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;

public class AlgoformerUnitTest {

	private Board board;

	@Before
	public void setUp() {
		board = new Board(10, 10);
	}

	@Test
	public void addToBoartTest() {
		Algoformer algoformer = AlgoFormerFactory.getBumblebee(new Position(0, 0));
		board.add(algoformer);
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial", board.getContent(new Position(0, 0)),
				algoformer);
	}

	@Test
	public void activeModeTest() {
		Algoformer algoformer = AlgoFormerFactory.getMegatron(new Position(0, 0));
		Assert.assertEquals("Modo deberia ser humanoide", algoformer.getActiveMode(), algoformer.getHumanoidMode());
	}

	@Test
	public void transformationTest() {
		Algoformer algoformer = AlgoFormerFactory.getFrenzy(new Position(0, 0));
		algoformer.transform();
		Assert.assertEquals("Modo deberia ser alterno", algoformer.getActiveMode(), algoformer.getAlternalMode());
	}
	
	@Test
	public void reduceLifeTest() {
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0, 0));
		algoformer.reduceLife();
		Assert.assertEquals("Algoformer deberia tener una vida de 475 puntos",475,algoformer.getLife());

	}
	
	@Test
	public void alternalAerialModeTest(){
		Algoformer algoformer = AlgoFormerFactory.getMegatron(new Position(0,0));
		algoformer.transform();
		Assert.assertTrue(algoformer.getActiveMode() instanceof ModeAlternalAerial);
		
	}
	
	@Test
	public void reduceAttackPowerTest(){
		Algoformer algoformer = AlgoFormerFactory.getMegatron(new Position(0,0));
		algoformer.transform();
		algoformer.getActiveMode().reduceAttackPower(0.6);
		Assert.assertEquals("el algoformer debe tener su poder de ataque reducido un 40 %",new Integer(33),algoformer.getActiveMode().getAttack() );
	
	}
	
	




}
