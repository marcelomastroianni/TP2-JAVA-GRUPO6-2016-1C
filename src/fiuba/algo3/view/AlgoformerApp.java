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

	        PrincipalContainer contenedorPrincipal = new PrincipalContainer(stage);
	        Scene playScene = new Scene(contenedorPrincipal, 640, 480);


	        stage.setScene(playScene);
	        stage.setFullScreen(true);

	        stage.show();

	    }



}
