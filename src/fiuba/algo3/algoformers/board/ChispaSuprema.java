package fiuba.algo3.algoformers.board;

public class ChispaSuprema implements IContent {

	Position position;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		ChispaSuprema other = (ChispaSuprema) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
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
