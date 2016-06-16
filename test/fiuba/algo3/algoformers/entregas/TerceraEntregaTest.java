package fiuba.algo3.algoformers.entregas;

import fiuba.algo3.model.bonus.BonusFlash;
import fiuba.algo3.model.bonus.CanonBonus;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.algoformers.AlgoFormerFactory;
import fiuba.algo3.model.algoformers.Algoformer;
import fiuba.algo3.model.bonus.Bonus;
import fiuba.algo3.model.algoformers.board.Board;
import fiuba.algo3.model.algoformers.board.Position;
import org.junit.Assert;
import org.junit.Test;

public class TerceraEntregaTest {

	/**
	 * 1. Ubico un algoformer, ubico un bonus doble cañón,ubico otro algoformer
	 * enemigo, el algoformer captura el bonus y ataca al enemigo verificando
	 * que causa el doble de daño durante 10 turnos. a. Repetir para el modo
	 * alterno.
	 * @throws InvalidPositionException 
	 * @throws AlgoformerUsadoEsteTurnoException 
	 */
	@Test
	public void test01() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException {
		Board board = new Board(5, 5);
		Algoformer algoformer1 = AlgoFormerFactory
				.getFrenzy(new Position(2, 0));
		Algoformer algoformer2 = AlgoFormerFactory
				.getOptimusPrime(new Position(2, 4));

		Bonus dobleCanon1 = CanonBonus.createCanonBonus(new Position(2, 1));
		Bonus dobleCanon2 = CanonBonus.createCanonBonus(new Position(2, 2));

		board.add(algoformer1);
		board.add(algoformer2);
		board.add(dobleCanon1);
		board.add(dobleCanon2);
		

		algoformer1.move(new Position(2, 1), board);
		algoformer1.notifyNextTurn();

		// Prueba Algoformer en modo Humanoide
		// Primer Turno
		Assert.assertEquals("La vida de Optimus deberia ser 500", 500,
				algoformer2.getLife());
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Optimus deberia ser 480", 480,
				algoformer2.getLife());
		// Segundo Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Frenzy deberia ser 460", 460,
				algoformer2.getLife());
		// Tercer Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Optimus deberia ser 440", 440,
				algoformer2.getLife());
		// Cuarto Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Frenzy deberia ser 430", 430,
				algoformer2.getLife());
		// Quinto Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Optimus deberia ser 420", 420,
				algoformer2.getLife());
		// Sexto Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Frenzy deberia ser 410", 410,
				algoformer2.getLife());
		// Septimo Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Optimus deberia ser 400", 400,
				algoformer2.getLife());
		// Octavo Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Frenzy deberia ser 390", 390,
				algoformer2.getLife());
		// Noveno Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Optimus deberia ser 380", 380,
				algoformer2.getLife());
		// Decimo Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Frenzy deberia ser 370", 370,
				algoformer2.getLife());
		// Onceavo Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Optimus deberia ser 360", 360,
				algoformer2.getLife());

		algoformer1.transform();
		algoformer1.notifyNextTurn();
		algoformer1.move(new Position(2,2), board);
		algoformer1.notifyNextTurn();
		
		// Prueba Algoformer en modo Alterno
		// Primer Turno
		Assert.assertEquals("La vida de Optimus deberia ser 360", 360,algoformer2.getLife());
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Optimus deberia ser 310", 310,algoformer2.getLife());
		// Segundo Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Frenzy deberia ser 260", 260,algoformer2.getLife());
		// Tercer Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Optimus deberia ser 210", 210,algoformer2.getLife());
		// Cuarto Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Frenzy deberia ser 185", 185,
				algoformer2.getLife());
		// Quinto Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Optimus deberia ser 160", 160,
				algoformer2.getLife());
		// Sexto Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Frenzy deberia ser 135", 135,
				algoformer2.getLife());
		// Septimo Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Optimus deberia ser 110", 110,
				algoformer2.getLife());
		// Octavo Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Frenzy deberia ser 85", 85,
				algoformer2.getLife());
		// Noveno Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Optimus deberia ser 60", 60,
				algoformer2.getLife());
		// Decimo Turno
		algoformer1.shot(algoformer2);
		algoformer1.notifyNextTurn();
		Assert.assertEquals("La vida de Frenzy deberia ser 35", 35,
				algoformer2.getLife());
		// Onceavo Turno
		algoformer1.shot(algoformer2);
		Assert.assertEquals("La vida de Optimus deberia ser 10", 10,
				algoformer2.getLife());
	}

	/**
	 * 2. Ubico un algoformer, ubico un bonus burbuja, ubico un otro alfoformer
	 * enemigo, el algoformer captura el bonus, el otro algoformer ataca al
	 * primer algoformer, este no recibe daños, repetir hasta 2 turnos propios,
	 * continuar y verificar que en el 3ro sí reciba daño. a. Realizar el mismo
	 * test en modo alterno.
	 */
	@Test
	public void test02() {
	}

	/**
	 * 3. Ubico un algoformer, ubico un bonus flash, verifico que se mueve 3
	 * veces más rápido durante 3 turnos propios. a. Repetir en modo alterno b.
	 * Repetir en modo humanoide-alterno-humanoide
	 */
	@Test
	public void test03() {
	}

	/**
	 * 4. Test boundary cases (Si ya tiene un bonus de un tipo que no pueda
	 * agarrar otro del mismo tipo, Atrapar 2 bonus distintos verifcar ambos
	 * comportamientos, etc…)
	 * @throws InvalidPositionException 
	 * @throws AlgoformerUsadoEsteTurnoException 
	 */
	@Test
	public void test04() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException {

		Board board = new Board(20, 20);
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(2, 0));

		Bonus dobleCanon1 = CanonBonus.createCanonBonus(new Position(2, 1));
		Bonus dobleCanon2 = CanonBonus.createCanonBonus(new Position(2, 3));
		Bonus flash1 = BonusFlash.createBonusFlash(new Position(2, 5));
		Bonus flash2 = BonusFlash.createBonusFlash(new Position(2, 7));

		board.add(frenzy);
		board.add(dobleCanon1);
		board.add(dobleCanon2);
		board.add(flash1);
		board.add(flash2);

		Assert.assertEquals("El poder de ataquer de Frenzy deberia ser 10",
				new Integer(10), frenzy.getActiveMode().getAttack());
		frenzy.move(new Position(2, 2), board);
		Assert.assertEquals("El poder de ataquer de Frenzy deberia ser 20",
				new Integer(20), frenzy.getActiveMode().getAttack());
		frenzy.notifyNextTurn();
		frenzy.move(new Position(2, 4), board);
		Assert.assertEquals("El poder de ataquer de Frenzy deberia ser 20",
				new Integer(20), frenzy.getActiveMode().getAttack());
		Assert.assertEquals("La velocidad de Frenzy deberia ser 2",
				new Integer(2), frenzy.getActiveMode().getSpeed());
		frenzy.notifyNextTurn();
		frenzy.move(new Position(2, 6), board);
		Assert.assertEquals("La velocidad de Frenzy deberia ser 6",
				new Integer(6), frenzy.getActiveMode().getSpeed());
		frenzy.notifyNextTurn();
		frenzy.move(new Position(2, 12), board);
		Assert.assertEquals("La velocidad de Frenzy deberia ser 6",
				new Integer(6), frenzy.getActiveMode().getSpeed());
		Assert.assertEquals("El poder de ataquer de Frenzy deberia ser 20",
				new Integer(20), frenzy.getActiveMode().getAttack());
	}

}
