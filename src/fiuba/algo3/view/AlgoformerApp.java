package fiuba.algo3.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlgoformerApp extends Application {

		Stage stage;
		Scene playScene;
		Scene escenaElegirEquipo;
		GameContainer juego;
		ChoseTeamContainer ChoseTeamContainer;
		
		public static void main(String[] args) {
	        launch(args);
	    }
		
		private void createControls(final Stage stage){
			this.stage = stage;
	    	this.stage.setTitle("Algoformers");
	        this.juego = new GameContainer(this.stage);
	        this.playScene = new Scene(this.juego,1200,800);
	        this.ChoseTeamContainer  = new ChoseTeamContainer(this.stage, this.playScene);
	        this.escenaElegirEquipo = new Scene(this.ChoseTeamContainer, 640, 480);	 
	        this.stage.show();
		}

	    @Override
	    public void start(final Stage stage) throws Exception {
	    	this.createControls(stage);
	        this.setGameScene();
	    }
	    
	    public void setGameScene(){
	    	this.stage.setScene(this.playScene);
	        this.stage.setFullScreen(true);
	    }
	    
	    public void setChooseTeamScene(){
	    	this.stage.setScene(this.escenaElegirEquipo);
	        this.stage.setFullScreen(true);
	    }
}