import java.util.List;

public class Fonction {

	List<Action> actions;
	
	/**
	 * constructeurs
	 */
	public Fonction() {
		this.actions.clear();
	}
	public Fonction(Action a){
		this.actions.clear();
		this.actions.add(a);
	}
	public Fonction(List<Action> list_a){
		this.actions.clear();
		this.actions.addAll(list_a);
	}
	
	/**
	 * ajoute une action dans la liste d'actions
	 * @param a l'action à ajouter
	 */
	public void ajout(Action a){
		this.actions.add(a);
	}
	
	/**
	 * ajoute une liste d'actions dans la liste d'actions
	 * @param list_a la liste d'actions à ajouter
	 */
	public void ajout(List<Action> list_a){
		this.actions.addAll(list_a);
	}
	
	/**
	 * ajoute une action dans la liste d'action à la position définie par index
	 * @param index position de l'action dans la liste d'action 
	 * @param a l'action à ajouter
	 */
	public void ajout (int index, Action a){
		this.actions.add(index,a);
	}
	
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
	
	
	public void executer() {
		for (int i=0; i< this.actions.size();i++) {
			actions.get(i).executer();
		}
	}

}
