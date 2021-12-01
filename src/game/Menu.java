package game;

import java.util.ArrayList;
import java.util.Map;

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
			Pion PionToMove = null;
				
				for (Pion j : tabJoueur1) { //test de pion pouvant manger un autre
					if (canEat(j.getMapCanEat()) == true) {
						
						cantplay = true;// si un pion peut manger et qu'il n'est pas sï¿½lï¿½ctionnï¿½ alors le joueur ne peut pas jouer
					}
					if (intChoosedPion == j.getPos()) {
						 PionToMove = j;
					}
				}
				if ( PionToMove != null) {
					if (canEat(PionToMove.getMapCanEat()) == true) {
						cantplay = false;
					}
				}
				
					
				
				
				
				if (PionToMove.getPos() == intChoosedPion && cantplay == false) {
					//test can mooved
					ArrayList<Integer> canMove = PionToMove.getTabCanMoove();
					Map<Integer, ArrayList<Integer>> canEat = PionToMove.getMapCanEat();
					
					System.out.println(PionToMove.getPos());
					System.out.println("tabcaneat");
					Utilitaires.PrintMap(PionToMove.getMapCanEat());
					System.out.println("TabCanMoove");
					Utilitaires.PrintTab(PionToMove.getTabCanMoove());
					
					System.out.println(PionToMove.getPos());
					Utilitaires.PrintMap(canEat);
					
					
					
		
					if (canEat(canEat)) {
						System.out.println("choisissez ou vous voulez dï¿½placer ce pion");
						int intNewPosPion = Utilitaires.readInt();
						
						for (Map.Entry<Integer, ArrayList<Integer>> nb : canEat.entrySet()) {
							
							if (nb.getKey() == intNewPosPion) {
							
								
								for(int k = 0 ; k< tabJoueur2.length; k++) {
									for(int l = 0 ; l< nb.getValue().size(); l++) {
										if (tabJoueur2[k].getPos() == nb.getValue().get(l)) {
											tabJoueur2[k].setDead(true);
											System.out.println("le joueur "+tabJoueur1[0].getJoueur()+" a mangé le pion "+ tabJoueur2[k].getPos());
											continue;
										}
									}
								}
								for (int i = 0;i < tabJoueur1.length; i++) {
									tabJoueur1[i].canEat(tabJoueur1, tabJoueur2);
									tabJoueur1[i].canMove(tabJoueur1, tabJoueur2);
								}
								PionToMove.setPos(intNewPosPion);
								Pion[][] tabReturn = {tabJoueur1, tabJoueur2};
								return tabReturn;
//								if (Menu.canEat(PionToMove.getMapCanEat())){
//									
//									String[] mapGame = new String[(Game.tailleTabX*Game.tailleTabY)/2];
//									mapGame = Tab.remplirTab(mapGame, tabJoueur1, tabJoueur2);
//									PrintGame.printGame(mapGame);
//									menu(tabJoueur1, tabJoueur2);
//								}
							}
						}
						
						System.out.println("ce pion ne peut pas etre deplace a cet endroit");
						continue;
							
					}
					if (canMove(canMove) && canEat(canEat) == false) {
						
						System.out.println("choisissez ou vous voulez dï¿½placer ce pion");
						int intNewPosPion = Utilitaires.readInt();
						
						for (int j : canMove) {
							
							if (j == intNewPosPion) {
								int oldPos = PionToMove.getPos();
								
								Utilitaires.addFile(Game.dateStr, "Joueur " + tabJoueur1[0].getJoueur() + " : " + oldPos +"  > "+intNewPosPion + "\n");
								PionToMove.setPos(intNewPosPion);
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

	public static boolean canMove(ArrayList<Integer> canMove)
	{
		for (int nb : canMove) {
			if (nb != 0) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean canEat( Map<Integer, ArrayList<Integer>> canMove)
	{
		for (Map.Entry<Integer, ArrayList<Integer>> nb : canMove.entrySet()) {
			if (nb.getKey() != 0) {
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
