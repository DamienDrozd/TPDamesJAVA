package pion;

public class Men extends Pion {
	
	String[] direction = {"haut gauche", "haut droite"};
	int nbCase = 1;

	public Men(int pos, String[] direction,int nbCase, String character) {
		super(pos, direction, nbCase, character);
		this.direction = direction;
		this.nbCase = nbCase;
		
	}
}
