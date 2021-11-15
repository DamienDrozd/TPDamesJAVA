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
		
			for (int i = 0;i<tabJoueur1.length; i++) {
				if (tabJoueur1[i].getPos() == intChoosedPion) {
					//test can mooved
					
					System.out.println("choisissez ou vous voulez déplacer ce pion");
					int intNewPosPion = Utilitaires.readInt();
					tabJoueur1[i].setPos(intNewPosPion);
					
					
					
					Pion[][] tabReturn = {tabJoueur1, tabJoueur2};
					return tabReturn;
				}
			}
		}
	
		return null;
		
	}
}
