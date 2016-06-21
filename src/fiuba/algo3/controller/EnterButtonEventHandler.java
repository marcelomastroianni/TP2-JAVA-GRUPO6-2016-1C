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
	private TextField inputNamePlayer1;
	private TextField inputNamePlayer2;

	public EnterButtonEventHandler(Stage stage,TextField inputNamePlayer1,TextField inputNamePlayer2, Scene nextScene) {
		this.inputNamePlayer1 = inputNamePlayer1;
		this.inputNamePlayer2 = inputNamePlayer2;
		this.proximaEscena = nextScene;

	}

	@Override
	public void handle(ActionEvent actionEvent) {
		System.out.println("jugador1: "+inputNamePlayer1.getText());
		System.out.println("jugador2: "+inputNamePlayer2.getText());
		stage.setScene(proximaEscena);
		stage.setFullScreenExitHint("Exit");
		stage.setFullScreen(true);
	}

}
