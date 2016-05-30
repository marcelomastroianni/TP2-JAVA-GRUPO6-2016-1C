package fiuba.algo3.algoformers.board;

import java.util.HashMap;
import java.util.Map;

import fiuba.algo3.exceptions.InvalidPositionException;

public class Board {
	
	private static Board singleton;
	
	private  Map<Position,Cell> map = new HashMap<>();
	
	Position centralPosition;
	public static final Integer X_LENGHT = 20;
	public static final Integer Y_LENGHT = 20;

	private Board(){
		for(int row = 0 ; row< X_LENGHT ; row++ ){
		    for(int column = 0 ; column < Y_LENGHT ; column++ ){
		        map.put(new Position(column,row),new Cell(new Position(column,row)));
		    }
		}
		
		this.centralPosition = new Position(X_LENGHT/2,Y_LENGHT/2);
	}
	
	public void reset(){
		map.clear();
		for(int row = 0 ; row< X_LENGHT ; row++ ){
		    for(int column = 0 ; column < Y_LENGHT ; column++ ){
		        map.put(new Position(column,row),new Cell(new Position(column,row)));
		    }
		}
	}
	
	public static Board getInstance() {
		if (singleton == null) {
			singleton = new Board();
		}
		return singleton;
	}


	public Cell getCell(Position position) {
		return map.get(position);
	}

	public IContent getContent(Position position) {
		return this.getCell(position).getContent();
	}

	public boolean isEmpty(Position position) {
		return this.getContent(position) instanceof Nothing;
	}

	private boolean isValidPosition(Position position) {
		return(position.getY()>=0 && position.getY() < Y_LENGHT && position.getX() >=0  && position.getX() < X_LENGHT );
	}

	public void add(IContent content) {
		if(!isValidPosition(content.getPosition())){
			throw new InvalidPositionException();
		}
		map.get(content.getPosition()).putContent(content);
	}


	public Position getCentralPosition() {
	
		return this.centralPosition;
	}

}
