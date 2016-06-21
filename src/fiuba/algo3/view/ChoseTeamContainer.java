package fiuba.algo3.view;

import fiuba.algo3.controller.EnterButtonEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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

	        this.setAlignment(Pos.CENTER);
	        Image imagen = new Image("file:src/vista/imagenes/textura.png");
	        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	        this.setBackground(new Background(imagenDeFondo));

	        Button enterButton = new Button();
	       enterButton.setText("Jugar");

	        Label etiqueta = new Label();
	        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
	        etiqueta.setText("Bienvenidos a Algoformer Game");
	        etiqueta.setTextFill(Color.web("#66A7C5"));

	        EnterButtonEventHandler enterButtonEventHandler = new EnterButtonEventHandler(stage, nextScene);
	        enterButton.setOnAction(enterButtonEventHandler);

	        this.getChildren().addAll(etiqueta,enterButton);
		  
	  }
}
