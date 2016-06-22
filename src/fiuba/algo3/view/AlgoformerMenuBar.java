package fiuba.algo3.view;

import fiuba.algo3.controller.GetOutOptionEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;


public class AlgoformerMenuBar extends MenuBar{

	public AlgoformerMenuBar(){
		  	Menu fileMenu = new Menu("Archivo");
	        Menu seeMenu = new Menu("Ver");
	        Menu helpMenu = new Menu("Ayuda");

	        MenuItem  getOutOption = new MenuItem("Salir");
	        MenuItem infoOption = new MenuItem("Acerca de...");

	        GetOutOptionEventHandler getOutOptionEventHandler= new GetOutOptionEventHandler();

	        this.getMenus().addAll(fileMenu, seeMenu, helpMenu);
	}

}
