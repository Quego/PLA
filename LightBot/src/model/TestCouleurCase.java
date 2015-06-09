package model;


public class TestCouleurCase extends IfThenElse {
	
	private static Couleur couleur;
	
	public TestCouleurCase() {
			super("La case est " + couleur.toString() ,Controleur.getMap().getCellule(Controleur.getBotActif().getPosition()).getCouleur() == couleur);
	}
	
	public void setCouleur (Couleur c){
		couleur = c;
	}
	public Couleur getCouleur(){ 
		return couleur;
	}
		

}
			


