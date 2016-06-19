package fiuba.algo3.controller;

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

    public MoveButtonHandler(GameView view,Game game) {
        this.view = view;
        this.game = game;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	try {
			this.game.moverAlgoformer(game.getPlayer1(), new Position(0,0), new Position(4,0));
			this.view.update();
		} catch (UsuarioNoSeleccionoAlgoformerException | JugadorNoPuedeUtilizarAlgoformerQueNoEsSuyoException
				| JugadorNoPuedeJugarCuandoNoEsSuTurnoException | InvalidPositionException
				| AlgoformerUsadoEsteTurnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
}