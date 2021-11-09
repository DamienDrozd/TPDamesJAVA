package pion;

public class Pion {

    int pos;
    String[] direction;
    int nbCase;
    String character;
    int joueur;
    
    
	public int[] canMove() {
        for (Joueur joueur : joueurTab[]) {
			switch(joueur) {
				case 1: 
				if pos
				
				
				
			}	
		}
    	return null;
    }
	
   

	public Pion(int pos, String[] direction, int nbCase, String character) {
		super();
		this.pos = pos;
		this.direction = direction;
		this.nbCase = nbCase;
		this.character = character;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
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

	@Override
	public String toString() {
		return "Pion [pos=" + pos + ", direction=" + direction + ", nbCase=" + nbCase + ", character=" + character
				+ "]";
	}

    

	
    
    
    
}
