package src;

public class Appuyer implements Action{
	
		Interrupteur mon_int;
	
		public void executer(){
			mon_int.cible.setHauteur(mon_int.getHauteurOpposee());
			Controleur.getBotActif().executer(new Allumer());
		}
		
		public String toString(){
			return "Appuyer";
		}
}
