package fiuba.algo3.model.algoformers.game;

import java.util.ArrayList;
import java.util.List;
import fiuba.algo3.model.algoformers.Algoformer;

public class Player {

	List<Algoformer> algoformersList;
	private Game game;
	private String name;

	public Player(Game game, String name){
		algoformersList = new ArrayList<Algoformer>();
		this.game = game;
		this.name = name;
	}

	public List<Algoformer> getAlgoformers() {
		return this.algoformersList;
	}

	public void addAlgoformer(Algoformer algoformer) {
		algoformer.setPlayer(this);
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

	public void notifyNextTurn(){
		for(Algoformer algoformer:this.algoformersList){
			algoformer.notifyNextTurn();
		}
	}

	public void notifyDeadAlgoformer(Algoformer algoformer) {
		this.algoformersList.remove(algoformer);
		if(this.algoformersList.size() < 1){
			this.game.notifyPlayerLost(this);
		}
	}

	public void notifyAlgoformerCathChispaSuprema()  {
		this.game.notifyPlayerWin(this);
	}

	public String getName() {
		return this.name;
	}
	
	public void removeAlgoformers(){
		this.algoformersList.clear();
	}
}
