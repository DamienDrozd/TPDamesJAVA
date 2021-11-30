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



	
	public void canMove(Pion[] tabJoueur1, Pion[] tabJoueur2) {
		int[] can = new int[2];
		
	for (int i = 0; i<tabJoueur1.length-1;i++) {
		if (this.isDead == false ) {
			
//---------------------------------------------------- pour les pions sur le cot�
			if(this.getPos()%10 == 0 || (this.getPos()-1)%10 == 0 ){
                if (this.joueur == 1) {
                	if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 5)) != false) {
						can[0] = this.getPos() - 5;
					}
                	this.setTabCanMoove(can);
					System.out.print(this.getPos());
					return ;
           
				} else if (this.joueur == 2) {
					if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 5)) != false) {
						can[0] = this.getPos() + 5;
						this.setTabCanMoove(can);
						return ;
					}
				}
			}
							

//---------------------------------------------------- pour les pions sur le cote
			if(this.getPos()%10 == 0 || (this.getPos()-1)%10 == 0 ){
				
                if (this.joueur == 1) {
                	if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 5)) != false) {
						can[0] = this.getPos() - 5;
						System.out.print(this.getPos());
						this.setTabCanMoove(can);
						return ;
					}
           
				} else if (this.joueur == 2) {
					if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 5)) != false) {
						can[0] = this.getPos() + 5;
						this.setTabCanMoove(can);
						return ;
					}
				}	
			}

//---------------------------------------------------pions sur les colonnes impaires----------------
			if (this.getPos()%10 > 5) {
				if (this.joueur == 1) {
                    if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 5)) != false) {
						can[0] = this.getPos() - 5;
                    }
					if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 4)) != false){
						can[1] = this.getPos() - 4;
					}
					this.setTabCanMoove(can);
					System.out.print(this.getPos());
					return ;
					
				} else if (this.joueur == 2) {
                    if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 5)) != false) {
							can[0] = this.getPos() + 5;
                    }
					if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 6)) != false){
						can[1] = this.getPos() + 6;
					}
					this.setTabCanMoove(can);
					return ;
						
				}
			}
//---------------------------------------------------pions sur les colonnes paires----------------
			if (this.getPos()%10 <= 5) {
				if (this.joueur == 1) {
					if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 6)) != false) {
						can[0] = this.getPos() - 6;
					}
					if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 5)) != false){
						can[1] = this.getPos() - 5;
					}
					System.out.print(this.getPos());
					this.setTabCanMoove(can);
					return ;
				} else if (this.joueur == 2) {
					if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 5)) != false) {
						can[0] = this.getPos() + 5;
					}
					if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 4)) != false){
						can[1] = this.getPos() + 4;
					}
					this.setTabCanMoove(can);
					return ;
					
				}
			}
		}
	
	}			
	this.setTabCanMoove(can);
}


			
	public boolean testPos(Pion[] tabJoueur1, Pion[] tabJoueur2, int posToTest) {
    	for (int i=0; i < tabJoueur1.length - 1;i++){
            if (tabJoueur1[i].getPos() == posToTest || tabJoueur2[i].getPos() == posToTest) {
            	return false;
            }
    	}
    	return true;
	}

	
		
	 public void canEat(Pion[] tabJoueur1, Pion[] tabJoueur2) {
		 int[] prohibited = new int[] {1, 11 , 21 , 31 , 41, 10, 20, 30, 40 , 50};
		 
		 int[] canE = new int[4];
//---------------------------------------------------pions sur les colonnes impaires----------------
		 if (this.getPos()%10 <= 5) {
			 if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 5)) == false || testPos(tabJoueur1,tabJoueur2, (this.getPos() - 6)) == false || testPos(tabJoueur1,tabJoueur2, (this.getPos() + 5)) == false || (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 6)) == false ) )
			  {
				System.out.println("possible de manger");
				for (int i = 0; i < prohibited.length-1; i++) {
					if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 5)) == false && (this.getPos() - 5) != prohibited[i]) {
						if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 9)) != false) {
							canE[0] = this.getPos() - 9;
						}
					} else if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 6)) == false && (this.getPos() - 6) != prohibited[i]) {
						if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 11)) != false ) {
							canE[1] = this.getPos() - 11;
						}
					}
					
					if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 5)) == false && (this.getPos() + 5) != prohibited[i]) {
						if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 9)) != false) {
							canE[2] = this.getPos() + 9;
						}
						
					} else if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 6)) == false && (this.getPos() + 6) != prohibited[i]) {
						if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 11)) != false ) {
							canE[3] = this.getPos() + 11;
						}
					}
				this.setTabCanEat(canE);
				return ;
				}
			}
		} 
//---------------------------------------------------pions sur les colonnes paires----------------
		else if (this.getPos()%10 > 5) { //Diag similaire == +/- 9 ou +/- 11
			if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 5)) == false || (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 6))) == false || (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 5))) == false || (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 6))) == false)
			  {
				System.out.println("possible de manger");
				for (int i = 0; i < prohibited.length-1; i++) {
					if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 5)) == false && (this.getPos() - 5) != prohibited[i]) {
						if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 9)) != false) {
							canE[0] = this.getPos() - 9;
						} 
					} else if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 6)) == false && (this.getPos() - 6) != prohibited[i]) {
						if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 11)) != false ) {
							canE[1] = this.getPos() - 11;
						}
					}
					
					if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 5)) == false && (this.getPos() + 5) != prohibited[i]) {
						if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 9)) != false) {
							canE[2] = this.getPos() + 9;
						}
						
					} else if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 6)) == false && (this.getPos() + 6) != prohibited[i]) {
						if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 11)) != false ) {
							canE[3] = this.getPos() + 11;
						}
					}
					this.setTabCanEat(canE);
					return ;
				}
		 }
	 }
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

	 