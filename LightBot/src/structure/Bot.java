package structure;

import java.util.ArrayList;
import java.util.List;

import structure.actions.Action;
import enumere.Couleur;
import enumere.Etat;
import enumere.Objet;
import enumere.Orientation;

public class Bot {
	
	/**
	 * Attributs de la classe Bot
	 */
	
	private Position position, initialeP, devant;
	private Orientation orientation, initialeO;
	private Couleur couleur;
	private List<Objet> objets, initiauxO;
	private List<Action> actions;
	private Etat etat;
	
	
	/**
	 * Getteurs - Setteurs
	 */
	
	public Position getPosition() {return this.position;}
	public void setPosition(Position p) {this.position = p;}
	
	public Position getInitialeP() {return this.initialeP;}
	public void setInitialeP(Position i) {this.initialeP = i;}
	
	public Position getDevant() {return this.devant;}
	public void setDevant(Position p) {this.devant = p;}
	public void setDevant() {
		Position p = this.getPosition();
		switch(this.getOrientation()) {
		case NORD :
			this.setDevant(new Position(p.getLigne()-1, p.getColonne()));
			break;
		case EST :
			this.setDevant(new Position(p.getLigne(), p.getColonne()+1));
			break;
		case SUD :
			this.setDevant(new Position(p.getLigne()+1, p.getColonne()));
			break;
		case OUEST :
			this.setDevant(new Position(p.getLigne(), p.getColonne()-1));
			break;
		}
	}
	
	public Orientation getOrientation() {return this.orientation;}
	public void setOrientation(Orientation o) {this.orientation = o;}
	public Orientation getInitialeO() {return this.initialeO;}
	public void setInitialeO(Orientation o) {this.initialeO = o;}
	public void setOrientationGauche() {
		switch(this.getOrientation()) {
		case NORD :
			this.setOrientation(Orientation.OUEST);
			break;
		case EST :
			this.setOrientation(Orientation.NORD);
			break;
		case SUD :
			this.setOrientation(Orientation.EST);
			break;
		case OUEST :
			this.setOrientation(Orientation.SUD);
			break;
		}
	}
	public void setOrientationDroite() {
		switch(this.getOrientation()) {
		case NORD :
			this.setOrientation(Orientation.EST);
			break;
		case EST :
			this.setOrientation(Orientation.SUD);
			break;
		case SUD :
			this.setOrientation(Orientation.OUEST);
			break;
		case OUEST :
			this.setOrientation(Orientation.NORD);
			break;
		}
	}
	
	public Couleur getCouleur() {return this.couleur;}
	public void setCouleur(Couleur c) {this.couleur = c;}
	
	public List<Objet> getObjets() {return this.objets;}
	public void setObjets(List<Objet> o) {this.objets = o;}
	public List<Objet> getInitiauxO() {return this.initiauxO;}
	public void setInitiauxO(List<Objet> o) {this.initiauxO = o;}
	
	public List<Action> getActions() {return this.actions;}
	public void setActions(List<Action> a) {this.actions = a;}
	
	public Etat getEtat() {return this.etat;}
	public void setEtat(Etat e) {this.etat = e;}
	
	
	/**
	 * Constructeurs
	 */
	
	public Bot() {
		this.setPosition(null);
		this.setInitialeP(null);
		this.setOrientation(Orientation.SUD);
		this.setInitialeO(this.getOrientation());
		this.setCouleur(Couleur.BLANC);
		this.setObjets(new ArrayList<Objet>());
		this.setInitiauxO(new ArrayList<Objet>());
		this.setActions(new ArrayList<Action>());
		this.setEtat(Etat.UNLOCK);
	}
	
	public Bot(Position i) {
		this.setPosition(i);
		this.setInitialeP(i);
		this.setOrientation(Orientation.SUD);
		this.setInitialeO(this.getOrientation());		
		this.setDevant();
		this.setCouleur(Couleur.BLANC);
		this.setObjets(new ArrayList<Objet>());
		this.setInitiauxO(new ArrayList<Objet>());
		this.setActions(new ArrayList<Action>());
		this.setEtat(Etat.UNLOCK);
	}
	
	public Bot(Position i, Orientation o, Etat e) {
		this.setPosition(i);
		this.setInitialeP(i);
		this.setOrientation(o);
		this.setInitialeO(this.getOrientation());
		this.setDevant();
		this.setCouleur(Couleur.BLANC);
		this.setObjets(new ArrayList<Objet>());
		this.setInitiauxO(new ArrayList<Objet>());
		this.setActions(new ArrayList<Action>());
		this.setEtat(e);
	}
	
	/**
	 * Exécute chaque actions du bot
	 */
	public void play() {
		for (Action a : this.getActions()) {
			a.executer();
		}
	}
	
	/**
	 * Renvoie le premier élément de la liste
	 * @return
	 */
	public Objet recuperePremierObjet() {
		return this.getObjets().get(0);
	}
	
	/**
	 * Supprime le premier objet de la liste
	 */
	public void supprimePremierObjet() {
		this.getObjets().remove(0);
	}
	
}
