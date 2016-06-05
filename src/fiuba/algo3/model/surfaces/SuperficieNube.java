package fiuba.algo3.model.surfaces;

public class SuperficieNube  implements Surface{

	public boolean puedeSerCruzadaPorModoHumanoide() {
		return false;
	}

	public boolean puedeSerCruzadaPorModoAlternoAereo() {
		return true;
	}

	public boolean puedeSerCruzadaPorModoAlternoTerrestre() {
		return false;
	}

}
