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



	
	public int[] canMove(Pion[] tabJoueur1, Pion[] tabJoueur2) {
		int[] can = new int[2];
		int turn = 1;
			if (turn%2 == 1){
				turn++;
				for (int i = 0; i<tabJoueur1.length-1;i++) {
					if (tabJoueur1[i].isDead != false ) {
						switch (tabJoueur1[i].pos) {
							//all of the border case
							case 41:
							case 31:
							case 21:
							case 11:
							case 1:
							case 50:
							case 40:
							case 30:
							case 20:
							case 10:
							if (tabJoueur1[i].pos - 5 != tabJoueur1[i].pos && tabJoueur1[i].pos - 5 != tabJoueur2[i].pos) {
								can = tabJoueur1[i].pos - 5;
								return can;
							}
							//all the case that can go left and right but with -4 or -5
							case 6:
							case 7:
							case 8:
							case 9:
							case 16:
							case 17:
							case 18:
							case 19:
							case 26:
							case 27:
							case 28:
							case 29:
							case 36:
							case 37:
							case 38:
							case 39:
							case 46:
							case 47:
							case 48:
							case 49:
							if (tabJoueur1[i].pos - 5 != tabJoueur1[i].pos && tabJoueur1[i].pos - 5 != tabJoueur2[i].pos) {
								can[0] = tabJoueur1[i].pos - 5;
							
								if (tabJoueur1[i].pos - 4 != tabJoueur1[i].pos && tabJoueur1[i].pos - 4 != tabJoueur2[i].pos) {
									can[1] = tabJoueur1[i].pos - 4;
								}
							return can;
							break;
						}
							
							case 12:
							case 13:
							case 14:
							case 15:
							case 22:
							case 23:
							case 24:
							case 25:
							case 32:
							case 33:
							case 34:
							case 35:
							case 42:
							case 43:
							case 44:
							case 45:
							if (tabJoueur1[i].pos - 5 != tabJoueur1[i].pos && tabJoueur1[i].pos - 5 != tabJoueur2[i].pos) {
								can[0] = tabJoueur1[i].pos - 5;
								if (tabJoueur1[i].pos - 6 != tabJoueur1[i].pos && tabJoueur1[i].pos - 6 != tabJoueur2[i].pos){
									can[1] = tabJoueur1[i].pos - 6;
								}
							return can;
							break;
						}
							

						}
					}
				}
			}
			else{
				turn++;
				for (int i = 0; i<tabJoueur2.length-1;i++) {
					if (tabJoueur2[i].isDead != false ) {
						switch (tabJoueur2[i].pos) {
							//all of the border case
							case 41:
							case 31:
							case 21:
							case 11:
							case 1:
							case 50:
							case 40:
							case 30:
							case 20:
							case 10:
							if (tabJoueur2[i].pos + 5 != tabJoueur2[i].pos && tabJoueur2[i].pos + 5 != tabJoueur1[i].pos) {
								can = tabJoueur2[i].pos - 5;
								return can;
							}
							//all the case that can go left and right but with -4 or -5
							case 6:
							case 7:
							case 8:
							case 9:
							case 16:
							case 17:
							case 18:
							case 19:
							case 26:
							case 27:
							case 28:
							case 29:
							case 36:
							case 37:
							case 38:
							case 39:
							case 46:
							case 47:
							case 48:
							case 49:
							if (tabJoueur2[i].pos + 5 != tabJoueur2[i].pos && tabJoueur2[i].pos + 5 != tabJoueur1[i].pos) {
								can[0] = tabJoueur1[i].pos - 5;
							
								if (tabJoueur2[i].pos + 4 != tabJoueur2[i].pos && tabJoueur2[i].pos + 4 != tabJoueur1[i].pos) {
									can[1] = tabJoueur2[i].pos + 4;
								}
							return can;
							break;
						}
							
							case 12:
							case 13:
							case 14:
							case 15:
							case 22:
							case 23:
							case 24:
							case 25:
							case 32:
							case 33:
							case 34:
							case 35:
							case 42:
							case 43:
							case 44:
							case 45:
							if (tabJoueur2[i].pos + 5 != tabJoueur2[i].pos && tabJoueur2[i].pos + 5 != tabJoueur1[i].pos) {
								can[0] = tabJoueur2[i].pos + 5;
								if (tabJoueur2[i].pos + 6 != tabJoueur2[i].pos && tabJoueur2[i].pos + 6 != tabJoueur1[i].pos){
									can[1] = tabJoueur2[i].pos + 6;
								}
							return can;
							break;
						}
						}
					}
				}
			}


	        // for (Pion joueur : tabJoueur1) {
			// 	if (this.isDead == false && this.joueur == '1' && (newpos[0] < this.pos)){
			// 		this.pos = newpos[0];
			// 		can = true;
			// 	} else {
			// 		if (this.isDead == false && this.joueur == '1' && (newpos[0] > this.pos));
			// 		this.pos = newpos[0];
			// 		can = true;
			// 	} 
			// }
			// for (Pion joueur : tabJoueur2) {
			// 	if (this.isDead == false && this.joueur == '2' && (newpos[0] < this.pos)){
			// 		this.pos = newpos[0];
			// 		can = true;
			// 	} else {
			// 		if (this.isDead == false && this.joueur == '2' && (newpos[0] > this.pos));
			// 		this.pos = newpos[0];
			// 		can = true;
			// 	} 
			// }
		}
    	this.tabCanMoove = null;
    }

	
		
	 public void canEat(Pion[] tabJoueur1, Pion[] tabJoueur2) {
         for (Pion joueur : tabJoueur1) {
	 	this.eat = false;
        int [] posApresManger = this.getPosManger(cible);
        
         int[] oldPos = getPos();
        
         if(posApresManger) && this.joueur != cible.joueur
                 && distanceValide(distanceAvec(cible))) {
             setPos(cible.getPos());

             if(this.canMove(posApresManger)) { 
                 cible.ate();
                 return true;
             }
             else {
                 setPos(oldPos);//on annule les changements
                 
                 return false;}
         } else {
             //System.out.print("mangeage échoué");
             return false;
         }
        	
	 	}
         this.tabCanEat = null;
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

	 