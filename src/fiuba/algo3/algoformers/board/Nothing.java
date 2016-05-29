package fiuba.algo3.algoformers.board;

public class Nothing implements IContent{


	@Override
	public boolean equals(Object anObject){
		return anObject instanceof Nothing;
	}

	@Override
	public void moveRight(Position inicialPosition, Board board) {
	}

	@Override
	public void moveLeft(Position inicialPosition, Board board) {
	}

	@Override
	public void moveUp(Position inicialPosition, Board board) {
	}

	@Override
	public void moveDown(Position inicialPosition, Board board) {
	}
}
