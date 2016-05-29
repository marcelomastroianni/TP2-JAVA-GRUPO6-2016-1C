package fiuba.algo3.algoformers;

public class AlgoFormerFactory {

	public static Algoformer getOptimusPrime() {
		ModeAlternal alternalMode = new ModeAlternal(500,15,4,5, new TypeTerrestrial());
		ModeHumanoid humanoidMode = new ModeHumanoid(500,50,2,2, alternalMode);
		return new Algoformer("Optimus Prime", humanoidMode);
	}



}
