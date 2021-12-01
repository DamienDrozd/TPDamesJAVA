package game;

import pion.Pion;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import pion.Men;
import pion.King;
import utilitaires.Utilitaires;

public class Game {
	
	static int tailleTabX = 10;
    static int tailleTabY = 10;
    static int nbPions = 20;
 // current date
    static DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
    static Date date = new Date();        
    static String dateStr = dateFormat.format(date);
    
	
	public static void startGame() {
		boolean endGame = false;
		
		Pion[] tabJoueur1 = new Pion[nbPions];
		Pion[] tabJoueur2 = new Pion[nbPions];
		
		Utilitaires.createFile(Game.dateStr);
		
		int nbTour = 0;
		
		
		
		//choix aléatoire des couleurs
		int couleurInt = (int) (1 + Math.random() * ( 3-1 ));
		for (int i=0;i<nbPions;i++) {
			
			if (couleurInt == 1) {
				tabJoueur1[i] = new Men(50-i,null, 0,  "o", "Men", 1 , null , null, false);
				tabJoueur2[i] = new Men(i+1,null, 0,  "x", "Men", 2, null , null, false);
			}
			if (couleurInt == 2) {
				tabJoueur1[i] = new Men(50-i,null, 0,  "x", "Men", 1, null , null, false);
				tabJoueur2[i] = new Men(i+1,null, 0,  "o", "Men", 2 , null , null, false);
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
			
			nbTour++;
			
			Utilitaires.addFile(dateStr, "Tour " + nbTour + " :\n");

			
			/*Tab.isDame(tabJoueur1,tabJoueur2);*/
			
			for (int i = 0;i < tabJoueur1.length; i++) {
				tabJoueur1[i].canEat(tabJoueur1, tabJoueur2);
				tabJoueur1[i].canMove(tabJoueur1, tabJoueur2);
				
			}
			for (int i = 0;i < tabJoueur2.length; i++) {
				tabJoueur2[i].canEat(tabJoueur1, tabJoueur2);
				tabJoueur2[i].canMove(tabJoueur1, tabJoueur2);
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
				
				mapGame = Tab.remplirTab(mapGame, tabJoueur1, tabJoueur2);
				
				PrintGame.printGame(mapGame);
				
				System.out.println("Tour du joueur 2:");
				if (choixMode == 1) {
					IaPlay.iaPlay(tabJoueur2, tabJoueur1);
				}
				if (choixMode == 2) {
					Menu.menu(tabJoueur2, tabJoueur1);
				}
			}
			if (couleurInt == 2) {
				//joueur 2 en premier
				
				System.out.println("Tour du joueur 2:");
				if (choixMode == 1) {
					IaPlay.iaPlay(tabJoueur2, tabJoueur1);
				}
				if (choixMode == 2) {
					Menu.menu(tabJoueur2, tabJoueur1);
				}
				
				mapGame = Tab.remplirTab(mapGame, tabJoueur1, tabJoueur2);
				
				PrintGame.printGame(mapGame);
				
				
				System.out.println("Tour du joueur 1:");
				Menu.menu(tabJoueur1, tabJoueur2);
			}

			
		}
	}
	
	
}


