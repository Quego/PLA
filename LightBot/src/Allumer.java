
public class Allumer implements Action {
	public void executer(){
		Cellule ma_cellule = Controleur.getMap().getCellule(Controleur.getBot().getPosition());
		if(ma_cellule.getCouleur() == Couleur.BLEU){
			ma_cellule.setCouleur(Couleur.JAUNE);
		}
		else if (ma_cellule.getCouleur() == Couleur.JAUNE){
			ma_cellule.setCouleur(Couleur.BLEU);
		}
	}
	
	public String toString(){
		return "Allumer";
	}
}
