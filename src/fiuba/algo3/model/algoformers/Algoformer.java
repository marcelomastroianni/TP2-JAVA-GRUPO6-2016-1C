package fiuba.algo3.model.algoformers;

import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.bonus.Bonus;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.InvalidStrikeException;
import fiuba.algo3.model.surfaces.Surface;

import java.util.ArrayList;
import java.util.List;

public class Algoformer implements Content {
	private String name;
	private Position position;
	private Integer life;
	private Mode humanoidMode;
	private Mode alternalMode;
	private Mode activeMode;
	private Team team;
	private boolean trapped = false;
	private Integer turnsTrapped = 0;
	private boolean isDobleDamage = false;
	private Integer turnsDobleDamage = 0;
	private boolean isFlash = false;
	private Integer turnsFlash = 0;
	private Integer stepsMovedInTurn = 0;
	private boolean haveBeenUsedInTurn = false;
	private boolean isImmaculateBubble = false;
	private Integer turnsImmaculateBubble = 0;
	private Player player;

	public enum Team {
		AUTOBOTS, DECEPTICONS;
	}

	public Algoformer(String name, Mode humanoidMode, Mode alternalMode,
			Integer life, Position position, Team team) {
		this.name = name;
		this.humanoidMode = humanoidMode;
		this.alternalMode = alternalMode;
		this.activeMode = this.humanoidMode;
		this.life = life;
		this.position = position;
		this.team = team;
	}

	public void setPlayer(Player player){
		this.player = player;
	}
	public Player getPlayer(){
		return this.player;
	}

	public String getNombre() {
		return this.name;
	}

	public Mode getActiveMode() {
		return activeMode;
	}

	public void downHealthPoints(Integer damage) {
		if (!this.isImmaculateBubble){
			this.life = this.life - damage;
		}
		if(this.life < 1){
			this.player.notifyDeadAlgoformer(this);

		}
	}

	public Mode getHumanoidMode() {
		return humanoidMode;
	}

	public Mode getAlternalMode() {
		return alternalMode;
	}

	public int getLife() {
		return life;
	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	public Team getTeam() {
		return team;
	}

	public void transform() {
		if(this.haveBeenUsedInTurn)
			throw new AlgoformerUsadoEsteTurnoException();
		if (!this.trapped) {
				this.changeMode();
				//board.getContent(this.position).collideWithAlgoformer(this);
		}
		this.haveBeenUsedInTurn = true;
	}

	private void changeMode() {
		this.activeMode = (this.activeMode.equals(this.humanoidMode)) ? this.alternalMode : this.humanoidMode;
	}

	public void reduceLifeFivePercent() {
		this.life = (int) (this.life * 0.95);
	}

	public void move(Position finalPosition, Board board) throws AlgoformerUsadoEsteTurnoException {
		if(this.haveBeenUsedInTurn)
			throw new AlgoformerUsadoEsteTurnoException();
		if (!this.trapped) {
			Position previous;
			Position next;
			Surface nextSurface;
			int speed = this.activeMode.getSpeed();
			if (isFlash){
				speed = speed *3;
			}
			while (position.hasNext(finalPosition)
					&& this.stepsMovedInTurn < speed) {
				this.stepsMovedInTurn++;
				previous = this.position;
				next = this.position.next(finalPosition);
				nextSurface = board.getSurface(next);
				if (this.activeMode.canCrossSurface(nextSurface)) {
					try {
						board.getContent(next).collideWithAlgoformer(this);
						this.position = next;
						board.clearContent(previous);
						board.add(this);
						this.activeMode.crossSurface(nextSurface, this);
						this.haveBeenUsedInTurn = true;
					} catch (InvalidPositionException ex) {
						//Coliciono con otro Algoformer
						break;
					}
				} else{
					break;
			}
			}
		}
	}

	public void reduceSpeedFiftyPercent(){
		this.stepsMovedInTurn++;
	}

	public void reduceAttackPowerFortyPercent(){
		this.activeMode.changeAttackPower(0.6);
	}

	public void shot(Algoformer algoformer) throws AlgoformerUsadoEsteTurnoException {
		if(this.haveBeenUsedInTurn)
			throw new AlgoformerUsadoEsteTurnoException();
		try {
			this.resolveShootingDistance(algoformer);
			this.checkTeamSide(algoformer);
			if (this.isDobleDamage) {
				algoformer.downHealthPoints((this.activeMode.getAttack() * 2));
			}else{
				algoformer.downHealthPoints(this.activeMode.getAttack());
			}
			this.haveBeenUsedInTurn = true;
		} catch (InvalidStrikeException e) {
			// System.err.print(e.getMessage());
		}
	}

	private void checkTeamSide(Algoformer algoformer)
			throws InvalidStrikeException {
		if (algoformer.getTeam().equals(this.team)) {
			throw new InvalidStrikeException();
		}

	}

	private void resolveShootingDistance(Algoformer algoformer)
			throws InvalidStrikeException {
		if (!this.position.inAttackDistance(algoformer.getPosition(),this.activeMode.getStrikingDistance())){
			throw new InvalidStrikeException();
		}
	}

	public void dobleDamage(Integer turns) {
		if (!isDobleDamage){
			this.turnsDobleDamage = turns + 1;
			this.isDobleDamage = true;
		}
	}

	public void haste(Integer turns) {
		if (!isFlash){
			this.turnsFlash = turns + 1;
			this.isFlash = true;
		}
	}

	public void protectWithImmaculateBubble(Integer turns) {
		this.turnsImmaculateBubble = turns;
		if (!this.isImmaculateBubble){
			this.isImmaculateBubble = true;
		}
	}

	public void trap(Integer turns) {
		this.trapped = true;
		this.turnsTrapped = turns + 1;// le sumo uno para que se libere en cero
	}

	public void notifyNextTurn() {
		if (trapped) {
			this.turnsTrapped -= 1;
			if (this.turnsTrapped.equals(new Integer(0))) {
				this.trapped = false;
			}
		}
		if (isDobleDamage) {
			this.turnsDobleDamage -= 1;
			if (this.turnsDobleDamage.equals(new Integer(0))) {
				this.isDobleDamage = false;
			}
		}
		if (isFlash) {
			this.turnsFlash -= 1;
			if (this.turnsFlash.equals(new Integer(0))) {
				this.isFlash = false;
			}
		}
		if (isImmaculateBubble) {
			this.turnsImmaculateBubble -= 1;
			if (this.turnsImmaculateBubble.equals(new Integer(0))) {
				this.isImmaculateBubble = false;

			}
		}
		this.stepsMovedInTurn = 0;
		this.haveBeenUsedInTurn = false;
	}

	@Override
	public void collideWithAlgoformer(Algoformer algoformer){
		throw new InvalidPositionException();
	}


	public void collideWithChiapaSuprema(ChispaSuprema chispaSuprema) {
		this.activeMode.collideWithChispaSuprema(chispaSuprema, player );

	}

}