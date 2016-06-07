package fiuba.algo3.model.algoformers.game;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.model.algoformers.Algoformer;

public class Player {

	List<Algoformer> algoformersList;
	
	public Player(){
		algoformersList = new ArrayList<Algoformer>();
	}
	
	public List<Algoformer> getAlgoformers() {
		return this.algoformersList;
	}

	public void addAlgoformer(Algoformer algoformer) {
		this.algoformersList.add(algoformer);		
	}

	public boolean hasAlgoformer(Algoformer algoformer) {
		boolean hasAlgoformer = false;
			
		for(Algoformer algoforrmerItem:this.algoformersList){
			if(algoformer.equals(algoforrmerItem)){
				hasAlgoformer = true;
				break;
			}
				
		}
		return hasAlgoformer;
	}

}
