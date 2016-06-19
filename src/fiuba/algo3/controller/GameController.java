package fiuba.algo3.controller;

import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeJugarCuandoNoEsSuTurnoException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerAQuienDispararException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerException;
import fiuba.algo3.view.GameView;
import fiuba.algo3.view.ViewConstants;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

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
						game.transformaraAlgoformer(positionSelected1);
					} catch (JugadorNoPuedeJugarCuandoNoEsSuTurnoException | UsuarioNoSeleccionoAlgoformerException
						 | InvalidPositionException
							| AlgoformerUsadoEsteTurnoException e) {
						e.printStackTrace();
					}
	    			this.clearSelectedCells();	  
	    		}
	    		
	    	}else if (this.positionSelected2 == null){
	    		this.positionSelected2 =position;
	    		this.view.toggleSelectCell(this.positionSelected2);
	    		
	    		if (this.action == Action.MOVERSE){
	    			try {
	        			
	    				game.moverAlgoformer( positionSelected1, positionSelected2);
	    			} catch (UsuarioNoSeleccionoAlgoformerException 
	    					| JugadorNoPuedeJugarCuandoNoEsSuTurnoException | InvalidPositionException
	    					| AlgoformerUsadoEsteTurnoException e) {
	    				e.printStackTrace();
	    			}
	    		}
	    		
	    		if (this.action == Action.ATACAR){    			 
					try {
						game.dispararaAlgoformer(positionSelected1, positionSelected2);
					} catch (JugadorNoPuedeJugarCuandoNoEsSuTurnoException | UsuarioNoSeleccionoAlgoformerException
							| UsuarioNoSeleccionoAlgoformerAQuienDispararException | InvalidPositionException
							| AlgoformerUsadoEsteTurnoException e) {
						e.printStackTrace();
					}    		
	    		}
	    		
	    		this.clearSelectedCells();	    
	    		this.view.update(); 
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
	}

	public void nextTurn() {
		this.clearSelectedCells();
		this.game.nextTurn();		
	}

	public void dobleClickCell(Position position) {
		try {
			this.game.transformaraAlgoformer(position);
			this.view.update(); 
		} catch (JugadorNoPuedeJugarCuandoNoEsSuTurnoException | UsuarioNoSeleccionoAlgoformerException
			 | InvalidPositionException
				| AlgoformerUsadoEsteTurnoException e) {
			e.printStackTrace();		
		}
	}
	
	public void registerClickEvents(Canvas canvas){
		 canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, 
	                new EventHandler<MouseEvent>() {
	                    @Override
	                    public void handle(MouseEvent t) {
	                    	int x_celda = (int) (t.getX() / ViewConstants.CELL_WIDTH);
	                    	int y_celda = (int) (t.getY() / ViewConstants.CELL_HEIGHT);
	                    	
	                    	selectCell(new Position(x_celda,y_celda));
	                    	System.out.println("(" + x_celda +  "," + y_celda +  ")");
	                    	
	                        if (t.getClickCount() >1) {
	                        	dobleClickCell(new Position(x_celda,y_celda));	                        	
	                        }  
	                    }
	                });
	}
}