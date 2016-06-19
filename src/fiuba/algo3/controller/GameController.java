package fiuba.algo3.controller;

import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeJugarCuandoNoEsSuTurnoException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeUtilizarAlgoformerQueNoEsSuyoException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerAQuienDispararException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerException;
import fiuba.algo3.view.GameView;

public class GameController {
	private Position positionSelected1;
	private Position positionSelected2;
	private Action action = Action.SIN_ACCION; 
	private Game game;
	private GameView view;
	
	public enum Action {
		SIN_ACCION, MOVERSE, TRANSFORMARSE, ATACAR;
	}
	
	public GameController(Game game,GameView view){
		this.game = game;
		this.view = view;
	}
	
	public void selectAction(Action action){
		this.action = action;
	}
	
	public void selectCell(Position position){          	 
		if (this.action != Action.SIN_ACCION){
			if (this.positionSelected1 == null){
	    		this.positionSelected1 =position;
	    		this.view.toggleSelectCell(this.positionSelected1);
	    		
	    		
	    		if (this.action == Action.TRANSFORMARSE){
	    				        			
	    			try {
						game.transformaraAlgoformer(game.getPlayer1(), positionSelected1);
					} catch (JugadorNoPuedeJugarCuandoNoEsSuTurnoException | UsuarioNoSeleccionoAlgoformerException
							| JugadorNoPuedeUtilizarAlgoformerQueNoEsSuyoException | InvalidPositionException
							| AlgoformerUsadoEsteTurnoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			
	    			this.clearSelectedCells();	  
	    		}
	    		
	    		
	    	}else if (this.positionSelected2 == null){
	    		this.positionSelected2 =position;
	    		this.view.toggleSelectCell(this.positionSelected2);
	    		
	    		if (this.action == Action.MOVERSE){
	    			try {
	        			
	    				game.moverAlgoformer(game.getPlayer1(), positionSelected1, positionSelected2);
	    			} catch (UsuarioNoSeleccionoAlgoformerException | JugadorNoPuedeUtilizarAlgoformerQueNoEsSuyoException
	    					| JugadorNoPuedeJugarCuandoNoEsSuTurnoException | InvalidPositionException
	    					| AlgoformerUsadoEsteTurnoException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    		}
	    		
	    		if (this.action == Action.ATACAR){    			 
					try {
						game.dispararaAlgoformer(game.getPlayer1(), positionSelected1, positionSelected2);
					} catch (JugadorNoPuedeJugarCuandoNoEsSuTurnoException | UsuarioNoSeleccionoAlgoformerException
							| JugadorNoPuedeUtilizarAlgoformerQueNoEsSuyoException
							| UsuarioNoSeleccionoAlgoformerAQuienDispararException | InvalidPositionException
							| AlgoformerUsadoEsteTurnoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}    		
	    		}
	    		
	    		this.clearSelectedCells();	    		   
	    	}
		}
    }
	
	private void clearSelectedCells(){
		if (this.positionSelected1!=null){
			this.view.toggleSelectCell(this.positionSelected1);
			this.positionSelected1 =null;
		}
		if (this.positionSelected2!=null){
			this.view.toggleSelectCell(this.positionSelected2);   
			this.positionSelected2 =null;
		}		 		     									
		this.view.update(); 
	}

	public void nextTurn() {
		this.clearSelectedCells();
		this.game.nextTurn();		
	}
	
}
