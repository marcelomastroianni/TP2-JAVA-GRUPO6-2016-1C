package fiuba.algo3.algoformers.board;

public class Position{
	private Integer X;
	private Integer Y;
	public Position(Integer X, Integer Y){
		this.X = X;
		this.Y = Y;
	}

	public Integer getX(){
		return X;
	}

	public Integer getY(){
		return Y;
	}


	@Override
	public boolean equals(Object anObject){
		if(!(anObject instanceof Position)) return false;

		if(this == anObject) return true;
		Position aPosition = (Position) anObject;
		return (aPosition.getX().equals(this.X) && aPosition.getY().equals(this.Y));
	}
}
