package fiuba.algo3.controller;

import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.view.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NextTurnButtonHandler implements EventHandler<ActionEvent> {

	GameView view;
	Game game;

    public NextTurnButtonHandler(GameView view,Game game) {
        this.view = view;
        this.game = game;
    }

    @Override
    public void handle(ActionEvent actionEvent) {  
		this.game.nextTurn();		
    }
}