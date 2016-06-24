package fiuba.algo3.algoformers;

import java.util.List;

import fiuba.algo3.model.exceptions.AlgoformerAtrapadoEsteTurnoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.ModeAlternalAerial;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;

public class AlgoformerUnitTest {

	private Board board;

	@Before
	public void setUp() {
		board = new Board(10, 10);
	}

	@Test
	public void addToBoartTest() throws InvalidPositionException {
		Algoformer algoformer = AlgoFormerFactory.getBumblebee(new Position(0, 0));
		board.add(algoformer);
		Assert.assertEquals("Algoformer deberia estar en su posicion inicial", board.getContent(new Position(0, 0)),
				algoformer);
	}

	@Test
	public void activeModeTest() {
		Algoformer algoformer = AlgoFormerFactory.getMegatron(new Position(0, 0));
		Assert.assertTrue("Modo deberia ser humanoide", algoformer.isHumanoidMode());
	}

	@Test
	public void transformationTest() throws AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Algoformer algoformer = AlgoFormerFactory.getFrenzy(new Position(0, 0));
		algoformer.transform();
		Assert.assertTrue("Modo deberia ser alterno", algoformer.isAlternalMode() );
	}
	
	@Test
	public void reduceLifeTest() {
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0, 0));
		algoformer.reduceLifeFivePercent();
		Assert.assertEquals("Algoformer deberia tener una vida de 475 puntos",475,algoformer.getLife());
	}
	
	@Test
	public void alternalAerialModeTest() throws AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Algoformer algoformer = AlgoFormerFactory.getMegatron(new Position(0,0));
		algoformer.transform();
		Assert.assertTrue(algoformer.isAlternalMode());
	}
	
	@Test
	public void reduceAttackPowerTest() throws AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Algoformer algoformer = AlgoFormerFactory.getMegatron(new Position(0,0));
		algoformer.transform();
		algoformer.reduceAttackPowerFortyPercent();
		Assert.assertEquals("el algoformer debe tener su poder de ataque reducido un 40 %",33,algoformer.getAttack() );
	}
	
	@Test
	public void duplicateAttackPowerTest() {
		Algoformer algoformer = AlgoFormerFactory.getOptimusPrime(new Position(0, 0));	
		algoformer.dobleDamage(2);
		Assert.assertEquals("Algoformer deberia tener un poder de ataque de 100 puntos",100,algoformer.getAttack());
	}
	
	@Test
	public void twoEqualsAlgoformersTest(){
		Algoformer algoformer1 = AlgoFormerFactory.getMegatron(new Position(0,0));
		Algoformer algoformer2 = AlgoFormerFactory.getMegatron(new Position(0,0));
	}
	
	@Test
	public void twoDiferentsAlgoformersTest(){
		Algoformer algoformer1 = AlgoFormerFactory.getMegatron(new Position(0,0));
		Algoformer algoformer2 = AlgoFormerFactory.getBonecrusher(new Position(0,0));
	}

	@Test
	public void twoEqualsAlgoformersInDiferentStatesTest() throws AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		Algoformer algoformer1 = AlgoFormerFactory.getMegatron(new Position(0,0));
		Algoformer algoformer2 = AlgoFormerFactory.getMegatron(new Position(0,0));
		algoformer2.transform();
	}
	
	
	
}
