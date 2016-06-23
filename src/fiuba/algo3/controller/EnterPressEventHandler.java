package fiuba.algo3.controller;

import fiuba.algo3.view.AlgoformerApp;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EnterPressEventHandler implements   EventHandler<KeyEvent>  {

	private TextField inputNamePlayer1;
	private TextField inputNamePlayer2;
	AlgoformerApp app;

	public EnterPressEventHandler(TextField inputNamePlayer1,TextField inputNamePlayer2,AlgoformerApp app) {
		this.inputNamePlayer1 = inputNamePlayer1;
		this.inputNamePlayer2 = inputNamePlayer2;
		this.app = app;

	}

	@Override
	public void handle(KeyEvent event) {
		if(event.getCode() == KeyCode.ENTER){
			String namePlayer1 = inputNamePlayer1.getText();
			String namePlayer2 = inputNamePlayer2.getText();
			this.app.setGameScene(namePlayer1,namePlayer2);
		}

	}

}
