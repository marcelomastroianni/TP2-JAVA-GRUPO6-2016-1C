package fiuba.algo3.algoformers;



import java.util.ArrayList;

import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Cell;
import fiuba.algo3.algoformers.board.IContent;
import fiuba.algo3.algoformers.board.Nothing;
import fiuba.algo3.algoformers.board.Position;
import fiuba.algo3.exceptions.CantCrossException;

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

	public void transform() {
		if (this.activeMode.equals(this.humanoidMode))
			this.activeMode = this.alternalMode;
		else
			this.activeMode = this.humanoidMode;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeMode == null) ? 0 : activeMode.hashCode());
		result = prime * result + ((alternalMode == null) ? 0 : alternalMode.hashCode());
		result = prime * result + ((humanoidMode == null) ? 0 : humanoidMode.hashCode());
		result = prime * result + ((life == null) ? 0 : life.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Algoformer other = (Algoformer) obj;
		if (activeMode == null) {
			if (other.activeMode != null)
				return false;
		} else if (!activeMode.equals(other.activeMode))
			return false;
		if (alternalMode == null) {
			if (other.alternalMode != null)
				return false;
		} else if (!alternalMode.equals(other.alternalMode))
			return false;
		if (humanoidMode == null) {
			if (other.humanoidMode != null)
				return false;
		} else if (!humanoidMode.equals(other.humanoidMode))
			return false;
		if (life == null) {
			if (other.life != null)
				return false;
		} else if (!life.equals(other.life))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}




}