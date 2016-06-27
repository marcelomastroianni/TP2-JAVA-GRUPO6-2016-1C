package fiuba.algo3.model.algoformers.board;


public class Position {
	private Integer x;
	private Integer y;
	public Position(Integer X, Integer Y){
		this.x = X;
		this.y = Y;
	}

	public boolean isInDistance(Position position, int distance){
		return (this.x + distance >= position.getX() && this.x - distance <= position.getX() &&
		this.y + distance >= position.getY() && this.y - distance <= position.getY());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x.hashCode();
		result = prime * result + y.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Position other = (Position) obj;
		if (!x.equals(other.x))
			return false;
		if (!y.equals(other.y))
			return false;
		return true;
	}

	public boolean isInRange(int xLength, int yLength){
		return(y>=0 && y < yLength && x >=0  && x < xLength );
	}


	public Integer getX(){
		return x;
	}

	public Integer getY(){
		return y;
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
		return "(" + Integer.toString(x)  + "," + Integer.toString(y) + ")";
	}
}
