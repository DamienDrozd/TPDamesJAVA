package game;

import utilitaires.Utilitaires;

public class Game {
	
	static int tailleTabX = 10;
    static int tailleTabY = 10;
    
	
	public static void startGame() {
		boolean endGame = false;
		
		
	    char[] mapGame = new char[(tailleTabX*tailleTabY)/2];
	    mapGame = remplirTab(mapGame);
		
		//System.out.println("Choisissez votre mode de jeu:\n1/ Mode 1 joueur\n2/ Mode 2 joueurs");
		
		//int choixMode = Utilitaires.readInt();
		
		while(endGame != true) {
			
			printGame(mapGame);

			int choixPion = Utilitaires.readInt();
		
		}
	}
	
	public static void printGame(char[] mapGame) {
		int y =0;
		for (int i = 0 ; i < mapGame.length; i++) {
			
			System.out.print("| ");
			
			
			
			if (y%2 == 0) {
				System.out.print(i+1);
				System.out.print(" ");
			} else {
				System.out.print(mapGame[i]);
				System.out.print(" ");
			}
			
			if (i<9 || (i>=10 && y%2 != 0) || (y == 5)) {
				System.out.print(" ");
			}
			
			
			
			if (((i+1)%5) == 0 && y%2==0 && i != 0) {
				y = y+1;
				System.out.print("| ");
				System.out.print("\n");
				i = i-5;
				continue;
			}
			if ((i+1)%5 == 0 && y%2!=0) {
				y = y+1;
				System.out.print("| ");
				System.out.print("\n");
				continue;
			}
		}
	}
	
	public static char[] remplirTab(char[] mapGame) {
		for (int x = 0; x < (tailleTabX * tailleTabY)/2; x++ ) {
			mapGame[x] = '.';
		}
		return mapGame;
	}

}
