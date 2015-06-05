
public class Prendre implements Action {
	
	public void executer(){
		Position p = Bot.getPosition();
		Cellule c = Map.getCellule(p);
		Bot.setObjet(c.getObjet());
	}
}
