package fiuba.algo3.algoformers;

import java.util.ArrayList;

import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Cell;
import fiuba.algo3.algoformers.board.Position;

public interface IMode {

	Position moveRight(Position inicialPosition, Board board);
	Position moveLeft(Position inicialPosition, Board board);
	Position moveUp(Position inicialPosition, Board board);
	Position moveDown(Position inicialPosition, Board board);
	
	void cross(ArrayList<Cell> steps);

}
