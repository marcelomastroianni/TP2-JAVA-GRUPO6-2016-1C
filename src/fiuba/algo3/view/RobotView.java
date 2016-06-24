package fiuba.algo3.view;

import fiuba.algo3.model.algoformers.Algoformer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class RobotView {
	 private Algoformer algoformer;
	 private Canvas canvas;

	 public RobotView(Algoformer algoformer, Canvas canvas){
		 this.algoformer = algoformer;
		 this.canvas = canvas;
	 }

	public void draw() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image imagen = ImageFactory.drowAlgoformer(algoformer);
    	int x = algoformer.getPosition().getX() * ViewConstants.CELL_WIDTH;
		int y =algoformer.getPosition().getY() * ViewConstants.CELL_HEIGHT;
    	gc.drawImage(imagen,x ,y ,ViewConstants.ALGO_WIDTH,ViewConstants.ALGO_HEIGHT);
	}
}
