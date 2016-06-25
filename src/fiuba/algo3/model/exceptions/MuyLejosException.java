package fiuba.algo3.model.exceptions;


public class MuyLejosException extends RuntimeException {
	public MuyLejosException(){
		super("Solo pueden combinarse si estan a una distancia de uno entre ellos");
	}
}
