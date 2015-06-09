package src;


public class TestCaseBleu extends IfThenElse {
	
		public TestCaseBleu() {
			super("La case est bleu",Controleur.getMap().getCellule(Controleur.getBotActif().getPosition()).getCouleur() == Couleur.BLEU);
		}
			
}
