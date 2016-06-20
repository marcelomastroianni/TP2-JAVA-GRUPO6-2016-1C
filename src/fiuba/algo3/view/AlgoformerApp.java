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
import fiuba.algo3.model.exceptions.UsuarioNoSeleccionoAlgoformerException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlgoformerApp extends Application {

		private Canvas canvas;
		private Group canvasContainer;
		private Button moveButton;
		private Button nextTurnButton;
		private Button transformButton;
		private Button attackButton;
		private Label lblActionSelectedTitle;
		private Label lblActionSelected;
		private Label lblTurnoTitle;
		private Label lblTurno;
		private Label lblAlgoformerTitle;
		private Label lblAlgoformerName;
		private Label lblAlgoformerLife;
		private Label lblAlgoformerAttack;		
		private Label lblAlgoformerStrikingDistance;
		private Label lblAlgoformerSpeed;
		private Label lblAlgoformerPosition;
		
		private Label lblBlankLine1;
		private Label lblBlankLine2;
		
		private Game game;
		private GameView gameView;
		private GameController gameController;
		
		public static void main(String[] args) {
	        launch(args);
	    }

		private void createControls(){
			this.canvas = new Canvas(1400, 900);
      	      	
			this.moveButton = new Button("Mover");   	        
			this.nextTurnButton = new Button("Siguiente Turno");
			this.transformButton = new Button("Transformar");       
			this.attackButton = new Button("Atacar");
	        
			this.lblActionSelectedTitle = new Label("Accion Seleccionada:");
			this.lblActionSelected = new Label("");
	        
			this.lblTurnoTitle = new Label("Turno Jugador:");
			this.lblTurno = new Label("");
			
			this.lblBlankLine1 = new Label("");
			this.lblBlankLine2 = new Label("");
			
			this.lblAlgoformerTitle = new Label("Algoformer Seleccionado:");
			this.lblAlgoformerName = new Label("");
			this.lblAlgoformerLife = new Label("");
			this.lblAlgoformerAttack = new Label("");
			this.lblAlgoformerStrikingDistance = new Label("");
			this.lblAlgoformerSpeed = new Label("");
			this.lblAlgoformerPosition = new Label("");
		}
		
		private void initilizeLayout(final Stage stage){
			stage.setTitle("Algoformers");
        	      
			this.canvasContainer = new Group();
			this.canvasContainer.getChildren().add(canvas);
			
	        HBox contenedorHorizontal = new HBox(this.moveButton, this.transformButton, this.attackButton, this.nextTurnButton);
	        contenedorHorizontal.setSpacing(10);
	        contenedorHorizontal.setPadding(new Insets(20));
	        
		    VBox contenedorPrincipal = new VBox(contenedorHorizontal, this.canvasContainer);
	        contenedorPrincipal.setSpacing(10);
	        contenedorPrincipal.setPadding(new Insets(20));
	        	    	 	        	     	    	        	        
	        VBox leftPane = new VBox(this.lblActionSelectedTitle,
	        						this.lblActionSelected,
	        						this.lblBlankLine1,
	        						this.lblTurnoTitle,
	        						this.lblTurno,
	        						this.lblBlankLine2,
	        						this.lblAlgoformerTitle,
	        						this.lblAlgoformerName,
	        						this.lblAlgoformerLife,
	        						this.lblAlgoformerAttack,
	        						this.lblAlgoformerStrikingDistance,
	        						this.lblAlgoformerSpeed,
	        						this.lblAlgoformerPosition);
	        	     
	        leftPane.setSpacing(10);
	        leftPane.setPadding(new Insets(20));
	        
	        BorderPane borderPane = new BorderPane();
	        
	        borderPane.setLeft(leftPane);
	        borderPane.setTop(contenedorHorizontal);
	        borderPane.setCenter(this.canvasContainer);
	        	        	        	        	      
	        Scene playScene = new Scene(borderPane, 640, 480);

	        stage.setScene(playScene);
	        stage.setFullScreen(true);

	        stage.show();
		}

		private void initializeMVC() throws InvalidPositionException{
			this.game = new Game();
	        this.game.init();	       	       
	        this.gameView = new GameView(this.game, this.canvas);	        
	        this.gameController = new GameController(this.game, this.gameView); 	        	        	           
	        this.gameView.setLblActionSelected(this.lblActionSelected);
	        this.gameView.setLblTurno(this.lblTurno);
	        this.gameView.setLblAlgoformerTitle(this.lblAlgoformerTitle);
	        this.gameView.setLblAlgoformerName(this.lblAlgoformerName);
	        this.gameView.setLblAlgoformerLife(this.lblAlgoformerLife);
	        this.gameView.setLblAlgoformerAttack(this.lblAlgoformerAttack);
	        this.gameView.setLblAlgoformerStrikingDistance(this.lblAlgoformerStrikingDistance);
	        this.gameView.setLblAlgoformerSpeed(this.lblAlgoformerSpeed);
	        this.gameView.setLblAlgoformerPosition(this.lblAlgoformerPosition);
	        this.gameView.updateTurn();			
		}
		
		private void registerEvents(){
			this.gameController.registerClickEvents(this.canvas);	   
	        MoveButtonHandler moveButtonHandler = new MoveButtonHandler(this.gameView, this.game, this.gameController);
	        this.moveButton.setOnAction(moveButtonHandler);
	        NextTurnButtonHandler nextTurnButtonHandler = new NextTurnButtonHandler(this.gameView, this.game,this.gameController);
	        this.nextTurnButton.setOnAction(nextTurnButtonHandler);
	        TransformButtonHandler transformButtonHandler = new TransformButtonHandler(this.gameView, this.game, this.gameController);
	        this.transformButton.setOnAction(transformButtonHandler);
	        AttackButtonHandler attackButtonHandler = new AttackButtonHandler(this.gameView, this.game, this.gameController);
	        this.attackButton.setOnAction(attackButtonHandler);
		}
		
	    @Override
	    public void start(final Stage stage) throws Exception {
	    	this.createControls();
	    	this.initilizeLayout(stage);
	    	this.initializeMVC();	        	        	      
	    	this.registerEvents();	        	        	        
	    }
}