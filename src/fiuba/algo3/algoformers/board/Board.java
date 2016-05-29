package fiuba.algo3.algoformers.board;

import fiuba.algo3.algoformers.Algoformer;
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

	public void add(IContent content) {
		Integer X = content.getPosition().getX();
		Integer Y = content.getPosition().getY();
		matrix[Y][X].putContent(content);	
	}
}
