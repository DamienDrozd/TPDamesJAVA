package utilitaires;

import java.util.Scanner;

public class Utilitaires {
	
	
	public static int readInt(){
        int i = 0 ;
        Scanner sc = new Scanner(System.in);
        try {
        	i = sc.nextInt();
        } catch(Exception e) {
        	
        }

        return i;
    }
	
	
}
