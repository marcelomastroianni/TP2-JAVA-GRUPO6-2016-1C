package fiuba.algo3.model.algoformers.board;

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
	
	public Surface getSurface() {
		return surface;
	}

	public void setSurface(Surface surface) {
		this.surface = surface;
	}

	public void putContent(Content content) {
		this.content = content;

	}


}
