package fiuba.algo3.view;

import javafx.scene.image.Image;

public class ImageFactory {
	private static Image supRocosa;
	private static Image supEspinas;
	private static Image supNubes;
	private static Image supPantano;
	private static Image supAndromeda;
	private static Image supPsionica;

	private static Image cannon;
	private static Image flash;
	private static Image bubble;

	private static Image chispaSupremaImage;

	private static Image algoformerOptimusprime;
	private static Image algoformerOptimusprimeAlternal;
	private static Image algoformerBumblebee;
	private static Image algoformerBumblebeeAlternal;
	private static Image algoformerRatchet;
	private static Image algoformerRatchetAlternal;
	private static Image algoformerMegatron;
	private static Image algoformerMegatronAlternal;
	private static Image algoformerBonecrusher;
	private static Image algoformerBonecrusherAlternal;
	private static Image algoformerFrenzy;
	private static Image algoformerFrenzyAlternal;

	public static Image getAlgoformer(String name) {
		switch(name){
		case("Optimus Prime"):
			return getAlgoformerOtimusPrime();
		case("Bumblebee"):
			return getAlgoformerBumblebee();
		case("Ratchet"):
			return getAlgoformerRatchet();
		case("Megatron"):
			return getAlgoformerMegatron();
		case("Bonecrusher"):
			return getAlgoformerBonecrusher();
		case("Frenzy"):
			return getAlgoformerFrenzy();
		}
		throw new RuntimeException("error al cargar imagen de algoformer");
	}

	public static Image getAlgoformerOtimusPrime() {
		if (algoformerOptimusprime == null) {
			algoformerOptimusprime = new Image(
					"file:src/fiuba/algo3/vista/pictures/algoformer_optimusprime.png");
		}
		return algoformerOptimusprime;
	}

	public static Image getAlgoformerOtimusPrimeAlternal() {
		if (algoformerOptimusprimeAlternal == null) {
			algoformerOptimusprimeAlternal = new Image(
					"file:src/fiuba/algo3/vista/pictures/algoformer_optimusprime_alternal.png");
		}
		return algoformerOptimusprimeAlternal;
	}

	public static Image getAlgoformerBumblebee() {
		if (algoformerBumblebee == null) {
			algoformerBumblebee = new Image(
					"file:src/fiuba/algo3/vista/pictures/algoformer_bumblebee.png");
		}
		return algoformerBumblebee;
	}

	public static Image getAlgoformerBumblebeeAlternal() {
		if (algoformerBumblebeeAlternal == null) {
			algoformerBumblebeeAlternal = new Image(
					"file:src/fiuba/algo3/vista/pictures/algoformer_bumblebee_alternal.png");
		}
		return algoformerBumblebeeAlternal;
	}

	public static Image getAlgoformerRatchet() {
		if (algoformerRatchet == null) {
			algoformerRatchet = new Image(
					"file:src/fiuba/algo3/vista/pictures/algoformer_ratchet.png");
		}
		return algoformerRatchet;
	}

	public static Image getAlgoformerRatchetAlternal() {
		if (algoformerRatchetAlternal == null) {
			algoformerRatchetAlternal = new Image(
					"file:src/fiuba/algo3/vista/pictures/algoformer_ratchet_alternal.png");
		}
		return algoformerRatchetAlternal;
	}

	public static Image getAlgoformerMegatron() {
		if (algoformerMegatron == null) {
			algoformerMegatron = new Image(
					"file:src/fiuba/algo3/vista/pictures/algoformer_megatron.png");
		}
		return algoformerMegatron;
	}

	public static Image getAlgoformerMegatronAlternal() {
		if (algoformerMegatronAlternal == null) {
			algoformerMegatronAlternal = new Image(
					"file:src/fiuba/algo3/vista/pictures/algoformer_megatron_alternal.png");
		}
		return algoformerMegatronAlternal;
	}

	public static Image getAlgoformerBonecrusher() {
		if (algoformerBonecrusher == null) {
			algoformerBonecrusher = new Image(
					"file:src/fiuba/algo3/vista/pictures/algoformer_bonecrusher.gif");
		}
		return algoformerBonecrusher;
	}

	public static Image getAlgoformerBonecrusherAlternal() {
		return algoformerBonecrusherAlternal;
	}

	public static Image getAlgoformerFrenzy() {
		if (algoformerFrenzy == null) {
			algoformerFrenzy = new Image(
					"file:src/fiuba/algo3/vista/pictures/algoformer_frenzy.gif");
		}
		return algoformerFrenzy;
	}

	public static Image getAlgoformerFrenzyAlternal() {
		return algoformerFrenzyAlternal;
	}

	public static Image getChispaSuprema() {
		if (chispaSupremaImage == null) {
			chispaSupremaImage = new Image(
					"file:src/fiuba/algo3/vista/pictures/chispa-suprema.png");
		}
		return chispaSupremaImage;
	}

	public static Image getBonusDobleCannon() {
		if (cannon == null) {
			cannon = new Image(
					"file:src/fiuba/algo3/vista/pictures/bonus_doble_cannon.png");
		}
		return cannon;
	}

	public static Image getBonusFlash() {
		if (flash == null) {
			flash = new Image(
					"file:src/fiuba/algo3/vista/pictures/bonus_flash.png");
		}
		return flash;
	}

	public static Image getBonusBubble() {
		if (bubble == null) {
			bubble = new Image(
					"file:src/fiuba/algo3/vista/pictures/bonus_burbuja_inmaculada.png");
		}
		return bubble;
	}

	public static Image getSupRocosa() {
		if (supRocosa == null) {
			supRocosa = new Image(
					"file:src/fiuba/algo3/vista/pictures/superficie_rocasa.jpg");
		}
		return supRocosa;
	}

	public static Image getSupEspinas() {
		if (supEspinas == null) {
			supEspinas = new Image(
					"file:src/fiuba/algo3/vista/pictures/superficie_espinas_2.jpg");
		}
		return supEspinas;
	}

	public static Image getSupNubes() {
		if (supNubes == null) {
			supNubes = new Image(
					"file:src/fiuba/algo3/vista/pictures/superficie_nubes.jpg");
		}
		return supNubes;
	}

	public static Image getSupPantano() {
		if (supPantano == null) {
			supPantano = new Image(
					"file:src/fiuba/algo3/vista/pictures/superficie_pantano_2.jpg");
		}
		return supPantano;
	}

	public static Image getSupAndromeda() {
		if (supAndromeda == null) {
			supAndromeda = new Image(
					"file:src/fiuba/algo3/vista/pictures/superficie_nebulosa_andromeda.jpg");
		}
		return supAndromeda;
	}

	public static Image getSupPsionica() {
		if (supPsionica == null) {
			supPsionica = new Image(
					"file:src/fiuba/algo3/vista/pictures/superficie_tormenta_psionica.jpg");
		}
		return supPsionica;
	}
}
