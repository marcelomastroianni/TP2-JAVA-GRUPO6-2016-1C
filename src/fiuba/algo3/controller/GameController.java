package fiuba.algo3.controller;

import java.util.List;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.exceptions.*;
import fiuba.algo3.view.AlgoformerApp;
import fiuba.algo3.view.GameView;
import fiuba.algo3.view.ViewConstants;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class GameController {
	private Position positionSelected1;
	private Position positionSelected2;
	private Position positionSelected3;
	private Action action = Action.SIN_ACCION;
	private Game game;
	private GameView view;
	private Algoformer algoformerSelected;
	private AlgoformerApp app;

	public enum Action {
		SIN_ACCION, MOVERSE, TRANSFORMARSE, ATACAR, COMBINAR;
	}

	public GameController(Game game,GameView view,AlgoformerApp app){
		this.game = game;
		this.view = view;
		this.app = app;
	}

	public void selectAction(Action action){
		this.action = action;
		this.view.updateAction(this.action);
	}

	private void clearAction(){
		this.action = Action.SIN_ACCION;
		this.view.updateAction(this.action);
	}

	public void selectCell(Position position) throws InvalidPositionException, MuyLejosException{

		try{
			this.algoformerSelected = (Algoformer) this.game.getBoard().getContent(position);
			this.view.updateAlgoformerSelected(algoformerSelected);
		}catch(ClassCastException ex){
			this.algoformerSelected = null;
			this.view.clearAlgoformerSelected();
		}

		if (this.action != Action.SIN_ACCION){
			if (this.positionSelected1 == null){
	    		this.positionSelected1 =position;
	    		this.view.toggleSelectCell(this.positionSelected1);

	    		if (this.action == Action.TRANSFORMARSE){
	    			try {
						game.transformaraAlgoformer(positionSelected1);
					} catch (JugadorNoPuedeJugarCuandoNoEsSuTurnoException | UsuarioNoSeleccionoAlgoformerException
						 | InvalidPositionException | AlgoformerAtrapadoEsteTurnoException | AlgoformerUsadoEsteTurnoException e) {
						e.printStackTrace();
					}
	    			this.clearSelectedCells();
	    			this.clearAction();
	    			this.view.updateAlgoformerSelected(algoformerSelected);
	    		}

	    	}else if (this.positionSelected2 == null){
	    		this.positionSelected2 =position;
	    		this.view.toggleSelectCell(this.positionSelected2);

	    		if (this.action == Action.MOVERSE){
	    			try {

	    				game.moverAlgoformer( positionSelected1, positionSelected2);
	    			} catch (UsuarioNoSeleccionoAlgoformerException | AlgoformerAtrapadoEsteTurnoException
	    					| JugadorNoPuedeJugarCuandoNoEsSuTurnoException | InvalidPositionException | AlgoformerUsadoEsteTurnoException e) {
	    				e.printStackTrace();
	    			}

	    			if (game.isOver()){
	    				this.clearSelectedCells();
	    	    		this.view.update();
	    				this.view.showGameFinish(game.getWinner());
	    				this.app.setChooseTeamScene();
	    			}

	    			this.clearAction();
	    		}

	    		if (this.action == Action.ATACAR){
					try {
						game.dispararaAlgoformer(positionSelected1, positionSelected2);
					} catch (JugadorNoPuedeJugarCuandoNoEsSuTurnoException | UsuarioNoSeleccionoAlgoformerException
							| UsuarioNoSeleccionoAlgoformerAQuienDispararException | InvalidPositionException
							| AlgoformerUsadoEsteTurnoException e) {
						e.printStackTrace();
					}
					if (game.isOver()){
	    				this.clearSelectedCells();
	    	    		this.view.update();
	    				this.view.showGameFinish(game.getWinner());
	    				this.app.setChooseTeamScene();
	    			}
					this.clearAction();
	    		}

	    		this.clearSelectedCells();
	    		this.view.update();
	    	}

			if(this.action == Action.COMBINAR){
				List<Algoformer> algoformers = game.getActivePlayer().getAlgoformers();
				positionSelected1 = algoformers.get(0).getPosition();
				positionSelected2 = algoformers.get(1).getPosition();
				positionSelected3 = algoformers.get(2).getPosition();
				game.combinar();
				if (game.isOver()){
    				this.clearSelectedCells();
    	    		this.view.update();
    				this.view.showGameFinish(game.getWinner());
    				this.app.setChooseTeamScene();
    			}
				this.clearAction();
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
		if (this.positionSelected3!=null){
			this.view.toggleSelectCell(this.positionSelected3);
			this.positionSelected3 =null;
		}
	}

	public void nextTurn() throws InvalidPositionException {
		this.clearSelectedCells();
		this.game.nextTurn();
		this.view.updateTurn();
	}

	public void registerClickEvents(Canvas canvas){
		 canvas.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                	int x_celda = (int) (t.getX() / ViewConstants.CELL_WIDTH);
                	int y_celda = (int) (t.getY() / ViewConstants.CELL_HEIGHT);
					try {
						selectCell(new Position(x_celda,y_celda));
					} catch (InvalidPositionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            });
	}
}