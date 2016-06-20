package fiuba.algo3.model.bonus;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;

public class CanonBonus implements Bonus{
	
	private Position position;

	public CanonBonus(Position position){
		this.position = position;
	}
	
	public static CanonBonus createCanonBonus(Position position){
		return new CanonBonus(position);
	}
	
	@Override
	public Position getPosition() {
		return this.position;
	}
	
	@Override
	public void collideWithAlgoformer(Content algoformer) {
		Algoformer algo = (Algoformer) algoformer;
		algo.dobleDamage(3);
	}

}
