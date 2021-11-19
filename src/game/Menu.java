package game;

import pion.Pion;
import utilitaires.Utilitaires;

public class Menu {
	public static Pion[][] menu(Pion[] tabJoueur1, Pion[] tabJoueur2) {
		
		
		
		Pion pionMoove = null;
		int intChoosedPion;
		
		while(pionMoove == null)
		{
			System.out.println("choisissez quel pion vous voulez déplacer");
			intChoosedPion = Utilitaires.readInt();
			boolean cantplay = false;
			
			//tabJoueur1[15].setTabCanMoove(new int[]{21,22});//provisoire
			//tabJoueur1[15].setTabCanEat(new int[]{26,27});
		
			for (int i = 0;i<tabJoueur1.length; i++) {
				
				
				for (Pion j : tabJoueur1) { //test de pion pouvant manger un autre
					if (j.getTabCanEat() != null) {
						if (intChoosedPion == j.getPos()) {
							cantplay = false;
							break;
						}
						cantplay = true;// si un pion peut manger et qu'il n'est pas séléctionné alors le joueur ne peut pas jouer
					}
				}
				
				if (tabJoueur1[i].getPos() == intChoosedPion && cantplay == false) {
					
					
					//test can mooved
					
					int[] canMove = tabJoueur1[i].getTabCanMoove();
					int[] canEat = tabJoueur1[i].getTabCanEat();
					
					if (canEat != null) {
						canMove = canEat;//Le pion est forcé de manger un adversaire si il le peut
					}

					
					
					if (canMove != null) {
					
						System.out.println("choisissez ou vous voulez déplacer ce pion");
						int intNewPosPion = Utilitaires.readInt();
						
						for (int j : canMove) {
							
							if (j == intNewPosPion) {
								tabJoueur1[i].setPos(intNewPosPion);
								
								Pion[][] tabReturn = {tabJoueur1, tabJoueur2};
								
								return tabReturn;
								
							}
						}
						System.out.println("ce pion ne peut pas être déplacé a cet endroit");
						continue;
					} else {
						System.out.println("ce pion ne peut pas être déplacé");
						continue;
					}
				}
			}
			System.out.println("ce pion ne peut pas être déplacé");
		}
	
		return null;
		
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
}
