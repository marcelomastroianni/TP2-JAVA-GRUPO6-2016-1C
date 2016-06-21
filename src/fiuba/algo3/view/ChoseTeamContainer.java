package fiuba.algo3.view;


import fiuba.algo3.controller.EnterButtonEventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ChoseTeamContainer extends VBox{

	  Stage stage;


	  public ChoseTeamContainer(Stage stage, Scene nextScene){
		  super();

	        this.stage = stage;

	        this.setStyle("-fx-background: #000000;");
	        this.setAlignment(Pos.CENTER);


	        Label title = new Label();
	        title.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
	        title.setText("Bienvenidos a Algoformer Game");
	        title.setTextFill(Color.web("#66A7C5"));


	        /////////////////////////////////////////////////////TEAM1

	    	Image imagenAutobots = new Image("file:src/fiuba/algo3/vista/pictures/autobots.jpg");
	    	ImageView imageviewTeam1 = new ImageView();
	    	imageviewTeam1.setImage(imagenAutobots);

	        Label namePlayer1 = new Label();
	        namePlayer1.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
	        namePlayer1.setText("Nombre:");
	        namePlayer1.setTextFill(Color.web("#66A7C5"));
	        TextField inputNamePlayer1 = new TextField();

	        HBox name1hbox = new HBox();
	        name1hbox.getChildren().addAll(namePlayer1, inputNamePlayer1);

	        VBox team1 = new VBox();
	        team1.getChildren().addAll(imageviewTeam1, name1hbox);


	        ///////////////////////////////////////////////////////TEAM2

	        Image imagenDecepticons = new Image("file:src/fiuba/algo3/vista/pictures/decepticons.jpg");
	    	ImageView imageviewTeam2 = new ImageView();
	    	imageviewTeam2.setImage(imagenDecepticons);

	        Label namePlayer2 = new Label();
	        namePlayer2.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
	        namePlayer2.setText("Nombre:");
	        namePlayer2.setTextFill(Color.web("#66A7C5"));
	        TextField inputNamePlayer2 = new TextField();

	        HBox name2hbox = new HBox();
	        name2hbox.getChildren().addAll(namePlayer2, inputNamePlayer2);

	        VBox team2 = new VBox();
	        team2.getChildren().addAll(imageviewTeam2, name2hbox);

	        HBox hbox = new HBox();
		    hbox.getChildren().addAll(team1, team2);



		    Button enterButton = new Button();
		    enterButton.setText("Jugar");

	        EnterButtonEventHandler enterButtonEventHandler = new EnterButtonEventHandler(stage,inputNamePlayer1, inputNamePlayer2, nextScene);
	        enterButton.setOnAction(enterButtonEventHandler);

	        this.getChildren().addAll(title,hbox, enterButton);

	  }
}
