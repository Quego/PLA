package structure.actions;
import structure.Cellule;
import structure.Controleur;
import enumere.Couleur;
import enumere.Etat;
import enumere.Objet;


public class Lacher implements Action {

	public int executer() {
		int num = Controleur.numeroBot();
		Cellule courrante = Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition());
		if (courrante != null && !Controleur.getMapCourrante().getBot(num).getObjets().isEmpty()) {
			Objet premier = Controleur.getMapCourrante().getBot(num).getObjets().get(0);
			switch (courrante.getCouleur()) {
			case ROUGE:
				if (premier == Objet.FRAISE) {
					Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition()).setObjet(premier);
					Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition()).setCouleur(Couleur._ROUGE);
					Controleur.getMapCourrante().getBot(num).getObjets().remove(0);
					return 1;
				}
				break;
			case VIOLET:
				if (premier == Objet.MYRTILLE) {
					Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition()).setObjet(premier);
					Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition()).setCouleur(Couleur._VIOLET);
					Controleur.getMapCourrante().getBot(num).getObjets().remove(0);
					return 1;
				}
				break;
			case VERT:
				if (premier == Objet.PASTEQUE) {
					Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition()).setObjet(premier);
					Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition()).setCouleur(Couleur._VERT);
					Controleur.getMapCourrante().getBot(num).getObjets().remove(0);
					return 1;
				}
				break;
			default:
				break;
			}
		}
		return 0;
	}
	
	public String toString() {
		int num = (Controleur.getMapCourrante().getBot1().getEtat() == Etat.UNLOCK) ? 0 : 1;
		return "Lacher : " + Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition())
							.getObjet().toString();
	}
	
}
