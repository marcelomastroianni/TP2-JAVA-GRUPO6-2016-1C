package fiuba.algo3.algoformers.board;

public interface IContent {

	void moveRight(Position inicialPosition, Board board);
	void moveLeft(Position inicialPosition, Board board);
	void moveUp(Position inicialPosition, Board board);
	void moveDown(Position inicialPosition, Board board);

}
