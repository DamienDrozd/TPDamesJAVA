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
		
		
		
		//choix aléatoire des couleurs
		int couleurInt = (int) (1 + Math.random() * ( 3-1 ));
		for (int i=0;i<nbPions;i++) {
			
			if (couleurInt == 1) {
				tabJoueur1[i] = new Men(i+1,null, 0,  "O", "", 1 , null , null, false);
				tabJoueur2[i] = new Men(50-i,null, 0,  "X", "", 2, null , null, false);
			}
			if (couleurInt == 2) {
				tabJoueur2[i] = new Men(i+1,null, 0,  "O", "", 1 , null , null, false);
				tabJoueur1[i] = new Men(50-i,null, 0,  "X", "", 2, null , null, false);
			}
		}
		String[] mapGame = new String[(tailleTabX*tailleTabY)/2];

		
		//System.out.println("Choisissez votre mode de jeu:\n1/ Mode 1 joueur\n2/ Mode 2 joueurs");
		
		int choixMode = Menu.menuModeGame();
		
		if (couleurInt == 1) {
			System.out.println("Le joueur 1 a la couleur '0', c'est lui qui démarre le jeu");
		}else {
			System.out.println("Le joueur 2 a la couleur '0', c'est lui qui démarre le jeu");
		}
		
		while(endGame != true) {
			
			Tab.isDame(tabJoueur1,tabJoueur2);
			
			for (int i = 0;i < tabJoueur1.length; i++) {
				tabJoueur1[i].canEat(tabJoueur1, tabJoueur2);
				tabJoueur1[i].canMove(tabJoueur1, tabJoueur2);
				for (int nb : tabJoueur1[i].getTabCanMoove()) {
					System.out.println(tabJoueur1[i].getPos() + " " + nb);
				}
				
			}
			for (int i = 0;i < tabJoueur2.length; i++) {
				tabJoueur2[i].canEat(tabJoueur2, tabJoueur1);
				tabJoueur2[i].canMove(tabJoueur2, tabJoueur1);
			}
			
			if (Tab.playerLoose(tabJoueur1)) {
				System.out.println("Le joueur 1 n'a plus de pions, il a perdu");
				endGame = true;
				break;
			}
			if (Tab.playerLoose(tabJoueur2)) {
				System.out.println("Le joueur 2 n'a plus de pions, il a perdu");
				endGame = true;
				break;
			}
			
			mapGame = Tab.remplirTab(mapGame, tabJoueur1, tabJoueur2);
			
			PrintGame.printGame(mapGame);
			
			
			if (couleurInt == 1) {
				//joueur 1 en premier
				
				System.out.println("Tour du joueur 1:");
				Menu.menu(tabJoueur1, tabJoueur2);
				
				System.out.println("Tour du joueur 2:");
				if (choixMode == 1) {
					IaPlay.iaPlay(tabJoueur1, tabJoueur2);
				}
				if (choixMode == 2) {
					Menu.menu(tabJoueur2, tabJoueur1);
				}
			}
				
			
				
			
			if (couleurInt == 2) {
				//joueur 2 en premier
				
				System.out.println("Tour du joueur 2:");
				if (choixMode == 1) {
					Menu.menu(tabJoueur2, tabJoueur1);
				}
				if (choixMode == 2) {
					IaPlay.iaPlay(tabJoueur1, tabJoueur2);
				}
				
				
				System.out.println("Tour du joueur 1:");
				Menu.menu(tabJoueur1, tabJoueur2);
			}

			
		}
	}
	
	
}


