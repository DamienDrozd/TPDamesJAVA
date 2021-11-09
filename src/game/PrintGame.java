package game;

public class PrintGame {
	public static void printGame(char[] mapGame) {
		int y =0;
		for (int i = 0 ; i < mapGame.length; i++) {
			
			System.out.print("|  ");
			
			if(y%4==2 || y%4==3) {
				System.out.print("   |  ");
			}
			
			
			
			if (y%2 == 0) {
				System.out.print(i+1);
				System.out.print(" ");
			} else {
				System.out.print(mapGame[i]);
				System.out.print(" ");
			}
			
			if ((i<9) || (i>10 && y%2 != 0) || (y == 5) || (y == 3 && i==9)) {
				System.out.print(" ");
			}
			
			if(y%4==0 || (y%4==1)) {
				System.out.print("|     ");
			}
			
			
			
			if (((i+1)%5) == 0 && y%2==0 && i != 0) {
				y = y+1;
				System.out.print("|");
				System.out.print("\n");
				i = i-5;
				
				continue;
			}
			
			if ((i+1)%5 == 0 && y%2!=0) {
				y = y+1;
				System.out.print("|");
				System.out.print("\n");
				
				for (int k = 0; k< 10;k++) {
					System.out.print("------");
				}
				System.out.print("-\n");
				continue;
			}
		}
	}
}
