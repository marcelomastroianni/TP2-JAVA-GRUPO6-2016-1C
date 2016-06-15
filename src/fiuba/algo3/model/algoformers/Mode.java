package fiuba.algo3.model.algoformers;

import java.util.ArrayList;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.surfaces.Surface;

public abstract class Mode {

	protected Integer attack;
	protected Integer strikingDistance;
	protected Integer speed;

	public Mode(Integer attack, Integer strikingDistance, Integer speed) {
		this.attack = attack;
		this.strikingDistance = strikingDistance;
		this.speed = speed;
	}
	
	public Integer getAttack(){
		return this.attack;
	}
	
	public Integer getStrikingDistance(){
		return this.strikingDistance;
	}
	
	public Integer getSpeed(){
		return speed;
	}
	
	public void changeAttackPower(Double porcentage) {
		this.attack =  (int) (this.attack *porcentage);
	}

	public void changeSpeed(Double porcentage){this.speed = (int) Math.round(this.speed *porcentage); }

	public abstract boolean canCrossSurface(Surface surface);
	
	public abstract void crossSurface(Surface surface,Algoformer algoformer);
}
