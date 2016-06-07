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
	public abstract boolean canCrossSurface(Surface surface);
	
	public abstract boolean reduceSpeedFiftyPercent(Surface surface);
	

	public Integer getAttack(){
		return this.attack;
	}
	
	public Integer getStrikingDistance(){
		return this.strikingDistance;
	}
	
	public Integer getSpeed(){
		return speed;
	}

	

}
