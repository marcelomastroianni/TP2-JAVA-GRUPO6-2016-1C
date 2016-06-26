package fiuba.algo3.algoformers.entregas;

import fiuba.algo3.model.bonus.BubbleBonus;
import fiuba.algo3.model.bonus.CanonBonus;
import fiuba.algo3.model.bonus.FlashBonus;
import fiuba.algo3.model.exceptions.AlgoformerAtrapadoEsteTurnoException;
import fiuba.algo3.model.exceptions.AlgoformerCombinandoseEsteTurnoException;
import fiuba.algo3.model.exceptions.AlgoformerUsadoEsteTurnoException;
import fiuba.algo3.model.exceptions.InvalidPositionException;
import fiuba.algo3.model.exceptions.ModoAlternoNoPuedeCapturarChispaSupremaException;
import fiuba.algo3.model.exceptions.MuyLejosParaAtacarException;
import fiuba.algo3.model.exceptions.NoPuedeMoverseDondeEstaOtroAlgoformerException;
import fiuba.algo3.model.exceptions.NoSePuedeAtacarAlgoformerDelMismoEquipoException;
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
	 * @throws AlgoformerCombinandoseEsteTurnoException 
	 * @throws NoSePuedeAtacarAlgoformerDelMismoEquipoException 
	 * @throws MuyLejosParaAtacarException 
	 * @throws NoPuedeMoverseDondeEstaOtroAlgoformerException 
	 * @throws ModoAlternoNoPuedeCapturarChispaSupremaException 
	 * @throws GameOverException
	 */
	@Test
	public void test01() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoSePuedeAtacarAlgoformerDelMismoEquipoException, MuyLejosParaAtacarException, NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException {
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
		algoformer1.notifyNextTurn( );

		// Prueba Algoformer en modo Humanoide
		// Primer Turno
		Assert.assertEquals("La vida de Optimus deberia ser 500", 500,
				algoformer2.getLife());
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Optimus deberia ser 480", 480,
				algoformer2.getLife());
		// Segundo Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Frenzy deberia ser 460", 460,
				algoformer2.getLife());
		// Tercer Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Optimus deberia ser 440", 440,
				algoformer2.getLife());
		// Cuarto Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Frenzy deberia ser 430", 430,
				algoformer2.getLife());
		// Quinto Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Optimus deberia ser 420", 420,
				algoformer2.getLife());
		// Sexto Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Frenzy deberia ser 410", 410,
				algoformer2.getLife());
		// Septimo Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Optimus deberia ser 400", 400,
				algoformer2.getLife());
		// Octavo Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Frenzy deberia ser 390", 390,
				algoformer2.getLife());
		// Noveno Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Optimus deberia ser 380", 380,
				algoformer2.getLife());
		// Decimo Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Frenzy deberia ser 370", 370,
				algoformer2.getLife());
		// Onceavo Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Optimus deberia ser 360", 360,
				algoformer2.getLife());

		algoformer1.transform();
		algoformer1.notifyNextTurn( );
		algoformer1.move(new Position(2,2), board);
		algoformer1.notifyNextTurn( );

		// Prueba Algoformer en modo Alterno
		// Primer Turno
		Assert.assertEquals("La vida de Optimus deberia ser 360", 360,algoformer2.getLife());
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Optimus deberia ser 310", 310,algoformer2.getLife());
		// Segundo Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Frenzy deberia ser 260", 260,algoformer2.getLife());
		// Tercer Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Optimus deberia ser 210", 210,algoformer2.getLife());
		// Cuarto Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Frenzy deberia ser 185", 185,
				algoformer2.getLife());
		// Quinto Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Optimus deberia ser 160", 160,
				algoformer2.getLife());
		// Sexto Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Frenzy deberia ser 135", 135,
				algoformer2.getLife());
		// Septimo Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Optimus deberia ser 110", 110,
				algoformer2.getLife());
		// Octavo Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Frenzy deberia ser 85", 85,
				algoformer2.getLife());
		// Noveno Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Optimus deberia ser 60", 60,
				algoformer2.getLife());
		// Decimo Turno
		algoformer1.shot(algoformer2,board);
		algoformer1.notifyNextTurn( );
		Assert.assertEquals("La vida de Frenzy deberia ser 35", 35,
				algoformer2.getLife());
		// Onceavo Turno
		algoformer1.shot(algoformer2,board);
		Assert.assertEquals("La vida de Optimus deberia ser 10", 10,
				algoformer2.getLife());
	}

	/**
	 * 2. Ubico un algoformer, ubico un bonus burbuja, ubico un otro alfoformer
	 * enemigo, el algoformer captura el bonus, el otro algoformer ataca al
	 * primer algoformer, este no recibe daños, repetir hasta 2 turnos propios,
	 * continuar y verificar que en el 3ro sí reciba daño. a. Realizar el mismo
	 * test en modo alterno.
	 * @throws InvalidPositionException
	 * @throws AlgoformerAtrapadoEsteTurnoException
	 * @throws AlgoformerUsadoEsteTurnoException
	 * @throws AlgoformerCombinandoseEsteTurnoException 
	 * @throws NoSePuedeAtacarAlgoformerDelMismoEquipoException 
	 * @throws MuyLejosParaAtacarException 
	 * @throws NoPuedeMoverseDondeEstaOtroAlgoformerException 
	 * @throws ModoAlternoNoPuedeCapturarChispaSupremaException 
	 */
	@Test
	public void test02() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoSePuedeAtacarAlgoformerDelMismoEquipoException, MuyLejosParaAtacarException, NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException {

		Board board = new Board(5, 5);
		Algoformer algoformer1 = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer algoformer2 = AlgoFormerFactory.getMegatron(new Position(0,2));
		Bonus burbuja = new BubbleBonus(new Position(0,1));

		board.add(algoformer1);
		board.add(algoformer2);
		board.add(burbuja);

		//primer turno
		algoformer1.move(new Position(0,1), board);
		algoformer1.notifyNextTurn( );
		algoformer2.shot(algoformer1, board);
		algoformer2.notifyNextTurn( );
		Assert.assertEquals(algoformer1.getLife(), 500);

		//segundo turno
		algoformer1.notifyNextTurn( );
		algoformer2.shot(algoformer1, board);
		algoformer2.notifyNextTurn( );
		Assert.assertEquals(algoformer1.getLife(), 500);

		//tercer turno
		algoformer1.notifyNextTurn( );
		algoformer2.shot(algoformer1, board);
		algoformer2.notifyNextTurn( );
		Assert.assertEquals(algoformer1.getLife(), 490);


	}

	@Test
	public void test02Alterno() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoSePuedeAtacarAlgoformerDelMismoEquipoException, MuyLejosParaAtacarException, NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException {

		Board board = new Board(5, 5);
		Algoformer algoformer1 = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer algoformer2 = AlgoFormerFactory.getMegatron(new Position(0,2));
		Bonus burbuja = new BubbleBonus(new Position(0,1));

		board.add(algoformer1);
		board.add(algoformer2);
		board.add(burbuja);

		algoformer1.transform();
		algoformer1.notifyNextTurn() ;
		algoformer2.transform();
		algoformer2.notifyNextTurn( );

		//primer turno
		algoformer1.move(new Position(0,1), board);
		algoformer1.notifyNextTurn( );
		algoformer2.shot(algoformer1, board);
		algoformer2.notifyNextTurn( );
		Assert.assertEquals(algoformer1.getLife(), 500);

		//segundo turno
		algoformer1.notifyNextTurn( );
		algoformer2.shot(algoformer1, board);
		algoformer2.notifyNextTurn( );
		Assert.assertEquals(algoformer1.getLife(), 500);

		//tercer turno
		algoformer1.notifyNextTurn( );
		algoformer2.shot(algoformer1, board);
		algoformer2.notifyNextTurn( );
		Assert.assertEquals(algoformer1.getLife(), 445);


	}

	/**
	 * 3. Ubico un algoformer, ubico un bonus flash, verifico que se mueve 3
	 * veces más rápido durante 3 turnos propios. a. Repetir en modo alterno b.
	 * Repetir en modo humanoide-alterno-humanoide
	 * @throws InvalidPositionException
	 * @throws AlgoformerAtrapadoEsteTurnoException
	 * @throws AlgoformerUsadoEsteTurnoException
	 * @throws AlgoformerCombinandoseEsteTurnoException 
	 * @throws NoPuedeMoverseDondeEstaOtroAlgoformerException 
	 * @throws ModoAlternoNoPuedeCapturarChispaSupremaException 
	 */
	@Test
	public void test03() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException {

		Board board = new Board(10, 10);
		Algoformer algoformer1 = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer algoformer2 = AlgoFormerFactory.getMegatron(new Position(0,2));
		Bonus flash = new FlashBonus(new Position(0,1));

		board.add(algoformer1);
		board.add(algoformer2);
		board.add(flash);


		algoformer1.move(new Position(0,1), board);
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );

		//primer turno
		algoformer1.move(new Position(6,1), board);
		Assert.assertEquals(new Position(6,1), algoformer1.getPosition());
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );


		//segundo turno
		algoformer1.move(new Position(6,7), board);
		Assert.assertEquals(new Position(6,7), algoformer1.getPosition());
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );


		//tercer turno
		algoformer1.move(new Position(0,1), board);
		Assert.assertEquals(new Position(0,1), algoformer1.getPosition());
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );

		//cuarto turno
		algoformer1.move(new Position(6,7), board);
		Assert.assertEquals(new Position(2,3), algoformer1.getPosition());

	}



	@Test
	public void test03Alterno() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException {

		Board board = new Board(20, 20);
		Algoformer algoformer1 = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer algoformer2 = AlgoFormerFactory.getMegatron(new Position(0,2));
		Bonus flash = new FlashBonus(new Position(0,1));

		board.add(algoformer1);
		board.add(algoformer2);
		board.add(flash);

		algoformer1.transform();
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );


		algoformer1.move(new Position(0,1), board);
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );


		//primer turno
		algoformer1.move(new Position(15,1), board);
		Assert.assertEquals(new Position(15,1), algoformer1.getPosition());
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );


		//segundo turno
		algoformer1.move(new Position(15,16), board);
		Assert.assertEquals(new Position(15,16), algoformer1.getPosition());
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );


		//tercer turno
		algoformer1.move(new Position(0,1), board);
		Assert.assertEquals(new Position(0,1), algoformer1.getPosition());
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );

		//cuarto turno
		algoformer1.move(new Position(15,1), board);
		Assert.assertEquals(new Position(5,1), algoformer1.getPosition());

	}


	@Test
	public void test03HumanoideAlterno() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException {

		Board board = new Board(20, 20);
		Algoformer algoformer1 = AlgoFormerFactory.getOptimusPrime(new Position(0,0));
		Algoformer algoformer2 = AlgoFormerFactory.getMegatron(new Position(0,2));
		Bonus flash = new FlashBonus(new Position(0,1));

		board.add(algoformer1);
		board.add(algoformer2);
		board.add(flash);


		algoformer1.move(new Position(0,1), board);
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );

		//primer turno
		algoformer1.move(new Position(6,1), board);
		Assert.assertEquals(new Position(6,1), algoformer1.getPosition());
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );


		//segundo turno
		algoformer1.transform();
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );

		//tercer turno
		algoformer1.move(new Position(6,16), board);
		Assert.assertEquals(new Position(6,16), algoformer1.getPosition());
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );

		//cuarto turno
		algoformer1.move(new Position(6,1), board);
		Assert.assertEquals(new Position(6,11), algoformer1.getPosition());
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );

		//quinto turno
		algoformer1.transform();
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );

		//sexto turno
		algoformer1.move(new Position(0,0), board);
		Assert.assertEquals(new Position(4,9), algoformer1.getPosition());
		algoformer1.notifyNextTurn( );
		algoformer2.notifyNextTurn( );


	}


	/**
	 * 4. Test boundary cases (Si ya tiene un bonus de un tipo que no pueda
	 * agarrar otro del mismo tipo, Atrapar 2 bonus distintos verifcar ambos
	 * comportamientos, etc…)
	 * @throws InvalidPositionException
	 * @throws AlgoformerUsadoEsteTurnoException
	 * @throws AlgoformerCombinandoseEsteTurnoException 
	 * @throws NoSePuedeAtacarAlgoformerDelMismoEquipoException 
	 * @throws MuyLejosParaAtacarException 
	 * @throws NoPuedeMoverseDondeEstaOtroAlgoformerException 
	 * @throws ModoAlternoNoPuedeCapturarChispaSupremaException 
	 * @throws GameOverException
	 */
	@Test
	public void test04() throws InvalidPositionException, AlgoformerUsadoEsteTurnoException, AlgoformerAtrapadoEsteTurnoException, AlgoformerCombinandoseEsteTurnoException, NoSePuedeAtacarAlgoformerDelMismoEquipoException, MuyLejosParaAtacarException, NoPuedeMoverseDondeEstaOtroAlgoformerException, ModoAlternoNoPuedeCapturarChispaSupremaException {

		Board board = new Board(20, 20);
		Algoformer frenzy = AlgoFormerFactory.getFrenzy(new Position(2, 0));
		Algoformer optimus = AlgoFormerFactory.getOptimusPrime(new Position(3, 4));

		Bonus dobleCanon1 = CanonBonus.createCanonBonus(new Position(2, 1));
		Bonus dobleCanon2 = CanonBonus.createCanonBonus(new Position(2, 5));
		Bonus dobleCanon3 = CanonBonus.createCanonBonus(new Position(2, 9));
		Bonus flash1 = FlashBonus.createBonusFlash(new Position(2, 3));
		Bonus flash2 = FlashBonus.createBonusFlash(new Position(2, 10));
		Bonus flash3 = FlashBonus.createBonusFlash(new Position(2, 11));


		board.add(frenzy);
		board.add(optimus);
		board.add(dobleCanon1);
		board.add(dobleCanon2);
		board.add(dobleCanon3);
		board.add(flash1);
		board.add(flash2);
		board.add(flash3);

		Assert.assertEquals("El poder de ataquer de Frenzy deberia ser 10", 10, frenzy.getAttack());
		frenzy.move(new Position(2, 2), board);			//agarra un DobleDamage por 3 turnos
		frenzy.notifyNextTurn( );
		Assert.assertEquals("la vida de Optimus deberia ser 500", 500, optimus.getLife());
		frenzy.shot(optimus,board);
		frenzy.notifyNextTurn( );						//Le quedan 2 turnos de DobleDamage
		Assert.assertEquals("la vida de Optimus deberia ser 480", 480, optimus.getLife());
		Assert.assertEquals("La velocidad de Frenzy deberia ser 2", 2, frenzy.getSpeed());
		frenzy.move(new Position(2, 4), board);			//agarra un Flash por 3 turnos
		frenzy.notifyNextTurn( );						//Le quedan 1 turnos de DobleDamage y 3 de Flash
		frenzy.shot(optimus,board);
		frenzy.notifyNextTurn( );						//Se quedo sin turnos de DobleDamage y 2 de Flash
		Assert.assertEquals("la vida de Optimus deberia ser 460", 460, optimus.getLife());
		frenzy.move(new Position(2, 9), board);			//agarra 2 DobleDamage por 3 turnos
		frenzy.notifyNextTurn( );						//Le quedan 3 turnos de DobleDamage y 1 de Flash
		Assert.assertEquals("Frenzy deberia estar en la posicion (2,9)",new Position(2,9),frenzy.getPosition());
		optimus.move(new Position(3,6), board);
		optimus.notifyNextTurn( );
		frenzy.shot(optimus,board);
		frenzy.notifyNextTurn( );						//Se quedo sin turnos de Flash y 2 de DobleDamage
		Assert.assertEquals("la vida de Optimus deberia ser 440", 440, optimus.getLife());
		frenzy.move(new Position(2,10), board);			//agarra un Flash por 3 turnos
		frenzy.notifyNextTurn( );						//Le quedan 1 turnos de DobleDamage y 3 de Flash
		frenzy.move(new Position(2,12), board);			//agarra el segundo Flash
		frenzy.notifyNextTurn( );						//Se quedo sin turnos de DobleDamage y 2 de Flash
		frenzy.move(new Position(2,20), board);
		frenzy.notifyNextTurn( );						//Le quedan 1 turnos de DobleDamage
		Assert.assertEquals("Frenzy deberia estar en la posicion (2,18)",new Position(2,18),frenzy.getPosition());
	}

}
