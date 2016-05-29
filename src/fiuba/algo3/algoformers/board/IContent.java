package fiuba.algo3.algoformers.board;

public interface IContent {

	void moveRight(Board board);
	void moveLeft(Board board);
	void moveUp(Board board);
	void moveDown(Board board);
	void setPosition(Position position);
	Position getPosition();

}
