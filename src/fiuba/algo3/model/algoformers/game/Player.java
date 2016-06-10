package fiuba.algo3.model.algoformers.game;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.model.algoformers.Algoformer;

public class Player {

	List<Algoformer> algoformersList;
	
	List<Algoformer> usedAlgoformersList;
	
	public Player(){
		algoformersList = new ArrayList<Algoformer>();
		usedAlgoformersList = new ArrayList<Algoformer>();
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
	
	public void useAlgoformer(Algoformer algoformer){
		this.usedAlgoformersList.add(algoformer);
		
	}
	
	public boolean haveUsed(Algoformer algoformer) {
		return usedAlgoformersList.contains(algoformer);
	}

	public void notifyNextTurn() {
		usedAlgoformersList = new ArrayList<Algoformer>();
		
	}

	public void finishTurn() {
		for(Algoformer algoformer : algoformersList){
			algoformer.finishTurn();
		}
		
	}

}
