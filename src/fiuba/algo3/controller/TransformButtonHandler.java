package fiuba.algo3.controller;

import fiuba.algo3.controller.GameController.Action;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.view.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TransformButtonHandler implements EventHandler<ActionEvent> {

	GameView view;
	Game game;
	GameController controller;

    public TransformButtonHandler(GameView view,Game game,GameController controller) {
        this.view = view;
        this.game = game;
        this.controller = controller;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	this.controller.selectAction(Action.TRANSFORMARSE);    	    	    
    }
}