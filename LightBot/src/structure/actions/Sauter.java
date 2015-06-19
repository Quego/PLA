package structure.actions;
import structure.Cellule;
import structure.Controleur;
import enumere.Couleur;
import enumere.Etat;


public class Sauter implements Action {

	public int executer() {
		int num = Controleur.numeroBot();
		if (Controleur.getMapCourrante().estDansMap(num)) {
			Cellule courrante = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition());
			Cellule devant = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getDevant());
			if (courrante != null && devant != null) {
				if (devant.getCouleur() != Couleur.GRIS) {
					if (devant.getHauteur() - 1 ==  courrante.getHauteur()) {
						Controleur.getMapCourrante().getBot(num).setPosition(Controleur.getMapCourrante().getBot(num).getDevant());
						Controleur.getMapCourrante().getBot(num).setDevant();
						return 1;
					}
					if (devant.getHauteur() + 1 == courrante.getHauteur()) {
						Controleur.getMapCourrante().getBot(num).setPosition(Controleur.getMapCourrante().getBot(num).getDevant());
						Controleur.getMapCourrante().getBot(num).setDevant();
						return -1;
					}
				}
			}
		}
		return 0;
	}
	
	public String toString() {
		int num = (Controleur.getMapCourrante().getBot1().getEtat() == Etat.UNLOCK) ? 0 : 1;
		return "Sauter : (" + Controleur.getMapCourrante().getBot(num).getPosition().toString() + ")";
	}
	
}
