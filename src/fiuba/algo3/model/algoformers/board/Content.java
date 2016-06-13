package fiuba.algo3.model.algoformers.board;

public interface Content {


	Position getPosition();
	
	void collideWithAlgoformer(Content algoformer);


}
