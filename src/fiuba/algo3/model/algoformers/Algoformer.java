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

	public Algoformer(String name, Mode humanoidMode,Mode alternalMode,Integer life,Position position) {
		this.name = name;
		this.humanoidMode = humanoidMode;
		this.alternalMode = alternalMode;
		this.activeMode = this.humanoidMode;
		this.life = life;
		this.position = position;
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
		Nothing nothing = new Nothing(this.position);
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

	/*
	@Override
	public void setPosition(Position position) {
		this.position = position;

	}
	*/

	@Override
	public Position getPosition() {
		return this.position;
	}

}