package pion;

import java.util.Arrays;

public class Pion {

    int pos;
    String[] direction;
    int nbCase;
    String character;
	String type;
	int joueur;
    int[] tabCanMoove;
    int[] tabCanEat;
    boolean isDead = false;
    
    
	
	
	public Pion(int pos, String[] direction, int nbCase, String character, String type, int joueur, 
			int[] tabCanMoove, int[] tabCanEat, boolean isDead) {
		super();
		this.pos = pos;
		this.direction = direction;
		this.nbCase = nbCase;
		this.character = character;
		this.type = type;
		this.joueur = joueur;
		this.tabCanMoove = tabCanMoove;
		this.tabCanEat = tabCanEat;
		this.isDead = isDead;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	public String toString() {
		return "Pion [pos=" + pos + ", direction=" + Arrays.toString(direction) + ", nbCase=" + nbCase + ", character="
				+ character + ", type=" + type + ", joueur=" + joueur + ", eat="  + ", tabCanMoove="
				+ Arrays.toString(tabCanMoove) + ", tabCanEat=" + Arrays.toString(tabCanEat) + ", isDead=" + isDead
				+ "]";
	}



	/**
	public void canMove(Pion[] tabJoueur1, Pion[] tabJoueur2) {
		boolean can = false;
		for(int i = 0; i<50;i++) {
	        for (Pion joueur : tabJoueur1) {
				if (this.isDead == false && this.joueur1 == true && (newpos[0] < this.pos)){
					this.pos = newpos[0];
					can = true;
				} else {
					if (this.isDead == false && this.joueur1 == false && (newpos[0] > this.pos));
					this.pos = newpos[0];
					can = true;
				} 
			}
			for (Pion joueur : tabJoueur2) {
				if (this.isDead == false && this.joueur1 == true && (newpos[0] < this.pos)){
					this.pos = newpos[0];
					can = true;
				} else {
					if (this.isDead == false &&this.joueur1 == false && (newpos[0] > this.pos));
					this.pos = newpos[0];
					can = true;
				} 
			}
		}
    	this.tabCanMoove = null;
    }
	 */
	/**
	//	non fonctionnel encore 
	 public void canEat(Pion[] tabJoueur1, Pion[] tabJoueur2) {
    //     for (Pion joueur : tabJoueur1) {
	// 	this.eat = false;
    //     int [] posApresManger = this.getPosManger(cible);
        
    //     int[] oldPos = getPos();
        
    //     if(!cible.isInvicible() && plateau.estVide(posApresManger) && this.joueur != cible.joueur
    //             && distanceValide(distanceAvec(cible))) {
    //         setPos(cible.getPos());

    //         if(this.canMove(posApresManger)) { 
    //             cible.ate();
    //             return true;
    //         }
    //         else {
    //             setPos(oldPos);//on annule les changements
    //             System.out.println("Erreur: impossible de manger vers cette case");
    //             return false;}
    //     } else {
    //         //System.out.print("mangeage échoué");
    //         return false;
    //     }
        	
	// 	}
    //     this.tabCanEat = null;
     }



	
   public int[] getPosManger(Pion cible){
        int[] mangerpos = new int[2];
        int k=0;
        if(this. <= cible.coordX )
            k = 1;
        else
            k = -1; // cas 2 => Cible est à gauche de pion
        if(this.coordY <= cible.coordY)
            j = -1; // cas 1 => Cible est en dessus de pion
        else
            j = 1; // cas 2 => Cible est au dessous de pion

        if(k==1)
            mangerpos[0]=(cible.coordX+1);
        else
            mangerpos[0]=(cible.coordX-1);
        if(j==1)
            mangerpos[1]=(cible.coordY-1);
        else
            mangerpos[1]=(cible.coordY+1);

        //System.out.println("position pion :"+this.coordX+" "+this.coordY);
        //System.out.println("position cible: "+mangerpos[0]+" "+mangerpos[1]);
        return mangerpos;
    }
	public boolean stillAlive() {
	    return !typePion.equals("mort");
	    
	}
	
	public void ate() {
		if(!stillAlive()) {
			System.out.println("a pion has been eat");
		this.typePion = "mort";
		}
	}

	 */
	
	
	public int[] canEat(Pion[] tabJoueur1, Pion[] tabJoueur2) {
		
		return null;
	}
	
	public int[] canMove(Pion[] tabJoueur1, Pion[] tabJoueur2) {
		
		return null;
	}
}
	
	





	
