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
	
	
	
	
	
	/*-----------------------------CONSTRUCTEURS-----------------------------*/
	/**
	 * constructeurs
	 */
	public Bot(){
		position = new Position();
		orientation = Orientation.SUD;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
	}
	public Bot(int l, int c){
		position = new Position(l,c);
		orientation = Orientation.SUD;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
	}
	public Bot(Orientation o){
		position = new Position();
		orientation = o;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
	}
	public Bot(Couleur c){
		position = new Position();
		orientation = Orientation.SUD;
		couleur = c;
		objet = Objet.RIEN;
	}
	public Bot(int l, int c, Orientation o){
		position = new Position(l,c);
		orientation = o;
		couleur = Couleur.GRIS;
		objet = Objet.RIEN;
	}
	public Bot(int l, int c, Couleur coul){
		position = new Position(l,c);
		orientation = Orientation.SUD;
		couleur = coul;
		objet = Objet.RIEN;
	}
	public Bot(int l, int c, Orientation o, Couleur coul){
		position = new Position(l,c);
		orientation = o;
		couleur = coul;
		objet = Objet.RIEN;
	}
	
	/*-----------------------------PROCEDURES-----------------------------*/
	/**
	 * exécute la liste de fonctions contenue dans l'attribut actions
	 */
	public void play(){
		for (int i=0; i< fonctions.size();i++) {
			fonctions.get(i).executer();
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
	
	
	
	
	/*-----------------------------GETTEURS-----------------------------*/
	/**
	 * renvoie la position du Bot
	 * @return la valeur de l'attribut position
	 */
	public static Position getPosition(){
		return position;
	}
	
	/**
	 * renvoie la position devant le Bot
	 * @return la position devant le Bot
	 */
	public static Position getPositionDevant(){
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
	public static Orientation getOrientation(){
		return orientation;
	}
	
	/**
	 * renvoie la couleur du Bot
	 * @return la valeur de l'attribut couleur
	 */
	public static Couleur getCouleur(){
		return couleur;
	}
	
	/**
	 * renvoie l'objet porté par le Bot
	 * @return la valeur de l'attribut objet
	 */
	public static Objet getObjet(){
		return objet;
	}
	
	/**
	 * renvoir la liste de fonctions à exécuter par le Bot
	 * @return la valeur de l'attribut fonctions
	 */
	public static List<Fonction> getFonctions(){
		return fonctions;
	}
	
	
	/*-----------------------------SETTEURS-----------------------------*/
	/**
	 * met à jour la position du Bot
	 * @param p : nouvelle position
	 * @param l et c : nouvelle position
	 */
	public static void setPosition(Position p){
		position = p;
	}
	public static void setPosition(int l, int c){
		Position p = new Position(l,c);
		position = p;
	}
	
	/**
	 * met à jour l'orientation du Bot
	 * @param o : nouvelle orientation
	 */
	public static void setOrientation(Orientation o){
		orientation = o;
	}
	
	
	/**
	 * met à jour la couleur du Bot
	 * @param c : nouvelle couleur
	 */
	public static void setCouleur(Couleur c){
		couleur = c;
	}
	
	/**
	 * met à jour l'objet porté par le Bot
	 * @param obj : nouvel objet
	 */
	public static void setObjet(Objet obj){
		objet = obj;
	}
	
	/**
	 * met à jour la liste de fonctions à exécuter par le Bot
	 * @param list_f : nouvelle liste de fonctions
	 */
	public static void setFonctions(List<Fonction> list_f){
		fonctions = list_f;
	}
	
	
	/*------------------------------------------------------------------*/
	
	public String toString(){
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
		
		return pos+orient+coul+obj+fonct;
	}
}
