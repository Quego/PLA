package structure;

import enumere.Couleur;
import enumere.Objet;

public class Cellule {
	
	private int hauteur;
	private Objet objet;
	private Couleur couleur;
	private boolean visible;
	private boolean aleatoire;
	
	public Cellule() {
		this.hauteur = 0;
		this.objet = Objet.RIEN;
		this.couleur = Couleur.BLANC;
		this.visible = true;
		this.aleatoire = false;
	}
	
	public Cellule(int h) {
		this.hauteur = h;
		this.objet = Objet.RIEN;
		this.couleur = Couleur.BLANC;
		this.visible = true;
		this.aleatoire = false;
	}
	
	public Cellule(Couleur c) {
		this.hauteur = 0;
		this.objet = Objet.RIEN;
		this.couleur = c;
		this.visible = true;
		this.aleatoire = false;
	}
	
	public Cellule(int h, Objet ob, Couleur c, boolean v, boolean a) {
		this.hauteur = h;
		this.objet = ob;
		this.couleur = c;
		this.visible = v;
		this.aleatoire = a;
	}
	
	public int getHauteur() {return this.hauteur;}
	public void setHauteur(int h) {this.hauteur = h;}
	
	public Objet getObjet() {return this.objet;}
	public void setObjet(Objet o) {this.objet = o;}
	
	public Couleur getCouleur() {return this.couleur;}
	public void setCouleur(Couleur c) {this.couleur = c;}
	
	public boolean getVisible() {return this.visible;}
	public void setVisible(boolean v) {this.visible = v;}
	
	public boolean getAleatoire() {return this.aleatoire;}
	public void setAleatoire(boolean a) {this.aleatoire = a;}
	
	public String toString() {
		return "hauteur = " + this.getHauteur() + "\n" +
			   "objet = " + this.objet + "\n" + 
			   "couleur = " + this.couleur + "\n";
	}

}
