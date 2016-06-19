package fiuba.algo3.view;


import java.util.List;

import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class PrincipalContainer extends BorderPane {

	private Canvas canvas;
	private Game game;
	
    public PrincipalContainer(Stage stage,Game game) {        
        this.game = game;
        this.drawBoard();
        this.drawAlgoformers();
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

    private void drawBoard() {
    	 this.canvas = new Canvas(1400, 900);
    	 GraphicsContext gc = canvas.getGraphicsContext2D();
         for(int x= 0; x<=1350; x +=50){
        	 for(int y = 0; y<=750; y+=50){
        		 drawCell(gc, x, y);
        	 }
         }
         VBox contenedor = new VBox(canvas);
         this.setCenter(contenedor);

    }
    private void drawCell(GraphicsContext gc, int x, int y){
    	Image imagen = new Image("file:src/fiuba/algo3/vista/pictures/roca.jpg");
    	
    	gc.rect(x, y, 50, 50);
    	gc.fillRect(x, y, 50, 50);
    	gc.drawImage(imagen, x + 1, y + 1,48,48);
    }
}