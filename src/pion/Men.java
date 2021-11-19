package pion;

public class Men extends Pion {
	
	String[] direction = {"haut gauche", "haut droite"};
	int nbCase = 1;

	
	
	



	public Men(int pos, String[] direction, int nbCase, String character, String type, int joueur,
			int[] tabCanMoove, int[] tabCanEat, boolean isDead) {
		super(pos, direction, nbCase, character, type, joueur, tabCanMoove, tabCanEat, isDead);
		this.direction = direction;
		this.nbCase = nbCase;
	}


	
	
	
}
