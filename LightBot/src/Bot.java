import java.util.*;
import jus.util.assertion.*;
public class Bot {
	/**
	 * x et y représentent la position du Bot dans la Map
	 */
	int x, y;
	
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
	List<Action> actions;
	
	/**
	 * constructeurs
	 */
	public Bot(){
		this.x = 0;
		this.y = 0;
		orientation = Orientation.SUD;
		couleur = Couleur.GRIS;
	}
	public Bot(int x, int y){
		this.x = x;
		this.y = y;
		orientation = Orientation.SUD;
		couleur = Couleur.GRIS;
	}
	public Bot(Orientation o){
		this.x = 0;
		this.y = 0;
		orientation = o;
		couleur = Couleur.GRIS;
	}
	public Bot(Couleur c){
		this.x = 0;
		this.y = 0;
		orientation = Orientation.SUD;
		couleur = c;
	}
	public Bot(int x, int y, Orientation o){
		this.x = x;
		this.y = y;
		orientation = o;
		couleur = Couleur.GRIS;
	}
	public Bot(int x, int y, Couleur c){
		this.x = x;
		this.y = y;
		orientation = Orientation.SUD;
		couleur = c;
	}
	public Bot(int x, int y, Orientation o, Couleur c){
		this.x = x;
		this.y = y;
		orientation = o;
		couleur = c;
	}
	
	
	/**
	 * exécute la liste d'actions contenue dans l'attribut actions
	 */
	public void play(){
		//A FAIRE
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
	public void resetActions(){
		actions.clear();
		if (!(actions.isEmpty())) throw new Ensure("La liste d'actions n'a pas été vidée");
	}
	
	/**
	 * renvoie la position horizontale du Bot
	 * @return la valeur de l'attribut x
	 */
	public int getX(){
		return this.x;
	}
	
	/**
	 * renvoie la position verticale du Bot
	 * @return la valeur de l'attribut y
	 */
	public int getY(){
		return this.y;
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
	public void setX(int x){
		this.x = x;
	}
	
	/**
	 * met à jour la position du Bot
	 * @require y ne dépasse pas les bornes de la Map
	 * @param y : nouvelle position verticale 
	 */
	public void setY(int y){
		this.y = y;
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
