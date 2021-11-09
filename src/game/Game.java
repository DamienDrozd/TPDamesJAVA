package game;

import pion.Pion;
import pion.Men;
import pion.King;
import utilitaires.Utilitaires;

public class Game {
	
	static int tailleTabX = 10;
    static int tailleTabY = 10;
    static int nbPions = 20;
    
	
	public static void startGame() {
		boolean endGame = false;
		
		Pion[] tabJoueur1 = new Pion[nbPions];
		Pion[] tabJoueur2 = new Pion[nbPions];
		
		for (int i=0;i<nbPions;i++) {
			tabJoueur1[i] = new Men(i+1,null, 0,  "O");
			tabJoueur2[i] = new Men(50-i,null, 0,  "X");
		}
		
	    char[] mapGame = new char[(tailleTabX*tailleTabY)/2];
	    mapGame = remplirTab(mapGame, tabJoueur1, tabJoueur2);
		
		//System.out.println("Choisissez votre mode de jeu:\n1/ Mode 1 joueur\n2/ Mode 2 joueurs");
		
		//int choixMode = Utilitaires.readInt();
		
		while(endGame != true) {
			
			mapGame = remplirTab(mapGame, tabJoueur1, tabJoueur2);
			
			PrintGame.printGame(mapGame);

			int choixPion = Utilitaires.readInt();
		
		}
	}
	
	
	
	public static char[] remplirTab(String[] mapGame, Pion[] tabJoueur1, Pion[] tabJoueur2) {
		for (int x = 0; x < (tailleTabX * tailleTabY)/2; x++ ) {
			mapGame[x] = ".";
			
			for (Pion pion : tabJoueur1) {
				
			
				if (x+1 == pion) {
					mapGame[x] = pion.getCharacter();
				}
			}
			for (Pion pion : tabJoueur1) {
				
			}
		}
		
		
		return mapGame;
	}

}
