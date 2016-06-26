package fiuba.algo3.view;

import fiuba.algo3.model.bonus.Bonus;
import fiuba.algo3.model.bonus.BonusInmaculateBubble;
import fiuba.algo3.model.bonus.BonusFlash;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BonusView {
	 private Bonus bonus;
	 private Canvas canvas;
	 
	 private Image cannon = ImageFactory.getBonusDobleCannon();
	 private Image flash = ImageFactory.getBonusFlash();
	 private Image bubble = ImageFactory.getBonusBubble();

	 public BonusView(Bonus bonus, Canvas canvas){
		 this.bonus = bonus;
		 this.canvas = canvas;
	 }

	public void draw() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
	   	Image imagen = cannon;
	   
	   	try{
	   		BonusFlash bonusFlash = (BonusFlash)this.bonus;
	   		imagen = flash;
	   	}
	   	catch(ClassCastException ex){	   		
	   	}	   	
		try{
			BonusInmaculateBubble bonusBurbuja = (BonusInmaculateBubble)this.bonus;
	   		imagen = bubble;
	   	}
	   	catch(ClassCastException ex){	   		
	   	}
	  	   
	   	int x = bonus.getPosition().getX()*ViewConstants.CELL_WIDTH;
		int y = bonus.getPosition().getY()*ViewConstants.CELL_HEIGHT;
	   	gc.drawImage(imagen,x ,y ,ViewConstants.CELL_WIDTH,ViewConstants.CELL_HEIGHT);
	}
}
