package fiuba.algo3.view;


import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.bonus.Bonus;
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
	 private Image supRocosa = new Image("file:src/fiuba/algo3/vista/pictures/superficie_rocasa.jpg");
	 private Image supEspinas = new Image("file:src/fiuba/algo3/vista/pictures/superficie_espinas_2.jpg");
	 private Image supNubes = new Image("file:src/fiuba/algo3/vista/pictures/superficie_nubes.jpg");
	 private Image supPantano = new Image("file:src/fiuba/algo3/vista/pictures/superficie_pantano_2.jpg");
	 private Image supAndromeda = new Image("file:src/fiuba/algo3/vista/pictures/superficie_nebulosa_andromeda.jpg");
	 private Image supPsionica = new Image("file:src/fiuba/algo3/vista/pictures/superficie_tormenta_psionica.jpg");
	 
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
    	
    	if (this.cell.getSurface() instanceof SurfaceThorn)    	
    		imagen = supEspinas;
    	
    	if (this.cell.getSurface() instanceof SurfaceCloud)    	
    		imagen = supNubes;
    	
      	if (this.cell.getSurface() instanceof SuperficiePantano)    	
    		imagen = supPantano;
    	
    	if (this.cell.getSurface() instanceof SurfaceAndromedaNebula)    	
    		imagen = supAndromeda;
      	
    	if (this.cell.getSurface() instanceof SurfacePsionicStorm)    	
    		imagen = supPsionica;
    	
    	if (this.selected)
    		gc.setFill(Color.BLUE);
    	else
    		gc.setFill(Color.BLACK);
    	
    	gc.rect(cell.getPosition().getX()*ViewConstants.CELL_WIDTH, cell.getPosition().getY()*ViewConstants.CELL_HEIGHT, ViewConstants.CELL_WIDTH, ViewConstants.CELL_HEIGHT);
    	gc.fillRect(cell.getPosition().getX()*ViewConstants.CELL_WIDTH, cell.getPosition().getY()*ViewConstants.CELL_HEIGHT, ViewConstants.CELL_WIDTH, ViewConstants.CELL_HEIGHT);
    	gc.drawImage(imagen, cell.getPosition().getX()*ViewConstants.CELL_WIDTH + 1, cell.getPosition().getY()*ViewConstants.CELL_HEIGHT + 1,ViewConstants.CELL_WIDTH-2,ViewConstants.CELL_HEIGHT-2);
    	
    	
    	if (this.cell.getContent() instanceof Algoformer){
    		Algoformer algoformer = (Algoformer) this.cell.getContent();
    		RobotView robotView = new RobotView(algoformer, canvas);
    		robotView.draw();
    	}
    	
    	if (this.cell.getContent() instanceof ChispaSuprema){
    		ChispaSuprema chispaSuprema = (ChispaSuprema) this.cell.getContent();
    		ChispaSupremaView chispaSupremaView = new ChispaSupremaView(chispaSuprema, canvas);
    		chispaSupremaView.draw();
    	}
    	
    	if (this.cell.getContent() instanceof Bonus){
    		Bonus bonus = (Bonus) this.cell.getContent();
    		BonusView bonusView = new BonusView(bonus, canvas);
    		bonusView.draw();
    	}
    	
    }
}
