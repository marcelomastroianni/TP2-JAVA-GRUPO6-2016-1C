package fiuba.algo3.model.algoformers.board;

import fiuba.algo3.model.surfaces.SurfaceRocky;
import fiuba.algo3.model.surfaces.Surface;

public class Cell{
	private Position position;
	private Surface surface;
	private Content content;

	public Cell(Position position, Surface surface){
		this.position = position;
		this.surface = surface;
		this.content = new Nothing(position);
	}

	public Position getPosition(){
		return position;
	}

	public Surface getSurface() {
		return surface;
	}
	public Content getContent(){
		return content;
	}
	
	public void setSurface(Surface surface) {
		this.surface = surface;	
	}

	public void removeContent(){
		this.content = new Nothing(position);
	}

	public void add(Content content) {
		this.content = content;
	}
}
