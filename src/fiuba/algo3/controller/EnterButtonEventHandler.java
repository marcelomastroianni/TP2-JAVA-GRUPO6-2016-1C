package fiuba.algo3.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EnterButtonEventHandler implements EventHandler<ActionEvent> {

	  Stage stage;
	    Scene proximaEscena;

	    public EnterButtonEventHandler(Stage stage, Scene nextScene) {
	        this.stage = stage;
	        this.proximaEscena = nextScene;
	    }

	    @Override
	    public void handle(ActionEvent actionEvent) {
	        stage.setScene(proximaEscena);
	        stage.setFullScreenExitHint("");
	        stage.setFullScreen(true);
	    }

}
