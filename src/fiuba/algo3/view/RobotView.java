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
		
		if (this.robot.getNombre().equals("Optimus Prime"))
			imagen = new Image("file:src/fiuba/algo3/vista/pictures/optimusPrime.png");
		if (this.robot.getNombre().equals("Bumblebee"))
			imagen = new Image("file:src/fiuba/algo3/vista/pictures/bumblebee.png");
		if (this.robot.getNombre().equals("Ratchet"))
			imagen = new Image("file:src/fiuba/algo3/vista/pictures/ratchet.png");
		if (this.robot.getNombre().equals("Megatron"))
			imagen = new Image("file:src/fiuba/algo3/vista/pictures/megatron.png");
		if (this.robot.getNombre().equals("Bonecrusher"))
			imagen = new Image("file:src/fiuba/algo3/vista/pictures/bonecrusher.png");
		if (this.robot.getNombre().equals("Frenzy"))
			imagen = new Image("file:src/fiuba/algo3/vista/pictures/frenzy.png");
							
    	int x = robot.getPosition().getX()*ViewConstants.CELL_WIDTH;
		int y =robot.getPosition().getY()*ViewConstants.CELL_HEIGHT;
    	gc.drawImage(imagen,x ,y ,ViewConstants.CELL_WIDTH,ViewConstants.CELL_HEIGHT);
	}
}
