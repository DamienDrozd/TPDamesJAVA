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
			tabJoueur1[i] = new Men(i+1,null, 0,  "O", 1);
			tabJoueur2[i] = new Men(50-i,null, 0,  "X", 2);
		}
		
		String[] mapGame = new String[(tailleTabX*tailleTabY)/2];

		
		//System.out.println("Choisissez votre mode de jeu:\n1/ Mode 1 joueur\n2/ Mode 2 joueurs");
		
		//int choixMode = Utilitaires.readInt();
		
		while(endGame != true) {
			
			isDame(tabJoueur1,tabJoueur2);
			
			for (int i = 0;i < tabJoueur1.length; i++) {
				tabJoueur1[i].canEat(tabJoueur1, tabJoueur2);
				tabJoueur1[i].canMove(tabJoueur1, tabJoueur2);
			}
			for (int i = 0;i < tabJoueur2.length; i++) {
				tabJoueur2[i].canEat(tabJoueur2, tabJoueur1);
				tabJoueur2[i].canMove(tabJoueur2, tabJoueur1);
			}
			
			mapGame = Tab.remplirTab(mapGame, tabJoueur1, tabJoueur2);
			
			PrintGame.printGame(mapGame);

			Menu.menu(tabJoueur1, tabJoueur2);
		
		}
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

	
	
	
	

}


