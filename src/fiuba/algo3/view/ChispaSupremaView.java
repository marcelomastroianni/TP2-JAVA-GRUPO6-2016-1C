package fiuba.algo3.view;

import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ChispaSupremaView {
	 private ChispaSuprema chispaSuprema;
	 private Canvas canvas;
	 private Image chispaSupremaImage = ImageFactory.getChispaSuprema();

	 public ChispaSupremaView(ChispaSuprema chispaSuprema, Canvas canvas){
		 this.chispaSuprema = chispaSuprema;
		 this.canvas = canvas;
	 }

	public void draw() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
	   	Image imagen = chispaSupremaImage;
	   	int x = chispaSuprema.getPosition().getX()*ViewConstants.CELL_WIDTH;
		int y =chispaSuprema.getPosition().getY()*ViewConstants.CELL_HEIGHT;
	   	gc.drawImage(imagen,x ,y ,ViewConstants.CELL_WIDTH,ViewConstants.CELL_HEIGHT);
	}
}
