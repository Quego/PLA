import jus.util.assertion.*;

public class Avancer implements Action {
	/**
	 * exécute l'action AVANCER 
	 * @ensure le robot est dans la Map (dans les bornes et sur une cellule valable)
	 */
	public void executer(){
		int c,l;
		boolean accessible;
		Position p = Controleur.getBot().getPosition();
		Position destination = Controleur.getBot().getPositionDevant();
		if (!destination.estDansMap()) throw new Ensure("Le robot sort de la Map");
		Cellule ma_cellule = Controleur.getMap().getCellule(p);
		Cellule cellule_dest = Controleur.getMap().getCellule(destination);
		accessible = (ma_cellule.getHauteur() == cellule_dest.getHauteur());		
		if (!accessible) throw new Ensure("La cellule de destination n'est pas à la meme hauteur");
		Controleur.getBot().setPosition(destination);
	}
	
	public String toString() {
		return "Avancer";
	}
}
