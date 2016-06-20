package fiuba.algo3.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class AlgoformerApp extends Application {


		public static void main(String[] args) {
	        launch(args);
	    }



	    @Override
	    public void start(final Stage stage) throws Exception {

	        stage.setTitle("Algoformers");

	        GameContainer juego = new GameContainer(stage);
	        Scene playScene = new Scene(juego,3000,3000);

	       ChoseTeamContainer ChoseTeamContainer  = new ChoseTeamContainer(stage, playScene);
	        Scene escenaElegirEquipo = new Scene(ChoseTeamContainer, 640, 480);


	        stage.setScene(escenaElegirEquipo);
	        stage.setFullScreen(true);

	        stage.show();

	    }



}