package fiuba.algo3.view;


import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Position;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class PrincipalContainer extends BorderPane {

	private Canvas canvas;
    public PrincipalContainer(Stage stage) {
        this.createBoard();
    }

    private void createBoard() {
    	 this.canvas = new Canvas(1400, 900);
    	 GraphicsContext gc = canvas.getGraphicsContext2D();
         for(int x= 0; x<=1350; x +=50){
        	 for(int y = 0; y<=750; y+=50){
        		 drawCell(gc, x, y);
        	 }
         }
         this.drawRobot();
         VBox contenedor = new VBox(canvas);
         this.setCenter(contenedor);

    }
    private void drawCell(GraphicsContext gc, int x, int y){
    	Image imagen = new Image("file:src/fiuba/algo3/vista/pictures/roca.jpg");
    	gc.drawImage(imagen, x, y,50,50);
    }

    private void drawRobot(){
    	Algoformer robot = AlgoFormerFactory.getOptimusPrime(new Position(5, 5));
    	 RobotView robotView = new RobotView(robot,canvas);
         robotView.draw();
    }
}