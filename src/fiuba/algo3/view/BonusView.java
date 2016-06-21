package fiuba.algo3.view;

import fiuba.algo3.model.bonus.Bonus;
import fiuba.algo3.model.bonus.BonusBurbujaInmaculada;
import fiuba.algo3.model.bonus.BonusFlash;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BonusView {
	 private Bonus bonus;
	 private Canvas canvas;
	 
	 private Image cannon = new Image("file:src/fiuba/algo3/vista/pictures/bonus_doble_cannon.png");
	 private Image flash = new Image("file:src/fiuba/algo3/vista/pictures/bonus_flash.png");
	 private Image bubble = new Image("file:src/fiuba/algo3/vista/pictures/bonus_burbuja_inmaculada.png");

	 public BonusView(Bonus bonus, Canvas canvas){
		 this.bonus = bonus;
		 this.canvas = canvas;
	 }

	public void draw() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
	   	Image imagen = cannon;
	   		   	
	   	if (this.bonus instanceof BonusFlash){
	   		imagen = flash;
	   	}
	   	if (this.bonus instanceof BonusBurbujaInmaculada){
	   		imagen = bubble;
	   	}	   	
	   		   	
	   	int x = bonus.getPosition().getX()*ViewConstants.CELL_WIDTH;
		int y = bonus.getPosition().getY()*ViewConstants.CELL_HEIGHT;
	   	gc.drawImage(imagen,x ,y ,ViewConstants.CELL_WIDTH,ViewConstants.CELL_HEIGHT);
	}
}
