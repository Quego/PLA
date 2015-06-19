package structure.actions;
import structure.Cellule;
import structure.Controleur;
import enumere.Couleur;
import enumere.Etat;


public class Avancer implements Action {

	public int executer() {
		int num = Controleur.numeroBot();
		if (Controleur.getMapCourrante().estDansMap(num)) {
			Cellule courrante = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition());
			if (courrante != null) {
				Cellule devant = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getDevant());
				if (devant != null && devant.getCouleur() != Couleur.GRIS) {
					if (devant.getHauteur() == courrante.getHauteur()) {
						Controleur.getMapCourrante().getBot(num).setPosition(Controleur.getMapCourrante().getBot(num).getDevant());
						Controleur.getMapCourrante().getBot(num).setDevant();
						return 1;
					}
				}
			}
		}
		return 0;
	}
	
	public String toString() {
		int num = (Controleur.getMapCourrante().getBot1().getEtat() == Etat.UNLOCK) ? 0 : 1;
		return "Avancer : (" + Controleur.getMapCourrante().getBot(num).getPosition().toString() + ")";
	}
	
}
