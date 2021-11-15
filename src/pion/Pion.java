package pion;

import java.util.Arrays;

public class Pion {

    int pos;
    String[] direction;
    int nbCase;
    String character;
    int joueur;
    int[] tabCanMoove;
    int[] tabCanEat;
    
    
	public void canMove(Pion[] tabJoueur1, Pion[] tabJoueur2) {
        for (Pion joueur : tabJoueur1) {
        	
		}
    	this.tabCanMoove = null;
    }
	public void canEat(Pion[] tabJoueur1, Pion[] tabJoueur2) {
        for (Pion joueur : tabJoueur1) {
        	
		}
        this.tabCanEat = null;
    }
	public Pion(int pos, String[] direction, int nbCase, String character, int joueur) {
		super();
		this.pos = pos;
		this.direction = direction;
		this.nbCase = nbCase;
		this.character = character;
		this.joueur = joueur;
		
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public String[] getDirection() {
		return direction;
	}
	public void setDirection(String[] direction) {
		this.direction = direction;
	}
	public int getNbCase() {
		return nbCase;
	}
	public void setNbCase(int nbCase) {
		this.nbCase = nbCase;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public int getJoueur() {
		return joueur;
	}
	public void setJoueur(int joueur) {
		this.joueur = joueur;
	}
	public int[] getTabCanMoove() {
		return tabCanMoove;
	}
	public void setTabCanMoove(int[] tabCanMoove) {
		this.tabCanMoove = tabCanMoove;
	}
	public int[] getTabCanEat() {
		return tabCanEat;
	}
	public void setTabCanEat(int[] tabCanEat) {
		this.tabCanEat = tabCanEat;
	}
	public String toString() {
		return "Pion [pos=" + pos + ", direction=" + Arrays.toString(direction) + ", nbCase=" + nbCase + ", character="
				+ character + ", joueur=" + joueur + ", tabCanMoove=" + Arrays.toString(tabCanMoove) + ", tabCanEat="
				+ Arrays.toString(tabCanEat) + "]";
	}
	
   

}
