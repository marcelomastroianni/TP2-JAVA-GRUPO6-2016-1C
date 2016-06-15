package fiuba.algo3.model.algoformers;

import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Content;
import fiuba.algo3.model.algoformers.board.Position;
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
	private List<Bonus> bonusList = new ArrayList<>();
	private Team team;
	private boolean trapped = false;
	private Integer turnsTrapped = 0;
	private boolean isDobleDamage = false;
	private Integer turnsDobleDamage = 0;
	private boolean isFlash = false;
	private Integer turnsFlash = 0;

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

	public String getNombre() {
		return this.name;
	}

	public Mode getActiveMode() {
		return activeMode;
	}

	public void downHealthPoints(Integer damage) {
		this.life = this.life - damage;
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

	public boolean dobleDamage() {
		return isDobleDamage;
	}

	public boolean flash() {
		return isFlash;
	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	public Team getTeam() {
		return team;
	}

	public void transform() {
		if (!this.trapped) {
			if (!this.isDobleDamage && !this.isFlash)
				this.changeMode();
			else if (this.isDobleDamage && !this.isFlash) {
				this.activeMode.changeAttackPower(0.5);
				this.changeMode();
				this.activeMode.changeAttackPower(2.0);
			}
			if (this.isFlash && !this.isDobleDamage) {
				this.activeMode.changeSpeed(0.33);
				this.changeMode();
				this.activeMode.changeSpeed(3.0);
			}
		}
	}

	private void changeMode() {
		this.activeMode = (this.activeMode.equals(this.humanoidMode)) ? this.alternalMode : this.humanoidMode;
	}

	public void reduceLife() {
		this.life = (int) (this.life * 0.95);
	}

	public void move(Position finalPosition, Board board) {
		if (!this.trapped) {
			Position previous;
			Position next;
			Surface nextSurface;
			int steps = 0;
			while (position.hasNext(finalPosition)
					&& steps < this.activeMode.getSpeed()) {
				steps++;
				previous = this.position;
				next = this.position.next(finalPosition);
				nextSurface = board.getSurface(next);
				if (this.activeMode.canCrossSurface(nextSurface)) {
					try{
						board.getContent(next).collideWithAlgoformer(this);
						this.position = next;		
						board.clearContent(previous);
						board.add(this);
					}catch(InvalidPositionException ex){
						//Coliciono con otro Algoformer
						break;
					}
					if (this.activeMode.reduceSpeedFiftyPercent(nextSurface)) {
						steps++;
					}
					if (this.activeMode.reduceLifeFiftyPercent(nextSurface)) {
						this.reduceLife();
					}
					if (this.activeMode
							.reduceAttackPowerFortyPercent(nextSurface)) {
						this.activeMode.changeAttackPower(0.6);
					}
					if (nextSurface.traps()) {
						this.trap(3);
					}					
				}
			}
		}
	}

	public void shot(Algoformer algoformer) {
		try {
			this.resolveShootingDistance(algoformer);
			this.checkTeamSide(algoformer);
			algoformer.downHealthPoints(this.activeMode.getAttack());
		} catch (InvalidStrikeException e) {
			// System.err.print(e.getMessage());
		}
	}

	private void checkTeamSide(Algoformer algoformer)
			throws InvalidStrikeException {
		if (algoformer.getTeam().equals(this.team)) {
			throw new InvalidStrikeException("You can't attack a partner.");
		}

	}

	private void resolveShootingDistance(Algoformer algoformer)
			throws InvalidStrikeException {
		if (this.position.distance(algoformer.getPosition()) > this.activeMode
				.getStrikingDistance()) {
			throw new InvalidStrikeException(
					"You can't attack objectives that far.");
		}
	}

	public void dobleDamage(Integer turns) {
		if (!isDobleDamage){
			this.isDobleDamage = true;
			this.turnsDobleDamage = turns;
			this.activeMode.changeAttackPower(2.0);
		}
	}

	public void haste(Integer turns) {
		if (!isFlash){
			this.isFlash = true;
			this.turnsFlash = turns + 1;
			this.activeMode.changeSpeed(3.0);
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
				this.activeMode.changeAttackPower(0.5);
			}
		}
		if (isFlash) {
			this.turnsFlash -= 1;
			if (this.turnsFlash.equals(new Integer(0))) {
				this.isFlash = false;
				this.activeMode.changeSpeed(0.33);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activeMode == null) ? 0 : activeMode.hashCode());
		result = prime * result
				+ ((alternalMode == null) ? 0 : alternalMode.hashCode());
		result = prime * result
				+ ((humanoidMode == null) ? 0 : humanoidMode.hashCode());
		result = prime * result + ((life == null) ? 0 : life.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Algoformer other = (Algoformer) obj;
		if (activeMode == null) {
			if (other.activeMode != null)
				return false;
		} else if (!activeMode.equals(other.activeMode))
			return false;
		if (alternalMode == null) {
			if (other.alternalMode != null)
				return false;
		} else if (!alternalMode.equals(other.alternalMode))
			return false;
		if (humanoidMode == null) {
			if (other.humanoidMode != null)
				return false;
		} else if (!humanoidMode.equals(other.humanoidMode))
			return false;
		if (life == null) {
			if (other.life != null)
				return false;
		} else if (!life.equals(other.life))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@Override
	public void collideWithAlgoformer(Content algoformer) {
		throw new InvalidPositionException();
	}
}