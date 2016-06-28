package fiuba.algo3.controller;

import fiuba.algo3.view.AlgoformerMenuBar;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AplicacionOnExitPressEventHandler  implements EventHandler<KeyEvent> {

	private Stage stage;
    private AlgoformerMenuBar menuBar;

    public AplicacionOnExitPressEventHandler(Stage stage, AlgoformerMenuBar  menuBar) {
        this.stage = stage;
        this.menuBar = menuBar;
    }
	@Override
	public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ESCAPE) {
            stage.setMaximized(true);
            menuBar.maximizedApp();
        }
	}
}