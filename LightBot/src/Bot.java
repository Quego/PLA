import java.util.*;

import jus.util.assertion.*;
public class Bot {
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
	private List<Fonction> fonctions;
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
		fonctions.clear();
		etat = Etat.ACTIF;
	}
	public Bot(Etat e){
		position = new Position();
		orientation = Orientation.SUD;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		fonctions.clear();
		etat = e;
	}
	public Bot(int l, int c){
		position = new Position(l,c);
		orientation = Orientation.SUD;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		fonctions.clear();
		etat = Etat.ACTIF;
	}
	public Bot(Orientation o){
		position = new Position();
		orientation = o;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		fonctions.clear();
		etat = Etat.ACTIF;
	}
	public Bot(Couleur c){
		position = new Position();
		orientation = Orientation.SUD;
		couleur = c;
		objet = Objet.RIEN;
		fonctions.clear();
		etat = Etat.ACTIF;
	}
	public Bot(int l, int c, Orientation o){
		position = new Position(l,c);
		orientation = o;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		fonctions.clear();
		etat = Etat.ACTIF;
	}
	public Bot(int l, int c, Couleur coul){
		position = new Position(l,c);
		orientation = Orientation.SUD;
		couleur = coul;
		objet = Objet.RIEN;
		fonctions.clear();
		etat = Etat.ACTIF;
	}
	public Bot(int l, int c, Orientation o, Couleur coul){
		position = new Position(l,c);
		orientation = o;
		couleur = coul;
		objet = Objet.RIEN;
		fonctions.clear();
		etat = Etat.ACTIF;
	}
	
	public Bot(int l, int c, Etat e){
		position = new Position(l,c);
		orientation = Orientation.SUD;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		fonctions.clear();
		etat = e;
	}
	public Bot(Orientation o, Etat e){
		position = new Position();
		orientation = o;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		fonctions.clear();
		etat = e;
	}
	public Bot(Couleur c, Etat e){
		position = new Position();
		orientation = Orientation.SUD;
		couleur = c;
		objet = Objet.RIEN;
		fonctions.clear();
		etat = e;
	}
	public Bot(int l, int c, Orientation o, Etat e){
		position = new Position(l,c);
		orientation = o;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
		fonctions.clear();
		etat = e;
	}
	public Bot(int l, int c, Couleur coul, Etat e){
		position = new Position(l,c);
		orientation = Orientation.SUD;
		couleur = coul;
		objet = Objet.RIEN;
		fonctions.clear();
		etat = e;
	}
	public Bot(int l, int c, Orientation o, Couleur coul, Etat e){
		position = new Position(l,c);
		orientation = o;
		couleur = coul;
		objet = Objet.RIEN;
		fonctions.clear();
		etat = e;
	}
	
	/*---------------------PROCEDURES-&-FONCTIONS-----------------------------*/
	/**
	 * exécute la liste de fonctions contenue dans l'attribut actions seulement si le Bot est actif
	 */
	public void play(){
		if (etat == Etat.ACTIF){
			for (int i=0; i< fonctions.size();i++) {
				fonctions.get(i).executer();
			}
		}
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
		fonctions.clear();
		if (!(fonctions.isEmpty())) throw new Ensure("La liste d'actions n'a pas été vidée");
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
		if (this.fonctions.isEmpty()) {
			fonct = "Il n'a rien à faire \n";
		}
		else {
			fonct = "Il doit faire cette liste d'actions : " + this.fonctions.toString() + "\n";
		}
		
		return etat+pos+orient+coul+obj+fonct;
	}
	
	
	/*-----------------------------GETTEURS-----------------------------*/
	/**
	 * renvoie la position du Bot
	 * @return la valeur de l'attribut position
	 */
	public Position getPosition(){
		return position;
	}
	
	/**
	 * renvoie la position devant le Bot
	 * @return la position devant le Bot
	 */
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
	
	
	/**
	 * renvoie l'orientation du Bot
	 * @return la valeur de l'attribut orientation
	 */
	public Orientation getOrientation(){
		return orientation;
	}
	
	/**
	 * renvoie la couleur du Bot
	 * @return la valeur de l'attribut couleur
	 */
	public Couleur getCouleur(){
		return couleur;
	}
	
	/**
	 * renvoie l'objet porté par le Bot
	 * @return la valeur de l'attribut objet
	 */
	public Objet getObjet(){
		return objet;
	}
	
	/**
	 * renvoie la liste de fonctions à exécuter par le Bot
	 * @return la valeur de l'attribut fonctions
	 */
	public List<Fonction> getFonctions(){
		return fonctions;
	}
	
	/**
	 * renvoie l'etat du Bot
	 * @return la valeur de l'attribut etat
	 */
	public Etat getEtat(){
		return etat;
	}
	
	/*-----------------------------SETTEURS-----------------------------*/
	/**
	 * met à jour la position du Bot
	 * @param p : nouvelle position
	 * @param l et c : nouvelle position
	 */
	public void setPosition(Position p){
		position = p;
	}
	public void setPosition(int l, int c){
		Position p = new Position(l,c);
		position = p;
	}
	
	/**
	 * met à jour l'orientation du Bot
	 * @param o : nouvelle orientation
	 */
	public void setOrientation(Orientation o){
		orientation = o;
	}
	
	
	/**
	 * met à jour la couleur du Bot
	 * @param c : nouvelle couleur
	 */
	public void setCouleur(Couleur c){
		couleur = c;
	}
	
	/**
	 * met à jour l'objet porté par le Bot
	 * @param obj : nouvel objet
	 */
	public void setObjet(Objet obj){
		objet = obj;
	}
	
	/**
	 * met à jour la liste de fonctions à exécuter par le Bot
	 * @param list_f : nouvelle liste de fonctions
	 */
	public void setFonctions(List<Fonction> list_f){
		fonctions = list_f;
	}
	
	/**
	 * met a jour l'etat du Bot
	 * @param e : nouvel etat
	 */
	public void setEtat(Etat e){
		etat = e;
	}
	

}
