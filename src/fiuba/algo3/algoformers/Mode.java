package fiuba.algo3.algoformers;

import java.util.ArrayList;

import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Cell;
import fiuba.algo3.algoformers.board.Position;
import fiuba.algo3.exceptions.cantCrossException;

public class Mode {

	protected Integer attack;
	protected Integer strikingDistance;
	protected Integer speed;
	

	public Mode(Integer attack, Integer strikingDistance, Integer speed) {
		this.attack = attack;
		this.strikingDistance = strikingDistance;
		this.speed = speed;
		
	}

	public void cross(ArrayList<Cell> steps) {
		// TODO Auto-generated method stub
		
	}

	public Position moveRight(Position initialPosition, Board board) {
		Integer i = 1;
		Integer X = initialPosition.getX();
		Integer Y = initialPosition.getY();
		ArrayList<Cell> steps = new ArrayList<Cell>();
		for(i= 0; i < speed; i++){
			steps.add(board.getCell(new Position(X+i+1,Y)));
		}
		try{
			cross(steps);
		}
		catch(cantCrossException e){
			return initialPosition;
		}
		return new Position(X+i,Y);
	}
	
	public Position moveLeft(Position initialPosition, Board board) {
		Integer i = 1;
		Integer X = initialPosition.getX();
		Integer Y = initialPosition.getY();
		ArrayList<Cell> steps = new ArrayList<Cell>();
		for(i= 0; i < speed; i++){
			steps.add(board.getCell(new Position(X-(i+1),Y)));
		}
		try{
			cross(steps);
		}
		catch(cantCrossException e){
			return initialPosition;
		}
		return new Position(X-i,Y);
	}

	public Position moveUp(Position initialPosition, Board board) {
		Integer i = 1;
		Integer X = initialPosition.getX();
		Integer Y = initialPosition.getY();
		ArrayList<Cell> steps = new ArrayList<Cell>();
		for(i= 0; i < speed; i++){
			steps.add(board.getCell(new Position(X,Y-(i+1))));
		}
		try{
			cross(steps);
		}
		catch(cantCrossException e){
			return initialPosition;
		}
		return new Position(X,Y-i);
	}

	public Position moveDown(Position initialPosition, Board board) {
		Integer i = 1;
		Integer X = initialPosition.getX();
		Integer Y = initialPosition.getY();
		ArrayList<Cell> steps = new ArrayList<Cell>();
		for(i= 0; i < speed; i++){
			steps.add(board.getCell(new Position(X,Y+i+1)));
		}
		try{
			cross(steps);
		}
		catch(cantCrossException e){
			return initialPosition;
		}
		return new Position(X,Y+i);
	}


}
