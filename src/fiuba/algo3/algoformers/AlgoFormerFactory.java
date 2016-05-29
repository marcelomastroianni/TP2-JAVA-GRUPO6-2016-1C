package fiuba.algo3.algoformers;

public class AlgoFormerFactory {

	public static Algoformer getOptimusPrime() {
		ModeTerrestrial alternalMode = new ModeTerrestrial(15,4,5);
		ModeTerrestrial humanoidMode = new ModeTerrestrial(50,2,2);
		return new Algoformer("Optimus Prime", humanoidMode,alternalMode,500);
	}



}
