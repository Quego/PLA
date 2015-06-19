package structure.actions;
import structure.Cellule;
import structure.Controleur;
import enumere.Couleur;


public class TestSauter extends IfThenElse {
	
	public int executer() {
		int num = Controleur.numeroBot();
		Cellule courrante = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition());
		Cellule devant = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getDevant());
		if (courrante != null && devant != null) {
			if (devant.getCouleur() != Couleur.GRIS && 
			   (courrante.getHauteur() == devant.getHauteur() + 1 || courrante.getHauteur() == devant.getHauteur() - 1))
				return 0;
			 else return 1;
		}
		return -1;
	}

	public String toString() {
		return "TestSauter";
	}

}
