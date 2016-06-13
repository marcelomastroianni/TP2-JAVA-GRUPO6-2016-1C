package fiuba.algo3.algoformers.bonus;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;

public class CanonBonus implements Content{

	Position position;
	
	public CanonBonus(Position position){
		this.position = position;
	}
	
	@Override
	public Position getPosition() {
		return this.position;
	}
	
	@Override
	public void collideWithAlgoformer(Content algoformer) {
		Algoformer algo = (Algoformer) algoformer;
		
		algo.dobleDamage(2);
	}

}
