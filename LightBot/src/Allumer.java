package src;

public class Allumer implements Action {
	public void executer(){
		Cellule ma_cellule = Controleur.getMap().getCellule(Controleur.getBotActif().getPosition());
		if(ma_cellule.getCouleur() == Couleur.BLEU){
			ma_cellule.setCouleur(Couleur.JAUNE.toString());
		}
		else if (ma_cellule.getCouleur() == Couleur.JAUNE){
			ma_cellule.setCouleur(Couleur.BLEU.toString());
		}
	}
	
	public String toString(){
		return "Allumer";
	}
}
