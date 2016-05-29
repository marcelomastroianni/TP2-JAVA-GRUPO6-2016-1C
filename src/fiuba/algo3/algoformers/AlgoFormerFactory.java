package fiuba.algo3.algoformers;

public class AlgoFormerFactory {

	//Autobots:
	
	public static Algoformer getOptimusPrime() {
		ModeTerrestrial humanoidMode = new ModeTerrestrial(50,2,2);
		ModeTerrestrial alternalMode = new ModeTerrestrial(15,4,5);		
		return new Algoformer("Optimus Prime", humanoidMode,alternalMode,500);
	}

	public static Algoformer getBumblebee() {
		ModeTerrestrial humanoidMode = new ModeTerrestrial(40,1,2);
		ModeTerrestrial alternalMode = new ModeTerrestrial(20,3,5);		
		return new Algoformer("Bumblebee", humanoidMode,alternalMode,350);
	}

	public static Algoformer getRatchet() {
		ModeTerrestrial humanoidMode = new ModeTerrestrial(5,5,1);
		ModeAerial alternalMode = new ModeAerial(35,2,8);	
		return new Algoformer("Ratchet", humanoidMode,alternalMode,150);
	}
	
	public static Algoformer getSuperion() {
		ModeTerrestrial humanoidMode = new ModeTerrestrial(100,2,3);
		return new Algoformer("Superion", humanoidMode,humanoidMode,100);
	}
	
	//Decepticons:
	
	public static Algoformer getMegatron() {
		ModeTerrestrial humanoidMode = new ModeTerrestrial(10,3,1);
		ModeAerial alternalMode = new ModeAerial(55,2,8);		
		return new Algoformer("Megatron", humanoidMode,alternalMode,550);
	}
	
	public static Algoformer getBonecrusher() {
		ModeTerrestrial humanoidMode = new ModeTerrestrial(30,3,1);
		ModeTerrestrial alternalMode = new ModeTerrestrial(30,3,8);		
		return new Algoformer("Bonecrusher", humanoidMode,alternalMode,200);
	}
	
	public static Algoformer getFrenzy() {
		ModeTerrestrial humanoidMode = new ModeTerrestrial(10,5,2);
		ModeTerrestrial alternalMode = new ModeTerrestrial(25,2,6);		
		return new Algoformer("Frenzy", humanoidMode,alternalMode,400);
	}
	
	public static Algoformer getMenasor() {
		ModeTerrestrial humanoidMode = new ModeTerrestrial(115,2,2);	
		return new Algoformer("Menasor", humanoidMode,humanoidMode,400);
	}

}
