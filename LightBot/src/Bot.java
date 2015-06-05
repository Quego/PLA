import java.util.*;

import jus.util.assertion.*;
public class Bot {
	/**
	 * x et y représentent la position du Bot dans la Map
	 */
	static int x, y;
	
	/**
	 * orientation représente l'orientation du Bot (NORD, EST, SUD, OUEST)
	 */
	static Orientation orientation;
	
	/**
	 * couleur représente la couleur du Bot
	 */
	static Couleur couleur;
	
	/**
	 * actions représente la liste d'actions que le Bot va exécuter lors de l'appel de la procédure play()
	 */
	List<Fonction> fonctions;
	
	/**
	 * constructeurs
	 */
	public Bot(){
		x = 0;
		y = 0;
		orientation = Orientation.SUD;
		couleur = Couleur.GRIS;
	}
	public Bot(int l, int c){
		x = l;
		y = c;
		orientation = Orientation.SUD;
		couleur = Couleur.GRIS;
	}
	public Bot(Orientation o){
		x = 0;
		y = 0;
		orientation = o;
		couleur = Couleur.GRIS;
	}
	public Bot(Couleur c){
		x = 0;
		y = 0;
		orientation = Orientation.SUD;
		couleur = c;
	}
	public Bot(int l, int c, Orientation o){
		x = l;
		y = c;
		orientation = o;
		couleur = Couleur.GRIS;
	}
	public Bot(int l, int c, Couleur coul){
		x = l;
		y = c;
		orientation = Orientation.SUD;
		couleur = coul;
	}
	public Bot(int l, int c, Orientation o, Couleur coul){
		x = l;
		y = c;
		orientation = o;
		couleur = coul;
	}
	
	
	/**
	 * exécute la liste de fonctions contenue dans l'attribut actions
	 */
	public void play(){
		for (int i=0; i< this.fonctions.size();i++) {
			fonctions.get(i).executer();
		}
	}
	
	/**
	 * positionne le Bot à sa position, son orientation et sa couleur de départ
	 */
	public void resetBot(){
		//A FAIRE
	}
	
	/**
	 * vide la liste d'actions contenue dans l'attibut actions
	 * @ensure la liste d'actions est vide
	 */
	public void resetListeFonctions(){
		fonctions.clear();
		if (!(fonctions.isEmpty())) throw new Ensure("La liste d'actions n'a pas été vidée");
	}
	
	/**
	 * renvoie la position horizontale du Bot
	 * @return la valeur de l'attribut x
	 */
	public static int getX(){
		return x;
	}
	
	/**
	 * renvoie la position verticale du Bot
	 * @return la valeur de l'attribut y
	 */
	public static int getY(){
		return y;
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
	public Couleur getCouleur(){
		return couleur;
	}
	
	/**
	 * met à jour la position du Bot
	 * @require x ne dépasse pas les bornes de la Map
	 * @param x : nouvelle position horizontale 
	 */
	public static void setX(int new_x){
		x = new_x;
	}
	
	/**
	 * met à jour la position du Bot
	 * @require y ne dépasse pas les bornes de la Map
	 * @param y : nouvelle position verticale 
	 */
	public static void setY(int new_y){
		y = new_y;
	}
	
	/**
	 * met à jour l'orientation du Bot
	 * @param x : nouvelle orientation
	 */
	public static void setOrientation(Orientation o){
		orientation = o;
	}
	
	/**
	 * met à jour la couleur du Bot
	 * @param x : nouvelle couleur
	 */
	public void setCouleur(Couleur c){
		couleur = c;
	}
	

}
