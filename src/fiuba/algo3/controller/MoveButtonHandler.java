package fiuba.algo3.controller;

import fiuba.algo3.controller.GameController.Action;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeJugarCuandoNoEsSuTurnoException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeUtilizarAlgoformerQueNoEsSuyoException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerException;
import fiuba.algo3.view.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveButtonHandler implements EventHandler<ActionEvent> {

	GameView view;
	Game game;
	GameController controller;

    public MoveButtonHandler(GameView view,Game game,GameController controller) {
        this.view = view;
        this.game = game;
        this.controller = controller;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	this.controller.selectAction(Action.MOVERSE);    	    	    
    }
}