package fiuba.algo3.model.algoformers.game;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerParaMoverException;

public class Game {

	Player player1;
	Player player2;
	Board board;
	Turn turn;
	
	int BOARD_X_LENGTH = 20;
	int BOARD_Y_LENGTH = 20;
	

	public void init() {
		this.player1 = new Player();
		this.player2 = new Player();
		this.board = new Board(BOARD_X_LENGTH,BOARD_Y_LENGTH);
		this.turn = new Turn(this.player1, this.player2);
		
		//Autobots:
		Algoformer optimusPrime = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer bumblebee = AlgoFormerFactory.getBumblebee(new Position(0,1));
		Algoformer ratchet = AlgoFormerFactory.getRatchet(new Position(0,2));	
		
	
		
	
		
		//Decepticons:
		Algoformer megatron = AlgoFormerFactory.getMegatron(new Position(board.getXLength()-1,0));		
		Algoformer bonecrusher = AlgoFormerFactory.getBonecrusher(new Position(board.getXLength()-1,1));
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(board.getXLength()-1,2));
		
		

				
		
		this.player1.addAlgoformer(optimusPrime);
		this.player1.addAlgoformer(bumblebee);
		this.player1.addAlgoformer(ratchet);
		
		this.player2.addAlgoformer(megatron);
		this.player2.addAlgoformer(bonecrusher);
		this.player2.addAlgoformer(frenzy);
		
		ChispaSuprema chispaSuprema = new ChispaSuprema(board.getCentralPosition());

		
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

	public void moverAlgoformer(Player jugador1, Position initialPosition, Position finalPosition) throws UsuarioNoSeleccionoAlgoformerParaMoverException {
		Content content = this.board.getContent(initialPosition);
		
		if (!(content instanceof Algoformer)){
			throw new UsuarioNoSeleccionoAlgoformerParaMoverException();
		}
		
		Algoformer algofomer = (Algoformer)content;
		
		algofomer.move(finalPosition, this.board);

	}

}
