package fiuba.algo3.model.algoformers;

import java.util.ArrayList;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.surfaces.Surface;

public abstract class Mode {

	protected Integer attack;
	protected Integer strikingDistance;
	protected Integer speed;
	
	private boolean Trapped;
	private Integer turnsTrapped;


	public Mode(Integer attack, Integer strikingDistance, Integer speed) {
		this.attack = attack;
		this.strikingDistance = strikingDistance;
		this.speed = speed;
		this.Trapped = false;
		this.turnsTrapped = 0;

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
	
	public void reduceAttackPower(Double porcentage) {
		this.attack =  (int) (this.attack *porcentage);
	}
	
	public boolean isTrapped(){
		return this.Trapped;
	}
	
	public void trap(Integer turns) {
		this.Trapped = true;
		this.turnsTrapped = turns + 1;// le sumo uno para que se libere en cero
		
	}
	
	public void reduceTurnsTrapped(){
		if(!Trapped){
			return;
		}
		this.turnsTrapped -=1;
		if(turnsTrapped.equals(new Integer(0))){
			this.Trapped = false;
		}
	}

	

}
