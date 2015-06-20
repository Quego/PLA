package structure.actions;

import structure.Cellule;
import structure.Controleur;
import enumere.Couleur;


public class TestCaseDevant implements Action {

	public int executer() {
		int num = Controleur.numeroBot();
		Cellule courrante = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition());
		Cellule devant = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getDevant());
		if (courrante != null && devant != null) {
			if (devant.getCouleur() != Couleur.GRIS && devant.getHauteur() ==  courrante.getHauteur()) return 0;
			else return 1;
		} return -1;
	}

	public String toString() {
		return "TestCaseDevant";
	}
	
}
