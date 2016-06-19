package fiuba.algo3.view;

import fiuba.algo3.controller.MoveButtonHandler;
import fiuba.algo3.model.algoformers.game.Game;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlgoformerApp extends Application {

		public static void main(String[] args) {
	        launch(args);
	    }

	    @Override
	    public void start(final Stage stage) throws Exception {

	        stage.setTitle("Algoformers");
	        
	        Game game = new Game();
	        game.init();
	        
	        Canvas canvas = new Canvas(1400, 900);
	        	     
	        GameView gameView = new GameView(game, canvas);
	        
	        Group canvasContainer = new Group();
		    canvasContainer.getChildren().add(canvas);

		    
	        Button moveButton = new Button();
	        moveButton.setText("Move");
	        MoveButtonHandler moveButtonHandler = new MoveButtonHandler(gameView, game);
	        moveButton.setOnAction(moveButtonHandler);


	        Button directionButton = new Button();
	        directionButton.setText("Change direction");
	        //DirectionButtonHandler directionButtonHandler = new DirectionButtonHandler(robot);
	        //directionButton.setOnAction(directionButtonHandler);


	        HBox contenedorHorizontal = new HBox(moveButton, directionButton);
	        contenedorHorizontal.setSpacing(10);
	        
		    VBox contenedorPrincipal = new VBox(contenedorHorizontal, canvasContainer);
	        contenedorPrincipal.setSpacing(10);
	        contenedorPrincipal.setPadding(new Insets(20));
	        	        	        	        	      
	        //PrincipalContainer contenedorPrincipal = new PrincipalContainer(stage,game);	
	        Scene playScene = new Scene(contenedorPrincipal, 640, 480);

	        stage.setScene(playScene);
	        stage.setFullScreen(true);

	        stage.show();
	    }
}