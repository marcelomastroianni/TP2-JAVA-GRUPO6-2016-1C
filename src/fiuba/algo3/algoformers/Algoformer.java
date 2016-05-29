package fiuba.algo3.algoformers;



import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.Content;
import fiuba.algo3.algoformers.board.Nothing;
import fiuba.algo3.algoformers.board.Position;

public class Algoformer implements Content{
	private String name;
	private Mode mode;


	public Algoformer(String name, Mode humanoidMode) {
		this.name = name;
		this.mode = humanoidMode; // porque siempre se empieza de forma humanoide
	}

	public String getNombre() {
		return name;
	}

	public String getDescripcion() {
		return "Optimus Humanoide";
	}

	@Override
	public void moveEast(Position inicialPosition, Board board) {
		Position finalPosition = mode.moveEast(inicialPosition ,board);
		board.putContent(inicialPosition, new Nothing());
		board.putContent(finalPosition, this);
	}




}