package fiuba.algo3.algoformers;



import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Content;
import fiuba.algo3.algoformers.board.Nothing;
import fiuba.algo3.algoformers.board.Position;

public class Algoformer implements Content{
	private String name;
	
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
		return name;
	}

	public String getDescripcion() {
		return "Optimus Humanoide";
	}

	@Override
	public void moveEast(Position inicialPosition, Board board) {
		Position finalPosition = this.activeMode.moveEast(inicialPosition ,board);
		board.putContent(inicialPosition, new Nothing());
		board.putContent(finalPosition, this);
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




}