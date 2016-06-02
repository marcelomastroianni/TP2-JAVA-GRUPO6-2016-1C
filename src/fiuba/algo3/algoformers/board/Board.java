package fiuba.algo3.algoformers.board;

import fiuba.algo3.algoformers.Algoformer;
import fiuba.algo3.exceptions.InvalidPositionException;

public class Board {
	private  Cell [][]matrix;
	Position centralPosition;
	int x_length;
	int y_length;

	public Board( int rows,int columns){
		this.matrix = new Cell[rows][columns];
		for(int row = 0 ; row< rows ; row++ ){
		    for(int column = 0 ; column < columns ; column++ ){
		        matrix[row][column] = new Cell(new Position(column,row));
		    }
		}
		
		this.x_length = rows;
		this.y_length = columns;
		this.centralPosition = new Position(rows/2,columns/2);
		
	}


	public Cell getCell(Position position) {
		Integer X = position.getX();
		Integer Y = position.getY();
		return matrix[Y][X];
	}

	public IContent getContent(Position position) {
		return this.getCell(position).getContent();
	}

	public boolean isEmpty(Position position) {
		return this.getContent(position).equals(new Nothing());
	}

	private boolean isValidPosition(Position position) {
		return(position.getY()>=0 && position.getY() < matrix.length && position.getX() >=0  && position.getX() < matrix[0].length );
	}

	public void add(IContent content) {
		if(!isValidPosition(content.getPosition())){
			throw new InvalidPositionException();
		}
		Integer X = content.getPosition().getX();
		Integer Y = content.getPosition().getY();
		matrix[Y][X].putContent(content);
	}


	public Position getCentralPosition() {
	
		return this.centralPosition;
	}


	public int get_X_Length() {
		return this.x_length;
	}


	public int get_Y_Length() {
		return this.y_length;
	}



}
