package fiuba.algo3.view;


import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.bonus.Bonus;
import fiuba.algo3.model.bonus.FlashBonus;
import fiuba.algo3.model.surfaces.SuperficiePantano;
import fiuba.algo3.model.surfaces.SurfaceAndromedaNebula;
import fiuba.algo3.model.surfaces.SurfaceCloud;
import fiuba.algo3.model.surfaces.SurfacePsionicStorm;
import fiuba.algo3.model.surfaces.SurfaceThorn;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class CellView {
	 private Cell cell;
	 private Canvas canvas;
	 private boolean selected;

	 //Carga de imagenes
	 private Image supRocosa = ImageFactory.getSupRocosa();
	 private Image supEspinas = ImageFactory.getSupEspinas();
	 private Image supNubes = ImageFactory.getSupNubes();
	 private Image supPantano = ImageFactory.getSupPantano();
	 private Image supAndromeda = ImageFactory.getSupAndromeda();
	 private Image supPsionica = ImageFactory.getSupPsionica();

	 public CellView(Cell cell, Canvas canvas){
		 this.cell = cell;
		 this.canvas = canvas;
		 this.selected = false;
	 }

	 public void toggleSelect(){
		 if (this.selected)
			 this.selected = false;
		 else
			 this.selected = true;
	 }

	 public void update(){

		GraphicsContext gc = canvas.getGraphicsContext2D();
    	Image imagen = supRocosa;

       	try{
       		SurfaceThorn sup = (SurfaceThorn)this.cell.getSurface();
	   		imagen = supEspinas;
	   	}
	   	catch(ClassCastException ex){
	   	}

      	try{
      		SurfaceCloud sup = (SurfaceCloud)this.cell.getSurface();
	   		imagen = supNubes;
	   	}
	   	catch(ClassCastException ex){
	   	}

      	try{
      		SuperficiePantano sup = (SuperficiePantano)this.cell.getSurface();
	   		imagen = supPantano;
	   	}
	   	catch(ClassCastException ex){
	   	}

    	try{
    		SurfaceAndromedaNebula sup = (SurfaceAndromedaNebula)this.cell.getSurface();
	   		imagen = supAndromeda;
	   	}
	   	catch(ClassCastException ex){
	   	}

    	try{
    		SurfacePsionicStorm sup = (SurfacePsionicStorm)this.cell.getSurface();
	   		imagen = supPsionica;
	   	}
	   	catch(ClassCastException ex){
	   	}

    	if (this.selected)
    		gc.setFill(Color.BLUE);
    	else
    		gc.setFill(Color.BLACK);

    	gc.rect(cell.getPosition().getX()*ViewConstants.CELL_WIDTH, cell.getPosition().getY()*ViewConstants.CELL_HEIGHT, ViewConstants.CELL_WIDTH, ViewConstants.CELL_HEIGHT);
    	gc.fillRect(cell.getPosition().getX()*ViewConstants.CELL_WIDTH, cell.getPosition().getY()*ViewConstants.CELL_HEIGHT, ViewConstants.CELL_WIDTH, ViewConstants.CELL_HEIGHT);
    	gc.drawImage(imagen, cell.getPosition().getX()*ViewConstants.CELL_WIDTH + 1, cell.getPosition().getY()*ViewConstants.CELL_HEIGHT + 1,ViewConstants.CELL_WIDTH-2,ViewConstants.CELL_HEIGHT-2);


    	try{
    		Algoformer algoformer = (Algoformer)this.cell.getContent();
    		RobotView robotView = new RobotView(algoformer, canvas);
    		robotView.draw();
	   	}
	   	catch(ClassCastException ex){
	   	}

    	try{
    		ChispaSuprema chispaSuprema = (ChispaSuprema) this.cell.getContent();
    		ChispaSupremaView chispaSupremaView = new ChispaSupremaView(chispaSuprema, canvas);
    		chispaSupremaView.draw();
	   	}
	   	catch(ClassCastException ex){
	   	}

    	try{
    		Bonus bonus = (Bonus) this.cell.getContent();
    		BonusView bonusView = new BonusView(bonus, canvas);
    		bonusView.draw();
	   	}
	   	catch(ClassCastException ex){
	   	}
    }
}
