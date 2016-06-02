package fiuba.algo3.model.algoformers;

public class AlgoFormerFactory {

	//Autobots:
	
	public static Algoformer getOptimusPrime() {
		Mode humanoidMode = new ModeHumanoid(50,2,2);
		Mode alternalMode = new ModeAlternalTerrestrial(15,4,5);		
		return new Algoformer("Optimus Prime", humanoidMode,alternalMode,500);
	}

	public static Algoformer getBumblebee() {
		Mode humanoidMode = new ModeHumanoid(40,1,2);
		Mode alternalMode = new ModeAlternalTerrestrial(20,3,5);		
		return new Algoformer("Bumblebee", humanoidMode,alternalMode,350);
	}

	public static Algoformer getRatchet() {
		Mode humanoidMode = new ModeHumanoid(5,5,1);
		Mode alternalMode = new ModeAlternalAerial(35,2,8);	
		return new Algoformer("Ratchet", humanoidMode,alternalMode,150);
	}
	
	public static Algoformer getSuperion() {
		Mode humanoidMode = new ModeHumanoid(100,2,3);
		return new Algoformer("Superion", humanoidMode,humanoidMode,100);
	}
	
	//Decepticons:
	
	public static Algoformer getMegatron() {
		Mode humanoidMode = new ModeHumanoid(10,3,1);
		Mode alternalMode = new ModeAlternalAerial(55,2,8);		
		return new Algoformer("Megatron", humanoidMode,alternalMode,550);
	}
	
	public static Algoformer getBonecrusher() {
		Mode humanoidMode = new ModeHumanoid(30,3,1);
		Mode alternalMode = new ModeAlternalTerrestrial(30,3,8);		
		return new Algoformer("Bonecrusher", humanoidMode,alternalMode,200);
	}
	
	public static Algoformer getFrenzy() {
		Mode humanoidMode = new ModeHumanoid(10,5,2);
		Mode alternalMode = new ModeAlternalTerrestrial(25,2,6);		
		return new Algoformer("Frenzy", humanoidMode,alternalMode,400);
	}
	
	public static Algoformer getMenasor() {
		Mode humanoidMode = new ModeHumanoid(115,2,2);	
		return new Algoformer("Menasor", humanoidMode,humanoidMode,400);
	}

}
