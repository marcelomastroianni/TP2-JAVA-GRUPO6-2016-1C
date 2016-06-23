package fiuba.algo3.view;

import fiuba.algo3.controller.AplicacionOnExitPressEventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class AlgoformerApp extends Application {
		Stage stage;
		Scene playScene;
		Scene escenaElegirEquipo;
		GameContainer juego;
		ChoseTeamContainer ChoseTeamContainer;
		String css;


		public static void main(String[] args) {
	        launch(args);
	    }

		private void createControls(final Stage stage){
			this.stage = stage;
	    	this.stage.setTitle("Algoformers");
	    	this.css = this.getClass().getResource("DarckTheme.css").toExternalForm();
		}

	    @Override
	    public void start(final Stage stage) throws Exception {
	    	this.createControls(stage);
	        this.setChooseTeamScene();
	    }

	    public void setGameScene(String namePlayer1,String namePlayer2){
	    	this.juego = new GameContainer(this,namePlayer1,namePlayer2);
	    	this.playScene = new Scene(this.juego,1000,500);
	    	this.stage.setScene(this.playScene);
	    	this.stage.setFullScreen(true);

	        playScene.getStylesheets().add(css);

	    	AplicacionOnExitPressEventHandler aplicacionOnKeyPressEventHandler = new AplicacionOnExitPressEventHandler(stage, this.juego.getMenuBar());
	        playScene.setOnKeyPressed( aplicacionOnKeyPressEventHandler);
	    	this.stage.show();

	    }

	    public void setChooseTeamScene(){
	        this.ChoseTeamContainer  = new ChoseTeamContainer(this);
	        this.escenaElegirEquipo = new Scene(this.ChoseTeamContainer, 1200,800);
	        escenaElegirEquipo.getStylesheets().add(css);
	    	this.stage.setScene(this.escenaElegirEquipo);
	    	this.stage.setFullScreen(true);
	    	this.stage.show();
	    }

	    public Stage getStage(){
	    	return this.stage;
	    }
}