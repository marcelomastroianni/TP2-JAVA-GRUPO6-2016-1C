package fiuba.algo3.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeJugarCuandoNoEsSuTurnoException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeUtilizarAlgoformerQueNoEsSuyoException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerException;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameView  {

	private Canvas canvas;
	private Game game;
	private Map<Position,CellView> listaCellViews = new HashMap<>();
    public GameView(Game game,Canvas canvas) {        
        this.game = game;
        this.canvas = canvas;
        this.update();      
    }
    
    public void update(){
    	  this.drawCells();   
    }
    
    public void toggleSelectCell(Position position){
    	listaCellViews.get(position).toggleSelect();
		listaCellViews.get(position).update(); 
    }
    
    private void drawCells(){    	    
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	Iterator entries = this.game.getBoard().getCells().entrySet().iterator();
    	while (entries.hasNext()) {
    	  Entry thisEntry = (Entry) entries.next();
    	  Position position = (Position) thisEntry.getKey();
    	  Cell cell = (Cell) thisEntry.getValue();    	
    	  CellView cellView = new CellView(cell,canvas);
    	  cellView.update();
    	  listaCellViews.put(position, cellView);
    	}    
    }
}