
public class Position {
	
	int l, c;
	
	/**
	 * constructeurs
	 */
	public Position(){
		l = 0;
		c = 0;
	}
	public Position(int x, int y){
		l = x;
		c = y;
	}
	public Position(Position p){
		c = p.getC();
		l = p.getL();
	}
	
	/**
	 * renvoie la position horizontale du Bot
	 * @return la valeur de l'attribut x
	 */
	public int getL(){
		return l;
	}
	
	/**
	 * renvoie la position verticale du Bot
	 * @return la valeur de l'attribut y
	 */
	public int getC(){
		return c;
	}
	
	/**
	 * met à jour la position du Bot
	 * @param x : nouvelle position horizontale 
	 */
	public void setC(int new_c){
		c = new_c;
	}
	
	/**
	 * met à jour la position du Bot
	 * @param y : nouvelle position verticale 
	 */
	public void setL(int new_l){
		l = new_l;
	}
	
	public boolean estDansMap() {
		return ((this.l >= 0) && (this.l < Map.getLongueur()) && (this.c >= 0) && (this.c < Map.getLargeur()));
	}
	
	public String toString() {
		return "ligne " + this.l.toString() + ", colonne " + this.c.toString();
	}

}
