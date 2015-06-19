package structure.actions;

public interface Action {

	/**
	 * Permet l'exécution de l'action
	 * @return 
	 */
	public int executer();
	
	/**
	 * Représentation de l'objet sous forme de chaine
	 * @return la chaine associée
	 */
	public String toString();
	
}
