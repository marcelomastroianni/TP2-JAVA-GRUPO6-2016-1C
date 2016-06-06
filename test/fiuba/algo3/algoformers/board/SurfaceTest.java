package fiuba.algo3.algoformers.board;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.surfaces.Thorn;

public class SurfaceTest {
	int XBOARDLENGTH = 10;
	int YBOARDLENGTH = 10;
	private Board board;
	
	@Before
	public void setUp(){
		board = new Board(XBOARDLENGTH,YBOARDLENGTH);
	
	}	
	
	@Test
	public void crossThornReduceLifeOfTerrestial(){	
		board.addCell(new Cell(new Position(1, 0), new Thorn()));

		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(0, 0));
		board.add(optimus);
		optimus.move(new Position(2,0), board);
		Assert.assertEquals("su vida se ve reducida 5% porque atraviesa un casillero con espinas",475, optimus.getLife());
	
	}
	
	@Test
	public void startInthornReduceLifeOfTerrestial(){	
		board.addCell(new Cell(new Position(0, 0), new Thorn()));

		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(0, 0));
		board.add(optimus);
		optimus.move(new Position(1,0), board);
		Assert.assertEquals("su vida se sigue igual porque comienza en un casillero con espinas, ya lo atraveso en otro turno",500, optimus.getLife());
	
	}
	
	@Test
	public void endInthornDontReduceLifeOfTerrestial(){	
		board.addCell(new Cell(new Position(1, 0), new Thorn()));

		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(0, 0));
		board.add(optimus);
		optimus.move(new Position(1,0), board);
		Assert.assertEquals("su vida se ve reducida un 5% porque termina en un casillero con espinas",475, optimus.getLife());
	
	}

}
