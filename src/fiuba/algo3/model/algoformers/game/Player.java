package fiuba.algo3.model.algoformers.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.MuyLejosException;

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
		Iterator<Algoformer> iter = algoformersList.iterator();
		while (iter.hasNext()) {
		    Algoformer algoformer = iter.next();
		    if(algoformer.getNombre().equals("Superion") ||algoformer.getNombre().equals("Menasor")){
		    	algoformer.notifyNextTurn();
		    	break;
		    }
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

	public void combinar(Algoformer fusion) {
		this.algoformersList = new ArrayList<Algoformer>();
		this.addAlgoformer(fusion);

	}

}
