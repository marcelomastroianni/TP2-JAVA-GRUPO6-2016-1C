package fiuba.algo3.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class FullScreenEventHandler implements EventHandler<ActionEvent> {

	  Stage stage;
	    MenuItem fullScreenOption;

	    public FullScreenEventHandler(Stage stage, MenuItem fullScreenOption) {
	        this.stage = stage;
	        this.fullScreenOption = fullScreenOption;
	    }

	    @Override
	    public void handle(ActionEvent actionEvent) {
	        if (!stage.isFullScreen()) {
	            stage.hide();
	            stage.setFullScreen(true);
	            fullScreenOption.setDisable(true);
	            stage.show();
	        }
	    }

}
