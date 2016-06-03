package fiuba.algo3.algoformers.board;

public class Cell{
	private Position position;
	private Surface surface;
	private Content content;

	public Cell(Position position){
		this.position = position;
		this.content = new Nothing();
	}

	public Position getPosition(){
		return position;
	}

	public Content getContent() {
		return content;

	}

	public void putContent(Content content) {
		this.content = content;

	}


}
