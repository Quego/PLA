package src;
import jus.util.assertion.*;

public class Avancer implements Action {
	/**
	 * exécute l'action AVANCER 
	 * @ensure le robot est dans la Map (dans les bornes et sur une cellule valable)
	 */
	public void executer(){
		boolean accessible;
		Position p = Controleur.getBotActif().getPosition();
		Position destination = Controleur.getBotActif().getPositionDevant();
		if (!destination.estDansMap()) throw new Ensure("Le robot sort de la Map");
		Cellule ma_cellule = Controleur.getMap().getCellule(p);
		Cellule cellule_dest = Controleur.getMap().getCellule(destination);
		accessible = ((ma_cellule.getHauteur() == cellule_dest.getHauteur()) && (cellule_dest.getCouleur() != Couleur.GRIS) && cellule_dest.getOccupee());		
		if (!accessible) throw new Ensure("La cellule de destination n'est pas accessible");
		Controleur.getBotActif().setPosition(destination);
		ma_cellule.setOccupee(false); cellule_dest.setOccupee(true);
	}
	
	public String toString() {
		return "Avancer";
	}
}
