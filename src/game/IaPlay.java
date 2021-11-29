package game;

import pion.Pion;
import utilitaires.Utilitaires;

public class IaPlay {
	public static Pion[][] iaPlay(Pion[] tabJoueur1, Pion[] tabJoueur2) {
			Pion pionMoove = null;
			int intChoosedPion;
			while(pionMoove == null)
			{
				intChoosedPion = (int) (Math.random() * ( 20 - 1 ));
				boolean cantplay = false;
				for (int i = 0;i<tabJoueur1.length; i++) {
					for (Pion j : tabJoueur1) { //test de pion pouvant manger un autre
						if (j.getTabCanEat() != null && (j.getTabCanEat()[0] != 0 || j.getTabCanEat()[1] != 0)) {
							if (intChoosedPion == j.getPos()) {
								cantplay = false;
								break;
							}
							cantplay = true;// si un pion peut manger et qu'il n'est pas séléctionné alors le joueur ne peut pas jouer
						}
					}
//					
					if (i == intChoosedPion && cantplay == false) {
						//test can mooved
						int[] canMove = tabJoueur1[i].getTabCanMoove();
						int[] canEat = tabJoueur1[i].getTabCanEat();
						if (canEat != null && (canEat[0] != 0 || canEat[1] != 0 )) {
							canMove = canEat;//Le pion est forcé de manger un adversaire si il le peut
						}
						
						if (canMove != null && (canMove[0] != 0 || canMove[1] != 0 )) {
							int intNewPosPion = 0;
							Pion[][] tabReturn = {tabJoueur1, tabJoueur2};
							while (intNewPosPion == 0) {
								intNewPosPion = canMove[(int)(Math.random() * ( canMove.length ))];
								tabJoueur1[i].setPos(intNewPosPion);
								System.out.println(intNewPosPion);
								
								
							}
							return tabReturn;
							 
						} 
					}
				}
			}
			return null;
	}
}
