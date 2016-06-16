package fiuba.algo3.model.algoformers.board;

public class ChispaSuprema implements Content {

	Position position;
	
	public ChispaSuprema(Position position){
		this.position = position;
	}

	@Override
	public Position getPosition() {
		return this.position;
	}
	
	@Override
	public void collideWithAlgoformer(Content algoformer) {
		
	}
	
}
