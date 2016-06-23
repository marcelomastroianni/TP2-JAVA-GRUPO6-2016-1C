package fiuba.algo3.view;


import fiuba.algo3.controller.AplicacionOnExitPressEventHandler;
import fiuba.algo3.controller.EnterButtonEventHandler;
import fiuba.algo3.controller.EnterPressEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ChoseTeamContainer extends VBox{


	@SuppressWarnings("static-access")
	public ChoseTeamContainer(AlgoformerApp app){
		  	super();

	        this.setStyle("-fx-background: #000000;");
	        this.setAlignment(Pos.CENTER);

	        Label title = new Label();
	        title.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
	        title.setText("Bienvenidos a Algoformer Game");
	        title.setTextFill(Color.web("#66A7C5"));

	        //Team 1

	        Label autobots = new Label();
	        autobots.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
	        autobots.setText("AUTOBOTS");
	        autobots.setTextFill(Color.web("#BA0707"));

	    	Image imagenAutobots = new Image("file:src/fiuba/algo3/vista/pictures/autobots.jpg");
	    	ImageView imageviewTeam1 = new ImageView();
	    	imageviewTeam1.setImage(imagenAutobots);

	        TextField textFieldName1 = new TextField();
	        textFieldName1.setPromptText("ingrese el nombre del primer jugador");
	        textFieldName1.setPrefWidth(300);

	        VBox team1 = new VBox(3);
	        team1.setAlignment(Pos.CENTER);
	        team1.getChildren().addAll(autobots, imageviewTeam1, textFieldName1);

	        //Team 2

	        Label decepticons = new Label();
	        decepticons.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
	        decepticons.setText("DECEPTICONS");
	        decepticons.setTextFill(Color.web("#870FA8"));

	        Image imagenDecepticons = new Image("file:src/fiuba/algo3/vista/pictures/decepticons.jpg");
	    	ImageView imageviewTeam2 = new ImageView();
	    	imageviewTeam2.setImage(imagenDecepticons);

	        TextField textFieldName2 = new TextField();
	        textFieldName2.setPromptText("ingrese el nombre del segundo jugador");
	        textFieldName2.setPrefWidth(300);

	        VBox team2 = new VBox(3);
	        team2.setAlignment(Pos.CENTER);
	        team2.getChildren().addAll(decepticons, imageviewTeam2, textFieldName2);

	        HBox hbox = new HBox(2);
	        hbox.setAlignment(Pos.CENTER);
		    hbox.getChildren().addAll(team1, team2);
		    hbox.setMargin(team2,  new Insets(0,0,0,100));

		    Button enterButton = new Button();
		    String css = this.getClass().getResource("DarckTheme.css").toExternalForm();
		    enterButton.getStylesheets().add(css);
		    enterButton.setText("Jugar");

	        EnterButtonEventHandler enterButtonEventHandler = new EnterButtonEventHandler(textFieldName1, textFieldName2, app);
	        enterButton.setOnAction(enterButtonEventHandler);

	        EnterPressEventHandler EnterPressEventHandler = new EnterPressEventHandler(textFieldName1, textFieldName2, app);
	        this.setOnKeyPressed( EnterPressEventHandler );

	        this.getChildren().addAll(title,hbox, enterButton);
	        this.setMargin(hbox, new Insets(50,50,50,50));
	  }
}
