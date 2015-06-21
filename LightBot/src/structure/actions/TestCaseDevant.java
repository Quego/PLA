package structure.actions;

import structure.Cellule;
import structure.Controleur;
import enumere.Couleur;


public class TestCaseDevant implements Action {

	public int executer() {
		int num = Controleur.numeroBot();
		if (Controleur.getMapCourrante().estDansMap(num)) {
			Cellule courrante = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition());
			Cellule devant = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getDevant());
			if (courrante != null && devant != null && devant.getCouleur() != Couleur.GRIS) {
				if (devant.getHauteur() == courrante.getHauteur()) return 0;
			}
		}
		return 1;
	}

	public String toString() {
		return "TestCaseDevant";
	}
	
}
