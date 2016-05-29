package fiuba.algo3.algoformers.board;

public class Nothing implements Content{


	@Override
	public boolean equals(Object anObject){
		return anObject instanceof Nothing;
	}

	@Override
	public void moveEast(Position inicialPosition, Board board) {
		// TODO Auto-generated method stub

	}
}
