package fiuba.algo3.view;

import fiuba.algo3.controller.AttackButtonHandler;
import fiuba.algo3.controller.GameController;
import fiuba.algo3.controller.MergeButtonHandler;
import fiuba.algo3.controller.MoveButtonHandler;
import fiuba.algo3.controller.NextTurnButtonHandler;
import fiuba.algo3.controller.TransformButtonHandler;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class GameContainer extends BorderPane {

	private AlgoformerMenuBar menuBar;

	private Canvas boardCanvas;
	private Group canvasContainer;
	private Button moveButton;
	private Button nextTurnButton;
	private Button transformButton;
	private Button mergeButton;
	private Button attackButton;
	private Label lblActionSelectedTitle;
	private Label lblActionSelected;
	private Label lblTurnoTitle;
	private Label lblTurno;
	private Label lblAlgoformerTitle;
	private Label lblAlgoformerName;
	private Canvas algoformerSelectedCanvas;
	private Label lblAlgoformerLife;
	private Label lblAlgoformerAttack;
	private Label lblAlgoformerStrikingDistance;
	private Label lblAlgoformerSpeed;
	private Label lblAlgoformerPosition;
	private Label lblException;

	private Label lblAlgoformerStateTrapped;
	private Label lblAlgoformerStateCombining;
	private Label lblAlgoformerBonusTitle;
	private Label lblAlgoformerBonusDobleCannon;
	private Label lblAlgoformerBonusFlash;
	private Label lblAlgoformerBonusInmaculateBubble;

	private Label lblBlankLine1;
	private Label lblBlankLine2;

	private Game game;
	private GameView gameView;
	private GameController gameController;

	public GameContainer(AlgoformerApp app,String namePlayer1,String namePlayer2) {
		this.setMenu(app.getStage());
		this.createControls();
		this.initilizeLayout();
		this.initializeMVC(app,namePlayer1,namePlayer2);
		this.registerEvents();
	}

	private void setMenu(Stage stage) {
	        this.menuBar = new AlgoformerMenuBar(stage);
	        this.setTop(menuBar);
	}
	public AlgoformerMenuBar getMenuBar(){
		return this.menuBar;
	}

	private void createControls() {
		this.boardCanvas = new Canvas(1400, 900);
		this.moveButton = new Button("Mover");
		this.nextTurnButton = new Button("Siguiente Turno");
		this.transformButton = new Button("Transformar");
		this.mergeButton = new Button("Combinar");
		this.attackButton = new Button("Atacar");
		this.lblActionSelectedTitle = new Label("Accion Seleccionada:");
		this.lblActionSelectedTitle.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 15;");
		this.lblActionSelected = new Label("");
		this.lblTurnoTitle = new Label("Turno Jugador:");
		this.lblTurnoTitle.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 15;");
		this.lblTurno = new Label("");
		this.lblBlankLine1 = new Label("");
		this.lblBlankLine2 = new Label("");
		this.lblAlgoformerTitle = new Label("Algoformer Seleccionado:");
		this.lblAlgoformerTitle.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 15;");
		this.lblAlgoformerName = new Label("");
		this.algoformerSelectedCanvas = new Canvas(100,100);
		this.lblAlgoformerLife = new Label("");
		this.lblAlgoformerAttack = new Label("");
		this.lblAlgoformerStrikingDistance = new Label("");
		this.lblAlgoformerSpeed = new Label("");
		this.lblAlgoformerPosition = new Label("");
		this.lblException = new Label("");
		this.lblAlgoformerStateTrapped = new Label("");
		this.lblAlgoformerStateCombining = new Label("");
		this.lblAlgoformerBonusTitle = new Label("");
		this.lblAlgoformerBonusDobleCannon = new Label("");
		this.lblAlgoformerBonusFlash = new Label("");
		this.lblAlgoformerBonusInmaculateBubble = new Label("");
	}

	private void initilizeLayout() {

		this.canvasContainer = new Group();
		this.canvasContainer.getChildren().add(boardCanvas);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setPrefSize(120, 120);
		scrollPane.setContent(canvasContainer);

		this.moveButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		this.transformButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		this.attackButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		this.mergeButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		this.nextTurnButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);


		TilePane actionButtonsBox = new TilePane(Orientation.VERTICAL);
		actionButtonsBox.setHgap(8.0);
		actionButtonsBox.setVgap(4.0);
		actionButtonsBox.setPadding(new Insets(15));
		actionButtonsBox.getChildren().addAll(this.moveButton,
												this.transformButton,
												this.attackButton,
												this.mergeButton,
												this.nextTurnButton);


		VBox actionBox = new VBox(this.lblActionSelectedTitle,
									this.lblActionSelected);
		actionBox.setStyle("-fx-padding: 10;"
				+"-fx-background-color:#1d1d1d;"
				+ "-fx-border-style: solid inside;"
				+ "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;"
				+ "-fx-border-radius: 5;"
				+ "-fx-border-color: white;");

		VBox turnBox = new VBox(this.lblTurnoTitle, this.lblTurno);
		turnBox.setStyle("-fx-padding: 10;"
		+"-fx-background-color:#1d1d1d;"
		+ "-fx-border-style: solid inside;"
		+ "-fx-border-width: 2;"
		+ "-fx-border-insets: 5;"
		+ "-fx-border-radius: 5;"
		+ "-fx-border-color: white;");

		VBox algoformerBox = new VBox(this.lblAlgoformerTitle,
										this.algoformerSelectedCanvas,
										this.lblAlgoformerName,
										this.lblAlgoformerLife,
										this.lblAlgoformerAttack,
										this.lblAlgoformerStrikingDistance,
										this.lblAlgoformerSpeed,
										this.lblAlgoformerPosition,
										this.lblAlgoformerStateTrapped,
										this.lblAlgoformerStateCombining,
										this.lblAlgoformerBonusTitle,
										this.lblAlgoformerBonusDobleCannon,
										this.lblAlgoformerBonusFlash,
										this.lblAlgoformerBonusInmaculateBubble,
										this.lblException);

		algoformerBox.setStyle("-fx-padding: 10;"
				+"-fx-background-color:#1d1d1d;"
				+ "-fx-border-style: solid inside;"
				+ "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;"
				+ "-fx-border-radius: 5;"
				+ "-fx-border-color: white;");

		VBox infoPanel = new VBox();
		infoPanel.getChildren().addAll(actionButtonsBox,actionBox,turnBox,algoformerBox);
		this.setLeft(infoPanel);
		this.setTop(this.menuBar);
		this.setCenter(scrollPane);
	}

	private void initializeMVC(AlgoformerApp app,String namePlayer1,String namePlayer2) {
		this.game = new Game();
		try {
			this.game.init(namePlayer1,namePlayer2);
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.gameView = new GameView(this.game, this.boardCanvas);
		this.gameController = new GameController(this.game, this.gameView,app);
		this.gameView.setLblActionSelected(this.lblActionSelected);
		this.gameView.setLblTurno(this.lblTurno);
		this.gameView.setLblAlgoformerTitle(this.lblAlgoformerTitle);
		this.gameView.setLblAlgoformerName(this.lblAlgoformerName);
		this.gameView.setAlgoformerPic(algoformerSelectedCanvas);
		this.gameView.setLblAlgoformerLife(this.lblAlgoformerLife);
		this.gameView.setLblAlgoformerAttack(this.lblAlgoformerAttack);
		this.gameView.setLblAlgoformerStrikingDistance(this.lblAlgoformerStrikingDistance);
		this.gameView.setLblAlgoformerSpeed(this.lblAlgoformerSpeed);
		this.gameView.setLblAlgoformerPosition(this.lblAlgoformerPosition);
		this.gameView.setLblAlgoformerBonusTitle(this.lblAlgoformerBonusTitle);
		this.gameView.setLblAlgoformerBonusFlash(this.lblAlgoformerBonusFlash);
		this.gameView.setLblAlgoformerBonusDobleCannon(this.lblAlgoformerBonusDobleCannon);
		this.gameView.setLblAlgoformerBonusInmaculateBubble(this.lblAlgoformerBonusInmaculateBubble);
		this.gameView.setLblAlgoformerStateTrapped(this.lblAlgoformerStateTrapped);
		this.gameView.setLblAlgoformerStateCombining(this.lblAlgoformerStateCombining);		
		this.gameView.updateTurn();
		this.gameView.setExceptionMessage(this.lblException);
	}

	private void registerEvents() {
		this.gameController.registerClickEvents(this.boardCanvas);
		MoveButtonHandler moveButtonHandler = new MoveButtonHandler(this.gameView, this.game, this.gameController);
		this.moveButton.setOnAction(moveButtonHandler);
		NextTurnButtonHandler nextTurnButtonHandler = new NextTurnButtonHandler(this.gameView, this.game, this.gameController);
		this.nextTurnButton.setOnAction(nextTurnButtonHandler);
		TransformButtonHandler transformButtonHandler = new TransformButtonHandler(this.gameView, this.game, this.gameController);
		this.transformButton.setOnAction(transformButtonHandler);
		AttackButtonHandler attackButtonHandler = new AttackButtonHandler(this.gameView, this.game, this.gameController);
		this.attackButton.setOnAction(attackButtonHandler);
		MergeButtonHandler mergeButtonHandler = new MergeButtonHandler(this.gameView, this.game, this.gameController);
		this.mergeButton.setOnAction(mergeButtonHandler);
	}




}
