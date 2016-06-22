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
		Image imagen = ImageFactory.getAlgoformerOtimusPrime();
		
		if (this.robot.getNombre().equals("Optimus Prime")){
			imagen = ImageFactory.getAlgoformerOtimusPrime();
			if (this.robot.getActiveMode().equals(this.robot.getAlternalMode()))
				imagen = ImageFactory.getAlgoformerOtimusPrimeAlternal();
		}
			
		if (this.robot.getNombre().equals("Bumblebee")){
			imagen = ImageFactory.getAlgoformerBumblebee();			
			if (this.robot.getActiveMode().equals(this.robot.getAlternalMode()))
				imagen = ImageFactory.getAlgoformerBumblebeeAlternal();			
		}
					
		if (this.robot.getNombre().equals("Ratchet")){
			imagen = ImageFactory.getAlgoformerRatchet();						
			if (this.robot.getActiveMode().equals(this.robot.getAlternalMode()))
				imagen = ImageFactory.getAlgoformerRatchetAlternal();
		}
					
		if (this.robot.getNombre().equals("Megatron")){
			imagen = ImageFactory.getAlgoformerMegatron();			
			if (this.robot.getActiveMode().equals(this.robot.getAlternalMode()))
				imagen = ImageFactory.getAlgoformerMegatronAlternal();
		}
					
		if (this.robot.getNombre().equals("Bonecrusher")){
			imagen = ImageFactory.getAlgoformerBonecrusher();
		}
					
		if (this.robot.getNombre().equals("Frenzy")){
			imagen = ImageFactory.getAlgoformerFrenzy();
		}			
							
    	int x = robot.getPosition().getX() * ViewConstants.CELL_WIDTH;
		int y =robot.getPosition().getY() * ViewConstants.CELL_HEIGHT;
    	gc.drawImage(imagen,x ,y ,ViewConstants.CELL_WIDTH,ViewConstants.CELL_HEIGHT);
	}
}
