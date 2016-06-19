package fiuba.algo3.model.algoformers.game;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Nothing;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeJugarCuandoNoEsSuTurnoException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeUtilizarAlgoformerQueNoEsSuyoException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerAQuienDispararException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerException;
import fiuba.algo3.model.surfaces.SuperficiePantano;
import fiuba.algo3.model.surfaces.SurfaceAndromedaNebula;
import fiuba.algo3.model.surfaces.SurfaceCloud;
import fiuba.algo3.model.surfaces.SurfacePsionicStorm;
import fiuba.algo3.model.surfaces.SurfaceThorn;

public class Game {
	Player player1;
	Player player2;
	Board board;
	Turn turn;
	
	int BOARD_X_LENGTH = 14;
	int BOARD_Y_LENGTH = 14;
	

	public void init() throws InvalidPositionException {
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
				
		//Superficies
		this.board.addCell(new Cell(new Position(2,2), new SurfaceThorn()));
		this.board.addCell(new Cell(new Position(3,2), new SurfaceThorn()));
		this.board.addCell(new Cell(new Position(4,2), new SurfaceThorn()));
		this.board.addCell(new Cell(new Position(2,3), new SurfaceThorn()));
		this.board.addCell(new Cell(new Position(3,3), new SurfaceThorn()));
		this.board.addCell(new Cell(new Position(4,3), new SurfaceThorn()));
		
		this.board.addCell(new Cell(new Position(2,0), new SurfaceCloud()));
		
		this.board.addCell(new Cell(new Position(5,5), new SurfaceCloud()));
		this.board.addCell(new Cell(new Position(6,5), new SurfaceCloud()));
		
		this.board.addCell(new Cell(new Position(2,8), new SuperficiePantano()));
		this.board.addCell(new Cell(new Position(3,8), new SuperficiePantano()));
		
		this.board.addCell(new Cell(new Position(8,4), new SurfaceAndromedaNebula()));
		this.board.addCell(new Cell(new Position(12,8), new SurfaceAndromedaNebula()));
		
		this.board.addCell(new Cell(new Position(7,0), new SurfaceCloud()));
		this.board.addCell(new Cell(new Position(8,0), new SurfaceCloud()));
		this.board.addCell(new Cell(new Position(9,0), new SurfaceCloud()));
		this.board.addCell(new Cell(new Position(10,0), new SurfaceCloud()));
		this.board.addCell(new Cell(new Position(7,1), new SurfaceCloud()));
		this.board.addCell(new Cell(new Position(8,1), new SurfacePsionicStorm()));
		this.board.addCell(new Cell(new Position(9,1), new SurfacePsionicStorm()));
		this.board.addCell(new Cell(new Position(10,1), new SurfaceCloud()));
		this.board.addCell(new Cell(new Position(7,2), new SurfaceCloud()));
		this.board.addCell(new Cell(new Position(8,2), new SurfaceCloud()));
		this.board.addCell(new Cell(new Position(9,2), new SurfaceCloud()));
		this.board.addCell(new Cell(new Position(10,2), new SurfaceCloud()));
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
		
	public void setBoard(Board board){
		this.board = board;
	}
	public void setPlayer1(Player player1){
		this.player1 = player1;
	}
	public void setPlayer2(Player player2){
		this.player2 = player2;
	}
	public void setTurn(Turn turn){
		this.turn = turn;
	}
	
	public void nextTurn(){
		this.turn.next();		
	}
	
	public void moverAlgoformer(Position initialPosition, Position finalPosition) throws UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException {
	
		if (!this.board.isValidPosition(initialPosition) || !this.board.isValidPosition(finalPosition)){
			throw new InvalidPositionException();
		}
		
		Content content = this.board.getContent(initialPosition);
	
		
		Algoformer algoformer;
		
		try{
			algoformer = (Algoformer)content;
		}catch(ClassCastException ex){
			throw new UsuarioNoSeleccionoAlgoformerException();
		}
		
		if (!(this.turn.isActivePlayer(algoformer.getPlayer()))){
			throw new JugadorNoPuedeJugarCuandoNoEsSuTurnoException();
		}
		
		algoformer.move(finalPosition, this.board);
	}

	public void dispararaAlgoformer(Player jugador, Position initialPosition, Position finalPosition) throws JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeUtilizarAlgoformerQueNoEsSuyoException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, InvalidPositionException, AlgoformerUsadoEsteTurnoException {
		
		if (!this.board.isValidPosition(initialPosition) || !this.board.isValidPosition(finalPosition)){
			throw new InvalidPositionException();
		}
		
		Content content = this.board.getContent(initialPosition);
		if (!(this.turn.isActivePlayer(jugador))){
			throw new JugadorNoPuedeJugarCuandoNoEsSuTurnoException();
		}
		
		Algoformer algoformer;
		
		try{
			algoformer = (Algoformer)content;
		}catch(ClassCastException ex){
			throw new UsuarioNoSeleccionoAlgoformerException();
		}
		
		if (!jugador.hasAlgoformer(algoformer)){
			throw new JugadorNoPuedeUtilizarAlgoformerQueNoEsSuyoException();
		}
		
		Content contentDestino = this.board.getContent(finalPosition);
		
		Algoformer algoformerDestino;
		
		try{
			algoformerDestino = (Algoformer)contentDestino;
		}catch(ClassCastException ex){
			throw new UsuarioNoSeleccionoAlgoformerAQuienDispararException();
		}
		
		algoformer.shot(algoformerDestino);
	}

	public void transformaraAlgoformer(Player jugador, Position position) throws JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeUtilizarAlgoformerQueNoEsSuyoException, InvalidPositionException, AlgoformerUsadoEsteTurnoException {
		
		if (!this.board.isValidPosition(position)){
			throw new InvalidPositionException();
		}
		
		Content content = this.board.getContent(position);
		if (!(this.turn.isActivePlayer(jugador))){
			throw new JugadorNoPuedeJugarCuandoNoEsSuTurnoException();
		}
	
		Algoformer algoformer;
		
		try{
			algoformer = (Algoformer)content;
		}catch(ClassCastException ex){
			throw new UsuarioNoSeleccionoAlgoformerException();
		}
		
		if (!jugador.hasAlgoformer(algoformer)){
			throw new JugadorNoPuedeUtilizarAlgoformerQueNoEsSuyoException();
		}
		
		algoformer.transform();
	}

}
