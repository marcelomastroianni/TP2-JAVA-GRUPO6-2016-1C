package fiuba.algo3.algoformers.board;

import fiuba.algo3.exceptions.IsAnEmptyPositionException;

public class Board {
	private  Cell [][]matrix;

	public Board( int rows,int columns){
		this.matrix = new Cell[rows][columns];
		for(int row = 0 ; row< rows ; row++ ){
		    for(int column = 0 ; column < columns ; column++ ){
		        matrix[row][column] = new Cell(new Position(column,row));
		    }
		}
	}



	public Content getContent(Position position) {
		Integer X = position.getX();
		Integer Y = position.getY();
		return matrix[Y][X].getContent();
	}

	public boolean isEmpty(Position position) {
		Integer X = position.getX();
		Integer Y = position.getY();
		return matrix[Y][X].getContent().equals(new Nothing());
	}



	public void putContent(Position position, Content content) {
		Integer X = position.getX();
		Integer Y = position.getY();
		matrix[Y][X].putContent(content);
	}



	public void moveAlgoformerToEast(Position position) {
		if(isEmpty(position)){
			throw new IsAnEmptyPositionException();
		}
		getContent(position).moveEast(position,this);

	}



	public Cell getCell(Position position) {
		Integer X = position.getX();
		Integer Y = position.getY();
		return matrix[Y][X];
	}





}
