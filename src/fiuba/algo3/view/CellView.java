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
    	gc.rect(cell.getPosition().getX()*ViewConstants.CELL_WIDTH, cell.getPosition().getY()*ViewConstants.CELL_HEIGHT, ViewConstants.CELL_WIDTH, ViewConstants.CELL_HEIGHT);
    	gc.fillRect(cell.getPosition().getX()*ViewConstants.CELL_WIDTH, cell.getPosition().getY()*ViewConstants.CELL_HEIGHT, ViewConstants.CELL_WIDTH, ViewConstants.CELL_HEIGHT);
    	gc.drawImage(imagen, cell.getPosition().getX()*ViewConstants.CELL_WIDTH + 1, cell.getPosition().getY()*ViewConstants.CELL_HEIGHT + 1,ViewConstants.CELL_WIDTH-2,ViewConstants.CELL_HEIGHT-2);
    }
}
