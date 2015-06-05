import java.util.*;

import jus.util.assertion.*;
public class Bot {
	/**
	 * position repr�sente la position du Bot dans la Map
	 * orientation repr�sente l'orientation du Bot (NORD, EST, SUD, OUEST)
	 * couleur repr�sente la couleur du Bot
	 * objet repr�sente l'objet tenu par le robot ou rien
	 * actions repr�sente la liste d'actions que le Bot va ex�cuter lors de l'appel de la proc�dure play()
	 */
	private static Position position;
	private static Orientation orientation;
	private static Couleur couleur;
	private static Objet objet;
	private static List<Fonction> fonctions;
	
	
	
	
	
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
	 * ex�cute la liste de fonctions contenue dans l'attribut actions
	 */
	public void play(){
		for (int i=0; i< this.fonctions.size();i++) {
			fonctions.get(i).executer();
		}
	}
	
	/**
	 * positionne le Bot � sa position, son orientation et sa couleur de d�part
	 * @ensure le Bot est retourn� � la position initiale
	 */
	public void resetBot(){
		position = Map.getPositionInit();
		if (getPosition() != Map.getPositionInit()) throw new Ensure("Le Bot n'est pas retourn� � sa position initiale");
	}
	
	/**
	 * vide la liste d'actions contenue dans l'attibut actions
	 * @ensure la liste d'actions est vide
	 */
	public void resetListeFonctions(){
		fonctions.clear();
		if (!(fonctions.isEmpty())) throw new Ensure("La liste d'actions n'a pas �t� vid�e");
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
	 * renvoie l'objet port� par le Bot
	 * @return la valeur de l'attribut objet
	 */
	public static Objet getObjet(){
		return objet;
	}
	
	/**
	 * renvoir la liste de fonctions � ex�cuter par le Bot
	 * @return la valeur de l'attribut fonctions
	 */
	public static List<Fonction> getFonctions(){
		return fonctions;
	}
	
	
	/*-----------------------------SETTEURS-----------------------------*/
	/**
	 * met � jour la position du Bot
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
	 * met � jour l'orientation du Bot
	 * @param o : nouvelle orientation
	 */
	public static void setOrientation(Orientation o){
		orientation = o;
	}
	
	
	/**
	 * met � jour la couleur du Bot
	 * @param c : nouvelle couleur
	 */
	public static void setCouleur(Couleur c){
		couleur = c;
	}
	
	/**
	 * met � jour l'objet port� par le Bot
	 * @param obj : nouvel objet
	 */
	public static void setObjet(Objet obj){
		objet = obj;
	}
	
	/**
	 * met � jour la liste de fonctions � ex�cuter par le Bot
	 * @param list_f : nouvelle liste de fonctions
	 */
	public static void setFonctions(List<Fonction> list_f){
		fonctions = list_f;
	}
	

}
