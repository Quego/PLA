package src;
import java.util.*;

public class Procedure {

	
	/*---------------------ATTRIBUT-----------------------------*/
	private List<Action> actions;
	
	
	/*---------------------CONSTRUCTEURS-----------------------------*/	
	public Procedure() { actions = null;	}
	public Procedure(List<Action> p) { this.actions = p; }
	
	/*---------------------PROCEDURES-&-FONCTIONS-----------------------------*/
	/**
	 * @return vrai si la liste d'actions est vide
	 */
	public boolean isEmpty(){
		return actions.isEmpty();
	}
	
	/**
	 * ajoute une action dans la liste d'actions
	 * @param a l'action à ajouter
	 */
	public void ajout(Action a){ this.actions.add(a);	}
	
	/**
	 * ajoute une liste d'actions dans la liste d'actions
	 * @param list_a la liste d'actions à ajouter
	 */
	public void ajout(List<Action> list_a){ this.actions.addAll(list_a); }
	
	/**
	 * ajoute une action dans la liste d'action à la position définie par index
	 * @param index position de l'action dans la liste d'action 
	 * @param a l'action à ajouter
	 */
	public void ajout (int index, Action a){ this.actions.add(index,a);	}
	
	/**
	 * supprime une action dans la liste d'actions
	 * @param a l'action à supprimer
	 */
	public void supprimer(Action a){
		this.actions.remove(this.actions.indexOf(a));
	}
	
	/**
	 * supprime une liste d'actions dans la liste d'actions
	 * @param list_a la liste d'action à supprimer
	 */
	public void supprimer(List<Action> list_a){
		this.actions.removeAll(list_a);
	}
	
	/**
	 * exécute la liste d'actions
	 */
	public void executer() {
		for (int i=0; i< this.actions.size();i++) {
			if (actions.get(i).toString().equals("Break")){
				break;
			}
			actions.get(i).executer();
		}
	}
	
	public String toString(){
		String s = "";
		for (int i=0; i< this.actions.size()-1;i++) {
			s += actions.get(i).toString() + ", ";
		}
		s += actions.get(this.actions.size()-1).toString();
		return s;
	}

}
