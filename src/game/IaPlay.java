package game;

import java.util.ArrayList;
import java.util.Map;

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
						System.out.println(j.getPos());
						
						if (Menu.canEat(j.getMapCanEat()) == true) {
							
							
							cantplay = true;// si un pion peut manger et qu'il n'est pas sï¿½lï¿½ctionnï¿½ alors le joueur ne peut pas jouer
							
						}
					}
					
					if (Menu.canEat(tabJoueur1[intChoosedPion].getMapCanEat()) == true) {
						cantplay = false;
					}
						
					ArrayList<Integer> canMove = tabJoueur1[intChoosedPion].getTabCanMoove();
					Map<Integer, ArrayList<Integer>> canEat = tabJoueur1[intChoosedPion].getMapCanEat();
					if (cantplay == false && (Menu.canMove(canMove) || Menu.canEat(canEat))) {
						//test can mooved
						
						
						int intNewPosPion = 0;
						Pion[][] tabReturn = {tabJoueur1, tabJoueur2};
						if (Menu.canEat(canEat)) {
							while (intNewPosPion == 0) {
								ArrayList<Integer> tab = null;
								if (canEat.size() != 0) {
									int j = 0;
									int k = (int)(Math.random() * ( canEat.size());
									
									for (int i : canEat.keySet()) {
										  j++;
										  if (j == k) {
											  tab = canEat.get(i);
										  }
									}
								}
								intNewPosPion = canEat.get(tab.getKey());

								if (intNewPosPion == 0) {
									continue;
								}
								if (Menu.canEat(canEat)) {
									
									for (Map.Entry<Integer, ArrayList<Integer>> nb : canEat.entrySet()) {
										
										if (nb.getKey() == intNewPosPion) {
										
											
											for(int k = 0 ; k< tabJoueur2.length; k++) {
												for(int l = 0 ; l< nb.getValue().size(); l++) {
													if (tabJoueur2[k].getPos() == nb.getValue().get(l)) {
														tabJoueur2[k].setDead(true);
														tabJoueur2[k].setPos(0);
														System.out.println("le joueur "+tabJoueur1[0].getJoueur()+" a mangé le pion "+ tabJoueur2[k].getPos());
														continue;
													}
												}
											}
											for (int i = 0;i < tabJoueur1.length; i++) {
												tabJoueur1[i].canEat(tabJoueur1, tabJoueur2);
												tabJoueur1[i].canMove(tabJoueur1, tabJoueur2);
											}
											tabJoueur1[intChoosedPion].setPos(intNewPosPion);
											tabReturn[0] = tabJoueur1;
											tabReturn[1] = tabJoueur2;
											return tabReturn;
//											if (Menu.canEat(PionToMove.getMapCanEat())){
//												
//												String[] mapGame = new String[(Game.tailleTabX*Game.tailleTabY)/2];
//												mapGame = Tab.remplirTab(mapGame, tabJoueur1, tabJoueur2);
//												PrintGame.printGame(mapGame);
//												menu(tabJoueur1, tabJoueur2);
//											}
										}
									}
								}
							}
							
						}
						if (Menu.canMove(canMove)) {
							
							while (intNewPosPion == 0) {
								intNewPosPion = canMove.get((int)(Math.random() * ( canMove.size() )));
								if (intNewPosPion == 0) {
									continue;
								}
								int oldPos = tabJoueur1[intChoosedPion].getPos();
								
								System.out.print("Joueur " + tabJoueur1[0].getJoueur() + " : " + oldPos+" > "+intNewPosPion+"\n");
								Utilitaires.addFile(Game.dateStr, "Joueur " + tabJoueur1[0].getJoueur() + " : " + oldPos+" > "+intNewPosPion+"\n");
								tabJoueur1[intChoosedPion].setPos(intNewPosPion);
								tabReturn[0] = tabJoueur1;
								tabReturn[1] = tabJoueur2;
								return tabReturn;
							}
							return tabReturn;
							 
						} 
					
				}
			}
			return null;
	}
}
