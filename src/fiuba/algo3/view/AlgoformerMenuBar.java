package fiuba.algo3.view;

import fiuba.algo3.controller.GetOutOptionEventHandler;
import fiuba.algo3.controller.InfoOptionEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;



public class AlgoformerMenuBar extends MenuBar{

	public AlgoformerMenuBar(){
	    	Menu fileMenu = new Menu("Archivo");
	        MenuItem  getOutOption = new MenuItem("Salir");
	        GetOutOptionEventHandler getOutOptionEventHandler= new GetOutOptionEventHandler();
	        getOutOption.setOnAction(getOutOptionEventHandler);
	        fileMenu.getItems().addAll(getOutOption);

	        Menu seeMenu = new Menu("Ver");

	        Menu helpMenu = new Menu("Ayuda");
	        MenuItem infoOption = new MenuItem("Acerca de...");
	        InfoOptionEventHandler infoHandler = new InfoOptionEventHandler();
	        infoOption.setOnAction(infoHandler);
	        helpMenu.getItems().addAll(infoOption);




	        this.getMenus().addAll(fileMenu, seeMenu, helpMenu);
	}

}
