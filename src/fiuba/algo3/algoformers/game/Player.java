package fiuba.algo3.algoformers.game;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.Algoformer;

public class Player {

	List<Algoformer> algoformersList;
	
	Player(){
		algoformersList = new ArrayList<Algoformer>();
	}
	
	public List<Algoformer> getAlgoformers() {
		return this.algoformersList;
	}

	public void addAlgoformer(Algoformer algoformer) {
		this.algoformersList.add(algoformer);		
	}

}
