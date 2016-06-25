package fiuba.algo3.controller;

import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.exceptions.*;
import fiuba.algo3.view.AlgoformerApp;
import fiuba.algo3.view.GameView;
import fiuba.algo3.view.ViewConstants;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class GameController {
	private Position positionSelected1;
	private Position positionSelected2;
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

	private void selectAlgoformer(Position position){
		try{
			this.algoformerSelected = (Algoformer) this.game.getBoard().getContent(position);
			this.view.updateAlgoformerSelected(algoformerSelected);
		}catch(ClassCastException ex){
			this.algoformerSelected = null;
			this.view.clearAlgoformerSelected();
		}
	}

	public void selectCell(Position position) throws InvalidPositionException, MuyLejosException{
		this.selectAlgoformer(position);
		if (this.action != Action.SIN_ACCION){
			if (this.positionSelected1 == null){
	    		this.positionSelected1 =position;
	    		this.view.toggleSelectCell(this.positionSelected1);
	    		if (this.action == Action.TRANSFORMARSE){
	    			this.executeActionTransformar();
	    		}
	    	}else if (this.positionSelected2 == null){
	    		this.positionSelected2 =position;
	    		this.view.toggleSelectCell(this.positionSelected2);
	    		if (this.action == Action.MOVERSE){
	    			this.executeActionMover();
	    		}
	    		if (this.action == Action.ATACAR){
					this.executeActionAtacar();
	    		}
	    	}
		}
    }

	public void executeActionTransformar(){
		try {
			this.game.transformaraAlgoformer(positionSelected1);
		} catch (JugadorNoPuedeJugarCuandoNoEsSuTurnoException | UsuarioNoSeleccionoAlgoformerException
			 | InvalidPositionException | AlgoformerAtrapadoEsteTurnoException | AlgoformerUsadoEsteTurnoException e) {
			e.printStackTrace();
		}
		this.clearSelectedCells();
		this.clearAction();
		this.view.updateAlgoformerSelected(algoformerSelected);
	}

	public void executeActionMover(){
		try {
			this.game.moverAlgoformer( positionSelected1, positionSelected2);
		} catch (Exception e){
			e.printStackTrace();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("oups..");
			alert.setContentText(e.getMessage());
			alert.show();

		}
		this.checkGameOver();
		this.clearAction();
		this.clearSelectedCells();
		this.view.update();
	}

	public void executeActionAtacar(){
		try {
			this.game.dispararaAlgoformer(positionSelected1, positionSelected2);
		} catch (JugadorNoPuedeJugarCuandoNoEsSuTurnoException | UsuarioNoSeleccionoAlgoformerException
				| UsuarioNoSeleccionoAlgoformerAQuienDispararException | InvalidPositionException
				| AlgoformerUsadoEsteTurnoException e) {
			e.printStackTrace();
		}
		this.checkGameOver();
		this.clearAction();
		this.clearSelectedCells();
		this.view.update();
	}

	public void executeActionCombinar() throws MuyLejosException, InvalidPositionException{
		try{
			this.game.combinar();
		} catch (Exception e){
			e.printStackTrace();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("oups..");
			alert.setContentText(e.getMessage());
			alert.show();

		}
		this.clearAction();
		this.clearSelectedCells();
		this.view.update();
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

	public void checkGameOver(){
		if (this.game.isOver()){
			this.clearSelectedCells();
    		this.view.update();
			this.view.showGameFinish(game.getWinner());
			this.app.setChooseTeamScene();
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
					} catch (Exception e) {
						e.printStackTrace();
						Alert alert = new Alert(AlertType.INFORMATION);
				        alert.setTitle("oups.."+e);
				        String mensaje = "posicion Invalida";
				        alert.setContentText(mensaje);
				        alert.show();
					}

					}
            });
	}
}