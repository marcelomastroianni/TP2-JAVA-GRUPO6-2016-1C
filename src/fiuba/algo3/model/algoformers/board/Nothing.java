package fiuba.algo3.model.algoformers.board;

public class Nothing implements Content{

	Position position;

	@Override
	public boolean equals(Object anObject){
		return anObject instanceof Nothing;
	}

	public Nothing(Position position){
		this.position = position;
	}
/*
	@Override
	public void setPosition(Position position) {
		this.position = position;

	}
*/
	@Override
	public Position getPosition() {
		return this.position;
	}
	
	@Override
	public void collideWithAlgoformer(Content algoformer) {
		
	}
}
