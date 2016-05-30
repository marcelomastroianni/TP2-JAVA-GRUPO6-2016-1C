package fiuba.algo3.algoformers.game;

import fiuba.algo3.algoformers.AlgoFormerFactory;
import fiuba.algo3.algoformers.Algoformer;
import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.ChispaSuprema;
import fiuba.algo3.algoformers.board.Position;

public class Game {

	Player player1;
	Player player2;
	Board board = Board.getInstance();
	
	public void init() {
		this.player1 = new Player();
		this.player2 = new Player();
		
		//Autobots:
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime();
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee();
		Algoformer ratchet = AlgoFormerFactory.getRatchet();	
		
		optimusPrime.setPosition(new Position(0,0));
		bumblebee.setPosition(new Position(0,1));
		ratchet.setPosition(new Position(0,2));
		
	
		
		//Decepticons:
		Algoformer megatron = AlgoFormerFactory.getMegatron();		
		Algoformer bonecrusher = AlgoFormerFactory.getBonecrusher();
		Algoformer frenzy = AlgoFormerFactory.getFrenzy();
		
		
		megatron.setPosition(new Position(Board.X_LENGHT-1,0));
		bonecrusher.setPosition(new Position(Board.X_LENGHT-1,1));
		frenzy.setPosition(new Position(Board.X_LENGHT-1,2));
				
		
		this.player1.addAlgoformer(optimusPrime);
		this.player1.addAlgoformer(bumblebee);
		this.player1.addAlgoformer(ratchet);
		
		this.player2.addAlgoformer(megatron);
		this.player2.addAlgoformer(bonecrusher);
		this.player2.addAlgoformer(frenzy);
		
		ChispaSuprema chispaSuprema = new ChispaSuprema();
		chispaSuprema.setPosition(board.getCentralPosition());
		
		this.board.add(chispaSuprema);
		
		//Autobots:
		this.board.add(optimusPrime);
		this.board.add(bumblebee);
		this.board.add(ratchet);
		
		//Decepticons:
		this.board.add(megatron);
		this.board.add(bonecrusher);
		this.board.add(frenzy);
		
		
	}
	
	public Player getPlayer1() {
		return this.player1;
	}
	
	public Player getPlayer2() {
		return this.player2;
	}

	public Board getBoard() {
		return this.board;
	}

}
