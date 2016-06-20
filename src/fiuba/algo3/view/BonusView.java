package fiuba.algo3.view;

import fiuba.algo3.model.bonus.Bonus;
import fiuba.algo3.model.bonus.BonusFlash;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BonusView {
	 private Bonus bonus;
	 private Canvas canvas;

	 public BonusView(Bonus bonus, Canvas canvas){
		 this.bonus = bonus;
		 this.canvas = canvas;
	 }

	public void draw() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
	   	Image imagen = new Image("file:src/fiuba/algo3/vista/pictures/bonus_doble_cannon.png");
	   		   	
	   	if (this.bonus instanceof BonusFlash){
	   		imagen = new Image("file:src/fiuba/algo3/vista/pictures/bonus_flash.png");
	   	}	   	
	   	
	   	int x = bonus.getPosition().getX()*ViewConstants.CELL_WIDTH;
		int y = bonus.getPosition().getY()*ViewConstants.CELL_HEIGHT;
	   	gc.drawImage(imagen,x ,y ,ViewConstants.CELL_WIDTH,ViewConstants.CELL_HEIGHT);
	}
}
