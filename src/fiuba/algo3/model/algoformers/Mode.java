package fiuba.algo3.model.algoformers;

import java.util.ArrayList;

import fiuba.algo3.model.algoformers.board.Cell;
import fiuba.algo3.model.algoformers.board.ChispaSuprema;
import fiuba.algo3.model.algoformers.game.Player;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.surfaces.Surface;

public abstract class Mode {

	protected Integer attack;
	protected Integer strikingDistance;
	protected Integer speed;
	protected String imagePath;

	public Mode(Integer attack, Integer strikingDistance, Integer speed) {
		this.attack = attack;
		this.strikingDistance = strikingDistance;
		this.speed = speed;
		this.imagePath = imagePath;
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

	public abstract boolean canCrossSurface(Surface surface);

	public abstract void crossSurface(Surface surface,Algoformer algoformer);

	public abstract void collideWithChispaSuprema(Algoformer algoformer) throws InvalidPositionException;
}
