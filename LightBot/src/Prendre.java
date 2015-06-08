package src;

public class Prendre implements Action {
	
	public void executer(){
		Position p = Controleur.getBotActif().getPosition();
		Cellule c = Controleur.getMap().getCellule(p);
		Controleur.getBotActif().setObjet(c.getObjet());
	}
	
	public String toString() {
		return "Prendre";
	}
}
