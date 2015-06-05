
public class Prendre implements Action {
	
	public void executer(){
		Position p = Controleur.getBot().getPosition();
		Cellule c = Controleur.getMap().getCellule(p);
		Controleur.getBot().setObjet(c.getObjet());
	}
	
	public String toString() {
		return "Prendre";
	}
}
