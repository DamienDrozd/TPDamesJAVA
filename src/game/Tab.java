package game;

import pion.Pion;

public class Tab {

	public static String[] remplirTab(String[] mapGame, Pion[] tabJoueur1, Pion[] tabJoueur2) {
		for (int x = 0; x < mapGame.length; x++ ) {
			mapGame[x] = ".";
			
			
		}
		
		for (int x = 0; x < mapGame.length; x++ ) {
		
			for (Pion pion : tabJoueur1) {
				
				
				if (x+1 == pion.getPos()) {
					mapGame[x] = pion.getCharacter();
				}
			}
			for (Pion pion : tabJoueur2) {
				if (50-x == pion.getPos()) {
					mapGame[pion.getPos()-1] = pion.getCharacter();
				}
			}
		}
		
		
		return mapGame;
	}
}


