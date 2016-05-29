package fiuba.algo3.algoformers;



import fiuba.algo3.algoformers.board.Board;
import fiuba.algo3.algoformers.board.IContent;
import fiuba.algo3.algoformers.board.Nothing;
import fiuba.algo3.algoformers.board.Position;

public class Algoformer implements IContent{
	private String name;
	
	private Integer life;
	private IMode humanoidMode;
	private IMode alternalMode;
	private IMode activeMode;

	public Algoformer(String name, IMode humanoidMode,IMode alternalMode,Integer life) {
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


	public IMode getActiveMode() {
		return activeMode;
	}

	public void transform() {
		if (this.activeMode.equals(this.humanoidMode))
			this.activeMode = this.alternalMode;
		else
			this.activeMode = this.humanoidMode;
	}

	public IMode getHumanoidMode() {
		return humanoidMode;
	}

	public IMode getAlternalMode() {
		return alternalMode;
	}

	@Override
	public void moveRight(Position inicialPosition, Board board) {
		Position finalPosition = this.activeMode.moveEast(inicialPosition ,board);
		board.putContent(inicialPosition, new Nothing());
		board.putContent(finalPosition, this);
		
	}

	@Override
	public void moveLeft(Position inicialPosition, Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp(Position inicialPosition, Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown(Position inicialPosition, Board board) {
		// TODO Auto-generated method stub
		
	}




}