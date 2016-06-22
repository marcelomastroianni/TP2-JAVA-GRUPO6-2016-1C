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
	 	 
	 private static Image chispaSupremaImage ;
	 
	 private static Image algoformer_optimusprime;
	 private static Image algoformer_optimusprime_alternal;
	 private static Image algoformer_bumblebee;
	 private static Image algoformer_bumblebee_alternal;	 	 
	 private static Image algoformer_ratchet;
	 private static Image algoformer_ratchet_alternal;
	 private static Image algoformer_megatron;
	 private static Image algoformer_megatron_alternal;
	 private static Image algoformer_bonecrusher;
	 private static Image algoformer_bonecrusher_alternal;
	 private static Image algoformer_frenzy;
	 private static Image algoformer_frenzy_alternal;
	 
	 
	 public static Image getAlgoformerOtimusPrime(){
		if (algoformer_optimusprime == null){
			algoformer_optimusprime = new Image("file:src/fiuba/algo3/vista/pictures/algoformer_optimusprime.png");
		}
		return algoformer_optimusprime;
	 }
	 
	 public static Image getAlgoformerOtimusPrimeAlternal(){
		if (algoformer_optimusprime_alternal == null){
			algoformer_optimusprime_alternal = new Image("file:src/fiuba/algo3/vista/pictures/algoformer_optimusprime_alternal.png");
		}
		return algoformer_optimusprime_alternal;
	 }	 
	 	 	 	
	 public static Image getChispaSuprema(){
		if (chispaSupremaImage == null){
			chispaSupremaImage = new Image("file:src/fiuba/algo3/vista/pictures/chispa-suprema.png");
		}
		return chispaSupremaImage;
	 }
	
	public static Image getBonusDobleCannon(){
		if (cannon == null){
			cannon = new Image("file:src/fiuba/algo3/vista/pictures/bonus_doble_cannon.png");
		}
		return cannon;
	}
	
	public static Image getBonusFlash(){
		if (flash == null){
			flash = new Image("file:src/fiuba/algo3/vista/pictures/bonus_flash.png");
		}
		return flash;
	}
	
	public static Image getBonusBubble(){
		if (bubble == null){
			bubble = new Image("file:src/fiuba/algo3/vista/pictures/bonus_burbuja_inmaculada.png");
		}
		return bubble;
	}
			 
	public static Image getSupRocosa(){
		if (supRocosa == null){
			supRocosa = new Image("file:src/fiuba/algo3/vista/pictures/superficie_rocasa.jpg");
		}
		return supRocosa;
	}
	
	public static Image getSupEspinas(){
		if (supEspinas == null){
			supEspinas = new Image("file:src/fiuba/algo3/vista/pictures/superficie_espinas_2.jpg");		
		}
		return supEspinas;
	}
	
	public static Image getSupNubes(){
		if (supNubes == null){
			supNubes = new Image("file:src/fiuba/algo3/vista/pictures/superficie_nubes.jpg");	
		}
		return supNubes;
	}
	
	public static Image getSupPantano(){
		if (supPantano == null){
			supPantano = new Image("file:src/fiuba/algo3/vista/pictures/superficie_pantano_2.jpg");	
		}
		return supPantano;
	}
	
	public static Image getSupAndromeda(){
		if (supAndromeda == null){
			supAndromeda = new Image("file:src/fiuba/algo3/vista/pictures/superficie_nebulosa_andromeda.jpg");	
		}
		return supAndromeda;
	}
	
	public static Image getSupPsionica(){
		if (supPsionica == null){
			supPsionica = new Image("file:src/fiuba/algo3/vista/pictures/superficie_tormenta_psionica.jpg");	
		}
		return supPsionica;
	}	
}
