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
		
		String[] mapGame = new String[(tailleTabX*tailleTabY)/2];

		
		//System.out.println("Choisissez votre mode de jeu:\n1/ Mode 1 joueur\n2/ Mode 2 joueurs");
		
		//int choixMode = Utilitaires.readInt();
		
		while(endGame != true) {
			
			mapGame = Tab.remplirTab(mapGame, tabJoueur1, tabJoueur2);
			
			PrintGame.printGame(mapGame);

			int choixPion = Utilitaires.readInt();
		
		}
	}
	
	
	
	

}
