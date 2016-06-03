package fiuba.algo3.algoformers.board;

public interface IContent {

	void setPosition(Position position);
	Position getPosition();
	void moveEast(Board board);
	void moveWest(Board board);
	void moveNorth(Board board);
	void moveSouth(Board board);
	void moveSouthEast(Board board);
	void moveSouthWest(Board board);
	void moveNorthWest(Board board);
	void moveNorthEast(Board board);

}
