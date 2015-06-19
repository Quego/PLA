package structure.actions;

import structure.Controleur;
import enumere.Etat;
import enumere.Orientation;


public class TournerG implements Action {

	public int executer() {
		int num = Controleur.numeroBot();
		switch (Controleur.getMapCourrante().getBot(num).getOrientation()) {
		case NORD :
			Controleur.getMapCourrante().getBot(num).setOrientation(Orientation.OUEST);
			break;
		case EST :
			Controleur.getMapCourrante().getBot(num).setOrientation(Orientation.NORD);
			break;
		case SUD :
			Controleur.getMapCourrante().getBot(num).setOrientation(Orientation.EST);
			break;
		case OUEST :
			Controleur.getMapCourrante().getBot(num).setOrientation(Orientation.SUD);
			break;
		}
		Controleur.getMapCourrante().getBot(num).setDevant();
		return 1;
	}
	
	public String toString() {
		int num = (Controleur.getMapCourrante().getBot1().getEtat() == Etat.UNLOCK) ? 0 : 1;
		return "TournerD : " + Controleur.getMapCourrante().getBot(num).getOrientation();
	}
	
}
