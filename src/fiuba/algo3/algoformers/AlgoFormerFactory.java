package fiuba.algo3.algoformers;

public class AlgoFormerFactory {

	public static Algoformer getOptimusPrime() {
		AlternalMode alternalMode = new AlternalMode(500,15,4,5, new TerrestrialType());
		HumanoidMode humanoidMode = new HumanoidMode(500,50,2,2, alternalMode);
		return new Algoformer("Optimus Prime", humanoidMode);
	}



}
