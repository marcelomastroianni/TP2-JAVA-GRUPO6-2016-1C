package fiuba.algo3.model.algoformers;

import java.util.ArrayList;

import fiuba.algo3.model.algoformers.board.Cell;

public class Mode {

	protected Integer attack;
	protected Integer strikingDistance;
	protected Integer speed;


	public Mode(Integer attack, Integer strikingDistance, Integer speed) {
		this.attack = attack;
		this.strikingDistance = strikingDistance;
		this.speed = speed;

	}

	public void cross(ArrayList<Cell> steps) {
		// TODO Auto-generated method stub

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

	

}
