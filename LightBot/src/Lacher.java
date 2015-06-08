package src;

public class Lacher implements Action {
	public void executer(){
		Position p = Controleur.getBotActif().getPosition();
		Cellule c = Controleur.getMap().getCellule(p);
		if (!(c.getOccupee())){
			c.setObjet(Controleur.getBotActif().getObjet().toString());
			Controleur.getBotActif().setObjet(Objet.RIEN);
			
		}
	}
	
	public String toString() {
		return "Lacher";
	}
}
