package fiuba.algo3.model.algoformers.board;

import fiuba.algo3.algoformers.bonus.CanonBonus;
import fiuba.algo3.model.surfaces.SuperficieRocosa;
import fiuba.algo3.model.surfaces.Surface;

public class Cell{
	private Position position;
	private Surface surface;
	private Content algoformer;
	private Content bonus;

	public Cell(Position position, Surface surface){
		this.position = position;
		this.surface = surface;
		this.algoformer = new Nothing(position);
		this.bonus = new Nothing(position);
	}

	public Position getPosition(){
		return position;
	}

	public Content getAlgoformer() {
		return algoformer;

	}
	
	public Surface getSurface() {
		return surface;
	}
	public Content getBonus(){
		return bonus;
	}
	
	public void setSurface(Surface surface) {
		this.surface = surface;	
	}

	public void removeContent(){
		this.algoformer = new Nothing(position);
	}
	

	public void putAlgoformer(Content algoformer) {
		this.algoformer = algoformer;

	}
	
	public void putBonus(Content bonus) {
		this.bonus = bonus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((algoformer == null) ? 0 : algoformer.hashCode());
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
		if (algoformer == null) {
			if (other.algoformer != null)
				return false;
		} else if (!algoformer.equals(other.algoformer))
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
