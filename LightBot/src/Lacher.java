
public class Lacher implements Action {
	public void executer(){
		Position p = Controleur.getBot().getPosition();
		Cellule c = Controleur.getMap().getCellule(p);
		if (!(c.getOccupe())){
			c.setObjet(Controleur.getBot().getObjet());
			Controleur.getBot().setObjet(Objet.RIEN);
			
		}
	}
	
	public String toString() {
		return "Lacher";
	}
}
