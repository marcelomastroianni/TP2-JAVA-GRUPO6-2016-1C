package fiuba.algo3.view;


import fiuba.algo3.model.algoformers.board.Cell;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class CellView {
	 private Cell cell;
	 private Canvas canvas;

	 public CellView(Cell cell, Canvas canvas){
		 this.cell = cell;
		 this.canvas = canvas;
	 }
	 
	 public void draw(){
		GraphicsContext gc = canvas.getGraphicsContext2D();
    	Image imagen = new Image("file:src/fiuba/algo3/vista/pictures/roca.jpg");    	
    	gc.rect(cell.getPosition().getX()*50, cell.getPosition().getY()*50, 50, 50);
    	gc.fillRect(cell.getPosition().getX()*50, cell.getPosition().getY()*50, 50, 50);
    	gc.drawImage(imagen, cell.getPosition().getX()*50 + 1, cell.getPosition().getY()*50 + 1,48,48);
    }
}
