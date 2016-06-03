package fiuba.algo3.model.algoformers.board;

import java.util.HashMap;
import java.util.Map;

import fiuba.algo3.model.exceptions.InvalidPositionException;

public class Board {
	private  Map<Position,Cell> matrix;
	Position centralPosition;
	int xLength;
	int yLength;

	public Board( int rows,int columns){
		this.matrix = new HashMap<>();
		for(int row = 0 ; row< rows ; row++ ){
		    for(int column = 0 ; column < columns ; column++ ){
		        matrix.put(new Position(column,row), new Cell(new Position(column,row)));
		    }
		}
		
		this.xLength = rows;
		this.yLength = columns;
		this.centralPosition = new Position(rows/2,columns/2);
		
	}


	public Cell getCell(Position position) {
		return matrix.get(position);
	}

	public Content getContent(Position position) {
		return this.getCell(position).getContent();
	}

	public boolean isEmpty(Position position) {
		return this.getContent(position).equals(new Nothing());
	}

	private boolean isValidPosition(Position position) {
		return(position.getY()>=0 && position.getY() < this.yLength && position.getX() >=0  && position.getX() < this.xLength );
	}

	public void add(Content content) {
		if(!isValidPosition(content.getPosition())){
			throw new InvalidPositionException();
		}
		matrix.get(content.getPosition()).putContent(content);
	}


	public Position getCentralPosition() {
	
		return this.centralPosition;
	}


	public int getXLength() {
		return this.xLength;
	}


	public int getYLength() {
		return this.yLength;
	}



}
