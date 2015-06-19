package structure.actions;

import structure.Bot;
import structure.Cellule;
import structure.Controleur;
import enumere.Couleur;
import enumere.Etat;


public class Allumer implements Action {

	public int executer() {
		int num = Controleur.numeroBot();
		Bot courrant = Controleur.getMapCourrante().getBot(num);
		Cellule courrante = Controleur.getMapCourrante().getCellule(courrant.getPosition());
		if (courrant != null && courrante != null) {
			if (courrante.getCouleur() == Couleur.BLEU) {
				Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition()).setCouleur(Couleur.JAUNE);
				Controleur.getMapCourrante().setNbBleu(Controleur.getMapCourrante().getNbBleu()-1);
				return 1;
			}
			if (courrante.getCouleur() == Couleur.JAUNE) {
				Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition()).setCouleur(Couleur.BLEU);
				Controleur.getMapCourrante().setNbBleu(Controleur.getMapCourrante().getNbBleu()+1);
				return 1;
			}
		}
		return 0;
	}

	public String toString() {
		int num = (Controleur.getMapCourrante().getBot1().getEtat() == Etat.UNLOCK) ? 0 : 1;
		Cellule courrante = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition());
		return "Allumage Cellule(" + Controleur.getMapCourrante().getBot(num).getPosition().toString() + ") --> " + courrante.getCouleur().toString();
	}
	
}
