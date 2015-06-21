package structure.actions;

import structure.Controleur;

public class Envoyer implements Action {

	public int executer() {
		int num = Controleur.numeroBot();
		if (!Controleur.getMapCourrante().getBot(num).getObjets().isEmpty()) {
			Controleur.getMapCourrante().getBot((num+1)%2).getObjets().add(0, Controleur.getMapCourrante().getBot(num).getObjets().get(0));
			Controleur.getMapCourrante().getBot(num).getObjets().remove(0);
			return 1;
		}
		return 0;
	}

}
