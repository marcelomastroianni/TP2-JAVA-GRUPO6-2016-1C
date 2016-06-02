package fiuba.algo3.model.algoformers.board;

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
	
	public Surface getSurface() {
		return surface;
	}

	public void setSurface(Surface surface) {
		this.surface = surface;
	}

	public void putContent(IContent content) {
		this.content = content;

	}


}
