package utilitaires;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;
import pion.Pion;

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
	
	public static void createFile(String Name) {
	
		try {
	      FileWriter fw = new FileWriter(Name+".txt");
	      fw.write("Déroulement de la partie\n");
	      fw.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	public static void addFile(String Name, String strAdd) {
		
		try {
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(Paths.get(Name+".txt"), APPEND));
            // Ecrire dans le fichier
            output.write(strAdd.getBytes());
            // vider le tampon
            output.flush();
            // fermer le fichier
            output.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	public static void PrintTab(ArrayList<Integer> tab) {
		System.out.print("tab: ");
		for (int i = 0; i < tab.size(); i++) {
		      System.out.println(tab.get(i)+", ");
		 }
		System.out.print("\n");
	
	}
	
	public static void PrintMap(Map<Integer, ArrayList<Integer>> map) {
		System.out.print("map: ");
		for (Map.Entry<Integer, ArrayList<Integer>> tab : map.entrySet()) {
			System.out.print(tab.getKey()+", " );
			for (int i = 0; i < tab.getValue().size(); i++) {
			      System.out.println(tab.getValue().get(i));
			    }
			System.out.print(" / ");
		}
		System.out.print("\n");
	}
	
	
	 
	 

	
}
