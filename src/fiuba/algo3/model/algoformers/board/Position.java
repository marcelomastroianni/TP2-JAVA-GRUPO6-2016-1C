package fiuba.algo3.model.algoformers.board;


public class Position {
	private Integer X;
	private Integer Y;
	public Position(Integer X, Integer Y){
		this.X = X;
		this.Y = Y;
	}

	public Double distance(Position position){
		return Math.sqrt(Math.pow(this.X - position.getX(), 2) + Math.pow(this.Y - position.getY(), 2) );
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((X == null) ? 0 : X.hashCode());
		result = prime * result + ((Y == null) ? 0 : Y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (X == null) {
			if (other.X != null)
				return false;
		} else if (!X.equals(other.X))
			return false;
		if (Y == null) {
			if (other.Y != null)
				return false;
		} else if (!Y.equals(other.Y))
			return false;
		return true;
	}


	public Integer getX(){
		return X;
	}

	public Integer getY(){
		return Y;
	}

}
