package fiuba.algo3.view;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrincipalContainer extends BorderPane {

	private Canvas canvas;
	private Game game;
	
	private void initilizeCanvas(){
	    this.canvas = new Canvas(1400, 900);
	    VBox contenedor = new VBox(canvas);
	    this.setCenter(contenedor);
	}
    public PrincipalContainer(Stage stage,Game game) {        
        this.game = game;
        this.initilizeCanvas();
        this.drawCells();
        this.drawAlgoformers();    
        this.drawChispaSupreama();
    }
    
    private void drawAlgoformers(){    	     	
    	 List<Algoformer> listaAlgoformersPlayer1 = this.game.getPlayer1().getAlgoformers();
    	 for (Algoformer algoformer:listaAlgoformersPlayer1){
    		 RobotView robotView = new RobotView(algoformer,canvas);
             robotView.draw();
    	 }
    	 List<Algoformer> listaAlgoformersPlayer2 = this.game.getPlayer2().getAlgoformers();
    	 for (Algoformer algoformer:listaAlgoformersPlayer2){
    		 RobotView robotView = new RobotView(algoformer,canvas);
             robotView.draw();
    	 }
    }
    
    private void drawChispaSupreama(){    	  
    	ChispaSuprema chispaSuprema = (ChispaSuprema) this.game.getBoard().getContent(this.game.getBoard().getCentralPosition());    	
    	ChispaSupremaView chispaSupremaView = new ChispaSupremaView(chispaSuprema, canvas);
    	chispaSupremaView.draw();	
    }
    
    private void drawCells(){    	    
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	Iterator entries = this.game.getBoard().getCells().entrySet().iterator();
    	while (entries.hasNext()) {
    	  Entry thisEntry = (Entry) entries.next();
    	  Position position = (Position) thisEntry.getKey();
    	  Cell cell = (Cell) thisEntry.getValue();    	
    	  CellView cellView = new CellView(cell,canvas);
    	  cellView.draw();
    	}    
    }
}