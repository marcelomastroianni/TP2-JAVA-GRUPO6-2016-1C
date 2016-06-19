package fiuba.algo3.view;

import fiuba.algo3.controller.AttackButtonHandler;
import fiuba.algo3.controller.GameController;
import fiuba.algo3.controller.MoveButtonHandler;
import fiuba.algo3.controller.NextTurnButtonHandler;
import fiuba.algo3.controller.TransformButtonHandler;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeJugarCuandoNoEsSuTurnoException;
import fiuba.algo3.model.exceptions.JugadorNoPuedeUtilizarAlgoformerQueNoEsSuyoException;
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
	        
	        final Game game = new Game();
	        game.init();
	        
	        Canvas canvas = new Canvas(1400, 900);
	        final GameView gameView = new GameView(game, canvas);
	        
	        final GameController gameController = new GameController(game, gameView); 
	        
	        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, 
	                new EventHandler<MouseEvent>() {
	                    @Override
	                    public void handle(MouseEvent t) {
	                    	int x_celda = (int) (t.getX() / ViewConstants.CELL_WIDTH);
	                    	int y_celda = (int) (t.getY() / ViewConstants.CELL_HEIGHT);
	                    	
	                    	gameController.selectCell(new Position(x_celda,y_celda));
	                    	System.out.println("(" + x_celda +  "," + y_celda +  ")");
	                    	
	                        if (t.getClickCount() >1) {
	                        	try {
	                    			game.moverAlgoformer( new Position(0,0), new Position(4,0));
	                    			gameView.update();
	                    		} catch (UsuarioNoSeleccionoAlgoformerException 
	                    				| JugadorNoPuedeJugarCuandoNoEsSuTurnoException | InvalidPositionException
	                    				| AlgoformerUsadoEsteTurnoException e) {
	                    			// TODO Auto-generated catch block
	                    			e.printStackTrace();
	                    		}
	                        }  
	                    }
	                });
	        
	        Group canvasContainer = new Group();
		    canvasContainer.getChildren().add(canvas);

	        Button moveButton = new Button();
	        moveButton.setText("Mover");
	        MoveButtonHandler moveButtonHandler = new MoveButtonHandler(gameView, game, gameController);
	        moveButton.setOnAction(moveButtonHandler);
	        
	        Button nextTurnButton = new Button();
	        nextTurnButton.setText("Siguiente Turno");
	        NextTurnButtonHandler nextTurnButtonHandler = new NextTurnButtonHandler(gameView, game,gameController);
	        nextTurnButton.setOnAction(nextTurnButtonHandler);
	  
	        Button transformButton = new Button();
	        transformButton.setText("Transformar");
	        TransformButtonHandler transformButtonHandler = new TransformButtonHandler(gameView, game, gameController);
	        transformButton.setOnAction(transformButtonHandler);
	        
	        Button attackButton = new Button();
	        attackButton.setText("Atacar");
	        AttackButtonHandler attackButtonHandler = new AttackButtonHandler(gameView, game, gameController);
	        attackButton.setOnAction(attackButtonHandler);
	        	        
	        HBox contenedorHorizontal = new HBox(moveButton, transformButton, attackButton, nextTurnButton);
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