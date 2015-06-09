package src;
import jus.util.assertion.*;

public class Sauter implements Action {
	public void executer(){
		int h, h_prime;
		Position pinit = Controleur.getBotActif().getPosition();
		Position dest = Controleur.getBotActif().getPositionDevant();
		h = Controleur.getMap().getCellule(pinit).getHauteur();
		h_prime = Controleur.getMap().getCellule(dest).getHauteur();
		if (h > h_prime || h == (h_prime -1)) {
			Controleur.getMap().getCellule(Controleur.getBotActif().getPositionDevant()).setOccupee(false);
			Controleur.getBotActif().setPosition(dest);
			Controleur.getMap().getCellule(Controleur.getBotActif().getPositionDevant()).setOccupee(true);
		}
		else throw new Ensure("Le Bot ne peut pas sauter !");
	}
	
	public String toString(){
		return "Sauter";
	}
}