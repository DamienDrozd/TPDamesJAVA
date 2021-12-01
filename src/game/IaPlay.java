package game;

import pion.Pion;
import utilitaires.Utilitaires;

public class IaPlay {
	public static Pion[][] iaPlay(Pion[] tabJoueur1, Pion[] tabJoueur2) {
			Pion pionMoove = null;
			int intChoosedPion;
			for (int l = 0;l < tabJoueur1.length; l++) {
				tabJoueur1[l].canEat(tabJoueur1, tabJoueur2);
				tabJoueur1[l].canMove(tabJoueur1, tabJoueur2);
			}
			while(pionMoove == null)
			{
				intChoosedPion = (int) (Math.random() * ( 20 - 1 ));
				boolean cantplay = false;

					for (Pion j : tabJoueur1) { //test de pion pouvant manger un autre
						if (Menu.can(j.getTabCanEat())) {
							if (tabJoueur1[intChoosedPion].getPos() == j.getPos()) {
								cantplay = false;
								break;
							}
							cantplay = true;// si un pion peut manger et qu'il n'est pas séléctionné alors le joueur ne peut pas jouer
					}
						
					int[] canMove = tabJoueur1[intChoosedPion].getTabCanMoove();
					int[] canEat = tabJoueur1[intChoosedPion].getTabCanEat();
					if (cantplay == false && (Menu.can(canMove) || Menu.can(canEat))) {
						//test can mooved
						
						Utilitaires.PrintTab(canMove);
						
						
						if (Menu.can(canEat)) {
							canMove = canEat;//Le pion est forcé de manger un adversaire si il le peut
							
						}
						if (Menu.can(canMove)) {
							int intNewPosPion = 0;
							Pion[][] tabReturn = {tabJoueur1, tabJoueur2};
							while (intNewPosPion == 0) {
								intNewPosPion = canMove[(int)(Math.random() * ( canMove.length ))];
								int oldPos = tabJoueur1[intChoosedPion].getPos();
								if (Menu.can(canEat)) {
									
									//tuer le pion mangé----------------------------------------------------
									int killPos = Menu.killPion(oldPos, intNewPosPion);
									
									for(int k = 0 ; k< tabJoueur2.length; k++) {
										if (tabJoueur2[k].getPos() == killPos) {
											tabJoueur2[k].setDead(true);
										}
									}
									
									for (int i = 0;i < tabJoueur1.length; i++) {
										tabJoueur1[i].canEat(tabJoueur1, tabJoueur2);
										tabJoueur1[i].canMove(tabJoueur1, tabJoueur2);
										if (Menu.can(tabJoueur1[i].getTabCanEat())){
											tabJoueur1[intChoosedPion].setPos(intNewPosPion);
											tabReturn[0] = tabJoueur1;
											tabReturn[1] = tabJoueur2;
											iaPlay(tabJoueur1, tabJoueur2);
										}
									}
								}
								System.out.print("Joueur " + tabJoueur1[0].getJoueur() + " : " + oldPos+" > "+intNewPosPion+"\n");
								Utilitaires.addFile(Game.dateStr, "Joueur " + tabJoueur1[0].getJoueur() + " : " + oldPos+" > "+intNewPosPion+"\n");
								tabJoueur1[intChoosedPion].setPos(intNewPosPion);
								return tabReturn;
							}
							return tabReturn;
							 
						} 
					}
				}
			}
			return null;
	}
}
