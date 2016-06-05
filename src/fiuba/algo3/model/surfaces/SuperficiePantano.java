package fiuba.algo3.model.surfaces;

import fiuba.algo3.model.surfaces.Surface;

public class SuperficiePantano implements Surface {

	@Override
	public boolean puedeSerCruzadaPorModoHumanoide() {
		return false;
	}

	@Override
	public boolean puedeSerCruzadaPorModoAlternoTerrestre() {
		return true;
	}

	@Override
	public boolean puedeSerCruzadaPorModoAlternoAereo() {
		return true;
	}

}
