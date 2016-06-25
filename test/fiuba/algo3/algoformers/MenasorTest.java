package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.exceptions.InvalidPositionException;

public class MenasorTest {


	@Test
	public void menasorTest() throws InvalidPositionException{
		Game game = new Game();
		Player player1 = new Player(game, "Juan");

		Algoformer algoformer1 = AlgoFormerFactory.getMegatron(new Position(0,0));
		Algoformer algoformer2= AlgoFormerFactory.getBonecrusher(new Position(0,1));
		Algoformer algoformer3 = AlgoFormerFactory.getFrenzy(new Position(1,0));
		player1.addAlgoformer(algoformer1);
		player1.addAlgoformer(algoformer2);
		player1.addAlgoformer(algoformer3);

		player1.mergeTransformers();
		Assert.assertEquals(player1.getAlgoformers().size(), 1);
		Assert.assertEquals(player1.getAlgoformers().get(0).getNombre(), "Menasor");
	}

	@Test
	public void deadAlgoformerCantMerge() throws InvalidPositionException{
		Game game = new Game();
		Player player1 = new Player(game, "Juan");
		Board board = new Board(10,10);


		Algoformer algoformer1 = AlgoFormerFactory.getMegatron(new Position(0,0));
		Algoformer algoformer2= AlgoFormerFactory.getBonecrusher(new Position(0,1));
		Algoformer algoformer3 = AlgoFormerFactory.getFrenzy(new Position(1,0));

		board.add(algoformer1);
		board.add(algoformer2);
		board.add(algoformer3);

		player1.addAlgoformer(algoformer1);
		player1.addAlgoformer(algoformer2);
		player1.addAlgoformer(algoformer3);



		algoformer2.downHealthPoints(200, board);
		Assert.assertEquals(player1.getAlgoformers().size(), 2);
		player1.mergeTransformers();
		Assert.assertEquals(player1.getAlgoformers().size(), 2);
	}

}
