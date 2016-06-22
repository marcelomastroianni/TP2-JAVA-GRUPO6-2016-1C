package fiuba.algo3.view;

import fiuba.algo3.controller.FullScreenEventHandler;
import fiuba.algo3.controller.GetOutOptionEventHandler;
import fiuba.algo3.controller.InfoOptionEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;



public class AlgoformerMenuBar extends MenuBar{

	MenuItem fullScreenOption;

	public AlgoformerMenuBar(Stage stage){
	    	Menu fileMenu = new Menu("Archivo");
	        MenuItem  getOutOption = new MenuItem("Salir");
	        GetOutOptionEventHandler getOutOptionEventHandler= new GetOutOptionEventHandler();
	        getOutOption.setOnAction(getOutOptionEventHandler);
	        fileMenu.getItems().addAll(getOutOption);

	        Menu viewMenu = new Menu("Ver");
	        fullScreenOption = new MenuItem("Pantalla completa");
	        FullScreenEventHandler fullScreenOptionHandler = new FullScreenEventHandler(stage, fullScreenOption);
	        fullScreenOption.setOnAction(fullScreenOptionHandler );
	        fullScreenOption.setDisable(true);
	        viewMenu.getItems().add(fullScreenOption);

	        Menu helpMenu = new Menu("Ayuda");
	        MenuItem infoOption = new MenuItem("Acerca de...");
	        InfoOptionEventHandler infoHandler = new InfoOptionEventHandler();
	        infoOption.setOnAction(infoHandler);
	        helpMenu.getItems().addAll(infoOption);

	        this.getMenus().addAll(fileMenu, viewMenu, helpMenu);
	}

	 public void maximizedApp() {
		 fullScreenOption.setDisable(false);

	    }


}
