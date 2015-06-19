package structure.actions;
import structure.Cellule;
import structure.Controleur;
import structure.Interrupteur;
import enumere.Etat;


public class Appuyer implements Action {
	
	public int executer() {
		int num = Controleur.numeroBot();
		Cellule courrante = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition());
		if (courrante != null) {
			if (courrante instanceof Interrupteur) {
				if (((Interrupteur)courrante).getEtat() == Etat.LOCK) {
					Controleur.getMapCourrante().getCellule(((Interrupteur)courrante).getCible())
					.setHauteur(Controleur.getMapCourrante().getCellule(((Interrupteur)courrante).getCible()).getHauteur() - 3);
					((Interrupteur)courrante).setEtat(Etat.UNLOCK);
				} else {
					Controleur.getMapCourrante().getCellule(((Interrupteur)courrante).getCible())
					.setHauteur(Controleur.getMapCourrante().getCellule(((Interrupteur)courrante).getCible()).getHauteur() + 3);
					((Interrupteur)courrante).setEtat(Etat.LOCK);
				}
				return 1;
			}
		}
		return 0;
	}
	
	public String toString() {
		int num = (Controleur.getMapCourrante().getBot1().getEtat() == Etat.UNLOCK) ? 0 : 1;
		Cellule courrante = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition());
		return "Appuyer : " + ((Interrupteur)courrante).getEtat().toString();
	}

}
