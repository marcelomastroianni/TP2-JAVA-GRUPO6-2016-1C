package fiuba.algo3.model.algoformers.board;

import java.util.HashMap;
import java.util.Map;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.surfaces.SurfaceRocky;
import fiuba.algo3.model.surfaces.Surface;

public class Board {
	private  Map<Position,Cell> matrix;
	Position centralPosition;
	int xLength;
	int yLength;
	
	public Map<Position,Cell> getCells(){
		return matrix;
	}

	public Board( int rows,int columns){
		this.matrix = new HashMap<>();
		for(int row = 0 ; row< rows ; row++ ){
		    for(int column = 0 ; column < columns ; column++ ){
		        matrix.put(new Position(column,row), new Cell(new Position(column,row),new SurfaceRocky()));
		    }
		}
		this.xLength = rows;
		this.yLength = columns;
		this.centralPosition = new Position(rows/2,columns/2);
	}

	public Content getContent(Position position) {
		return this.matrix.get(position).getContent();
	}

	public boolean isValidPosition(Position position) {
		return position.isInRange(xLength,yLength);
	}
	
	public void add(Content content) throws InvalidPositionException {
		if(!isValidPosition(content.getPosition())){
			throw new InvalidPositionException();
		}
		matrix.get(content.getPosition()).add(content);
	}
	
	public void clearContent(Position position) throws InvalidPositionException {
		if(!isValidPosition(position)){
			throw new InvalidPositionException();
		}
		matrix.get(position).add(new Nothing(position));
	}

	public void remove(Content content) {
		matrix.get(content.getPosition()).removeContent();
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

	public void addCell(Cell cell) {	
		matrix.put(cell.getPosition(), cell);
	}

	public Surface getSurface(Position position) {
		return matrix.get(position).getSurface();
	}
}
