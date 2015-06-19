package structure.actions;
import structure.Controleur;
import enumere.Etat;



public class LockUnlock implements Action {

	public int executer() {
		if (Controleur.getMapCourrante().getBot1().getEtat() == Etat.LOCK) {
			Controleur.getMapCourrante().getBot1().setEtat(Etat.UNLOCK);
			Controleur.getMapCourrante().getBot2().setEtat(Etat.LOCK);
			return 1;
		} else if (Controleur.getMapCourrante().getBot1().getEtat() == Etat.UNLOCK) {
			Controleur.getMapCourrante().getBot1().setEtat(Etat.LOCK);
			Controleur.getMapCourrante().getBot2().setEtat(Etat.UNLOCK);
			return 2;
		} else return 0;
	}

	public String toString() {
		return "Changement d'état";
	}
	
}
