
public class Cellule {

	private int hauteur;
	private Objet objet;
	private Couleur couleur;
	private boolean occupe;
	
	public Cellule() {
		this.hauteur = 0;
		this.objet = Objet.RIEN;
		this.couleur = Couleur.BLANC;
		this.occupe = false;
	}
	
	public Cellule(int h) {
		this.hauteur = h;
		this.objet = Objet.RIEN;
		this.couleur = Couleur.BLANC;
		this.occupee = false;
	}
	
	public Cellule(Couleur c) {
		this.hauteur = 0;
		this.objet = Objet.RIEN;
		this.couleur = c;
		this.occupee = false;
	}
	
	public Cellule(int h, Objet ob, Couleur c, boolean oc) {
		this.hauteur = h;
		this.objet = ob;
		this.couleur = c;
		this.occupee = oc;
	}
	
	public int getHauteur() {return this.hauteur;}
	public void setHauteur(int h) {this.hauteur = h;}
	
	public Objet getObjet() {return this.objet;}
	public void setObjet(String o) {this.objet = Objet.valueOf(o);}
	
	public Couleur getCouleur() {return this.couleur;}
	public void setCouleur(String c) {this.couleur = Couleur.valueOf(c);}
	
	public boolean getOccupee() {return this.occupee;}
	public void setOccupee(boolean o) {this.occupee = o;}
	
	public String toString() {
		return "hauteur = " + this.getHauteur() + "\n" +
			   "objet = " + this.objet + "\n" + 
			   "couleur = " + this.couleur + "\n" +
			   "occupee = " + this.occupe + "\n";
	}
	
}
