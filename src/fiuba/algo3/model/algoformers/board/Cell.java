package fiuba.algo3.model.algoformers.board;

import fiuba.algo3.model.surfaces.SuperficieRocosa;
import fiuba.algo3.model.surfaces.Surface;

public class Cell{
	private Position position;
	private Surface surface;
	private Content content;

	public Cell(Position position, Surface surface){
		this.position = position;
		this.content = new Nothing(position);
		this.surface = surface;
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

	public void removeContent(){
		this.content = new Nothing(position);
	}
	

	public void putContent(Content content) {
		this.content = content;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((surface == null) ? 0 : surface.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (surface == null) {
			if (other.surface != null)
				return false;
		} else if (!surface.equals(other.surface))
			return false;
		return true;
	}

	

}
