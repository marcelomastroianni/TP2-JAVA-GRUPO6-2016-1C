package fiuba.algo3.model.surfaces;



public class SuperficieRocosa implements Surface {


	@Override
	public boolean puedeSerCruzadaPorModoHumanoide() {
		return true;
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
