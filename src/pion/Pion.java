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
						
							//all of the border case
							/*case 41:
							case 31:
							case 21:
							case 11:
							case 1:
							case 50:
							case 40:
							case 30:
							case 20:
							case 10:*/
						if(tabJoueur1[i].pos%10 == 0 || String.valueOf(tabJoueur1[i].pos) == "1"){
							for (int j = 0; j < 19;j++){
								if (tabJoueur1[i].pos - 5 == tabJoueur1[j].pos && tabJoueur1[i].pos - 5 == tabJoueur2[j].pos) {
									return null;

								} else {
									can[0] = tabJoueur1[i].pos - 5;
									return can;
								}
							}
						} else if ((tabJoueur1[i].pos >=6 && tabJoueur1[i].pos <=9 ) || (tabJoueur1[i].pos >=16 && tabJoueur1[i].pos <=19 ) || (tabJoueur1[i].pos >=26 && tabJoueur1[i].pos <=29 ) || (tabJoueur1[i].pos >=36 && tabJoueur1[i].pos <=39 ) || (tabJoueur1[i].pos >=46 && tabJoueur1[i].pos <=49 )){
							//all the case that can go left and right but with -4 or -5
							
						} else if ((tabJoueur1[i].pos >=6 && tabJoueur1[i].pos <=9 ) && (tabJoueur1[i].pos >=16 && tabJoueur1[i].pos <=19 ) && (tabJoueur1[i].pos >=26 && tabJoueur1[i].pos <=29 ) && (tabJoueur1[i].pos >=36 && tabJoueur1[i].pos <=39 ) && (tabJoueur1[i].pos >=46 && tabJoueur1[i].pos <=49 )){
							for (int j = 0; j < 19;j++){
								if (tabJoueur1[i].pos - 5 == tabJoueur1[j].pos && tabJoueur1[i].pos - 5 == tabJoueur2[j].pos && tabJoueur1[i].pos - 4 == tabJoueur1[j].pos && tabJoueur1[i].pos - 4 == tabJoueur2[j].pos) {
									return null;
								}
								if (tabJoueur1[i].pos - 5 != tabJoueur1[j].pos && tabJoueur1[i].pos - 5 != tabJoueur2[j].pos) {
										can[0] = tabJoueur1[i].pos - 5;
										if ( tabJoueur1[i].pos - 4 != tabJoueur1[j].pos && tabJoueur1[i].pos - 4 == tabJoueur2[j].pos){
											can[1] = tabJoueur1[i].pos - 4;
									}
								return can;
								}
							}
						}else if (tabJoueur1[i].pos >=12 && tabJoueur1[i].pos <=15 || tabJoueur1[i].pos >=22 && tabJoueur1[i].pos <=25 || tabJoueur1[i].pos >=32 && tabJoueur1[i].pos <=35 || tabJoueur1[i].pos >=42 && tabJoueur1[i].pos <=45) {
							for (int j = 0; j < 19;j++){
								if (tabJoueur1[i].pos - 5 == tabJoueur1[j].pos && tabJoueur1[i].pos - 5 == tabJoueur2[j].pos && tabJoueur1[i].pos - 6 == tabJoueur1[j].pos && tabJoueur1[i].pos - 6 == tabJoueur2[j].pos) {
									return null;
								}
							if (tabJoueur1[i].pos - 5 != tabJoueur1[j].pos || tabJoueur1[i].pos - 5 != tabJoueur2[j].pos) {
								can[0] = tabJoueur1[i].pos - 5;
								if (tabJoueur1[i].pos - 6 != tabJoueur1[j].pos && tabJoueur1[i].pos - 6 != tabJoueur2[j].pos){
									can[1] = tabJoueur1[i].pos - 6;
								}
							return can;
							}
						}
						}
					}
				}

				}else{
				turn++;
				for (int q = 0; q<tabJoueur2.length-1;q++) {
					if (tabJoueur2[q].isDead != false ) {
							//all of the border case
						if(tabJoueur2[q].pos%10 == 0 || String.valueOf(tabJoueur2[q].pos) == "1"){
							for (int j = 0; j < 19;j++){
								if (tabJoueur2[q].pos + 5 == tabJoueur2[j].pos && tabJoueur2[q].pos + 5 == tabJoueur1[j].pos) {
									return null;

								} else {
									can[0] = tabJoueur2[q].pos + 5;
									return can;

								}
							}
						}
							//all the case that can go left and right but with -4 or -5
							else if ((tabJoueur2[q].pos >=6 && tabJoueur2[q].pos <=9 ) && (tabJoueur2[q].pos >=16 && tabJoueur2[q].pos <=19 ) && (tabJoueur2[q].pos >=26 && tabJoueur2[q].pos <=29 ) && (tabJoueur2[q].pos >=36 && tabJoueur2[q].pos <=39 ) && (tabJoueur2[q].pos >=46 && tabJoueur2[q].pos <=49 ))
							for (int j = 0; j < 19;j++){
								if (tabJoueur2[q].pos + 5 == tabJoueur2[j].pos && tabJoueur2[q].pos + 5 == tabJoueur1[j].pos && tabJoueur2[q].pos + 4 == tabJoueur2[j].pos && tabJoueur2[q].pos + 4 == tabJoueur1[j].pos) {
									return null;

								}
							if (tabJoueur2[q].pos + 5 != tabJoueur2[j].pos && tabJoueur2[q].pos + 5 != tabJoueur1[j].pos) {
								can[0] = tabJoueur2[q].pos + 5;
							
								if (tabJoueur2[q].pos + 4 != tabJoueur2[j].pos && tabJoueur2[q].pos + 4 != tabJoueur1[j].pos) {
									can[1] = tabJoueur2[q].pos + 4;
								}
							return can;

						}
							}
							else if (tabJoueur2[q].pos >=12 && tabJoueur2[q].pos <=15 || tabJoueur2[q].pos >=22 && tabJoueur2[q].pos <=25 || tabJoueur2[q].pos >=32 && tabJoueur2[q].pos <=35 || tabJoueur2[q].pos >=42 && tabJoueur2[q].pos <=45)
							
							for (int j = 0; j < 19;j++){
								if (tabJoueur2[q].pos + 5 == tabJoueur2[j].pos && tabJoueur2[q].pos + 5 == tabJoueur1[j].pos && tabJoueur2[q].pos + 6 == tabJoueur2[j].pos && tabJoueur2[q].pos + 6 == tabJoueur1[j].pos) {
									return null;

								}
							if (tabJoueur2[q].pos + 5 != tabJoueur2[j].pos && tabJoueur2[q].pos + 5 != tabJoueur1[j].pos) {
								can[0] = tabJoueur2[q].pos + 5;
								if (tabJoueur2[q].pos + 6 != tabJoueur2[j].pos && tabJoueur2[q].pos + 6 != tabJoueur1[j].pos){
									can[1] = tabJoueur2[q].pos + 6;
								}
							return can;

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
			
			return can;
		}
    	

	
		
	 public void canEat(Pion[] tabJoueur1, Pion[] tabJoueur2) {
		 
	 }
	}
		 
	 
//          for (Pion joueur : tabJoueur1) {
// 	 	this.eat = false;
//         int [] posApresManger = this.getPosManger(cible);
        
//          int[] oldPos = getPos();
        
//          if(posApresManger) && this.joueur != cible.joueur
//                  && distanceValide(distanceAvec(cible))) {
//              setPos(cible.getPos());

//              if(this.canMove(posApresManger)) { 
//                  cible.ate();
//                  return true;
//              }
//              else {
//                  setPos(oldPos);//on annule les changements
                 
//                  return false;}
//          } else {
//              //System.out.print("mangeage échoué");
//              return false;
//          }
        	
// 	 	}
//          this.tabCanEat = null;
//      }



	
//    public int[] getPosManger(Pion cible){
//         int[] mangerpos = new int[2];
//         int k=0;
//         if(this. <= cible.coordX )
//             k = 1;
//         else
//             k = -1; // cas 2 => Cible est à gauche de pion
//         if(this.coordY <= cible.coordY)
//             j = -1; // cas 1 => Cible est en dessus de pion
//         else
//             j = 1; // cas 2 => Cible est au dessous de pion

//         if(k==1)
//             mangerpos[0]=(cible.coordX+1);
//         else
//             mangerpos[0]=(cible.coordX-1);
//         if(j==1)
//             mangerpos[1]=(cible.coordY-1);
//         else
//             mangerpos[1]=(cible.coordY+1);

//         //System.out.println("position pion :"+this.coordX+" "+this.coordY);
//         //System.out.println("position cible: "+mangerpos[0]+" "+mangerpos[1]);
//         return mangerpos;
//     }
// 	public boolean stillAlive() {
// 	    return !typePion.equals("mort");
	    
// 	}
	
// 	public void ate() {
// 		if(!stillAlive()) {
// 			System.out.println("a pion has been eat");
// 		this.typePion = "mort";
// 		}
// 	}

	 