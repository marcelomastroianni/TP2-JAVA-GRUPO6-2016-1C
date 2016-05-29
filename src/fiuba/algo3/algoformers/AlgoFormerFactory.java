package fiuba.algo3.algoformers;

public class AlgoFormerFactory {

	public static Algoformer getOptimusPrime() {
		ModeTerrestrial alternalMode = new ModeTerrestrial(500,15,4,5);
		ModeTerrestrial humanoidMode = new ModeTerrestrial(500,50,2,2);
		return new Algoformer("Optimus Prime", humanoidMode,alternalMode);
	}



}
