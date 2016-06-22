package fiuba.algo3.controller;

import fiuba.algo3.view.AlgoformerApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnterButtonEventHandler implements EventHandler<ActionEvent> {


	private TextField inputNamePlayer1;
	private TextField inputNamePlayer2;
	AlgoformerApp app;

	public EnterButtonEventHandler(TextField inputNamePlayer1,TextField inputNamePlayer2,AlgoformerApp app) {
		this.inputNamePlayer1 = inputNamePlayer1;
		this.inputNamePlayer2 = inputNamePlayer2;
		this.app = app;

	}

	@Override
	public void handle(ActionEvent actionEvent) {
		String namePlayer1 = inputNamePlayer1.getText();
		String namePlayer2 = inputNamePlayer2.getText();				
		this.app.setGameScene(namePlayer1,namePlayer2);
	}
}
