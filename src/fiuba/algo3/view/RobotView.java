package fiuba.algo3.view;

import fiuba.algo3.model.algoformers.Algoformer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class RobotView {
	 private Algoformer robot;
	 private Canvas canvas;

	 public RobotView(Algoformer robot, Canvas canvas){
		 this.robot = robot;
		 this.canvas = canvas;
	 }

	public void draw() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
    	Image imagen = new Image("file:src/fiuba/algo3/vista/pictures/optimusPrime.png");
    	int x = robot.getPosition().getX()*50;
		int y =robot.getPosition().getY()*50;
    	gc.drawImage(imagen,x ,y ,50,50);
	}
}
