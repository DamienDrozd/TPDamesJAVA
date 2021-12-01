package pion;

import java.util.Arrays;

public class Pion {

    int pos;
    String[] direction;
    int nbCase;
    String character;
	String type = "pion";
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


// ajouter dansune map la pos du pion qui se fait manger ainsi que la position finale du pion qui mange
// deplacement des dames
// dames qui mangent

	
	public void canMove(Pion[] tabJoueur1, Pion[] tabJoueur2) {
		int[] can = new int[2];
		boolean pas = true;
		
	for (int i = 0; i<tabJoueur1.length-1;i++) {
		if (this.isDead == false ) {
			if (this.getType() == "pion") {
			
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
//-------------------------------------Pour les deplacements des dames--------------------------------------------
			// else if (this.getType == "dame")
			// {	
			// 	if(this.getPos()%10 == 0 || (this.getPos()-1)%10 == 0 )
			// 	{
			// 		if (this.joueur == 1) 
			// 		{
			// 			while (pas != false)
			// 			{
			// 			if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 5)) != false) 
			// 			{


			// 				if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 9)) != false)
			// 				{

			// 				} 
			// 				else
			// 				{
			// 					pas = false;
			// 					break;
			// 				}
			// 			}
			// 			this.setTabCanMoove(can);
			// 			System.out.print(this.getPos());
			// 			return ;


			// 			}

			// 		}
			// 	}
	
			// }			
		this.setTabCanMoove(can);
		}
	}
}


			
	public boolean testPos(Pion[] tabJoueur1, Pion[] tabJoueur2, int posToTest) {
    	for (int i=0; i < tabJoueur1.length - 1;i++){
            if (tabJoueur1[i].getPos() == posToTest || tabJoueur2[i].getPos() == posToTest) {
            	return false;
            }
    	}
    	return true;
	}


	public int testPoseat(Pion[] tabJoueur1, Pion[] tabJoueur2, int posToTest) {
        for (int i=0; i < tabJoueur1.length - 1;i++){
            if (tabJoueur1[i].getPos() == posToTest ) {
                return tabJoueur1[i].getJoueur();
            }
            if (tabJoueur2[i].getPos() == posToTest) {
                return tabJoueur2[i].getJoueur();
            }
        }
        return 0;
    }
	
		
	 public void canEat(Pion[] tabJoueur1, Pion[] tabJoueur2) {
		 int[] prohibited = new int[] {1, 11 , 21 , 31 , 41, 10, 20, 30, 40 , 50};
		 
		 int[] canE = new int[4];
//---------------------------------------------------pions sur les colonnes impaires----------------
		 if (this.getPos()%10 <= 5) {
			 if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 5)) == false || testPos(tabJoueur1,tabJoueur2, (this.getPos() - 6)) == false || testPos(tabJoueur1,tabJoueur2, (this.getPos() + 5)) == false || (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 6)) == false ) )
			  {
				
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
				System.out.println("possibilité de manger : " + canE[0] +  canE[1]+  canE[2] +  canE[3] );

				for (int i = 0; i < prohibited.length-1; i++) {
					if (testPoseat(tabJoueur1,tabJoueur2, (this.getPos() - 5)) == 0 && (this.getPos() - 5) != prohibited[i]) {
						if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 9)) != false) {
							canE[0] = this.getPos() - 9;
						} 
					} else if (testPoseat(tabJoueur1,tabJoueur2, (this.getPos() - 6)) == 0 && (this.getPos() - 6) != prohibited[i]) {
						if (testPos(tabJoueur1,tabJoueur2, (this.getPos() - 11)) != false ) {
							canE[1] = this.getPos() - 11;
						}
					}
					
					if (testPoseat(tabJoueur1,tabJoueur2, (this.getPos() + 5)) == 0 && (this.getPos() + 5) != prohibited[i]) {
						if (testPos(tabJoueur1,tabJoueur2, (this.getPos() + 9)) != false) {
							canE[2] = this.getPos() + 9;
						}
						
					} else if (testPoseat(tabJoueur1,tabJoueur2, (this.getPos() + 6)) == 0 && (this.getPos() + 6) != prohibited[i]) {
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
		 

	 