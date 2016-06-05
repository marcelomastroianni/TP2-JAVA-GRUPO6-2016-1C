package fiuba.algo3.model.surfaces;

public class SuperficieNube  implements Surface{

	@Override
	public boolean puedeSerCruzadaPorModoHumanoide() {
		return false;
	}

	@Override
	public boolean puedeSerCruzadaPorModoAlternoAereo() {
		return true;
	}

	@Override
	public boolean puedeSerCruzadaPorModoAlternoTerrestre() {
		return false;
	}

}
