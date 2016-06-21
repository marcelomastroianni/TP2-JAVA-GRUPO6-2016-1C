package fiuba.algo3.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnterButtonEventHandler implements EventHandler<ActionEvent> {


	private Stage stage;
	private Scene proximaEscena;

	public EnterButtonEventHandler(Stage stage,TextField inputNamePlayer1,TextField inputNamePlayer2, Scene nextScene) {
		String namePlayer1 = inputNamePlayer1.getText();
		String namePlayer2 = inputNamePlayer2.getText();
		this.stage = stage;
		this.proximaEscena = nextScene;
		System.out.println("jugador1: "+namePlayer1);
		System.out.println("jugador2: "+namePlayer2);
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		stage.setScene(proximaEscena);
		stage.setFullScreenExitHint("Exit");
		stage.setFullScreen(true);
	}

}
