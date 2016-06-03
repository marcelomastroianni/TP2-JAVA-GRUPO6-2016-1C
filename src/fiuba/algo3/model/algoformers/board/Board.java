package fiuba.algo3.model.algoformers.board;

import java.util.HashMap;
import java.util.Map;

import fiuba.algo3.model.algoformers.Algoformer;
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
		return this.getContent(position) instanceof Nothing;
	}

	private boolean isValidPosition(Position position) {
		return position.isInRange(xLength,yLength);
	}
	private boolean isOccupiedPosition(Position position) {
		if(!isValidPosition(position)){
			return false;
		}
		return(getContent(position) instanceof Algoformer);
	}

	public void add(Content content) {
		if(!isValidPosition(content.getPosition()) | isOccupiedPosition(content.getPosition())){
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
