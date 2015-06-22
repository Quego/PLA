package structure.actions;

import structure.Controleur;

public class Envoyer implements Action {

	public int executer() {
		int num = Controleur.numeroBot();
		if (!Controleur.getMapCourrante().getBot(num).getObjets().isEmpty()) {
			Controleur.getMapCourrante().getBot((num+1)%2).getObjets().add(0, Controleur.getMapCourrante().getBot(num).recuperePremierObjet());
			Controleur.getMapCourrante().getBot(num).supprimePremierObjet();
			return 1;
		}
		return 0;
	}

}
