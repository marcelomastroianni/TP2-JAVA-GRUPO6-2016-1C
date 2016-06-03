package fiuba.algo3.model.algoformers;



import fiuba.algo3.model.algoformers.board.*;
import fiuba.algo3.model.exceptions.CantCrossException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.InvalidStrikeException;

import java.util.ArrayList;

public class Algoformer implements Content{
	private String name;

	private Position position;

	private Integer life;
	private Mode humanoidMode;
	private Mode alternalMode;
	private Mode activeMode;

	public Algoformer(String name, Mode humanoidMode,Mode alternalMode,Integer life) {
		this.name = name;
		this.humanoidMode = humanoidMode;
		this.alternalMode = alternalMode;
		this.activeMode = this.humanoidMode;
		this.life = life;
	}


	public String getNombre() {
		return this.name;
	}

	public Mode getActiveMode() {
		return activeMode;
	}

	public void downHealthPoints(Integer damage ){
		this.life = this.life - damage;
	}

	public Mode getHumanoidMode() {
		return humanoidMode;
	}

	public Mode getAlternalMode() {
		return alternalMode;
	}

	public int getLife()  {
		return life;
	}

	public void transform() {
		if (this.activeMode.equals(this.humanoidMode))
			this.activeMode = this.alternalMode;
		else
			this.activeMode = this.humanoidMode;
	}
	
	public void move(Position finalPosition, Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		board.add(nothing);
		this.position = finalPosition;
		try{
			board.add(this);
		}catch(InvalidPositionException e){
			this.position = nothing.getPosition();
			board.add(this);
		}
	}

	public void shot(Algoformer algoformer){
		try {
			this.resolveDistance(algoformer);
			algoformer.downHealthPoints(this.activeMode.getAttack());
		} catch (InvalidStrikeException e) {
			//TODO Reservado para interaccion con la GUI
		}
	}

	private void resolveDistance(Algoformer algoformer) throws InvalidStrikeException {
		if( this.position.distance(algoformer.getPosition()) > this.activeMode.getStrikingDistance()){
			throw new InvalidStrikeException("You can't attack objectives that far.");
		}
		
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;

	}

	@Override
	public Position getPosition() {
		return this.position;
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
	
	

}