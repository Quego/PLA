package model;

public class Avancer implements Action {
	/**
	 * ex�cute l'action AVANCER 
	 * @ensure le robot est dans la Map (dans les bornes et sur une cellule valable)
	 */
	public void executer(){
		boolean accessible;
		Position p = Controleur.getBotActif().getPosition();
		Position destination = Controleur.getBotActif().getPositionDevant();
		Cellule ma_cellule = Controleur.getMap().getCellule(p);
		Cellule cellule_dest = Controleur.getMap().getCellule(destination);
		accessible = ((ma_cellule.getHauteur() == cellule_dest.getHauteur()) && (cellule_dest.getCouleur() != Couleur.GRIS) && cellule_dest.getOccupee());		
		Controleur.getBotActif().setPosition(destination);
		ma_cellule.setOccupee(false); cellule_dest.setOccupee(true);
	}
	
	public String toString() {
		return "Avancer";
	}
}
