package fiuba.algo3.model.algoformers;

import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;
import fiuba.algo3.model.algoformers.game.GameConstants;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.exceptions.AlgoformerAtrapadoEsteTurnoException;
import fiuba.algo3.model.exceptions.AlgoformerCombinandoseEsteTurnoException;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.ModoAlternoNoPuedeCapturarChispaSupremaException;
import fiuba.algo3.model.exceptions.MuyLejosParaAtacarException;
import fiuba.algo3.model.exceptions.MuyLejosParaCombinarException;
import fiuba.algo3.model.exceptions.NoPuedeMoverseDondeEstaOtroAlgoformerException;
import fiuba.algo3.model.exceptions.NoSePuedeAtacarAlgoformerDelMismoEquipoException;
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
	private boolean isCombining;

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

		this.hasCrossPsionicStorm = false;
		this.haveBeenUsedInTurn = false;
		this.isImmaculateBubble = false;
		this.isFlash = false;
		this.isDobleDamage = false;
		this.isTrapped = false;
		this.isCombining = false;

		this.turnsTrapped = 0;
		this.turnsDobleDamage = 0;
		this.turnsFlash = 0;
		this.turnsCombined = 0;
		this.stepsMovedInTurn = 0;
		this.turnsImmaculateBubble = 0;
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

	public void downHealthPoints(Integer damage, Board board) throws InvalidPositionException {
		if (!this.isImmaculateBubble){
			this.life = this.life - damage;
		}
		if(this.life < 1){
			board.clearContent(this.getPosition());
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


	public void transform() throws AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException {
		if(this.haveBeenUsedInTurn)
			throw new AlgoformerUsadoEsteTurnoException();
		if (this.isTrapped)
			throw new AlgoformerAtrapadoEsteTurnoException();
		if (this.isCombining)
			throw new AlgoformerCombinandoseEsteTurnoException();
		this.changeMode();
		this.haveBeenUsedInTurn = true;
	}

	private void changeMode() {
		this.activeMode = (this.activeMode.equals(this.humanoidMode)) ? this.alternalMode : this.humanoidMode;
	}

	public void reduceLifeFivePercent() {
		this.life = (int) (this.life * GameConstants.SURFACE_THORN_LIFE_FACTOR);
	}

	public void move(Position finalPosition, Board board) throws AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException, InvalidPositionException {
		if(this.haveBeenUsedInTurn)
			throw new AlgoformerUsadoEsteTurnoException();
		if (this.isTrapped)
			throw new AlgoformerAtrapadoEsteTurnoException();
		if (this.isCombining)
			throw new AlgoformerCombinandoseEsteTurnoException();
		Position previous;
		Position next;
		Surface nextSurface;
		int speed = this.getSpeed();
		while (position.hasNext(finalPosition)
				&& this.stepsMovedInTurn < speed
				&& (!this.isTrapped)) {
			previous = this.position;
			next = this.position.next(finalPosition);
			nextSurface = board.getSurface(next);
			if (this.activeMode.canCrossSurface(nextSurface)) {				
				board.getContent(next).collideWithAlgoformer(this);
				this.stepsMovedInTurn++;
				this.position = next;
				board.clearContent(previous);
				board.add(this);
				this.activeMode.crossSurface(nextSurface, this);
				this.haveBeenUsedInTurn = true;				
			} else{
				break;
			}
		}
	}

	public void reduceSpeedFiftyPercent(){
		this.stepsMovedInTurn++;
	}

	public void reduceAttackPowerFortyPercent(){
		this.hasCrossPsionicStorm = true;
	}

	public void shot(Algoformer algoformer, Board board) throws AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, InvalidPositionException,NoSePuedeAtacarAlgoformerDelMismoEquipoException, MuyLejosParaAtacarException {
		if(this.haveBeenUsedInTurn)
			throw new AlgoformerUsadoEsteTurnoException();
		if (this.isTrapped)
			throw new AlgoformerAtrapadoEsteTurnoException();
		if (this.isCombining)
			throw new AlgoformerCombinandoseEsteTurnoException();
		
		this.resolveShootingDistance(algoformer);
		this.checkTeamSide(algoformer);
		algoformer.downHealthPoints(this.getAttack(),board);
		this.haveBeenUsedInTurn = true;		
	}

	private void checkTeamSide(Algoformer algoformer)
			throws NoSePuedeAtacarAlgoformerDelMismoEquipoException {
		if (algoformer.getTeam().equals(this.team)) {
			throw new NoSePuedeAtacarAlgoformerDelMismoEquipoException();
		}

	}

	private void resolveShootingDistance(Algoformer algoformer)
			throws MuyLejosParaAtacarException {
		if (!this.position.isInDistance(algoformer.getPosition(),this.getStrikingDistance())){
			throw new MuyLejosParaAtacarException();
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
		this.turnsImmaculateBubble = turns  + 1;
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
		if (isCombining) {
			this.turnsCombined-= 1;
			if (this.turnsCombined.equals(new Integer(0))) {
				this.isCombining = false;
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
	public void collideWithAlgoformer(Content algoformer) throws NoPuedeMoverseDondeEstaOtroAlgoformerException{
		throw new NoPuedeMoverseDondeEstaOtroAlgoformerException();
	}

	public void collideWithChiapaSuprema() throws ModoAlternoNoPuedeCapturarChispaSupremaException {
		this.activeMode.collideWithChispaSuprema(this);
	}

	public void notifyCathChispaSuprema() {
		this.player.notifyAlgoformerCathChispaSuprema();
	}

	public int getAttack(){
		int attack = this.activeMode.getAttack();
		if (this.isDobleDamage) {
			attack = (attack * GameConstants.BONUS_DOBLE_CANNON_ATACK_FACTOR);
		}
		if (this.hasCrossPsionicStorm && this.activeMode.equals(this.alternalMode)){
			attack =  (int) (attack * GameConstants.SURFACE_PSIONIC_STORM_ATACK_FACTOR);
		}
		return attack;
	}

	public int getSpeed(){
		if (this.isFlash){
			return (this.activeMode.getSpeed() * GameConstants.BONUS_FLASH_SPEED_FACTOR);
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


	@SuppressWarnings("static-access")
	public Algoformer getMergedAlgoformer( Board board, Algoformer algoformer1, Algoformer algoformer2) throws MuyLejosParaCombinarException, InvalidPositionException {
			if(this.canMerge(algoformer2.getPosition(), algoformer1.getPosition())){
				board.clearContent(algoformer1.getPosition());
				board.clearContent(algoformer2.getPosition());
				board.clearContent(this.position);
				Integer life = this.life + algoformer1.getLife() + algoformer2.getLife();
				if(this.team.equals(team.AUTOBOTS)){
					Algoformer algoformerCombinado = AlgoFormerFactory.getSuperion(this.position, life);
					board.add(algoformerCombinado);
					return algoformerCombinado;
				}
				Algoformer algoformerCombinado = AlgoFormerFactory.getMenasor(this.position, life);
				board.add(algoformerCombinado);
				return algoformerCombinado;
			}
			throw new MuyLejosParaCombinarException();
	}

	public boolean canMerge( Position position2, Position position3){
		return(((this.position.isInDistance(position2, GameConstants.ALGOFORMER_COMBINING_DISTANCE) && this.position.isInDistance(position3, GameConstants.ALGOFORMER_COMBINING_DISTANCE)) 
			||((this.position.isInDistance(position2, GameConstants.ALGOFORMER_COMBINING_DISTANCE) && position2.isInDistance(position3, GameConstants.ALGOFORMER_COMBINING_DISTANCE)) 
			||(this.position.isInDistance(position3, GameConstants.ALGOFORMER_COMBINING_DISTANCE) && position3.isInDistance(position2, GameConstants.ALGOFORMER_COMBINING_DISTANCE)))));
	}


	public void setCombinado() {
		this.isCombining = true;
		this.turnsCombined = GameConstants.ALGOFORMER_COMBINING_TURNS;
	}


	public boolean isCombining() {
		return this.isCombining;
	}

	public int getTurnsCombining() {
		return this.turnsCombined;
	}

}