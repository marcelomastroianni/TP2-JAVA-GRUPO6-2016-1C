package fiuba.algo3.algoformers.board;

import fiuba.algo3.model.algoformers.board.Surface;

public class SuperficieRocosa implements Surface {


	public boolean puedeSerCruzadaPorModoHumanoide() {
		return true;
	}


	public boolean puedeSerCruzadaPorModoAlternoTerrestre() {
		return true;
	}


	public boolean puedeSerCruzadaPorModoAlternoAereo() {
		return true;
	}

}
