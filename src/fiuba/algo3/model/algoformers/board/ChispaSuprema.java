package fiuba.algo3.model.algoformers.board;

public class ChispaSuprema implements Content {

	Position position;
	
	@Override
	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public Position getPosition() {
		return this.position;
	}
}
