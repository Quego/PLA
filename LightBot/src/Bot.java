package src;
import java.util.*;

import jus.util.assertion.*;
public class Bot {
	
	/*-----------------------------ATTRIBUTS-----------------------------*/
	/**
	 * position représente la position du Bot dans la Map
	 * orientation représente l'orientation du Bot (NORD, EST, SUD, OUEST)
	 * couleur représente la couleur du Bot
	 * objet représente l'objet tenu par le robot ou rien
	 * actions représente la liste d'actions que le Bot va exécuter lors de l'appel de la procédure play()
	 */
	private Position position;
	private Orientation orientation;
	private Couleur couleur;
	private Objet objet;
	private List<Action> actions;
	private Etat etat;
	
	
	
	
	
	/*-----------------------------CONSTRUCTEURS-----------------------------*/
	/**
	 * constructeurs
	 */
	public Bot(){
		position = new Position();
		orientation = Orientation.SUD;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		actions.clear();
		etat = Etat.ACTIF;
	}
	public Bot(Etat e){
		position = new Position();
		orientation = Orientation.SUD;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		actions.clear();
		etat = e;
	}
	public Bot(int l, int c){
		position = new Position(l,c);
		orientation = Orientation.SUD;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		actions.clear();
		etat = Etat.ACTIF;
	}
	public Bot(Orientation o){
		position = new Position();
		orientation = o;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		actions.clear();
		etat = Etat.ACTIF;
	}
	public Bot(Couleur c){
		position = new Position();
		orientation = Orientation.SUD;
		couleur = c;
		objet = Objet.RIEN;
		actions.clear();
		etat = Etat.ACTIF;
	}
	public Bot(int l, int c, Orientation o){
		position = new Position(l,c);
		orientation = o;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		actions.clear();
		etat = Etat.ACTIF;
	}
	public Bot(int l, int c, Couleur coul){
		position = new Position(l,c);
		orientation = Orientation.SUD;
		couleur = coul;
		objet = Objet.RIEN;
		actions.clear();
		etat = Etat.ACTIF;
	}
	public Bot(int l, int c, Orientation o, Couleur coul){
		position = new Position(l,c);
		orientation = o;
		couleur = coul;
		objet = Objet.RIEN;
		actions.clear();
		etat = Etat.ACTIF;
	}
	
	public Bot(int l, int c, Etat e){
		position = new Position(l,c);
		orientation = Orientation.SUD;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		actions.clear();
		etat = e;
	}
	public Bot(Orientation o, Etat e){
		position = new Position();
		orientation = o;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		actions.clear();
		etat = e;
	}
	public Bot(Couleur c, Etat e){
		position = new Position();
		orientation = Orientation.SUD;
		couleur = c;
		objet = Objet.RIEN;
		actions.clear();
		etat = e;
	}
	public Bot(int l, int c, Orientation o, Etat e){
		position = new Position(l,c);
		orientation = o;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		actions.clear();
		etat = e;
	}
	public Bot(int l, int c, Couleur coul, Etat e){
		position = new Position(l,c);
		orientation = Orientation.SUD;
		couleur = coul;
		objet = Objet.RIEN;
		actions.clear();
		etat = e;
	}
	public Bot(int l, int c, Orientation o, Couleur coul, Etat e){
		position = new Position(l,c);
		orientation = o;
		couleur = coul;
		objet = Objet.RIEN;
		actions.clear();
		etat = e;
	}
	
	/*---------------------PROCEDURES-&-FONCTIONS-----------------------------*/
	/**
	 * exécute la liste de fonctions contenue dans l'attribut actions seulement si le Bot est actif
	 */
	public void play(){
		if (etat == Etat.ACTIF){
			for (int i=0; i < actions.size();i++) {
				actions.get(i).executer();
			}
		}
	}
	
	public void executer(Action a){
		a.executer();
	}
	
	/**
	 * positionne le Bot à sa position, son orientation et sa couleur de départ
	 * @ensure le Bot est retourné à la position initiale
	 */
	public void resetBot(){
		position = Controleur.getMap().getPositionInit();
		if (getPosition() != Controleur.getMap().getPositionInit()) throw new Ensure("Le Bot n'est pas retourné à sa position initiale");
	}
	
	/**
	 * vide la liste d'actions contenue dans l'attibut actions
	 * @ensure la liste d'actions est vide
	 */
	public void resetListeFonctions(){
		actions.clear();
		if (!(actions.isEmpty())) throw new Ensure("La liste d'actions n'a pas été vidée");
	}
	
	public String toString(){
		String etat = "Le bot est " + this.etat.toString() + "\n";
		String pos 	= "Le Bot est à la position : "	+ this.position.toString() 	+"\n";
		String orient = "Il est tourné vers "	+ this.orientation.toString() +"\n";
		String coul = "Il est de couleur "	+ this.couleur.toString() +"\n";
		String obj;
		String fonct;
		if (this.objet != Objet.RIEN) {
				obj = "Il tient " + this.objet.toString() + "dans ses mains \n";
		}
		else {
				obj = "Il ne tient rien dans ses mains \n";
		}
		if (this.actions.isEmpty()) {
			fonct = "Il n'a rien à faire \n";
		}
		else {
			fonct = "Il doit faire cette liste d'actions : " + this.actions.toString() + "\n";
		}
		
		return etat+pos+orient+coul+obj+fonct;
	}
	
	
	/*-----------------------------GETTEURS-----------------------------*/

	public Position getPosition(){ return position;	}
	
	public Orientation getOrientation(){ return orientation; }
	
	public Couleur getCouleur(){ return couleur; }
	
	public Objet getObjet(){ return objet; }
	
	public List<Action> getFonctions(){ return actions; }

	public Etat getEtat(){ return etat; }
	
	public Position getPositionDevant(){
		int c,l;
		Position p;
		c = position.getC(); l = position.getL();
		switch (orientation){
			case SUD 	:	c = c+1; 	break;
			case OUEST 	: 	l = l-1; 	break;
			case NORD 	: 	c = c-1; 	break;
			case EST	: 	l = l+1; 	break;
		}
		p = new Position(l,c);
		return p;
	}
	
	/*-----------------------------SETTEURS-----------------------------*/

	public void setPosition(Position p){ position = p;	}
	
	public void setPosition(int l, int c){ position.setC(c); position.setL(l); }

	public void setOrientation(Orientation o){ orientation = o;	}
	
	public void setCouleur(Couleur c){ couleur = c; }
	
	public void setObjet(Objet obj){ objet = obj; }
	
	public void setFonctions(List<Action> list){ actions = list;	}
	
	public void setEtat(Etat e){ etat = e; }
	

}
