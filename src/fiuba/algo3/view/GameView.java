package fiuba.algo3.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import fiuba.algo3.controller.GameController.Action;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Game;
import fiuba.algo3.model.algoformers.game.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class GameView  {

	private Canvas canvas;
	private Game game;
	private Map<Position,CellView> listaCellViews = new HashMap<>();

	Label lblActionSelected;
	Label lblTurno;
	Label lblAlgoformerTitle;
	Label lblAlgoformerLife;
	Label lblAlgoformerName;
	Canvas algoformerSelectedCanvas;
	GraphicsContext gc;
	Label lblAlgoformerAttack;
	Label lblAlgoformerStrikingDistance;
	Label lblAlgoformerSpeed;
	Label lblAlgoformerPosition;
	Label lblAlgoformerStateTrapped;
	Label lblAlgoformerStateCombining;
	Label lblAlgoformerBonusTitle;
	Label lblAlgoformerBonusDobleCannon;
	Label lblAlgoformerBonusFlash;
	Label lblAlgoformerBonusInmaculateBubble;
	Label lblException;

	public GameView(Game game,Canvas canvas) {
	        this.game = game;
	        this.canvas = canvas;
	        this.update();
	}

	public void setLblActionSelected(Label lblActionSelected ){
		this.lblActionSelected = lblActionSelected;
	}

	public void updateAction(Action action){
		if (action == Action.SIN_ACCION)
			this.lblActionSelected.setText("");
		if (action == Action.ATACAR)
			this.lblActionSelected.setText("Atacar");
		if (action == Action.MOVERSE)
			this.lblActionSelected.setText("Mover");
		if (action == Action.TRANSFORMARSE)
			this.lblActionSelected.setText("Transformar");
		if (action == Action.COMBINAR)
			this.lblActionSelected.setText("Combinar");
	}

	public void updateTurn(){
		this.lblTurno.setText(this.game.getActivePlayer().getName());
	}

	public void updateAlgoformerSelected(Algoformer algoformer){
		if (algoformer!=null){
			this.lblAlgoformerTitle.setText("Algoformer Seleccionado:");
			this.lblAlgoformerName.setText("Name: " + algoformer.getNombre());

			Image algoformerSelected = ImageFactory.drawAlgoformer(algoformer);
			this.gc.clearRect(0, 0, 100, 100);
			this.gc.drawImage(algoformerSelected, 0, 0,90,90);

			this.lblAlgoformerLife.setText("Life: " + Integer.toString(algoformer.getLife()));
			this.lblAlgoformerAttack.setText("Attack: " + Integer.toString(algoformer.getAttack()));
			this.lblAlgoformerStrikingDistance.setText("Striking Distance: " + Integer.toString(algoformer.getStrikingDistance()));
			this.lblAlgoformerSpeed.setText("Speed: " + Integer.toString(algoformer.getSpeed()));
			this.lblAlgoformerPosition.setText("Position: " + algoformer.getPosition().toString());

			if (algoformer.isTrapped()){
				this.lblAlgoformerStateTrapped.setText("Trapped (" + Integer.toString(algoformer.getTurnsTrapped()) + " turns left)." );
			}else{
				this.lblAlgoformerStateTrapped.setText("");
			}

			if (algoformer.isCombining()){
				this.lblAlgoformerStateCombining.setText("Combining (" + Integer.toString(algoformer.getTurnsCombining()) + " turns left)." );
			}else{
				this.lblAlgoformerStateCombining.setText("");
			}

			if (algoformer.isBonus()){
				this.lblAlgoformerBonusTitle.setText("Bonus:");
			}else{
				this.lblAlgoformerBonusTitle.setText("");
			}

			if (algoformer.isDobleDamage()){
				this.lblAlgoformerBonusDobleCannon.setText("Doble Cannon (" + Integer.toString(algoformer.getTurnsDobleDamage()) + " turns left)." );
			}else{
				this.lblAlgoformerBonusDobleCannon.setText("");
			}

			if (algoformer.isFlash()){
				this.lblAlgoformerBonusFlash.setText("Flash (" + Integer.toString(algoformer.getTurnsFlash()) + " turns left)." );
			}else{
				this.lblAlgoformerBonusFlash.setText("");
			}

			if (algoformer.isImmaculateBubble()){
				this.lblAlgoformerBonusInmaculateBubble.setText("Immaculate Bubble (" + Integer.toString(algoformer.getTurnsImmaculateBubble()) + " turns left)." );
			}else{
				this.lblAlgoformerBonusInmaculateBubble.setText("");
			}

		}else{
			this.clearAlgoformerSelected();
		}
	}

	public void clearAlgoformerSelected(){
		this.lblAlgoformerTitle.setText("Algoformer Seleccionado:");
		this.gc.clearRect(0, 0, 100, 100);
		this.lblAlgoformerName.setText("");
		this.lblAlgoformerLife.setText("");
		this.lblAlgoformerAttack.setText("");
		this.lblAlgoformerStrikingDistance.setText("");
		this.lblAlgoformerSpeed.setText("");
		this.lblAlgoformerPosition.setText("");
		this.lblAlgoformerStateTrapped.setText("");
		this.lblAlgoformerStateCombining.setText("");
		this.lblAlgoformerBonusTitle.setText("");
		this.lblAlgoformerBonusDobleCannon.setText("");
		this.lblAlgoformerBonusFlash.setText("");
		this.lblAlgoformerBonusInmaculateBubble.setText("");
	}

    public void update(){
    	  this.drawCells();
    }

    public void toggleSelectCell(Position position){
    	listaCellViews.get(position).toggleSelect();
		listaCellViews.get(position).update();
    }

    private void drawCells(){
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	Iterator entries = this.game.getBoard().getCells().entrySet().iterator();
    	while (entries.hasNext()) {
    	  Entry thisEntry = (Entry) entries.next();
    	  Position position = (Position) thisEntry.getKey();
    	  Cell cell = (Cell) thisEntry.getValue();
    	  CellView cellView = new CellView(cell,canvas);
    	  cellView.update();
    	  listaCellViews.put(position, cellView);
    	}
    }

	public void setLblTurno(Label lblTurno) {
		this.lblTurno = lblTurno;
	}

	public void setLblAlgoformerLife(Label lblAlgoformerLife) {
		this.lblAlgoformerLife = lblAlgoformerLife;
	}

	public void setLblAlgoformerName(Label lblAlgoformerName) {
		this.lblAlgoformerName = lblAlgoformerName;
	}

	public void setLblAlgoformerTitle(Label lblAlgoformerTitle) {
		this.lblAlgoformerTitle = lblAlgoformerTitle;
	}

	public void setAlgoformerPic(Canvas algoformerSelectedCanvas){
		this.algoformerSelectedCanvas = algoformerSelectedCanvas;
		this.gc = this.algoformerSelectedCanvas.getGraphicsContext2D();
	}
	public void setLblAlgoformerAttack(Label lblAlgoformerAttack) {
		this.lblAlgoformerAttack = lblAlgoformerAttack;
	}

	public void setLblAlgoformerStrikingDistance(Label lblAlgoformerStrikingDistance) {
		this.lblAlgoformerStrikingDistance = lblAlgoformerStrikingDistance;
	}

	public void setLblAlgoformerSpeed(Label lblAlgoformerSpeed) {
		this.lblAlgoformerSpeed = lblAlgoformerSpeed;
	}

	public void setLblAlgoformerPosition(Label lblAlgoformerPosition) {
		this.lblAlgoformerPosition = lblAlgoformerPosition;
	}

	public void setLblAlgoformerStateTrapped(Label lblAlgoformerStateTrapped) {
		this.lblAlgoformerStateTrapped = lblAlgoformerStateTrapped;
	}

	public void setLblAlgoformerBonusTitle(Label lblAlgoformerBonusTitle) {
		this.lblAlgoformerBonusTitle = lblAlgoformerBonusTitle;
	}

	public void setLblAlgoformerBonusDobleCannon(Label lblAlgoformerBonusDobleCannon) {
		this.lblAlgoformerBonusDobleCannon = lblAlgoformerBonusDobleCannon;
	}

	public void setLblAlgoformerBonusFlash(Label lblAlgoformerBonusFlash) {
		this.lblAlgoformerBonusFlash = lblAlgoformerBonusFlash;
	}

	public void setLblAlgoformerBonusInmaculateBubble(Label lblAlgoformerBonusInmaculateBubble) {
		this.lblAlgoformerBonusInmaculateBubble = lblAlgoformerBonusInmaculateBubble;
	}
	public void setExceptionMessage(Label lblException) {
		this.lblException = lblException;

	}

	public void showGameFinish(Player winner){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("El juego ha terminado");
		alert.setHeaderText("Felicitaciones " + winner.getName() + " has ganado!!!");
		alert.setContentText("");
		alert.showAndWait();
	}

	public void setLblAlgoformerStateCombining(Label lblAlgoformerStateCombining) {
		this.lblAlgoformerStateCombining = lblAlgoformerStateCombining;
	}

	public void showMessage(String message){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("oups..");
		alert.setContentText(message);
		alert.show();
	}

}