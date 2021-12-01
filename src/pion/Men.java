package pion;

import java.util.ArrayList;

public class Men extends Pion {
	
	String[] direction = {"haut gauche", "haut droite"};
	int nbCase = 1;
	String type = "Men";
	
	
	public Men(int pos, String[] direction, int nbCase, String character, String type, int joueur,
			ArrayList<Integer> tabCanMoove, ArrayList<Integer> tabCanEat, boolean isDead) {
		super(pos, direction, nbCase, character, type, joueur, tabCanMoove, tabCanEat, isDead);
		// TODO Auto-generated constructor stub
		this.direction = direction;
		this.nbCase = nbCase;
		this.type = type;
	}


	


	
	
	
}
