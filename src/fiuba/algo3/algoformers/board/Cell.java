package fiuba.algo3.algoformers.board;

public class Cell{
	private Position position;
	private Surface surface;
	private IContent content;

	public Cell(Position position){
		this.position = position;
		this.content = new Nothing();
	}

	public Position getPosition(){
		return position;
	}

	public IContent getContent() {
		return content;

	}

	public void putContent(IContent content) {
		this.content = content;

	}


}
