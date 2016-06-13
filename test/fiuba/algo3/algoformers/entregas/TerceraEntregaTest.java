package fiuba.algo3.algoformers.entregas;

import fiuba.algo3.algoformers.bonus.BonusFlash;
import fiuba.algo3.algoformers.bonus.CanonBonus;
import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.algoformers.Bonus;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;
import org.junit.Assert;
import org.junit.Test;

public class TerceraEntregaTest {

	/**
	 * 1. Ubico un algoformer, ubico un bonus doble cañón,ubico otro algoformer
	 * enemigo, el algoformer captura el bonus y ataca al enemigo verificando
	 * que causa el doble de daño durante 10 turnos. 
	 * 		a. Repetir para el modo alterno.
	 */
	@Test
	public void test01() {
		Board board = new Board(5,5);
		Algoformer algoformer1 = AlgoFormerFactory.getFrenzy(new Position(2,0));
		Algoformer algoformer2 = AlgoFormerFactory.getOptimusPrime(new Position(2,4));
		
		Bonus dobleCanon = CanonBonus.createCanonBonus(new Position(2,1));

		board.add(algoformer1);
		board.add(algoformer2);
		board.add(dobleCanon);

		Assert.assertEquals("La vida de Optimus deberia ser 500", 500, algoformer2.getLife());
		algoformer1.shot(algoformer2);
		Assert.assertEquals("La vida de Optimus deberia ser 490", 490, algoformer2.getLife());
		Assert.assertEquals("La vida de Frenzy deberia ser 400", 400, algoformer1.getLife());
		algoformer1.shot(algoformer2);
		Assert.assertEquals("La vida de Frenzy deberia ser 400", 400, algoformer1.getLife());
	}

	/**
	 * 2. Ubico un algoformer, ubico un bonus burbuja, ubico un otro alfoformer
	 * enemigo, el algoformer captura el bonus, el otro algoformer ataca al
	 * primer algoformer, este no recibe daños, repetir hasta 2 turnos propios,
	 * continuar y verificar que en el 3ro sí reciba daño.
	 * 		a. Realizar el mismo test en modo alterno.
	 */
	@Test
	public void test02() {
	}

	/**
	 * 3. Ubico un algoformer, ubico un bonus flash, verifico que se mueve 3 veces 
	 * más rápido durante 3 turnos propios.
	 * 		a. Repetir en modo alterno
	 * 		b. Repetir en modo humanoide-alterno-humanoide
	 */
	@Test
	public void test03() {
	}

	/**
	 * 4. Test boundary cases (Si ya tiene un bonus de un tipo que no pueda agarrar 
	 * otro del mismo tipo, Atrapar 2 bonus distintos verifcar ambos comportamientos, 
	 * etc…)
	 */
	@Test
	public void test04() {

		Board board = new Board(20,20);
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(2,0));

		Bonus dobleCanon1 = CanonBonus.createCanonBonus(new Position(2,1));
		Bonus dobleCanon2 = CanonBonus.createCanonBonus(new Position(2,3));
		Bonus flash1 = BonusFlash.createBonusFlash(new Position(2,5));
		Bonus flash2 = BonusFlash.createBonusFlash(new Position(2,7));

		board.add(frenzy);
		board.add(dobleCanon1);
		board.add(dobleCanon2);
		board.add(flash1);
		board.add(flash2);

		Assert.assertEquals("El poder de ataquer de Frenzy deberia ser 10", new Integer(10), frenzy.getActiveMode().getAttack());
		frenzy.move(new Position(2,2),board);
		Assert.assertEquals("El poder de ataquer de Frenzy deberia ser 20", new Integer(20), frenzy.getActiveMode().getAttack());
		frenzy.move(new Position(2,4),board);
		Assert.assertEquals("El poder de ataquer de Frenzy deberia ser 20", new Integer(20), frenzy.getActiveMode().getAttack());
		Assert.assertEquals("La velocidad de Frenzy deberia ser 2",new Integer(2) ,frenzy.getActiveMode().getSpeed());
		frenzy.move(new Position(2,6),board);
		Assert.assertEquals("La velocidad de Frenzy deberia ser 6",new Integer(6) ,frenzy.getActiveMode().getSpeed());
		frenzy.move(new Position(2,12),board);
		Assert.assertEquals("La velocidad de Frenzy deberia ser 6",new Integer(6) ,frenzy.getActiveMode().getSpeed());
		Assert.assertEquals("El poder de ataquer de Frenzy deberia ser 20", new Integer(20), frenzy.getActiveMode().getAttack());
	}

}
