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
	Orientation orientation;
	
	/**
	 * couleur représente la couleur du Bot
	 */
	Couleur couleur;
	
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
		this.orientation = Orientation.SUD;
		this.couleur = Couleur.GRIS;
	}
	public Bot(int x, int y){
		this.x = x;
		this.y = y;
		this.orientation = Orientation.SUD;
		this.couleur = Couleur.GRIS;
	}
	public Bot(Orientation o){
		this.x = 0;
		this.y = 0;
		this.orientation = o;
		this.couleur = Couleur.GRIS;
	}
	public Bot(Couleur c){
		this.x = 0;
		this.y = 0;
		this.orientation = Orientation.SUD;
		this.couleur = c;
	}
	public Bot(int x, int y, Orientation o){
		this.x = x;
		this.y = y;
		this.orientation = o;
		this.couleur = Couleur.GRIS;
	}
	public Bot(int x, int y, Couleur c){
		this.x = x;
		this.y = y;
		this.orientation = Orientation.SUD;
		this.couleur = c;
	}
	public Bot(int x, int y, Orientation o, Couleur c){
		this.x = x;
		this.y = y;
		this.orientation = o;
		this.couleur = c;
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
	int getX(){
		return this.x;
	}
	
	/**
	 * renvoie la position verticale du Bot
	 * @return la valeur de l'attribut y
	 */
	int getY(){
		return this.y;
	}
	
	/**
	 * renvoie l'orientation du Bot
	 * @return la valeur de l'attribut orientation
	 */
	Orientation getOrientation(){
		return this.orientation;
	}
	
	/**
	 * renvoie la couleur du Bot
	 * @return la valeur de l'attribut couleur
	 */
	Couleur getCouleur(){
		return this.couleur;
	}
	
	/**
	 * met à jour la position du Bot
	 * @require x ne dépasse pas les bornes de la Map
	 * @param x : nouvelle position horizontale 
	 */
	void setX(int x){
		this.x = x;
	}
	
	/**
	 * met à jour la position du Bot
	 * @require y ne dépasse pas les bornes de la Map
	 * @param y : nouvelle position verticale 
	 */
	void setY(int y){
		this.y = y;
	}
	
	/**
	 * met à jour l'orientation du Bot
	 * @param x : nouvelle orientation
	 */
	void setOrientation(Orientation o){
		this.orientation = o;
	}
	
	/**
	 * met à jour la couleur du Bot
	 * @param x : nouvelle couleur
	 */
	void setCouleur(Couleur c){
		this.couleur = c;
	}
	

}
