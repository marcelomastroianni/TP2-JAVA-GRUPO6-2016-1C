package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.exceptions.InvalidPositionException;


public class SuperionTest {

	@Test
	public void superionTest() throws InvalidPositionException{
		Game game = new Game();
		Player player1 = new Player(game, "Juan");


		Algoformer algoformer1 = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer algoformer2 = AlgoFormerFactory.getBumblebee(new Position(0,1));
		Algoformer algoformer3 = AlgoFormerFactory.getRatchet(new Position(1,0));


		player1.addAlgoformer(algoformer1);
		player1.addAlgoformer(algoformer2);
		player1.addAlgoformer(algoformer3);


		player1.mergeTransformers();
		Assert.assertEquals(player1.getAlgoformers().size(), 1);
		Assert.assertEquals(player1.getAlgoformers().get(0).getNombre(), "Superion");
	}


	@Test
	public void superionTestDistance() throws InvalidPositionException{
		Game game = new Game();
		Player player1 = new Player(game, "Juan");


		Algoformer algoformer1 = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer algoformer2 = AlgoFormerFactory.getBumblebee(new Position(0,1));
		Algoformer algoformer3 = AlgoFormerFactory.getRatchet(new Position(3,3));


		player1.addAlgoformer(algoformer1);
		player1.addAlgoformer(algoformer2);
		player1.addAlgoformer(algoformer3);


		player1.mergeTransformers();
		Assert.assertEquals(player1.getAlgoformers().size(), 3);
	}




}
