package fiuba.algo3.algoformers;



import fiuba.algo3.algoformers.board.*;
import fiuba.algo3.exceptions.CantCrossException;

import java.util.ArrayList;

public class Algoformer implements Content{
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

	public void downHealthPoints(Integer damage ){
		this.life = this.life - damage;
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
		if ((this.getPosition().getX() + this.getActiveMode().getStrikingDistance()) >= algoformer.getPosition().getX() &&
				algoformer.getPosition().getX() >= (this.getPosition().getX() - this.getActiveMode().getStrikingDistance()) &&
				(this.getPosition().getY() + this.getActiveMode().getStrikingDistance()) >= algoformer.getPosition().getY() &&
				algoformer.getPosition().getY() >= (this.getPosition().getY() - this.getActiveMode().getStrikingDistance()))
		{
			algoformer.downHealthPoints(this.getActiveMode().getAttack());
		}

	}

	@Override
	public void setPosition(Position position) {
		this.position = position;

	}

	@Override
	public Position getPosition() {
		return this.position;
	}

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