package fiuba.algo3.model.algoformers;

import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.exceptions.AlgoformerAtrapadoEsteTurnoException;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.InvalidStrikeException;
import fiuba.algo3.model.exceptions.MuyLejosException;
import fiuba.algo3.model.surfaces.Surface;

public class Algoformer implements Content {
	private String name;
	private Position position;
	private Integer life;
	private Mode humanoidMode;
	private Mode alternalMode;
	private Mode activeMode;
	private Team team;
	private Integer turnsTrapped;
	private Integer turnsDobleDamage;
	private Integer turnsFlash;
	private Integer turnsCombined;
	private Integer stepsMovedInTurn;
	private Integer turnsImmaculateBubble;
	private boolean hasCrossPsionicStorm;
	private boolean haveBeenUsedInTurn;
	private boolean isImmaculateBubble;
	private boolean isFlash;
	private boolean isDobleDamage;
	private boolean isTrapped;
	private boolean isCombined;

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

		hasCrossPsionicStorm = false;
		haveBeenUsedInTurn = false;
		isImmaculateBubble = false;
		isFlash = false;
		isDobleDamage = false;
		isTrapped = false;
		isCombined = false;

		turnsTrapped = 0;
		turnsDobleDamage = 0;
		turnsFlash = 0;
		turnsCombined = 0;
		stepsMovedInTurn = 0;
		turnsImmaculateBubble = 0;
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

	public boolean isHumanoidMode(){
		return this.activeMode.equals(this.humanoidMode);
	}

	public boolean isAlternalMode(){
		return this.activeMode.equals(this.alternalMode);
	}

	public void downHealthPoints(Integer damage, Board board) {
		if (!this.isImmaculateBubble){
			this.life = this.life - damage;
		}
		if(this.life < 1){
			try {
				board.clearContent(this.getPosition());
			} catch (InvalidPositionException e) {
				e.printStackTrace();
			}
			this.player.notifyDeadAlgoformer(this);
		}
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


	public void transform() throws AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {

		if(this.haveBeenUsedInTurn)
			throw new AlgoformerUsadoEsteTurnoException();
		if (!this.isTrapped) {
				this.changeMode();
		}else {
			throw new AlgoformerAtrapadoEsteTurnoException();
		}
		this.haveBeenUsedInTurn = true;
	}

	private void changeMode() {
		this.activeMode = (this.activeMode.equals(this.humanoidMode)) ? this.alternalMode : this.humanoidMode;
	}

	public void reduceLifeFivePercent() {
		this.life = (int) (this.life * 0.95);
	}

	public void move(Position finalPosition, Board board) throws AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException {
		if(this.haveBeenUsedInTurn)
			throw new AlgoformerUsadoEsteTurnoException();
		if (!this.isTrapped) {
			Position previous;
			Position next;
			Surface nextSurface;
			int speed = this.getSpeed();
			while (position.hasNext(finalPosition)
					&& this.stepsMovedInTurn < speed
					&& (!this.isTrapped)) {
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
		}else throw new AlgoformerAtrapadoEsteTurnoException();
	}

	public void reduceSpeedFiftyPercent(){
		this.stepsMovedInTurn++;
	}

	public void reduceAttackPowerFortyPercent(){
		this.hasCrossPsionicStorm = true;
	}

	public void shot(Algoformer algoformer, Board board) throws AlgoformerUsadoEsteTurnoException {
		if(this.haveBeenUsedInTurn)
			throw new AlgoformerUsadoEsteTurnoException();
		try {
			this.resolveShootingDistance(algoformer);
			this.checkTeamSide(algoformer);
			algoformer.downHealthPoints(this.getAttack(),board);
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
		if (!this.position.isInDistance(algoformer.getPosition(),this.getStrikingDistance())){
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
		this.isTrapped = true;
		this.turnsTrapped = turns + 1;// le sumo uno para que se libere en cero
	}

	public void notifyNextTurn() {
		if (isTrapped) {
			this.turnsTrapped -= 1;
			if (this.turnsTrapped.equals(new Integer(0))) {
				this.isTrapped = false;
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
		if (isCombined) {
			this.turnsCombined -= 1;
			if (this.turnsCombined.equals(new Integer(0))) {
				this.isCombined = false;
				if(this.team.equals(team.AUTOBOTS)){
					player.notifyDeadAlgoformer(this);
					player.addAlgoformer(AlgoFormerFactory.getOptimusPrime(this.position));
					player.addAlgoformer(AlgoFormerFactory.getBumblebee(this.position.next()));
					player.addAlgoformer(AlgoFormerFactory.getRatchet(this.position.next().next()));
				}else{
					player.notifyDeadAlgoformer(this);
					player.addAlgoformer(AlgoFormerFactory.getOptimusPrime(this.position));
					player.addAlgoformer(AlgoFormerFactory.getBumblebee(this.position.next()));
					player.addAlgoformer(AlgoFormerFactory.getRatchet(this.position.next().next()));


				}
			}
		}

		this.stepsMovedInTurn = 0;
		this.haveBeenUsedInTurn = false;
	}

	@Override
	public void collideWithAlgoformer(Content algoformer) throws InvalidPositionException{
		throw new InvalidPositionException();
	}

	public void collideWithChiapaSuprema() throws InvalidPositionException {
		this.activeMode.collideWithChispaSuprema(this);
	}

	public void notifyCathChispaSuprema() {
		this.player.notifyAlgoformerCathChispaSuprema();
	}

	public int getAttack(){
		int attack = this.activeMode.getAttack();
		if (this.isDobleDamage) {
			attack = (attack * 2);
		}
		if (this.hasCrossPsionicStorm && this.activeMode.equals(this.alternalMode)){
			attack =  (int) (attack * 0.6);
		}
		return attack;
	}

	public int getSpeed(){
		if (this.isFlash){
			return (this.activeMode.getSpeed() *3);
		}else{
			return this.activeMode.getSpeed();
		}
	}

	public int getStrikingDistance(){
		return this.activeMode.getStrikingDistance();
	}

	public boolean isTrapped(){
		return this.isTrapped;
	}

	public int getTurnsTrapped(){
		return this.turnsTrapped;
	}

	public boolean isDobleDamage(){
		return this.isDobleDamage;
	}

	public int getTurnsDobleDamage(){
		return this.turnsDobleDamage;
	}

	public boolean isFlash(){
		return this.isFlash;
	}

	public int getTurnsFlash(){
		return this.turnsFlash;
	}

	public boolean isImmaculateBubble(){
		return this.isImmaculateBubble;
	}

	public int getTurnsImmaculateBubble(){
		return this.turnsImmaculateBubble;
	}

	public boolean isBonus(){
		return (this.isFlash || this.isDobleDamage || this.isImmaculateBubble);
	}


	public Algoformer getMergedAlgoformer( Board board, Algoformer algoformer1, Algoformer algoformer2) throws MuyLejosException, InvalidPositionException {
			board.clearContent(algoformer1.getPosition());
			board.clearContent(algoformer2.getPosition());
			board.clearContent(this.position);
			if(this.team.equals(team.AUTOBOTS)){
				Algoformer algoformerCombinado = AlgoFormerFactory.getSuperion(this.position);
				board.add(algoformerCombinado);
				return algoformerCombinado;
			}
			Algoformer algoformerCombinado = AlgoFormerFactory.getMenasor(this.position);
			board.add(algoformerCombinado);
			return algoformerCombinado;
	}


	public void setCombinado() {
		this.isCombined = true;
		this.turnsCombined = 2;

	}


}