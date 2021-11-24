package pion;

public class King extends Pion {

	String[] direction = {"haut gauche", "haut droite"};
	int nbCase = 8;
	String type = "King";
	public King(int pos, String[] direction, int nbCase, String character, String type, int joueur, int[] tabCanMoove,
			int[] tabCanEat, boolean isDead) {
		super(pos, direction, nbCase, character, type, joueur, tabCanMoove, tabCanEat, isDead);
		this.direction = direction;
		this.nbCase = nbCase;
		this.type = type;<>
	}

	

}
