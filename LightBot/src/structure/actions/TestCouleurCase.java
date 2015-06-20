package structure.actions;

import structure.Cellule;
import structure.Controleur;
import enumere.Couleur;


public class TestCouleurCase implements Action {

	public int executer() {
		int num = Controleur.numeroBot();
		Cellule courrante = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition());
		if (courrante != null) {
			if (courrante.getCouleur() == Couleur.BLEU) return 0;
			else return 1;
		}
		return -1;
	}

	public String toString() {
		return "TestCaseCouleur";
	}
	
}
