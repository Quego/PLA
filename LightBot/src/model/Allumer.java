package model;

public class Allumer implements Action {
	public void executer(){
		Cellule ma_cellule = Controleur.getMap().getCellule(Controleur.getBotActif().getPosition());
		ma_cellule.setCouleur(ma_cellule.getCouleur().toOpposee().toString());
	}
	
	public String toString(){
		return "Allumer";
	}
}
