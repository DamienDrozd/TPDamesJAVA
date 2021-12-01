package game;

import pion.Pion;
import utilitaires.Utilitaires;

public class Menu {
	public static Pion[][] menu(Pion[] tabJoueur1, Pion[] tabJoueur2) {
		
		for (int l = 0;l < tabJoueur1.length; l++) {
			tabJoueur1[l].canEat(tabJoueur1, tabJoueur2);
			tabJoueur1[l].canMove(tabJoueur1, tabJoueur2);
		}
		
		Score(tabJoueur1, tabJoueur2);
		System.out.print("couleur du joueur 1 : ");
		System.out.println(tabJoueur1[0].getCharacter());
		System.out.print("couleur du joueur 2 : ");
		System.out.println(tabJoueur2[0].getCharacter());
		Pion pionMoove = null;
		int intChoosedPion;
		while(pionMoove == null)
		{
			System.out.println("choisissez quel pion vous voulez dï¿½placer");
			intChoosedPion = Utilitaires.readInt();
			boolean cantplay = false;
			for (int i = 0;i<tabJoueur1.length; i++) {
				
				for (Pion j : tabJoueur1) { //test de pion pouvant manger un autre
					if (can(j.getTabCanEat()) == false) {
						if (intChoosedPion == j.getPos()) {
							cantplay = false;
							break;
						}
						cantplay = true;// si un pion peut manger et qu'il n'est pas sï¿½lï¿½ctionnï¿½ alors le joueur ne peut pas jouer
					}
				}
				if (tabJoueur1[i].getPos() == intChoosedPion && cantplay == false) {
					//test can mooved
					int[] canMove = tabJoueur1[i].getTabCanMoove();
					int[] canEat = tabJoueur1[i].getTabCanEat();
					
					
					
		
					if (can(canEat)) {
						canMove = canEat;//Le pion est forcé de manger un adversaire si il le peut

					}
					if (can(canMove)) {
						
						System.out.println("choisissez ou vous voulez dï¿½placer ce pion");
						int intNewPosPion = Utilitaires.readInt();
						
						for (int j : canMove) {
							
							if (j == intNewPosPion) {
								int oldPos = tabJoueur1[i].getPos();
								if (can(canEat)) {
									
									//tuer le pion mangé----------------------------------------------------
									int killPos = killPion(oldPos, intNewPosPion);
									
									for(int k = 0 ; k< tabJoueur2.length; k++) {
										if (tabJoueur2[k].getPos() == killPos) {
											tabJoueur2[k].setDead(true);
										}
									}
									
									for (int l = 0;l < tabJoueur1.length; l++) {
										tabJoueur1[l].canEat(tabJoueur1, tabJoueur2);
										tabJoueur1[l].canMove(tabJoueur1, tabJoueur2);
										if (Menu.can(tabJoueur1[l].getTabCanEat())){
											tabJoueur1[intChoosedPion].setPos(intNewPosPion);
											menu(tabJoueur1, tabJoueur2);
										}
									}
									
									
								}
								Utilitaires.addFile(Game.dateStr, "Joueur " + tabJoueur1[0].getJoueur() + " : " + oldPos +"  > "+intNewPosPion + "\n");
								tabJoueur1[i].setPos(intNewPosPion);
								Pion[][] tabReturn = {tabJoueur1, tabJoueur2};
								return tabReturn;
							}
						}
						System.out.println("ce pion ne peut pas etre deplace a cet endroit");
						continue;
					} else {
						System.out.println("ce pion ne peut pas etre deplace");
						continue;
					}
				}
			}
			
		}
		
		return null;
	}
	
	public static int killPion(int oldPos, int newPos)
	{
		int killPos = 0;
		killPos = ((newPos - oldPos)/2)+newPos;
		
		return killPos;
	}
	
	public static int menuModeGame()
	{
		
		int intChoosedMod = 0;
		while(intChoosedMod == 0)
		{
			System.out.println("choisissez votre mode de jeu:");
			System.out.println("1/ mode 1 joueur, ");
			System.out.println("2/ mode 2 joueurs ");
			intChoosedMod = Utilitaires.readInt();
			
			switch(intChoosedMod) {
				case 1:
					System.out.println("vous avez choisi le mode 1 joueur ");
					return 1;
				case 2:
					System.out.println("vous avez choisi le mode 2 joueurs ");
					return 2;
				default:
					System.out.println("Error, wrong input");
					intChoosedMod = 0;
					break;
			}
		}
		
		return 0;
	}

	public static boolean can(int[] canMove)
	{
		for (int nb : canMove) {
			if (nb != 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void Score(Pion[] tabJoueur1, Pion[] tabJoueur2)
	{
		int scoreJ1 = 0;
		int scoreJ2 = 0;

		for (Pion pion : tabJoueur1) {
			if (pion.isDead() == false) {
				scoreJ1++;
			}
		}
		for (Pion pion : tabJoueur2) {
			if (pion.isDead() == false) {
				scoreJ2++;
			}
		}
		
		System.out.println("Il reste "+ scoreJ1 + " pions au joueur 1");
		System.out.println("Il reste "+ scoreJ2 + " pions au joueur 2");
	}
	
}
