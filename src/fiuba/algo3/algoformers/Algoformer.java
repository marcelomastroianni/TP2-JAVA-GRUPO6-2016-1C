package fiuba.algo3.algoformers;



import fiuba.algo3.algoformers.board.*;
import fiuba.algo3.exceptions.CantCrossException;
import fiuba.algo3.exceptions.InvalidPositionException;
import fiuba.algo3.exceptions.InvalidStrikeException;

import java.util.ArrayList;
import java.util.concurrent.CountedCompleter;

public class Algoformer implements IContent{
	
	private String name;

	Position position;

	private Integer life;
	private Mode humanoidMode;
	private Mode alternalMode;
	private Mode activeMode;

	public Algoformer(String name, Mode humanoidMode,Mode alternalMode,Integer life) {
		this.name = name;
		this.humanoidMode = humanoidMode;
		this.alternalMode = alternalMode;
		this.activeMode = this.humanoidMode;
		this.life = life;
	}


	public String getNombre() {
		return this.name;
	}

	public Mode getActiveMode() {
		return activeMode;
	}


	public Mode getHumanoidMode() {
		return humanoidMode;
	}

	public Mode getAlternalMode() {
		return alternalMode;
	}

	public int getLife()  {
		return life;
	}

	public void transform() {
		if (this.activeMode.equals(this.humanoidMode))
			this.activeMode = this.alternalMode;
		else
			this.activeMode = this.humanoidMode;
	}
	

	public void shot(Algoformer algoformer){
		try {
			this.resolveDistance(algoformer);
			algoformer.receiveDamage(this.activeMode.getAttack());
		} catch (InvalidStrikeException e) {
			//TODO Reservado para interaccion con la GUI
		}
	}

	
	public void resolveDistance(Algoformer algoformer) throws InvalidStrikeException {
		if( this.position.distance(algoformer.getPosition()) > this.activeMode.getStrikingDistance()){
			throw new InvalidStrikeException("You can't attack objectives that far.");
		}
		
	}


	private void receiveDamage(Integer attack) {
		this.life = this.life - attack;
		
	}


	@Override
	public void setPosition(Position position) {
		this.position = position;

	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	
	//------------------------------
	
	@Override
	public void moveEast(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		
		
		Integer i = 1;
		Integer X = this.position.getX();
		Integer Y = this.position.getY();
		ArrayList<Cell> steps = new ArrayList<Cell>();
		for(i= 0; i < this.activeMode.getSpeed(); i++){
			steps.add(board.getCell(new Position(X+i+1,Y)));
		}
		try{
			this.activeMode.cross(steps);
		}
		catch(CantCrossException e){
			return ;
		}
		this.position = new Position(X+i,Y);
		
		
		board.add(nothing);
		board.add(this);

	}
	
	

	@Override
	public void moveWest(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		
		Integer i = 1;
		Integer X = this.position.getX();
		Integer Y = this.position.getY();
		ArrayList<Cell> steps = new ArrayList<Cell>();
		for(i= 0; i < this.activeMode.getSpeed(); i++){
			steps.add(board.getCell(new Position(X-(i+1),Y)));
		}
		try{
			this.activeMode.cross(steps);
		}
		catch(CantCrossException e){
			return;
		}
		this.position =  new Position(X-i,Y);
		
		
		board.add(nothing);
		board.add(this);
	}
	


	@Override
	public void moveNorth(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		
		Integer i = 1;
		Integer X = this.position.getX();
		Integer Y = this.position.getY();
		ArrayList<Cell> steps = new ArrayList<Cell>();
		for(i= 0; i < this.activeMode.getSpeed(); i++){
			steps.add(board.getCell(new Position(X,Y-(i+1))));
		}
		try{
			this.activeMode.cross(steps);
		}
		catch(CantCrossException e){
			return;
		}
		this.position =  new Position(X,Y-i);
		
		board.add(nothing);
		board.add(this);
	}
	

	@Override
	public void moveSouth(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		
		Integer i = 1;
		Integer X = this.position.getX();
		Integer Y = this.position.getY();
		ArrayList<Cell> steps = new ArrayList<Cell>();
		for(i= 0; i < this.activeMode.getSpeed(); i++){
			steps.add(board.getCell(new Position(X,Y+i+1)));
		}
		try{
			this.activeMode.cross(steps);
		}
		catch(CantCrossException e){
			return ;
		}
		this.position =  new Position(X,Y+i);
		
		
		board.add(nothing);
		board.add(this);
	}
	


	@Override
	public void moveNorthEast(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		
		Integer i = 1;
		Integer X = this.position.getX();
		Integer Y = this.position.getY();
		ArrayList<Cell> steps = new ArrayList<Cell>();
		for(i= 0; i < this.activeMode.getSpeed(); i++){
			steps.add(board.getCell(new Position(X+i+1,Y-i-1)));
		}
		try{
			this.activeMode.cross(steps);
		}
		catch(CantCrossException e){
			return ;
		}
		this.position =  new Position(X+i,Y-i);
		
		board.add(nothing);
		board.add(this);

	}
	
	

	
	@Override
	public void moveSouthEast(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		
		Integer i = 1;
		Integer X = this.position.getX();
		Integer Y = this.position.getY();
		ArrayList<Cell> steps = new ArrayList<Cell>();
		for(i= 0; i < this.activeMode.getSpeed(); i++){
			steps.add(board.getCell(new Position(X+i+1,Y+i+1)));
		}
		try{
			this.activeMode.cross(steps);
		}
		catch(CantCrossException e){
			return;
		}
		this.position =  new Position(X+i,Y+i);
		
		board.add(nothing);
		board.add(this);

	}
	
	@Override
	public void moveNorthWest(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		
		Integer i = 1;
		Integer X = this.position.getX();
		Integer Y = this.position.getY();
		ArrayList<Cell> steps = new ArrayList<Cell>();
		for(i= 0; i < this.activeMode.getSpeed(); i++){
			steps.add(board.getCell(new Position(X-(i+1),Y-i-1)));
		}
		try{
			this.activeMode.cross(steps);
		}
		catch(CantCrossException e){
			return;
		}
		this.position =  new Position(X-i,Y-i);
		
		board.add(nothing);
		board.add(this);

	}
	

	@Override
	public void moveSouthWest(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		
		Integer i = 1;
		Integer X = this.position.getX();
		Integer Y = this.position.getY();
		ArrayList<Cell> steps = new ArrayList<Cell>();
		for(i= 0; i < this.activeMode.getSpeed(); i++){
			steps.add(board.getCell(new Position(X-i-1,Y+i+1)));
		}
		try{
			this.activeMode.cross(steps);
		}
		catch(CantCrossException e){
			return ;
		}

		this.position =  new Position(X-i,Y+i);
		
		
		board.add(nothing);
		board.add(this);

	}
	
	




}