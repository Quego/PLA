import java.util.*;

import jus.util.assertion.*;
public class Bot {
	/**
	 * x et y repr�sentent la position du Bot dans la Map
	 */
	static int x, y;
	
	/**
	 * orientation repr�sente l'orientation du Bot (NORD, EST, SUD, OUEST)
	 */
	static Orientation orientation;
	
	/**
	 * couleur repr�sente la couleur du Bot
	 */
	static Couleur couleur;
	
	/**
	 * actions repr�sente la liste d'actions que le Bot va ex�cuter lors de l'appel de la proc�dure play()
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
	 * ex�cute la liste de fonctions contenue dans l'attribut actions
	 */
	public void play(){
		for (int i=0; i< this.fonctions.size();i++) {
			fonctions.get(i).executer();
		}
	}
	
	/**
	 * positionne le Bot � sa position, son orientation et sa couleur de d�part
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
		if (!(fonctions.isEmpty())) throw new Ensure("La liste d'actions n'a pas �t� vid�e");
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
	 * met � jour la position du Bot
	 * @require x ne d�passe pas les bornes de la Map
	 * @param x : nouvelle position horizontale 
	 */
	public static void setX(int new_x){
		x = new_x;
	}
	
	/**
	 * met � jour la position du Bot
	 * @require y ne d�passe pas les bornes de la Map
	 * @param y : nouvelle position verticale 
	 */
	public static void setY(int new_y){
		y = new_y;
	}
	
	/**
	 * met � jour l'orientation du Bot
	 * @param x : nouvelle orientation
	 */
	public static void setOrientation(Orientation o){
		orientation = o;
	}
	
	/**
	 * met � jour la couleur du Bot
	 * @param x : nouvelle couleur
	 */
	public void setCouleur(Couleur c){
		couleur = c;
	}
	

}
