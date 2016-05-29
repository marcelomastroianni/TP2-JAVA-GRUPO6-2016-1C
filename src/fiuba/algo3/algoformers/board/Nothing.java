package fiuba.algo3.algoformers.board;

public class Nothing implements IContent{

	Position position;
	
	@Override
	public boolean equals(Object anObject){
		return anObject instanceof Nothing;
	}

	@Override
	public void moveRight(Board board) {
	}

	@Override
	public void moveLeft(Board board) {
	}

	@Override
	public void moveUp(Board board) {
	}

	@Override
	public void moveDown(Board board) {
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
		
	}

	@Override
	public Position getPosition() {
		return this.position;
	}
}
