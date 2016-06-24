package fiuba.algo3.model.algoformers.game;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.bonus.BubbleBonus;
import fiuba.algo3.model.bonus.FlashBonus;
import fiuba.algo3.model.bonus.CanonBonus;
import fiuba.algo3.model.exceptions.*;
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
	
	boolean isOver = false;
	Player winner;


	public void init(String namePlayer1,String namePlayer2) throws InvalidPositionException {
		this.player1 = new Player(this, namePlayer1);
		this.player2 = new Player(this, namePlayer2);
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

		player1.addAlgoformer(optimusPrime);
		player1.addAlgoformer(bumblebee);
		player1.addAlgoformer(ratchet);

		player2.addAlgoformer(megatron);
		player2.addAlgoformer(bonecrusher);
		player2.addAlgoformer(frenzy);

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

		this.board.addCell(new Cell(new Position(2,7), new SuperficiePantano()));
		this.board.addCell(new Cell(new Position(3,7), new SuperficiePantano()));
		this.board.addCell(new Cell(new Position(5,1), new SuperficiePantano()));
		this.board.addCell(new Cell(new Position(6,1), new SuperficiePantano()));


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

		this.board.add(new CanonBonus(new Position(4,4)));
		this.board.add(new BubbleBonus(new Position(3,1)));
		this.board.add(new FlashBonus(new Position(2,5)));

	}

	public boolean isOver(){
		return this.isOver;
	}
	
	public Player getWinner(){
		return this.winner;
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

	public Turn getTurn() {
		return this.turn;
	}

	public String getActivePlayer(){
		if(this.getTurn().isActivePlayer(this.getPlayer1()))
			return "Jugador 1: " + this.getPlayer1().getName();
		else
			return "Jugador 2: " + this.getPlayer2().getName();
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

	public void moverAlgoformer(Position initialPosition, Position finalPosition) throws AlgoformerAtrapadoEsteTurnoException, InvalidPositionException, UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, AlgoformerUsadoEsteTurnoException {

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

	public void dispararaAlgoformer( Position initialPosition, Position finalPosition) throws InvalidPositionException, UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, UsuarioNoSeleccionoAlgoformerAQuienDispararException, AlgoformerUsadoEsteTurnoException {

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

		Content contentDestino = this.board.getContent(finalPosition);

		Algoformer algoformerDestino;

		try{
			algoformerDestino = (Algoformer)contentDestino;
		}catch(ClassCastException ex){
			throw new UsuarioNoSeleccionoAlgoformerAQuienDispararException();
		}

		algoformer.shot(algoformerDestino,this.board);
	}

	public void transformaraAlgoformer(Position position) throws AlgoformerAtrapadoEsteTurnoException, InvalidPositionException, UsuarioNoSeleccionoAlgoformerException, JugadorNoPuedeJugarCuandoNoEsSuTurnoException, AlgoformerUsadoEsteTurnoException {

		if (!this.board.isValidPosition(position)){
			throw new InvalidPositionException();
		}

		Content content = this.board.getContent(position);


		Algoformer algoformer;

		try{
			algoformer = (Algoformer)content;
		}catch(ClassCastException ex){
			throw new UsuarioNoSeleccionoAlgoformerException();
		}

		if (!(this.turn.isActivePlayer(algoformer.getPlayer()))){
			throw new JugadorNoPuedeJugarCuandoNoEsSuTurnoException();
		}

		algoformer.transform();
	}

	public void notifyPlayerWin(Player player) {		
		this.winner = player;		
		this.isOver = true;		
	}
	
	public void notifyPlayerLost(Player player) {
		if(player.equals(player1)){
			this.winner = player2;
		}else{
			this.winner = player1;
		}		
		this.isOver = true;
	}

}
