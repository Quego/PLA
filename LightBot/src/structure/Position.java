package structure;

public class Position {
	
	/**
	 * Attributs de la classe Position
	 */
	
	int ligne, colonne;
	
	
	/**
	 * Getteurs - Setteurs
	 */
	
	public int getLigne() {return this.ligne;}
	public void setLigne(int l) {this.ligne = l;}
	
	public int getColonne() {return this.colonne;}
	public void setColonne(int c) {this.colonne = c;}
	
	
	/**
	 * Constructeurs
	 */
	
	public Position() {
		this.setLigne(-1);
		this.setColonne(-1);
	}
	
	public Position(int l, int c) {
		this.setLigne(l);
		this.setColonne(c);
	}
	
	public String toString() {
		return this.getLigne() + ", " + this.getColonne();
	}

}