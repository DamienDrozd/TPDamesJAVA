package game;

import pion.Pion;

public class Tab {

	public static String[] remplirTab(String[] mapGame, Pion[] tabJoueur1, Pion[] tabJoueur2) {
		for (int x = 0; x < mapGame.length; x++ ) {
			mapGame[x] = ".";
			
			
		}
		
		for (int x = 0; x < mapGame.length; x++ ) {
		
			for (Pion pion : tabJoueur1) {
				if (x+1 == pion.getPos() && pion.isDead() == false) {
					mapGame[x] = pion.getCharacter();
				}
			}
			for (Pion pion : tabJoueur2) {
				if (50-x == pion.getPos() && pion.isDead() == false ) {
					mapGame[pion.getPos()-1] = pion.getCharacter();
				}
			}
		}
		
		
		return mapGame;
	}
	
	public static void isDame(Pion[] tabJoueur1, Pion[] tabJoueur2) {
		
		for (int i = 0; i<tabJoueur2.length ; i++) {
			
			if (tabJoueur2[i].getPos() >= 1 && tabJoueur2[i].getPos() <= 5) {
				tabJoueur2[i].setType("dame") ;
				// tabJoueur2[i] =  new King(i+1,null, 0,  "O", 1);
			} 
			
		}
		for (int i = 0; i<tabJoueur1.length ; i++) {
			
			if (tabJoueur1[i].getPos() >= 46 && tabJoueur1[i].getPos() <= 50) {
				tabJoueur1[i].setType("dame") ;
			} 
			
		}
	}
	
	public static boolean playerLoose(Pion[] tabJoueur) {
		for (int i = 0; i<tabJoueur.length ; i++) {
			if (tabJoueur[i].isDead() == false) {
				return false;
			} 
		}
		return true;
	}
}


