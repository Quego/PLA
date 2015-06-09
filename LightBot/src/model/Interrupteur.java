package model;

public class Interrupteur extends Cellule {
	Cellule cible;
	int hauteurH, hauteurB;
	
	public int getHauteurOpposee(){
		if(cible.getHauteur() == hauteurH) return hauteurB;
		return hauteurH;
	}
	
}
