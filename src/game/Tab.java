package game;

import pion.King;
import pion.Men;
import pion.Pion;

public class Tab {

	public static String[] remplirTab(String[] mapGame, Pion[] tabJoueur1, Pion[] tabJoueur2) {
		for (int x = 0; x < mapGame.length; x++ ) {// on remplit le tableau de cases vides
			mapGame[x] = ".";
		}
		for (int x = 0; x < mapGame.length; x++ ) {
		
			for (Pion pion : tabJoueur1) {
				if (x+1 == pion.getPos() && pion.isDead() == false) {
					mapGame[x] = pion.getCharacter();// on ajoute les pions du joueur 1
				}
			}
			for (Pion pion : tabJoueur2) {
				if (50-x == pion.getPos() && pion.isDead() == false ) {
					mapGame[pion.getPos()-1] = pion.getCharacter();// on ajoute les pions du joueur 2
				}
			}
		}
		return mapGame;
	}
	public static void isDame(Pion[] tabJoueur1, Pion[] tabJoueur2) {//transformation des pions en dames
		for (int i = 0; i<tabJoueur2.length ; i++) {
			if (tabJoueur2[i].getPos() >= 1 && tabJoueur2[i].getPos() <= 5) {
				String couleur = tabJoueur2[i].getCharacter();
				int pos = tabJoueur2[i].getPos();
				tabJoueur2[i] = new King(pos,null, 0,  couleur.toUpperCase(), "", 8 , null , null, false);
				tabJoueur2[i].setType("dame") ;
			} 
		}
		for (int i = 0; i<tabJoueur1.length ; i++) {
			if (tabJoueur1[i].getPos() >= 46 && tabJoueur1[i].getPos() <= 50) {
				tabJoueur1[i].setType("dame") ;
			} 
		}
	}
	public static boolean playerLoose(Pion[] tabJoueur) {//detection d'un joueur qui perd
		for (int i = 0; i<tabJoueur.length ; i++) {
			if (tabJoueur[i].isDead() == false) {
				return false;
			} 
		}
		return true;
	}
	
	
}


