package fiuba.algo3.algoformers;

import java.util.ArrayList;

import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Cell;
import fiuba.algo3.algoformers.board.Position;

public interface Mode {

	Position moveEast(Position inicialPosition, Board board);

	void cross(ArrayList<Cell> steps);

}
