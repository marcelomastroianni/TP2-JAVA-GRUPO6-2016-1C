package fiuba.algo3.algoformers.board;

public class Nothing implements IContent{

	Position position;

	@Override
	public boolean equals(Object anObject){
		return anObject instanceof Nothing;
	}


	@Override
	public void setPosition(Position position) {
		this.position = position;

	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public void moveEast(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveWest(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveNorth(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveSouth(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveSouthEast(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveSouthWest(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveNorthWest(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveNorthEast(Board board) {
		// TODO Auto-generated method stub

	}
}
