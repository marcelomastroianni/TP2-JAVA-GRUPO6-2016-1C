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

	public Mode getActiveMode() {
		return activeMode;
	}


	public Mode getHumanoidMode() {
		return humanoidMode;
	}

	public Mode getAlternalMode() {
		return alternalMode;
	}

	public void transform() {
		if (this.activeMode.equals(this.humanoidMode))
			this.activeMode = this.alternalMode;
		else
			this.activeMode = this.humanoidMode;
	}

	@Override
	public void moveEast(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		this.position = this.activeMode.moveEast(this.position ,board);
		board.add(nothing);
		board.add(this);

	}

	@Override
	public void moveWest(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		this.position = this.activeMode.moveWest(this.position ,board);
		board.add(nothing);
		board.add(this);
	}

	@Override
	public void moveNorth(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		this.position = this.activeMode.moveNorth(this.position ,board);
		board.add(nothing);
		board.add(this);
	}

	@Override
	public void moveSouth(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		this.position = this.activeMode.moveSouth(this.position ,board);
		board.add(nothing);
		board.add(this);
	}

	@Override
	public void moveSouthEast(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		this.position = this.activeMode.moveSouthEast(this.position ,board);
		board.add(nothing);
		board.add(this);

	}

	@Override
	public void moveSouthWest(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		this.position = this.activeMode.moveSouthWest(this.position ,board);
		board.add(nothing);
		board.add(this);

	}

	@Override
	public void moveNorthWest(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		this.position = this.activeMode.moveNorthWest(this.position ,board);
		board.add(nothing);
		board.add(this);

	}

	@Override
	public void moveNorthEast(Board board) {
		Nothing nothing = new Nothing();
		nothing.setPosition(this.position);
		this.position = this.activeMode.moveNorthEast(this.position ,board);
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