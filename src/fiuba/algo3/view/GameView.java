package fiuba.algo3.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

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