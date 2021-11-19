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
							int intNewPosPion = canMove[(int)(Math.random() * ( canMove.length ))];
							tabJoueur1[i].setPos(intNewPosPion);
							Pion[][] tabReturn = {tabJoueur1, tabJoueur2};
							return tabReturn;
						} 
					}
				}
			}
			return null;
	}
}
