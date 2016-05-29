package fiuba.algo3.algoformers;



import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.IContent;
import fiuba.algo3.algoformers.board.Nothing;
import fiuba.algo3.algoformers.board.Position;

public class Algoformer implements IContent{
	private String name;
	
	Position position;
	
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
	
	public Integer getLife() {
		return this.life;
	}


	public Mode getActiveMode() {
		return activeMode;
	}

	public void transform() {
		if (this.activeMode.equals(this.humanoidMode))
			this.activeMode = this.alternalMode;
		else
			this.activeMode = this.humanoidMode;
	}

	public Mode getHumanoidMode() {
		return humanoidMode;
	}

	public Mode getAlternalMode() {
		return alternalMode;
	}

	@Override
	public void moveRight(Board board) {		
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);		
		this.position = this.activeMode.moveRight(this.position ,board);						
		board.add(nothing);
		board.add(this);
		
	}

	@Override
	public void moveLeft(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);		
		this.position = this.activeMode.moveLeft(this.position ,board);							
		board.add(nothing);
		board.add(this);
	}

	@Override
	public void moveUp(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);		
		this.position = this.activeMode.moveUp(this.position ,board);						
		board.add(nothing);
		board.add(this);
	}

	@Override
	public void moveDown(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);		
		this.position = this.activeMode.moveDown(this.position ,board);						
		board.add(nothing);
		board.add(this);
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
		
	}

	@Override
	public Position getPosition() {
		return this.position;
	}



}