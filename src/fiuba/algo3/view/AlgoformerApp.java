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
		}

	    @Override
	    public void start(final Stage stage) throws Exception {
	    	this.createControls(stage);
	        this.setChooseTeamScene();
	    }

	    public void setGameScene(String namePlayer1,String namePlayer2){
	    	this.juego = new GameContainer(this,namePlayer1,namePlayer2);
	    	this.playScene = new Scene(this.juego,1200,800);
	    	this.stage.setScene(this.playScene);
	    	this.stage.setFullScreen(true);
	    	this.stage.show();

	    }

	    public void setChooseTeamScene(){
	        this.ChoseTeamContainer  = new ChoseTeamContainer(this);
	        this.escenaElegirEquipo = new Scene(this.ChoseTeamContainer, 1200,800);
	    	this.stage.setScene(this.escenaElegirEquipo);
	    	this.stage.setFullScreen(true);
	    	this.stage.show();
	    }

	    public Stage getStage(){
	    	return this.stage;
	    }
}