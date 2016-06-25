package fiuba.algo3.model.algoformers.board;


public class Position {
	private Integer X;
	private Integer Y;
	public Position(Integer X, Integer Y){
		this.X = X;
		this.Y = Y;
	}

	public boolean isInDistance(Position position, int distance){
		return (this.X + distance >= position.getX() && this.X - distance <= position.getX() &&
		this.Y + distance >= position.getY() && this.Y - distance <= position.getY());
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

	public boolean isInRange(int xLength, int yLength){
		return(Y>=0 && Y < yLength && X >=0  && X < xLength );


	}


	public Integer getX(){
		return X;
	}

	public Integer getY(){
		return Y;
	}

	public boolean hasNext(Position finalPosition) {
		return !this.equals(finalPosition);
	}

	public Position next(Position finalPosition) {
		int xNext = 0;
		int yNext = 0;

		if (this.getX()>finalPosition.getX()){
			xNext = this.getX() - 1;
		}
		if (this.getX()<finalPosition.getX()){
			xNext = this.getX() + 1;
		}
		if (this.getX()==finalPosition.getX()){
			xNext = this.getX();
		}

		if (this.getY()>finalPosition.getY()){
			yNext = this.getY() - 1;
		}
		if (this.getY()<finalPosition.getY()){
			yNext = this.getY() + 1;
		}
		if (this.getY()==finalPosition.getY()){
			yNext = this.getY();
		}

		return new Position(xNext,yNext);
	}

	public String toString(){
		return "(" + Integer.toString(X)  + "," + Integer.toString(Y) + ")";
	}


}
