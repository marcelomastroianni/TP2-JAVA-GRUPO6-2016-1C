package fiuba.algo3.model.algoformers;

import fiuba.algo3.model.algoformers.board.Position;

public class AlgoFormerFactory {

	//Autobots:

	public static Algoformer getOptimusPrime(Position position) {
		Mode humanoidMode = new ModeHumanoid(50,2,2);
		Mode alternalMode = new ModeAlternalTerrestrial(15,4,5);
		return new Algoformer("Optimus Prime", humanoidMode,alternalMode,500,position, Algoformer.Team.AUTOBOTS);
	}

	public static Algoformer getBumblebee(Position position) {
		Mode humanoidMode = new ModeHumanoid(40,1,2);
		Mode alternalMode = new ModeAlternalTerrestrial(20,3,5);
		return new Algoformer("Bumblebee", humanoidMode,alternalMode,350,position, Algoformer.Team.AUTOBOTS);
	}

	public static Algoformer getRatchet(Position position) {
		Mode humanoidMode = new ModeHumanoid(5,5,1);
		Mode alternalMode = new ModeAlternalAerial(35,2,8);
		return new Algoformer("Ratchet", humanoidMode,alternalMode,150,position, Algoformer.Team.AUTOBOTS);
	}

	public static Algoformer getSuperion(Position position, Integer life ) {
		Mode humanoidMode = new ModeHumanoid(100,2,3);
		Algoformer algoformer = new Algoformer("Superion", humanoidMode,humanoidMode,life,position, Algoformer.Team.AUTOBOTS);
		algoformer.setCombinado();
		return algoformer;
	}

	//Decepticons:

	public static Algoformer getMegatron(Position position) {
		Mode humanoidMode = new ModeHumanoid(10,3,1);
		Mode alternalMode = new ModeAlternalAerial(55,2,8);
		return new Algoformer("Megatron", humanoidMode,alternalMode,550,position, Algoformer.Team.DECEPTICONS);
	}

	public static Algoformer getBonecrusher(Position position) {
		Mode humanoidMode = new ModeHumanoid(30,3,1);
		Mode alternalMode = new ModeAlternalTerrestrial(30,3,8);
		return new Algoformer("Bonecrusher", humanoidMode,alternalMode,200,position, Algoformer.Team.DECEPTICONS);
	}

	public static Algoformer getFrenzy(Position position) {
		Mode humanoidMode = new ModeHumanoid(10,5,2);
		Mode alternalMode = new ModeAlternalTerrestrial(25,2,6);
		return new Algoformer("Frenzy", humanoidMode,alternalMode,400,position, Algoformer.Team.DECEPTICONS);
	}

	public static Algoformer getMenasor(Position position, Integer life) {
		Mode humanoidMode = new ModeHumanoid(115,2,2);
		Algoformer algoformer = new Algoformer("Menasor", humanoidMode,humanoidMode,life,position, Algoformer.Team.DECEPTICONS);
		algoformer.setCombinado();
		return algoformer;
	}

}
