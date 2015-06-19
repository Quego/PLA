package structure;
import enumere.Couleur;
import enumere.Etat;
import enumere.Objet;


public class Interrupteur extends Cellule {

	/**
	 * Attributs de la classe Interrupteur
	 */
	
	private Position cible;
	private Etat etat; 
	
	
	/**
	 * Getteurs - Setteurs
	 */
	
	public Position getCible() {return this.cible;}
	public void setCible(Position c) {this.cible = c;}
	
	public Etat getEtat() {return this.etat;}
	public void setEtat(Etat e) {this.etat = e;}
	
	/**
	 * Constructeurs
	 */
	
	public Interrupteur() {
		super();
		this.setCible(null);
		this.setEtat(null);
	}
	
	public Interrupteur(int h, Couleur c, Position p) {
		super(h, Objet.RIEN, c, true, false);
		this.setCible(p);
		this.setEtat(Etat.LOCK);
	}
	
}
