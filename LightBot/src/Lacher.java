
public class Lacher implements Action {
	public void executer(){
		Position p = Bot.getPosition();
		Cellule c = Map.getCellule(p);
		if (!(c.getOccupe())){
			c.setObjet(Bot.getObjet());
			Bot.setObjet(Objet.RIEN);
			
		}
	}
}
